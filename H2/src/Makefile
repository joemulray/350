#Joseph Mulray H2 Makefile

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
	Main.java
	

#main jar file used.
MAIN = Survey.jar


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
	
#remove docs if wanted.
swipe:
	-rm -rf docs/
	@echo Removed Docs

#clean directory 
clean:
	@rm *.class $(MAIN)
	@echo Done.

