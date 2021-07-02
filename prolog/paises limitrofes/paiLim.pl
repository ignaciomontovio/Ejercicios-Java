es_un_pais(argentina).
es_un_pais(chile).
es_un_pais(peru).
limita_con(argentina,chile).
limita_con(argentina,brasil).
limita_con(bolivia,brasil).
limita_con(bolivia,paraguay).
limita_con(bolivia,chile).
limita_con(bolivia,argentina).
limita_con(peru,ecuador).
son_limitrofes(X,Y):-limita_con(X,Y);limita_con(Y,X).
son_translimitrofes(X,Z):-son_limitrofes(X,Y),son_limitrofes(Y,Z),dif(X,Z),not(son_limitrofes(X,Z)).



