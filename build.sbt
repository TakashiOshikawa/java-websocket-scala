
lazy val root = (project in file(".")).
  settings(
    name := "websocket",
    version := "1.0",
    scalaVersion := "2.11.7"
  )

libraryDependencies  ++= Seq(
  "org.java-websocket" % "Java-WebSocket" % "1.3.0"
)
