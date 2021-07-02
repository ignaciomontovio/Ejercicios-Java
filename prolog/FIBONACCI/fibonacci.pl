fibonacci(X,F):-X == 1,F is 1,!.
fibonacci(X,F):-X == 2,F is 1,!.
fibonacci(X,F):-X>2,X1 is (X-1),X2 is (X-2),fibonacci(X1,F1),fibonacci(X2,F2),F is F1+F2.

%fibo(1,1):-!.
%fibo(2,1):-!.
%fibo(X,F):-X>2,X1 is X-1,X2 is X-2,
%           fibo(X1,F1),fibo(X2,F2),F is F1+F2.
