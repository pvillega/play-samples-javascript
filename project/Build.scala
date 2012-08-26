import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "play-samples-javascript"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
      // https://github.com/julienrf/play-jsmessages
      "com.github.julienrf" %% "play-jsmessages" % "1.2"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // we only compile mainless.less, the other less files are used via imports
      lessEntryPoints <<= baseDirectory(_ / "app" / "assets" / "stylesheets" ** "mainless.less"),
	    //required for i18n in javascript
      resolvers += "julienrf.github.com" at "http://julienrf.github.com/repo/"
    )

}
