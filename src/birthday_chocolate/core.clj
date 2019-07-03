(ns birthday-chocolate.core
  (:gen-class))

(defn chocolate-bar-generator []
  (let [rand-vec (atom [])]
    (dotimes [x (rand-int 100)] 
      (swap! rand-vec conj (+ 1 (rand-int 5))))
    @rand-vec))

(defn birthday-generator []
  {:day (+ 1 (rand-int 31)) :month (+ 1 (rand-int 12))})

(defn share-chocolate [vec birth]
  (->> vec
    (partition (:month birth) 1)
    (filter #(= (reduce + 0 %) (:day birth)))
    (count)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [vec (chocolate-bar-generator)
        birth (birthday-generator)]
    (do
      (println vec)
      (println birth)
      (println (share-chocolate vec birth)))))
