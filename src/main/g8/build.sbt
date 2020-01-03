import Dependencies.Versions
import org.jmotor.sbt.plugin.ComponentSorter

lazy val commonSettings = Seq(
  scalaVersion := Versions.scala212,
  organization := "$organization$",
  dependencyUpgradeModuleNames := Map(
    "scala-library" -> "scala"
  ),
  dependencyUpgradeComponentSorter := ComponentSorter.ByAlphabetically
)

lazy val proto = subProject("$module_name$-proto")
  .settings(BoxerProto)
  .settings(crossScalaVersions := Seq(Versions.scala212, Versions.scala211))
  .enablePlugins(ProtocPlugin, Publishing)

lazy val `$module_name$-server` = subProject("$module_name$-server")
  .dependsOn(proto)
  .settings(BoxerServer)
  .settings(Dependencies.server)
  .enablePlugins(DontPublish, JavaServerAppPackaging)

lazy val root = subProject("$name$", Some("."))
  .aggregate(proto, `$module_name$-server`)
  .enablePlugins(DontPublish)

def subProject(id: String, path: Option[String] = None): Project = {
  Project(id, file(path.getOrElse(id))).settings(commonSettings)
}
