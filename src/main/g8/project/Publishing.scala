import sbt.Keys._
import sbt._

object Publishing extends AutoPlugin {

  override def trigger: PluginTrigger = allRequirements

  override def projectSettings: Seq[_root_.sbt.Def.Setting[_]] = Seq(
    credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
    publishMavenStyle := true,
    publishTo := {
      val nexus = "http://52.80.121.32:8081/nexus/"
      if (isSnapshot.value) {
        Some("snapshots" at nexus + "content/repositories/snapshots")
      } else {
        Some("releases" at nexus + "content/repositories/releases/")
      }
    },
    pomExtra :=
      <url>$project_url$</url>
      <scm>
        <url>$project_git$</url>
        <connection>scm:git:$project_git$</connection>
      </scm>
      <developers>
        <developer>
          <id>yanbo.ai</id>
          <name>Andy Ai</name>
          <url>http://aiyanbo.github.io/</url>
        </developer>
      </developers>)

}

object DontPublish extends AutoPlugin {

  override def requires: Plugins = plugins.IvyPlugin

  override def projectSettings: Seq[_root_.sbt.Def.Setting[_]] = Seq(
    publishArtifact := false,
    publish := Unit,
    publishLocal := Unit)

}
