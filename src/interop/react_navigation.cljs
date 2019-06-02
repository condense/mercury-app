(ns interop.react-navigation
  (:refer-clojure :exclude [pop replace])
  (:require [goog.object :as gobj]
            [cljs.spec.alpha :as s]
            [reagent.core :as r]))

(set! *warn-on-infer* true)

(js/require "react-native-gesture-handler")

(defonce ReactNavigation ^js/ReactNavigation (js/require "react-navigation"))
(defonce createAppContainer (.-createAppContainer ReactNavigation))
(defonce createStackNavigator (.-createStackNavigator ReactNavigation))
(defonce createSwitchNavigator (.-createSwitchNavigator ReactNavigation))
(defonce NavigationActions ^js/ReactNavigation.NavigationActions (.-NavigationActions ReactNavigation))
(defonce StackActions ^js/ReactNavigation.StackActions (.-StackActions ReactNavigation))
(defonce createMaterialTopTabNavigator (.-createMaterialTopTabNavigator ReactNavigation))
(defonce SafeAreaView (.-SafeAreaView ReactNavigation))
(defonce safe-area-view (r/adapt-react-class SafeAreaView))

(defonce navigator nil)

(defn dispatch
  [^js/ReactNavigation.Navigation n a]
  (.dispatch n a))

(defn set-state
  [^js/ReactNavigation.Navigation n s]
  (.setState n s))

(defn init
  [m]
  (s/assert ::navigator (:navigator m))
  (set! navigator (:navigator m))
  (when (:state m)
    (set-state navigator #js {:nav (js/JSON.parse (:state m))})))

(defn reset
  []
  (set! navigator nil))

(defn navigate
  [{:keys [routeName params]}]
  (s/assert ::navigator navigator)
  (dispatch navigator (.navigate NavigationActions #js {:routeName (name routeName) :params params})))

(defn replace
  [{:keys [key newKey routeName params]}]
  (s/assert ::navigator navigator)
  (dispatch navigator (.replace StackActions #js {:key key :newKey newKey :routeName (name routeName) :params params})))

(defn back
  []
  (s/assert ::navigator navigator)
  (dispatch navigator (.back NavigationActions)))

(defn push
  [{:keys [routeName params]}]
  (s/assert ::navigator navigator)
  (dispatch navigator (.push StackActions #js {:routeName (name routeName) :params params})))

(defn pop
 ([]
  (s/assert ::navigator navigator)
  (.dispatch navigator (.pop StackActions)))
 ([{:keys [n]}]
  (if n
    (.dispatch navigator (.pop StackActions))
    (.dispatch navigator (.pop StackActions n)))))

(defn state
  []
  (s/assert ::navigator navigator)
  (js->clj (gobj/get navigator "state") :keywordize-keys true))

(defn state-json
  []
  (s/assert ::navigator navigator)
  (js/JSON.stringify (gobj/getValueByKeys navigator "state" "nav")))

(defn route []
  (let [{:keys [nav]} (state)]
    (loop [{:keys [routes index] :as route} nav]
      (if (int? index)
        (recur (get routes index))
        route))))

(defn params
  "View helper for fetching route params from navigation object passed to screen"
  [navigation]
  (gobj/getValueByKeys navigation "state" "params"))

(s/def ::navigator
  (s/and #(fn? (gobj/get % "dispatch"))
         #(fn? (gobj/get % "setState"))
         #(gobj/containsKey % "state")))
(s/def ::navigation-action #(instance? (type NavigationActions) %))
(s/def ::stack-action #(instance? (type StackActions) %))