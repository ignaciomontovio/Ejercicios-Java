numero(1).
numero(2).
numero(3).
producto_cartesiano(X,Y):-numero(X),numero(Y).
seleccionMen(X,Y):-producto_cartesiano(X,Y),X<Y.
seleccionMay(X,Y):-producto_cartesiano(X,Y),Y<X.
maximo(X):-numero(X),not(seleccionMen(X,_)).
minimo(X):-numero(X),not(seleccionMay(X,_)).
