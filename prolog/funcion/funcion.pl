%GRAFICAR LA FUNCION
%        -X+1 si X<0
%F(X)    1 SI X<=X<=1
%        X SI X>1
funcion(X,Y):-(X<0,Y is -X+1),!.
funcion(X,Y):-(X>1,Y is X),!.
funcion(X,Y):-(X >= 0 , X=< 1,Y is 1),!.

%funcion(X,Y):-Y is X+1, X<0,!.
%funcion(X,1):- X>=0,X=<1,!.
%funcion(X,X):-X>1.
%factorial(X) = 1 si X=0
%             = X*factorial(X-1) para todo x
%
% factorial(X01:-!.
factorial(X,F):-X == 0 , F is 1,!.
factorial(X,F):-X > 0,X1 is X-1,factorial(X1,F1),F is X*F1.
