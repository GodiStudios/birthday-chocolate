(ns birthday-chocolate.core-test
  (:require [clojure.test :refer :all]
            [birthday-chocolate.core :refer :all]))

(deftest generate-chocolate-bar
  (testing "Testing generated array"
    (is (< (count (chocolate-bar-generator)) 100))
    (is (every? (partial >= 5) (chocolate-bar-generator)))
    (is (every? (partial <= 1) (chocolate-bar-generator)))))

(deftest generate-birthday 
  (testing "Returns a map with day/month"
    (is (= (keys (birthday-generator)) '(:day :month)))
    (testing "Day of birth"
      (is (and (>= (:day (birthday-generator)) 1)
               (<= (:day (birthday-generator)) 31))))
    (testing "Month of birth"
      (is (and (>= (:month (birthday-generator)) 1)
               (<= (:month (birthday-generator)) 12))))))

(deftest chocolate-can-be-shared
  (testing "chocolate bars are shared by num of tablets equal month and sum of tablets equal day"
    (is (= (share-chocolate [1 2 1 3 2] {:day 3 :month 2}) 2))
    (is (= (share-chocolate [1 1 1 1 1 1] {:day 3 :month 2}) 0))
    (is (= (share-chocolate [4] {:day 4 :month 1}) 1))))
