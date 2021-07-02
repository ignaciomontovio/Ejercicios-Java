herramienta(pinza,150).
herramienta(martillo,100).
herramienta(tenaza,120).
herramienta(taladro,340).
herramienta(amoladora,340).
producto_cartesiano(X,Y):-herramienta(_,X),herramienta(_,Y).
seleccion(X,Y):-producto_cartesiano(X,Y),X<Y.
maximo(H,P):-herramienta(H,P),not(seleccion(P,_)).
