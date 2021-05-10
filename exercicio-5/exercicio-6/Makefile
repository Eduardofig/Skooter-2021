Dispositivo.o: Dispositivo.cpp
	g++ -c Dispositivo.cpp -o Dispositivo.o
a: Dispositivo.o letra_a.cpp
	g++ Dispositivo.o letra_a.cpp -o main
clean:
	rm -f *.o main
run: main
	./main
