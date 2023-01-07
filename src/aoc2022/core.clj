(ns aoc2022.core
  (:gen-class)
  (:require [aoc2022.day1 :as day1]
            [aoc2022.day2 :as day2]
            [aoc2022.day3 :as day3]
            [aoc2022.day4 :as day4]))


(defn -main []
  (println (map #(format "Day %s result: %s\n" (+ 1 (first %)) (second %))
                (map-indexed vector [(day1/do)
                                     (day2/do)
                                     (day3/do)
                                     (day4/do)]))))
