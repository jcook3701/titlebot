name := "titlebot"
version := "0.1"
scalaVersion := "2.13.7"

// Jsoup
libraryDependencies += "org.jsoup" % "jsoup" % "1.14.3"

// Scala-Scraper
//libraryDependencies += "net.ruippeixotog" %% "scala-scraper" % "2.2.0"

libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
)

// Playframwork
enablePlugins(PlayScala)

// ScalaJs
// scalaJSUseMainModuleInitializer := true   // this is an application with a main method
// Compile/mainClass := Some("search")
//enablePlugins(ScalaJSPlugin)

      
// DOM
//libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.0.0"
//libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.1.0"

// jQuery
//libraryDependencies += "org.querki" %%% "jquery-facade" % "2.0"
//enablePlugins(JSDependenciesPlugin)
//jsDependencies += "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js"
