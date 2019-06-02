(ns mercury-app.events.navigator-events
  (:require [re-frame.core :as rf]
            [cljs.spec.alpha :as s]
            [interop.react-navigation :as react-navigation]))

(rf/reg-event-fx
  :navigator/init
  [rf/debug]
  (fn [{:keys [db]} [_ navigator]]
    (s/assert ::react-navigation/navigator navigator)
    {:navigator/init {:navigator navigator :state (:nav/state db)}}))

(rf/reg-event-fx
  :navigator/reset
  [rf/debug]
  (fn [{:keys [db]} _]
    {:navigator/reset nil}))

(rf/reg-event-fx
  :navigator/change
  [(rf/inject-cofx :navigation/route) (rf/inject-cofx :navigation/state-json)]
  (fn [{:keys [react-navigation/route react-navigation/state-json db]} [_ {:keys [action-type]}]]
    (case action-type
      ("Navigation/NAVIGATE" "Navigation/BACK" "Navigation/SET_PARAMS" "Navigation/POP" "Navigation/POP_TO_TOP" "Navigation/PUSH" "Navigation/RESET" "Navigation/REPLACE")
      {:db (assoc db :nav/route route :nav/state state-json)}
      nil)))
