
To Run Only Voice assistant (without GUI)

Compile:
javac -cp ".;./lib/sphinx4-core-5prealpha.jar.;./lib/sphinx4-data-1.0.0.jar.;./lib/mysql-connector-java-8.0.26.jar.;./lib/javafx-0.2.jar" App.java
javac -cp ".;./lib/sphinx4-core-5prealpha.jar.;./lib/sphinx4-data-1.0.0.jar.;./lib/mysql-connector-java-8.0.26.jar" --module-path 'C:\javafx-sdk-17.0.1\lib' --add-modules javafx.controls,javafx.fxml,javafx.media ./App.java
Execute:
//java -cp ".;./lib/sphinx4-core-5prealpha.jar.;./lib/sphinx4-data-1.0.0.jar.;./lib/mysql-connector-java-8.0.26.jar" App
java -cp ".;./lib/sphinx4-core-5prealpha.jar.;./lib/sphinx4-data-1.0.0.jar.;./lib/mysql-connector-java-8.0.26.jar" --module-path 'C:\javafx-sdk-17.0.1\lib' --add-modules javafx.controls,javafx.fxml,javafx.media App
To run Only GUI (without voice assistant)


How to compile only App?
javac -cp ".;./lib/sphinx4-core-5prealpha.jar.;./lib/sphinx4-data-1.0.0.jar.;./lib/mysql-connector-java-8.0.26.jar.;./lib/javafx-0.2.jar.;./lib/freetts-1.2.2.jar" App.java
How to execute?
java -cp ".;./lib/sphinx4-core-5prealpha.jar.;./lib/sphinx4-data-1.0.0.jar.;./lib/mysql-connector-java-8.0.26.jar.;./lib/javafx-0.2.jar.;./lib/freetts-1.2.2.jar" App

How to Compile only GUI?
javac --module-path 'C:\javafx-sdk-17.0.1\lib' --add-modules javafx.controls,javafx.fxml,javafx.media .\ColorfulCircles.java

How to Execute?
java --module-path 'C:\javafx-sdk-17.0.1\lib' --add-modules javafx.controls,javafx.fxml,javafx.media ColorfulCircles

