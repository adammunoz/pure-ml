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

(ns lda-test
  {:clj-kondo/config '{:ignore true}} ; needed for python interop
  (:require [clojure.test :refer [deftest is testing]]
            [py-clj-config]
            [libpython-clj2.python :refer [py. py.. py.-] :as py]
            [lda :as lda]))

(def ^:private  ds (py/import-module "sklearn.datasets"))
(def ^:private  ms (py/import-module "sklearn.model_selection"))
(def ^:private  lda (py/import-module "sklearn.discriminant_analysis"))
(def ^:private  metrics (py/import-module "sklearn.metrics"))

(deftest test-accuracy
   (testing "Accuracy is similar to SciKit-Learn"
     (let [iris (py. ds load_iris)
           ; Prepare SciKit-Learn datasets: Iris
           X (py.- iris data)
           y (py.- iris target)
           ; Get the splits
           my-train-test-split
           (py. ms train_test_split X y :test_size 0.30 :random_state 0)
           X-train (py/get-item my-train-test-split 0)
           X-test (py/get-item my-train-test-split 1)
           y-train (py/get-item my-train-test-split 2)
           y-test (py/get-item my-train-test-split 3)
           ; SciKit-Learn LDA model
           model (py. lda LinearDiscriminantAnalysis)]
       (do
         ; train the model. This is mutable.
         (py. model fit X-train y-train)
         ; Get the predictions and measure accuracy
         (let [y-pred (py. model predict X-test)
               accuracy (py. metrics accuracy_score y-test y-pred)
               ; Pure ML LDA model
               pure-model (lda/train X-train y-train)
               ; Get the predictions measure accuracy for our model
               pure-y-pred (lda/predict pure-model X-test)
               pure-accuracy (lda/accuracy y-test pure-y-pred)]
           (is (= accuracy pure-accuracy)))))))
