(deffacts sintomas 
    (sintoma a)
    (sintoma b)
    (sintoma c)
)

(defrule r1 
    (sintoma ?x) => (printout t ?x crlf)
)

(reset)