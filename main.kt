
// val: permanent value
// var: temporary value

// PART 5
fun generateAnswerString(count: Int): String {
    val answerString = if (count == 42) {
        "I have the answer."
    } else {
        "The answer eludes me."
    }
    return answerString
}

// PART 6
fun generateAnswerString_2(count: Int, countThreshold: Int): String {
    val answerString = if (count > countThreshold) {
        "I have the answer."
    } else {
        "The answer eludes me."
    }

    return answerString
}

// PART 7: REDUCING FUNCTION SIZE
fun generateAnswerString_3(count: Int, countThreshold: Int): String = if (count > countThreshold) {
        "I have the answer"
    } else {
        "The answer eludes me"
    }

// PART 8: ANONYMOUS FUNCTIONS
val stringLengthFunc: (String) -> Int = { input ->
    input.length
}

fun main () {
    // PART 1
    var count: Int = 10
    count = 15
    println(count)

    // PART 2
    if (count == 42) {
        println("I have the answer")
    } else if (count > 35) {
    println("The answer is close.")
    } else {
        println("Answer eludes me")
    }

    // PART 3
    val answerString: String = if (count == 42) {
        "I have the answer."
    } else if (count > 35) {
        "The answer is close."
    } else {
        "The answer eludes me."
    }

    println(answerString)

    // PART 4
    val answerString_2 = when {
        count == 42 -> "I have the answer."
        count > 35 -> "The answer is close."
        else -> "The answer eludes me."
    }

    println(answerString_2)

    // PART 5 CONT.
    val answerString_3 = generateAnswerString(count)
    println("PART 5: ${answerString_3}")
    
    // PART 6 CONT.
    val answerString_4 = generateAnswerString_2(count, 42)
    println("PART 6: ${answerString_4}")
    
    // PART 7 CONT.
    val answerString_5 = generateAnswerString_3(count, 42)
    println("PART 7: ${answerString_5}")

    //PART 8 CONT.
    val stringLength: Int = stringLengthFunc("Android")
    println("PART 8: ${stringLength}")
}