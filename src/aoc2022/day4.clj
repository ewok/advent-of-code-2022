;; https://adventofcode.com/2022/day/4
(ns aoc2022.day4
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(def input
  (->> "day4_input.txt"
       io/resource
       io/file
       slurp
       string/split-lines
       (map #(string/split % #","))
       (map #(let [f (first %) s (second %)]
               [(string/split f #"-")
                (string/split s #"-")]))))

(defn overlapped? [pair]
  (let [ff (Integer/parseInt (ffirst pair))
        fs (Integer/parseInt (second (first pair)))
        sf (Integer/parseInt (first (second pair)))
        ss (Integer/parseInt (second (second pair)))]
    (cond
      (and (>= ff sf)
           (<= fs ss)) 1
      (and (<= ff sf)
           (>= fs ss)) 1
      (and (>= ff sf)
           (<= ff ss)) 2
      (and (>= fs sf)
           (<= fs ss)) 2
      :else 0)))

(def how-many-overlapped-fully
  (reduce + (map #(if (= (overlapped? %) 1) 1 0) input)))

(def how-many-overlapped-partly
  (reduce + (map #(if (>= (overlapped? %) 1) 1 0) input)))

(defn do []
  [how-many-overlapped-fully how-many-overlapped-partly])
