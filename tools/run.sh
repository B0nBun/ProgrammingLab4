#!/bin/sh
jarfiles=".:pokemon.jar"

if [ $1 ]
then
	cd build/classes
	java -cp $jarfiles $*
	cd ../..
else
	echo "Entry point class is required: ./run.sh Main"
fi
