parcial1(ana,7).
parcial1(juan,4).
parcial1(pedro,6).
parcial1(alan,7).
parcial1(nacho,7).
parcial1(ello,8).
parcial1(alguien,1).
parcial1(aban1,2).
parcial2(aban2,2).
parcial2(alguien,9).
parcial2(ello,9).
parcial2(nacho,7).
parcial2(ana,9).
parcial2(juan,8).
parcial2(pedro,7).
parcial2(alan,6).
promociona(N,P):-parcial1(N,N1),parcial2(N,N2),SUM is(N1+N2),P is (SUM/2),P>=7.
cursada(N):-parcial1(N,N1),parcial2(N,N2),N1>=4,N2>=4.
recursa(N):-parcial1(N,N1),parcial2(N,N2),(N1<4;N2<4).
alumnos(X):-parcial1(X,_),parcial2(X,_).
ausentes(X):-parcial1(X,_),not(parcial2(X,_)).
ausentes(X):-parcial2(X,_),not(parcial1(X,_)).
%SOBRECARGAR LA REGLA CUENTA COMO UN OR

