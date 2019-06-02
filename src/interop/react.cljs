(ns interop.react)

(set! *warn-on-infer* true)

(def React ^js/React (js/require "react"))

(defn create-factory [x]
  (.createFactory React x))
