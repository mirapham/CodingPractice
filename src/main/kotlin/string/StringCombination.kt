package mira.algo.string

/**
 * Generate all String combination of a list of char
 * {a,b,c, d} => {a, b, c, d, ab, ac, ad, bc, bd, cd, abc, abd, bcd, abcd}
 * */

fun main() {
    val arr = charArrayOf('a', 'b', 'c')
    val combinations = generateCombinations(arr)
    combinations.forEach { println(it) }
}

fun generateCombinations(array: CharArray): List<String> {
    val result = mutableListOf<String>()
    generateCombinationsHelper(array, "", 0, result)
    return result
}

fun generateCombinationsHelper(array: CharArray, current: String, index: Int, result: MutableList<String>) {
    if (index == array.size) {
        if (current.isNotEmpty()) {
            result.add(current)
        }
        return
    }

    // Include the current character
    generateCombinationsHelper(array, current + array[index], index + 1, result)

    // Exclude the current character
    generateCombinationsHelper(array, current, index + 1, result)
}