(ns om-datepicker.events
  (:require [cljs.core.async :as async :refer [chan put!]]
            [goog.events :as events]))

(defn mouse-click [ch]
  (let [f #(put! ch %)]
    (events/listen js/document events/EventType.CLICK f)
    (fn []
      (events/unlisten js/document events/EventType.CLICK f))))


