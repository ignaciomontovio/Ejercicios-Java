hombre(pedro).
hombre(manuel).
hombre(arturo).
mujer(maría).
padre(pedro, manuel).
padre(pedro, arturo).
padre(pedro, maría).

niño(arturo,pedro).
niño(manuel,pedro).
niño(maría,pedro).
hijo(arturo,pedro).
hijo(manuel,pedro).
hija(maría,pedro).
hermano(manuel,arturo).
hermano(arturo,manuel).
hermano(manuel,maría).
hermano(arturo,maría).
hermana(maría,arturo).
hermana(maría,manuel).
hermano_o_hermana(X,Y):-hermano(X,Y);hermana(X,Y).

