(ns mercury-app.screen.welcome-screen
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :as rf]
            [mercury-app.events]
            [mercury-app.subs]
            [interop.react-native :as rn]))

(def logo-img (js/require "./images/cljs.png"))

(defn container []
  (let [greeting (rf/subscribe [:get-greeting])]
    (fn []
      [rn/view {:style {:flex-direction "column" :margin 40 :align-items "center"}}
       [rn/text {:style {:font-size 30 :font-weight "100" :margin-bottom 20 :text-align "center"}} @greeting]
       [rn/image {:source logo-img
                  :style  {:width 80 :height 80 :margin-bottom 30}}]
       [rn/touchable-highlight {:style    {:background-color "#999" :padding 10 :border-radius 5}
                                :on-press #(rn/alert "HELLO!")}
        [rn/text {:style {:color "white" :text-align "center" :font-weight "bold"}} "press me"]]])))

(def screen
  (r/reactify-component container))
