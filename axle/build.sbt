name := """axle"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies += "org.springframework" % "spring-webmvc" % "4.1.5.RELEASE"
  
libraryDependencies += "org.jboss.resteasy" % "resteasy-client" % "3.0.11.Final"
  
libraryDependencies += "org.commonjava.googlecode.markdown4j" % "markdown4j" % "2.2-cj-1.0"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)


fork in run := true