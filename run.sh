export PATH_INCLUDE=-Djava.library.path=lib/
export INCLUDE_CP="-cp lib/CLIPSJNI.jar:lib/jade.jar:classes/"

if [ $1 = "demo" ]; then
    java $PATH_INCLUDE $INCLUDE_CP com.demo.Demo
elif [ $1 = "test" ]; then
    java $PATH_INCLUDE $INCLUDE_CP com.examples.behaviours.KnowledgeBase
elif [ $1 = "four" ]; then
    java $PATH_INCLUDE $INCLUDE_CP com.four.KnowledgeBase
else
    echo "Pass at least 1 argument, number of challenge"
fi
