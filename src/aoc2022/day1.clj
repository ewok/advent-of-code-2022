;; https://adventofcode.com/2022/day/1
(ns aoc2022.day1
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(def input
  (->> "day1_input.txt"
      io/resource
      io/file
      slurp
      string/split-lines
      (map #(if (string/blank? %) 0 (Integer/parseInt %)))
      (partition-by #(zero? %))
      (filter #(not (zero? (first %))))))

(def top-sorted (sort-by int > (map #(apply + %) input)))

(defn do []
  [(first top-sorted)
   (apply + (take 3 top-sorted))])
