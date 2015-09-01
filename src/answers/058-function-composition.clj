;; Write a function which allows you to create function compositions.
;; The parameter list should take a variable number of functions, and create a function that applies them from right-to-left.
;; Special Restrictions comp

;; (= [3 2 1] ((__ rest reverse) [1 2 3 4]))
;; (= 5 ((__ (partial + 3) second) [1 2 3 4]))
;; (= true ((__ zero? #(mod % 8) +) 3 5 7 9))
;; (= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world"))

(defn functions-composition
  [& fns]
  (fn
    [& args]
    (loop [ret (apply (last fns) args)
           fns (drop-last fns)]
      (if
        (empty? fns)
        ret
        (recur ((last fns) ret) (drop-last fns))))))

(= [3 2 1] ((functions-composition rest reverse) [1 2 3 4]))
(= 5 ((functions-composition (partial + 3) second) [1 2 3 4]))
(= true ((functions-composition zero? #(mod % 8) +) 3 5 7 9))
(= "HELLO" ((functions-composition #(.toUpperCase %) #(apply str %) take) 5 "hello world"))
