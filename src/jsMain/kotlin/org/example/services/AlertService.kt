package org.example.services

import kotlinx.browser.document
import org.example.utils.inputsAreValid
import org.w3c.dom.HTMLDivElement

class AlertService {

    private val errorBox = document.getElementById("error") as HTMLDivElement

    fun hideErrors() {
        errorBox.classList.add("invisible")
    }

    fun handleAdditionError(inputs: List<String>, numbers: List<Int?>) {
        val fullMessage = inputs.foldIndexed("Please enter two valid numbers! ") { index, message, s ->
            if (inputsAreValid(listOf(numbers[index]))) {
                message + ""
            } else {
                "$message$s is not a number! "
            }
        }

        errorBox.classList.remove("invisible")
        errorBox.innerText = fullMessage
    }
}