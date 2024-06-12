package org.example.multicalculator

class Calculator {
    fun Add(left: Int, right: Int): Int {
        return left + right
    }

    fun Subtract(left: Int, right: Int): Int {
        return left - right
    }

    fun Multiply(left: Int, right: Int): Int {
        return left * right
    }

    fun Divide(left: Int, right: Int): Int {
        if (right == 0) throw IllegalArgumentException("Cannot divide by zero")
        return left / right
    }
}