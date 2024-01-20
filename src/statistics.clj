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

(ns statistics
  (:require [uncomplicate.fluokitten.core :refer [just]]))

(defn mean
  "The mean of a vector.
   Receives a vector of numbers and returns a number."
  [vector]
  (/ (reduce + vector) (count vector)))

(defn mean-vector
  "The mean vector is the means of each feature in the dataset.
   Receives a matrix and returns a vector of means."
  ; TODO validate the format of the matrix
  [matrix]
  (map mean matrix))
