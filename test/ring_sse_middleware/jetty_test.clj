;   Copyright (c) Shantanu Kumar. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file LICENSE at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.


(ns ring-sse-middleware.jetty-test
  (:require
    [ring-sse-middleware.test-util       :as tu]
    [cheshire.core                       :as c]
    [ring-sse-middleware.core            :as r]
    [ring-sse-middleware.adapter.generic :as adapter]
    [ring.adapter.jetty                  :as jetty]))


(def wrapped-handler (-> tu/handler
                       (r/streaming-middleware adapter/generate-stream)))


(defn -main [& args]
  (jetty/run-jetty wrapped-handler {:port 3000
                                    :output-buffer-size 1}))
