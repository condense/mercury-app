(ns mercury-app.nav
  (:require [mercury-app.screen.welcome-screen :as welcome-screen]
            [mercury-app.screen.loading-screen :as loading-screen]
            [interop.react-navigation :as react-navigation]
            [cljs.spec.alpha :as s]
            [goog.object :as gobj]
            [re-frame.core :as rf]
            [reagent.core :as r]))

(def AppStack
  (react-navigation/createStackNavigator
    #js {"WelcomeScreen" #js {:screen welcome-screen/screen}}
    #js {:initialRouteName "WelcomeScreen"}))

(def AppNavigator
  (react-navigation/createSwitchNavigator
    #js {"Loading" (r/reactify-component loading-screen/container)
         "App"     AppStack}
    #js {:initialRouteName "Loading"}))

(def AppContainer (react-navigation/createAppContainer AppNavigator))

(defn handle-navigator-ref [navigator]
  (s/assert (s/nilable ::react-navigation/navigator) navigator)
  (if navigator
    (rf/dispatch [:navigator/init navigator])
    (rf/dispatch [:navigator/reset])))

(defn handle-navigation-change
  [_ _ action]
  (s/assert ::react-navigation/navigation-action action)
  (rf/dispatch [:navigator/change {:action-type (gobj/get action "type")}]))

(defn app-root []
  [:> AppContainer {:ref handle-navigator-ref :onNavigationStateChange handle-navigation-change}])
