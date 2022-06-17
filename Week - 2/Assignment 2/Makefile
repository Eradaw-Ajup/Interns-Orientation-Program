#This is a makefile for 2 source files : main.cpp and callback.cpp
CC = g++
LIBS = -lsqlite3

program:
	$(CC) $(LIBS) main.cpp read.cpp write.cpp update.cpp deleteEntry.cpp -o program -std=c++11 -std=c++14

clean:
	rm *.o program
