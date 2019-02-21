(ns twenty48.core
  (:gen-class))

(defn move-grid-right
  "Moves an entire grid to the right"
  [grid]
  grid)

(defn move-grid-left
  "Moves an entire grid to the left"
  [grid]
  grid)

(defn move-grid-down
  "Moves an entire grid down"
  [grid]
  grid)

(defn move-grid-up
  "Moves an entire grid up"
  [grid]
  grid)


(def split-identical (comp (partial partition-by identity) (partial remove zero?)))

(def split-by-2 (comp (partial mapcat (partial partition-all 2)) split-identical))

(def add (partial map (partial reduce +)))
