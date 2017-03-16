name := """play_java_akka_quartz_scheduler"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "com.enragedginger" %% "akka-quartz-scheduler" % "1.6.0-akka-2.4.x"

)
