package org.example.services

import kotlinx.browser.document
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSpanElement
import org.w3c.dom.events.Event

class ComponentService {

    private val numberOneInput = document.getElementById("numberOne") as HTMLInputElement
    private val numberTwoInput = document.getElementById("numberTwo") as HTMLInputElement
    private val addValuesButton = document.getElementById("addValues")
    private val resultDiv = document.getElementById("result") as HTMLSpanElement

    val inputs: List<String>
        get() = listOf(numberOneInput.value, numberTwoInput.value)

    fun setResult(result: String) {
        resultDiv.innerText = result
    }

    fun onClick(callBack: (Event) -> Unit) {
        addValuesButton?.addEventListener("click", callBack)
    }
}