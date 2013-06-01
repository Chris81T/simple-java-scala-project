simple-java-scala-project
=========================

This maven multi module project is used to find out, how it is possible to use it smart with IntelliJ / jRebel. The aim is to deploy the EAR to a JBoss AS 7.1 JEE6 app server as an exploded artifact.

Modules
=======

- calculator ( simple JAR containing a scala object )
- java-service ( a simple local EJB, that uses the calculator
- scala-web ( a simple scala liftweb app, that uses the java-service, provides a REST resource for AngularJS )
- simple-ear ( that contains the other modules to deploy it to the JBoss AS 7.1 app server )


Simple Test
===========

call 
- http://localhost:8080/geeksession/api/say/something 
in your web browser or call
- http://localhost:8080/geeksession/index.html
