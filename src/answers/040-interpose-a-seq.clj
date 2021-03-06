;; Write a function which separates the items of a sequence by an arbitrary value.
;; Special Restrictions interpose

;; (= (__ 0 [1 2 3]) [1 0 2 0 3])
;; (= (apply str (__ ", " ["one" "two" "three"])) "one, two, three")
;; (= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])

(defn interpose-a-seq
  [value coll]
  "Write a function which separates the items of a sequence by an arbitrary value."
  (drop-last (interleave coll (repeat value))))

(interpose-a-seq 0 [1 2 3])
(interpose-a-seq :z [:a :b :c :d])
