package $organization$

import scalikejdbc.{ GlobalSettings, LoggingSQLAndTimeSettings }

object $module_name;format="Camel"$BootstrapRunner extends App {

  GlobalSettings.loggingSQLAndTime = LoggingSQLAndTimeSettings(
    enabled = true,
    singleLineMode = true,
    logLevel = 'INFO)

  $module_name;format="Camel"$Bootstrap.main(args)

}
