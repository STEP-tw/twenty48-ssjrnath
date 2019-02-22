(ns twenty48.core
  (:gen-class))

(def split-identical (comp (partial partition-by identity) (partial remove zero?)))

(def split-by-2 (comp (partial mapcat (partial partition-all 2)) split-identical))

(def add (partial map (partial reduce +)))

(def split-and-add (comp add split-by-2))

(defn append 
  [coll]
  (take (first coll) (concat (last coll) (repeat (first coll) 0))))

(def cartesian (partial apply map vector))

; "Moves an entire grid to the left"
(def move-grid-left (partial map (comp (partial append) (juxt count split-and-add))))

; "Moves an entire grid to the right"
(def move-grid-right (partial map (comp reverse (partial append) (juxt count split-and-add) reverse)))

; "Moves an entire grid to the right"
(def move-grid-up (comp cartesian move-grid-left cartesian))

; "Moves an entire grid to the right"
(def move-grid-down (comp cartesian move-grid-right cartesian))
