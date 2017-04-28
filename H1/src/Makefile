#Joseph Mulray
#H2 Makefile for Survey
#CS 350

JC = javac
JAVA = java
VIEWER = more

FILES = Start.java \
	Test.java \
	Survey.java \
	Answers.java \
	Answer_Sheet.java \
	Question.java \
	Essay.java \
	Short_Answer.java \
	Matching.java \
	Ranking.java \
	Multiple_Choice.java \
	TF.java \
	
MAIN = Start

.PHONY : run view clean


run:
	$(JC) $(FILES)
	$(JAVA) $(MAIN)

view: 
	$(VIEWER) README
	$(VIEWER) $(FILES)

clean: 
	- rm *.class


