#Joseph Mulray H2 Makefile

#export CLASSPATH=$CLASSPATH:./../libs/freetts.jar

#variable declaration
JAVA = java
JAR = jar
JC = javac
FLAGS = cfm
VIEWER = more
DOCS = javadoc

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
	Console.java 
	

#main jar file used.
MAIN = H4.jar


.PHONY: run view clean

#run and execute program
run:
	@$(JC) $(FILES)
	@$(JAR) -$(FLAGS) $(MAIN) Manifest.txt *.class
	$(JAVA) -$(JAR) $(MAIN)


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
	@rm *.class $(MAIN)
	@echo Done.

