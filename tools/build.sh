#!/bin/sh

jarfiles_cp=""
jarfiles=""

find src -type f -name "*.java" > .sources.txt && rm -rf build/classes/*.class
if [ $jarfiles ]
then
    javac -cp $jarfiles -d build/classes @.sources.txt $*
else
    javac -d build/classes @.sources.txt $*
fi
if [ $jarfiles ]
then
    cp $jarfiles_cp build/classes
fi
cp src/MANIFEST.MF build/MANIFEST.MF

