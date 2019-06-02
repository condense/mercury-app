(ns mercury-app.screen.loading-screen
  (:require [reagent.core :as r]
            [interop.react-native :as rn]))

(def styles {:container {:flex 1 :alignItems "center" :justifyContent "center"}})

(defn container []
  [rn/view {:style (:container styles)}
   [rn/activity-indicator {:size "large"}]])

(def screen
  (r/reactify-component container))
