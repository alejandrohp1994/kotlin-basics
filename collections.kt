fun main() {
    //LISTS
    
    val numbers = listOf(0,3,8,4,0,5,8,9,2)
    println("list: ${numbers}")

    val sorted = numbers.sorted()
    println("sorted: ${sorted}")

    val setOfNumbers = numbers.toSet()
    println("set: ${setOfNumbers}")

    val set1 = setOf(1,2,3)
    mutable: liable to change
    val set2 = mutableSetOf(3,2,1)
    println("$set1 == $set2: ${set1 == set2}")
    println("contains 7: ${setOfNumbers.contains(7)}")
    

    //MAPS

    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )

    //To add new elements to the dicitonary
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    println(peopleAges)

    //Pretty print
    peopleAges.forEach { print("${it.key} is ${it.value}, ") }

    println( peopleAges.map {
        "${it.key} is ${it.value}" 
        }.joinToString(", "))

    val filtered = peopleAges.filter {it.key.length < 4}
    // it referes at the length of the string used as a key
    println(filtered)


     //LAMBDA FUNCTIONS

     //PART 1
     val triple: (Int) -> Int = {
        a: Int -> a * 3
     }
     println(triple(5)) 

     // PART 2: OMITTING THE IMPLICIT
     val triple2: (Int) ->Int = { it * 3}
     println(triple2(6))

     //PART 3: HIGH ORDER FUNCTIONS
     //Concept: passing a lambda or a function into another function or
     //         returning a function from another function

    val peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")
    println(peopleNames.sorted())
    println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length })

    //Note: If you don't use a lambda parameter in the function body,
    //      you can name it _ to make your code more readable and less cluttered.
    //      This code has the same behavior.
    //costOfServiceEditText.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode) }

    val words = listOf("about", "acute", "awesome", "balloon", "best", "brief", "class", "coffee", "creative")
    val filteredWords = words.filter {
        it.startsWith("b", ignoreCase = true)
        }
    println(filteredWords)

    val shuffled = filteredWords.shuffled()
    println(shuffled)

    val takeTwo = shuffled.take(2)
    println(takeTwo)

    val sorted_ = takeTwo.sorted()
    println(sorted_)
} 
