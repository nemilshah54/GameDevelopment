JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	GameTester.java \
	Game.java \
	Place.java \
	Artifact.java \
        Character.java \
        Player.java \
        NPC.java \
        PlayerInterface.java \
        Npc_Interface.java \
        DecisionMaker.java \
        Move.java \
	Direction.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class