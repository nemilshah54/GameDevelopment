JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	GameTester.java \
	Game.java \
	Place.java \
	Direction.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class