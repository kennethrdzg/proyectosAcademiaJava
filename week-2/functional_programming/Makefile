CLASSPATH=src
DIR=functional_programming
PACKAGE=functional_programming
BIN=bin
MAIN=Main
APP=app

default: clean build run

build: 
	if [ ! -d "$(BIN)" ]; \
	then \
		mkdir $(BIN); \
	fi;
	javac --class-path $(CLASSPATH) $(CLASSPATH)/$(DIR)/*.java -d $(BIN)/
	jar cvfe $(BIN)/$(APP).jar $(PACKAGE).$(MAIN) -C $(BIN)/ $(DIR)/
run: 
#	if [ -f "$(BIN)/$(DIR)/$(MAIN).class" ]; \
#	then \
#		java --class-path $(BIN) $(PACKAGE).$(MAIN); \
#	fi;
	if [ -f $(BIN)/$(APP).jar ]; \
	then \
		java -jar $(BIN)/$(APP).jar; \
	fi;
clean: 
	if [ -d "$(BIN)" ]; \
	then \
		rm -r $(BIN); \
	fi;