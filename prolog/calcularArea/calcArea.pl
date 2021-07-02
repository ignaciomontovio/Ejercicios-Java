triangulo(2,2).
triangulo(2,3).
cuadrado(4).
cuadrado(2).
rectangulo(6,3).
rectangulo(10,6).
circulo(10).
circulo(3).

areaTriangulo(A):-triangulo(B,H),A is (B*H/2).
areaCuadrado(A):-cuadrado(L),A is (L*L).
areaCirculo(A):-circulo(R),A is (3.14*R*R).
areaRectangulo(A):-rectangulo(B,H),A is (B*H).

productoCartesianoTrian(A,B):- areaTriangulo(A),areaTriangulo(B).
seleccionTrian(A,B):-productoCartesianoTrian(A,B),B>A.
proyeccionTrian(A):-areaTriangulo(A),not(seleccionTrian(A,_)).

productoCartersianoCuad(A,B):-areaCuadrado(A),areaCuadrado(B).
seleccionCuad(A,B):-productoCartersianoCuad(A,B),A<B.
proyeccionCuad(A):-areaCuadrado(A),not(seleccionCuad(A,_)).

productoCartersianoCirc(A,B):-areaCirculo(A),areaCirculo(B).
seleccionCirc(A,B):-productoCartersianoCirc(A,B),A<B.
proyeccionCirc(A):-areaCirculo(A),not(seleccionCirc(A,_)).

productoCartersianoRect(A,B):-areaRectangulo(A),areaRectangulo(B).
seleccionRect(A,B):-productoCartersianoRect(A,B),A<B.
proyeccionRect(A):-areaRectangulo(A),not(seleccionRect(A,_)).

mayorFigura(A,F):-proyeccionTrian(T),proyeccionCuad(X),proyeccionRect(Y),proyeccionCirc(Z).
