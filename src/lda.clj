; ============================================================================== 
; Copyright (C) 2023 Adam Munoz
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

(ns lda
  (:require [uncomplicate.fluokitten.core :refer [just]]))

; Linear Discriminant Analysis (LDA) is used for dimensionality reduction
; and classification. It is a supervised learning method used when classifying
; and unsupervised when reducing dimensionality.
; In LDA data scaling is not normally required.
;
; The goal of LDA is to find the coefficients (a1, a2, ..., an) that maximize 
; the separation between the different classe in the dataset.
; This is achieved by maximizing the distance between the means of the classes
; while minimizing the variance within each class.
; Said in another way, we want to maximize the ratio of the between-class to
; within-class variances.

; TODO: implement
(defn train 
  "Take the features (X) and the target (y) and return a trainned model."
  [X y])

; TODO: add docstrings
; TODO: implement
(defn predict [X y])

; TODO: add docstrings
; TODO: implement
(defn accuracy [y-test pred-y])
