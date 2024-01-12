package edu.uw.basickotlin

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(arg: Any): String {
    when (arg) {
        is String -> {
            if (arg == "Hello") {
                return "world"
            } else {
                return "Say what?"
            }
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
fun add(lhs: Int, rhs: Int): Int = 

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(lhs: Int, rhs: Int): Int = 0

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(lhs: Int, rhs: Int, op: (Int, Int) -> Int) = 0

// write a class "Person" with first name, last name and age

// write a class "Money"
