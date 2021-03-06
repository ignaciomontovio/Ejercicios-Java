
sumaGauss(X,1):-X == 1.
sumaGauss(X,R):-X > 1,X1 is X-1,sumaGauss(X1,R1),R is R1+X,!.
fibonacci(X,0):-X == 0.
fibonacci(X,1):-X == 1.
fibonacci(X,R):-X1 is X-1,X2 is X-2,fibonacci(X1,R1),fibonacci(X2,R2),R is R1 + R2,!.

factorial(N,1):-N==0.
factorial(N,R):-N1 is N-1,factorial(N1,R1),R is N*R1,!.

sumaSucesiva(X,Y,0):-X == 0;Y==0.
sumaSucesiva(X,Y,X):-Y == 1.
sumaSucesiva(X,Y,R):-X > 1 ,Y > 1,Y1 is Y-1,sumaSucesiva(X,Y1,R1),R is R1+X,!.

potencia(X,_,1):-X==0,!.
potencia(X,N,R):-X > 0,X1 is X-1,potencia(X1,N,R1),R is R1*N,!.

divisionRestas(X,Y,R):-X<Y,R is 0,!.
divisionRestas(X,Y,R):-Z is X-Y,X>=Y,divisionRestas(Z,Y,R1),R is R1+1,!.

divisionRestasResto(X,Y,RESU,X):-X<Y,RESU is 0,!.
divisionRestasResto(X,Y,RESU,REST):-Z is X-Y,X>=Y,divisionRestasResto(Z,Y,R1,R5),REST is R5,RESU is R1+1,!.

MCD(X,Y,Z):-Z<Y,Z<X,divisionRestasResto(X,Z,_,R),R == 0,divisionRestasResto(X,Z,_,R1),R1 == 0,Z1 is Z+1,MCD(X,Y,Z1).
