How to compile only App?
javac -cp ".;./lib/sphinx4-core-5prealpha.jar.;./lib/sphinx4-data-1.0.0.jar.;./lib/mysql-connector-java-8.0.26.jar.;./lib/javafx-0.2.jar" App.java
How to execute?
java -cp ".;./lib/sphinx4-core-5prealpha.jar.;./lib/sphinx4-data-1.0.0.jar.;./lib/mysql-connector-java-8.0.26.jar.;./lib/javafx-0.2.jar" App

How to Compile only GUI?
javac --module-path 'C:\javafx-sdk-17.0.1\lib' --add-modules javafx.controls,javafx.fxml,javafx.media .\ColorfulCircles.java

How to Execute?
java --module-path 'C:\javafx-sdk-17.0.1\lib' --add-modules javafx.controls,javafx.fxml,javafx.media ColorfulCircles

