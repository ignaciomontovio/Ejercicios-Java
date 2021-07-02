hombre(pablo,rock,pop).
hombre(ezequiel,rock,salsa).
mujer(ana,cumbia,salsa).
mujer(belen,rock,bachata).

parejas(X,A,D):-hombre(X,Y,Z),mujer(A,B,C),(((Y==B;Y==C),D = Y);((Z==B;Z==C),D = Z)).
obtenerParejas():-parejas(X,A,D),write(X+ "y" +A + "podrian participar del estilo "+D),nl,fail.
