dir /B /S src\*java > javaFiles.txt
javac -d out --module-source-path src @javaFiles.txt
