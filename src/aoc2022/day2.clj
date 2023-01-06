(ns aoc2022.day2
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(def input
  (->> "day2_input.txt"
       io/resource
       io/file
       slurp
       string/split-lines
       (map #(format "%s%s" (first %) (last %)))))

;; A X - Rock
;; B Y - Paper
;; C Z - Scissors

;; part 1
(defn- cal-p1 [shape]
  (case shape
    "AX" 4
    "AY" 8
    "AZ" 3
    "BX" 1
    "BY" 5
    "BZ" 9
    "CX" 7
    "CY" 2
    "CZ" 6))

;; X - lose
;; Y - draw
;; Z - win

;; part 2
(defn- cal-p2 [shape]
  (case shape
    "AX" 3
    "AY" 4
    "AZ" 8
    "BX" 1
    "BY" 5
    "BZ" 9
    "CX" 2
    "CY" 6
    "CZ" 7))

(defn do [] [(reduce + (map cal-p1 input))
             (reduce + (map cal-p2 input))])
