(ns twenty48.core
  (:gen-class))

(defn move-grid-right
  "Moves an entire grid to the right"
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

(defn append 
  [n coll]
  (take n (concat coll (repeat n 0))))

(def move-grid-left (partial map (comp (partial append 4) add split-by-2)))

(def move-grid-right (partial map (comp reverse (partial append 4) add split-by-2 reverse)))

(def cartesian (partial apply map vector))

(def move-grid-up (comp cartesian move-grid-left cartesian))

(def move-grid-down (comp cartesian move-grid-right cartesian))
