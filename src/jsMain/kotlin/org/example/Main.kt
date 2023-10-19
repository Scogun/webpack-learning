package org.example

import kotlinext.js.require
import org.example.services.AlertService
import org.example.services.ComponentService

fun main() {

    require<Any>("./main.css")

    val alertService = AlertService()
    val componentService = ComponentService()

    run(alertService, componentService)
}

