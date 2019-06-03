(ns mercury-app.fx.navigator-fx
  (:require [re-frame.core :as rf]
            [interop.react-navigation :as react-navigation]))

(rf/reg-fx :navigator/init react-navigation/init)
(rf/reg-fx :navigator/reset react-navigation/reset)
(rf/reg-fx :navigator/navigate react-navigation/navigate)
(rf/reg-fx :navigator/back react-navigation/back)
(rf/reg-fx :navigator/push react-navigation/push)
(rf/reg-fx :navigator/replace react-navigation/replace)
(rf/reg-fx :navigator/pop react-navigation/pop)
