package edu.uw.basickotlin

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(arg: Any): String {
    when (arg) {
        is String -> {
            return if (arg == "Hello") "world" else "Say what?"
        }
        is Int -> {
            when (arg) {
                0 -> return "zero"
                1 -> return "one"
                in 2..10 -> return "low numbers"
                else -> return "a number"
            }
        }
        else -> return "I don't understand"
    }
}

// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(a: Int, b: Int): Int = a + b

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(a: Int, b: Int): Int = a - b

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(a: Int, b: Int, op: (Int, Int) -> Int) = op(a, b)

// write a class "Person" with first name, last name and age
class Person(var firstName: String, var lastName: String, var age: Int) {
    val debugString: String 
        get() = "[Person firstName:$firstName lastName:$lastName age:$age]"
}

// write a class "Money"
class Money(var amount: Int, var currency: String) {
    init {
        if (amount < 0) 
            throw IllegalArgumentException("Amount cannot be less than zero")
        
        if (currency !in listOf("USD", "GBP", "EUR", "CAN"))
            throw IllegalArgumentException("Unreqcognized currency")
    }
    
    fun convert(otherCurrency: String): Money {
        if (otherCurrency !in listOf("USD", "EUR", "CAN", "GBP"))
            throw IllegalArgumentException("Unreqcognized currency")
        
        return when {
            this.currency == otherCurrency -> Money(this.amount, otherCurrency)
            this.currency == "USD" -> when (otherCurrency) {
                "GBP" -> Money((amount * 0.5).toInt(), "GBP")
                "EUR" -> Money((amount * 1.5).toInt(), "EUR")
                "CAN" -> Money((amount * 1.25).toInt(), "CAN")
                else -> convert("USD").convert(otherCurrency)
            }
            this.currency == "GBP" -> when (otherCurrency) {
                "USD" -> Money((amount * 2).toInt(), "USD")
                else -> convert("USD").convert(otherCurrency)
            }
            this.currency == "EUR" -> when (otherCurrency) {
                "USD" -> Money((amount * 0.67).toInt(), "USD")
                else -> convert("USD").convert(otherCurrency)
            }
            this.currency == "CAN" -> when (otherCurrency) {
                "USD" -> Money((amount * 0.8).toInt(), "USD")
                else -> convert("USD").convert(otherCurrency)
            }
        }
        else -> convert("USD").convert(otherCurrency)
    }

    operator fun plus(other: Money): Money {
        return Money(this.amount + (other.convert(this.currency)).amount, this.currency)
    }
}