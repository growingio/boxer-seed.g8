package $organization$

import io.growing.boxer.bootstrap.Bootstrap

object $module_name;format="Camel"$Bootstrap {

  def main(args: Array[String]): Unit = {
    val logo = """$name$""".stripMargin

    Bootstrap(logo).bind().awaitShutdown()

  }

}
