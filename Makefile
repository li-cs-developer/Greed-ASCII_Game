JAVAC = javac
JAVA = java
SRCS = $(wildcard *.java)
CLASSFILES = $(SRCS:.java=.class)
MAIN = RunGreed

all: $(CLASSFILES)

%.class: %.java
	$(JAVAC) $<

run: all
	$(JAVA) $(MAIN)

clean:
	rm -f *.class
