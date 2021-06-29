if test -f "$classes/"; then
    mkdir classes/
fi
if [ $1 = "demo" ]; then
    javac -cp lib/CLIPSJNI.jar:lib/jade.jar src/com/demo/Demo.java -d classes/
elif [ $1 = "test" ]; then
    javac -cp lib/CLIPSJNI.jar:lib/jade.jar src/com/examples/behaviours/KnowledgeBase.java -d classes/
elif [ $1 = "four" ]; then
    javac -cp lib/CLIPSJNI.jar:lib/jade.jar src/com/four/KnowledgeBase.java -d classes/
else
    echo "Pass number of challenge to build"
fi
