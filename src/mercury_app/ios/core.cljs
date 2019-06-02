(ns mercury-app.ios.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [mercury-app.core]
            [mercury-app.nav :as nav]
            [interop.react-native :as rn]))

(def app-root nav/app-root)

(defn init []
  (rf/dispatch-sync [:initialize-db])
  (.registerComponent rn/AppRegistry "mercury-app" #(r/reactify-component app-root)))
