#Joseph Mulray H4 Makefile

#variable declaration
JAVA = java
JAR = jar
JC = javac
FLAGS = cp
VIEWER = more
DOCS = javadoc

#Path to Libraries
LIB = ./../libs/'*'

#files used in this project
FILES = Answers.java \
	Essay.java \
	Matching.java \
	MultipleChoice.java \
	Question.java \
	Ranking.java \
	ShortAnswer.java \
	Start.java \
	Survey.java \
	Test.java \
	TF.java \
	Main.java \
	Output.java \
	Console.java \
	FreeTTS.java 
	

#main file used.
MAIN = Main


.PHONY: run view clean

#run and execute program
run:	
	@$(JC) -$(FLAGS) $(LIB): $(FILES)
	$(JAVA) -$(FLAGS) $(LIB): $(MAIN)


#view source code
view:
	$(VIEWER) README $(FILES)

#create java documentation
docs:
	-mkdir docs/
	$(DOCS) -d ./docs/ $(FILES)
	
#remove docs.
swipe:
	-rm -rf docs/
	@echo Removed Docs


#remove all created tests and surveys
remove:
	@find ./../ser/ -type f -name "*.ser" -delete
	@echo Removed all .ser Files

#clean directory 
clean:
	@rm *.class
	@echo Done.

