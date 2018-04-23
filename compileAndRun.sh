#!/bin/bash
find src/* -name '*.java' > sources.txt
mkdir -p target
javac @sources.txt -d target/classes && java -cp target/classes:resources com/codecool/expertsystem/Main
