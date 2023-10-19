package org.example

import org.example.services.AlertService
import org.example.services.ComponentService

fun main() {

    val alertService = AlertService()
    val componentService = ComponentService()

    run(alertService, componentService)
}

