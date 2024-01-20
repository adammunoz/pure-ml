(ns one
  {:clj-kondo/config '{:ignore true}}
  (:require [uncomplicate.fluokitten.core :as fk]
            [statistics-test :as stt]
            [lda-test :as lt])) ; needed for python interop

(require '[py-clj-config :reload true])
(require '[libpython-clj2.python :refer [py. py.. py.-] :as py])

(def ds (py/import-module "sklearn.datasets"))
(def ms (py/import-module "sklearn.model_selection"))
(def lda (py/import-module "sklearn.discriminant_analysis"))
(def metrics (py/import-module "sklearn.metrics"))

(def iris (py. ds load_iris))
(def X (py.- iris data))
(def y (py.- iris target))

(def my-train-test-split
  (py. ms train_test_split X y :test_size 0.30 :random_state 0))

(def X-train (py/get-item my-train-test-split 0))
(def X-test (py/get-item my-train-test-split 1))
(def y-train (py/get-item my-train-test-split 2))
(def y-test (py/get-item my-train-test-split 3))

(def model (py. lda LinearDiscriminantAnalysis))

; mutable!
(py. model fit X-train y-train)

(def y-pred (py. model predict X-test))
(def accuracy (py. metrics accuracy_score y-test y-pred))

; ==============================================================================

(require '[uncomplicate.fluokitten.core :as fk])

(def m0 (fk/just 0))

; ==============================================================================
(require '[statistics :as st :reload true])
(require '[statistics-test :as stt :reload true])
(require '[lda-test :as lt :reload true])

(st/mean-vector [[1 2 3] [4 5 6]])
(stt/test-mean)
(stt/test-mean-vector)
(lt/test-accuracy)
