#!/bin/sh

cd build/classes
find . -type f -name "*.class" > ../../.jar-sources.txt
jar cfm ../../jarred.jar ../MANIFEST.MF @../../.jar-sources.txt
cd ..