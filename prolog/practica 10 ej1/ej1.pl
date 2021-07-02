entrada(paella).
entrada(gazpacho).
entrada(consomé).

carne(filete_de_cerdo).
carne(pollo_asado).

pescado(trucha).
pescado(bacalao).

postre(flan).
postre(helado).
postre(pastel).
plato_principal(X):-carne(X);pescado(X).
menu(X,Y,Z):-entrada(X),plato_principal(Y),postre(Z).
%menu_consomé(Y,Z):-menu(consomé,Y,Z).

