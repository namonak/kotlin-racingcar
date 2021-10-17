package step2.module

import step2.exception.CalculatorMessage
import step2.exception.CustomException
import java.util.LinkedList
import java.util.Queue

class CalculatorParser : ParserModule {

    private fun String.isNullOrEmpty() {
        if (this.isEmpty()) throw CustomException(CalculatorMessage.NULL_AND_EMPTY)
    }

    private fun String.isDigit(): Boolean =
        try {
            this.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }

    private fun String.operatorCheck(): Boolean {
        return when (this) {
            "+" -> true
            "-" -> true
            "*" -> true
            "/" -> true
            else -> throw CustomException(CalculatorMessage.NOT_OPERATOR)
        }
    }

    private val queue: Queue<String> = LinkedList()

    override fun parse(input: String): Queue<String> {

        input.isNullOrEmpty()

        val calculatorText = input.split(" ")

        for (text in calculatorText) {

            if (text.isDigit()) {
                queue.add(text)
                continue
            }

            if (text.operatorCheck()) {
                queue.add(text)
            }
        }

        return queue
    }
}