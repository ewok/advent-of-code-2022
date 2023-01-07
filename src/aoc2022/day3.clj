(ns aoc2022.day3
  (:require [clojure.java.io :as io]
            [clojure.string :as string]
            [clojure.set :as cset]))

(defn get-priority [el]
  (let [binding (zipmap
                 (flatten
                  (conj
                   (map char (range (int \A) (inc (int \Z))))
                   (map char (range (int \a) (inc (int \z))))))
                 (range 1 53))]
    (get binding el)))

(def input
  (->> "day3_input.txt"
       io/resource
       io/file
       slurp
       string/split-lines))

(defn priority-sum-per-elf [input]
  (apply + (map #(let [length (/ (count %) 2)]
                   (get-priority (first (cset/intersection (set (take length %))
                                                           (set (take-last length %))))))
                input)))

(defn priority-sum-per-elf-group [input]
  (apply +
         (map #(apply get-priority
                      (apply cset/intersection %))
              (map vec (partition-all 3 (map set input))))))

(defn do []
  [(priority-sum-per-elf input) (priority-sum-per-elf-group input)])
