(ns mercury-app.ios.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [mercury-app.core]
            [interop.react-native :as rn]))


(def logo-img (js/require "./images/cljs.png"))

(defn app-root []
  (let [greeting (subscribe [:get-greeting])]
    (fn []
      [rn/view {:style {:flex-direction "column" :margin 40 :align-items "center"}}
       [rn/text {:style {:font-size 30 :font-weight "100" :margin-bottom 20 :text-align "center"}} @greeting]
       [rn/image {:source logo-img
               :style  {:width 80 :height 80 :margin-bottom 30}}]
       [rn/touchable-highlight {:style {:background-color "#999" :padding 10 :border-radius 5}
                             :on-press #(rn/alert "HELLO!")}
        [rn/text {:style {:color "white" :text-align "center" :font-weight "bold"}} "press me"]]])))

(defn init []
      (dispatch-sync [:initialize-db])
      (.registerComponent rn/AppRegistry "MercuryApp" #(r/reactify-component app-root)))
