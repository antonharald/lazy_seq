(ns fib.core)


(defn lazy-fac []
  ((fn step [prev_fac cur_index]
    (let [cur_fac (* prev_fac cur_index)
          next_index (inc cur_index)]
          (cons cur_fac (lazy-seq (step cur_fac next_index)))))
    1 1))

(defn lazy-fac2 []
  ((fn step [cur_fac next_index]
     (cons cur_fac (lazy-seq
                     (step (* cur_fac next_index) (inc next_index)))))
    1 2))

(defn lazy-fib []
  ((fn step [prev_prev_fib prev_fib]
     (let [cur_fib (+ prev_prev_fib prev_fib)]
     (cons cur_fib (lazy-seq (step prev_fib cur_fib)))))
    1 1))


(defn -main
  [& args]
  
  (println (take 20 (lazy-fac)))
  (println (take 20 (lazy-fac2)))

  (println "")
  (println (take 20(lazy-fib)))

  )
