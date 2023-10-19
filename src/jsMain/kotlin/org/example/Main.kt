package org.example

import kotlinx.browser.document
import org.w3c.dom.Element
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSpanElement

fun main() {
    val numberOneInput = document.getElementById("numberOne") as HTMLInputElement
    val numberTwoInput = document.getElementById("numberTwo") as HTMLInputElement
    val addValuesButton = document.getElementById("addValues")
    val resultDiv = document.getElementById("result") as HTMLSpanElement
    val errorBox = document.getElementById("error") as HTMLDivElement

    hideErrors(errorBox)

    addValuesButton?.addEventListener("click", {
        hideErrors(errorBox)
        val inputs = listOf(numberOneInput.value, numberTwoInput.value)
        val parsedInputs = parsedInputs(inputs)
        if (inputsAreValid(parsedInputs)) {
            resultDiv.innerText = "${parsedInputs[0]!! + parsedInputs[1]!!}"
        } else {
            resultDiv.innerText = ""
            handleAdditionError(inputs, parsedInputs, errorBox)
        }
    })
}

private fun hideErrors(box: Element?) {
    box?.classList?.add("invisible")
}

private fun parsedInputs(inputs: List<String>) = inputs.map { it.toIntOrNull() }

private fun inputsAreValid(inputs: List<Int?>) = inputs.all { it != null }

private fun handleAdditionError(inputs: List<String>, numbers: List<Int?>, box: HTMLDivElement?) {
    val fullMessage = inputs.foldIndexed("Please enter two valid numbers! ") { index, message, s ->
        if (inputsAreValid(listOf(numbers[index]))) {
            message + ""
        } else {
            "$message$s is not a number! "
        }
    }

    box?.classList?.remove("invisible")
    box?.innerText = fullMessage
}