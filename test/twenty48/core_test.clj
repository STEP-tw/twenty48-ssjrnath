(ns twenty48.core-test
  (:require [clojure.test :refer :all]
            [twenty48.core :refer :all]))

(deftest splitting-identically
  (testing "two consecutive identical numbers"
    (is (= '((2 2)(4)(8))
            (split-identical '(2 2 4 8)))))
  (testing "more than two consecutive identical numbers"
    (is (= '((2 2 2 2))
            (split-identical '(2 2 2 2)))))
  (testing "more than two consecutive identical numbers"
    (is (= '((2 2) (4 4))
            (split-identical '(2 2 4 4))))))

(deftest spliting-identical-list-by-2
  (testing "split when list has 3 identical numbers"
    (is (= '((2 2)(2))
            (split-by-2 '(2 2 2)))))
  (testing "split when list has all identical numbers"
    (is (= '((2 2)(2 2))
            (split-by-2 '(2 2 2 2))))))

(deftest adding-lists
  (testing "add all elements in list"
    (is (= '(4 2 4)
            (add '((2 2)(2)(4)))))))

(deftest append-zeros
  (testing "appending zeros to the given cloumn"
    (is (= '(2 4 0 0)
            (append 4 '(2 4))))))

(deftest cartesion-product
  (testing "applying cartesian product"
    (is (= '((0 0 2 0)
             (0 2 0 4)
             (2 0 2 4)
             ( 2 4 0 0))
            (cartesian '((0 0 2 2)
                         (0 2 0 4)
                         (2 0 2 0)
                         (0 4 4 0)))))))

(deftest moving-grid-right
  (testing "rows with numbers that repeat"
    (is (= '((0 0 0 4)
             (0 0 2 4)
             (0 0 0 4)
             (0 0 0 8))
           (move-grid-right
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0)))))))

(deftest moving-grid-left
  (testing "rows with numbers that repeat"
    (is (= '((4 0 0 0)
             (2 4 0 0)
             (4 0 0 0)
             (8 0 0 0))
           (move-grid-left
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0)))))))

(deftest moving-grid-up
  (testing "rows with numbers that repeat"
    (is (= '((2 2 4 2)
             (0 4 4 4)
             (0 0 0 0)
             (0 0 0 0))
           (move-grid-up
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0)))))))

(deftest moving-grid-down
  (testing "rows with numbers that repeat"
    (is (= '((0 0 0 0)
             (0 0 0 0)
             (0 2 4 2)
             (2 4 4 4))
           (move-grid-down
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0)))))))
