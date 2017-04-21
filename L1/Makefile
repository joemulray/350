#Joseph Mulray
#CS 350 L1
#4/20/17

JC = javac
JAVA = java
VIEWER = more

FILES = main.java \
	AlarmClock.java	

MAIN = main

.PHONY : run view clean

run : 
	$(JC) $(FILES)
	$(JAVA) $(MAIN)
	

view : $(FILES)
	$(VIEWER) README
	$(VIEWER) $(FILES)

clean : 
	- rm *.class
