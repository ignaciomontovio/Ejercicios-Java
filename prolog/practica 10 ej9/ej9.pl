ventas1erSem(pablo,10000).
ventas1erSem(raul,30000).
ventas1erSem(ezequiel,100).
ventas1erSem(ramon,25000).
ventas2doSem(lisa,25000).
ventas2doSem(pablo,30000).
ventas2doSem(raul,25000).
ventas2doSem(ezequiel,100).

totalVendido(X,T):-ventas1erSem(X,A),A > 20000,ventas2doSem(X,B),B > 20000,T is (A+B)*0.2 .
totalVendido(X,T):-ventas1erSem(X,A),ventas2doSem(X,B),((A > 20000 , B =< 20000);(A =< 20000 , B > 20000)),T is (A+B)*0.1.
totalVendido(X,T):-ventas1erSem(X,A),not(ventas2doSem(X,_)),T is (A*0.05).
totalVendido(X,T):-ventas2doSem(X,B),not(ventas1erSem(X,_)),T is (B*0.05).
