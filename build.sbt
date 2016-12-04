enablePlugins(ScalaJSPlugin)

resolvers += Resolver.mavenLocal

name := "google-analytics-scalajs"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.1"

skip in packageJSDependencies := false
jsDependencies += "org.webjars" % "google-analytics-snippet" % "20161204" / "20161204/analytics-snippet.js"

