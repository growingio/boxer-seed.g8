import sbt.Keys._
import sbt._

object Dependencies {

  object Versions {
    val scala212 = "2.12.10"
    val scalatest = "3.0.5"
    val scala211 = "2.11.11"
  }

  object Compiles {
  }

  object Tests {
    val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % Versions.scalatest % Test
  }

  import Compiles._

  lazy val l = libraryDependencies

  lazy val server = l ++= Seq(Tests.scalaTest)

}
