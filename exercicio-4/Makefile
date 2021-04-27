all: Superpoder.o Personagem.o SuperHeroi.o Vilao.o main.o
	g++ -o main main.o Superpoder.o Personagem.o SuperHeroi.o Vilao.o 
Superpoder.o: Superpoder.cpp
	g++ -c Superpoder.cpp
Personagem.o: Personagem.cpp
	g++ -c Personagem.cpp
SuperHeroi.o: SuperHeroi.cpp
	g++ -c SuperHeroi.cpp
Vilao.o: Vilao.cpp
	g++ -c Vilao.cpp
main.o: main.cpp
	g++ -c main.cpp
run:
	./main
