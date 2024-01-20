; ============================================================================== 
; Copyright (C) 2024 Adam Munoz
; This program is free software: you can redistribute it and/or modify it under 
; the terms of the GNU General Public License as published by the Free Software
; Foundation, version 3. 
;
; This program is distributed in the hope that it will be useful, but WITHOUT 
; ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
; FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
;
; You should have received a copy of the GNU General Public License along with 
; this program. If not, see <https://www.gnu.org/licenses/>.
; ==============================================================================

(ns statistics-test
  (:require [clojure.test :refer [deftest is testing]]
            [statistics :as st]))

(deftest test-mean
   (testing "Mean of a vector of numbers"
     (let [vector [1 2 3 4 5]]
       (is (= 3 (st/mean vector))))))

(deftest test-mean-vector
   (testing "Mean vector of a matrix"
     (let [matrix [[1 2 3] 
                   [4 5 6]]]
       (is (= [2 5] (st/mean-vector matrix))))))