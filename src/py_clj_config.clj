(ns py-clj-config
  (:require [libpython-clj2.python :as py]))

; TODO maybe paths should be configurable
(py/initialize!
 :python-executable "/Users/adammunozlopez/adam/miniconda3/envs/pure-ml/bin/python"
 :library-path "/Users/adammunozlopez/adam/miniconda3/envs/pure-ml/lib/libpython3.10.dylib")