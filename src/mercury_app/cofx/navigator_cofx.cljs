(ns mercury-app.cofx.navigator-cofx
  (:require [interop.react-navigation :as react-navigation]
            [re-frame.core :as re-frame]))

(re-frame/reg-cofx
  :navigator/state
  (fn [cofx _]
    (assoc cofx :navigator/state (react-navigation/state))))

(re-frame/reg-cofx
  :navigator/route
  (fn [cofx _]
    (assoc cofx :navigator/route (react-navigation/route))))