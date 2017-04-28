#Joseph Mulray H2 Makefile

JAVA = java
JAR = jar
JC = javac
FLAGS = cfm
VIEWER = more

FILES = AnswerSheet.java \
	Answers.java \
	Essay.java \
	Matching.java \
	MultipleChoice.java \
	Question.java \
	Ranking.java \
	ShortAnswer.java \
	Start.java \
	Survey.java \
	Test.java \
	TF.java

	

MAIN = Survey.jar


.PHONY: run view clean

run:
	@$(JC) $(FILES)
	@$(JAR) -$(FLAGS) $(MAIN) Manifest.txt *.class
	$(JAVA) -$(JAR) $(MAIN)


view:
	$(VIEWER) README $(FILES)

clean:
	-rm *.class $(MAIN)
