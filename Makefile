.PHONY: build clean run

build: tema2

run:
	java -Xmx1G MainClass ${ARGS}

tema2:
	javac *.java

clean:
	rm -rf *.class