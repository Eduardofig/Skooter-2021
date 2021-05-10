Dispositivo.o: Dispositivo.cpp
	g++ -c Dispositivo.cpp -o Dispositivo.o
a: Dispositivo.o letra_a.cpp
	g++ Dispositivo.o letra_a.cpp -o a
	./a
b: Dispositivo.o letra_b.cpp
	g++ Dispositivo.o letra_b.cpp -o b
	./b
clean:
	rm -f *.o a b
