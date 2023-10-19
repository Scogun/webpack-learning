package org.example

import org.example.services.AlertService
import org.example.services.ComponentService
import org.example.utils.inputsAreValid
import org.example.utils.parsedInputs

fun run(alertService: AlertService, componentService: ComponentService) {

    alertService.hideErrors()

    componentService.onClick {
        val inputs = componentService.inputs
        val parsedInputs = parsedInputs(inputs)
        if (inputsAreValid(parsedInputs)) {
            componentService.setResult("${parsedInputs[0]!! + parsedInputs[1]!!}")
        } else {
            componentService.setResult("")
            alertService.handleAdditionError(inputs, parsedInputs)
        }
    }
}