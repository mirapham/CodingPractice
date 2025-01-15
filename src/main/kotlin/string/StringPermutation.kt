package mira.algo.string

// generate all permutation of a String
// str = abc => {abc, acb, bac, bca, cba, cab]

fun main() {
    val str = "1234"
    val set1 = mutableSetOf<String>()
//    set.add(str)
//    stringPermutationRecursive(0, str, set)
    set1.addAll(stringPermutation(str))
    println(set1.size)

    //
    val set2 = mutableSetOf<String>()
    stringPermutationRecursive(str, "", set2)
    println(set2.size)

    val common = set1.intersect(set2)
    println(common.size)

    set2.removeAll(set1)

    for(s in set2){
        println(s)
    }
}

// this is wrong
fun stringPermutation(str: String): List<String> {
    val set = mutableSetOf<String>()

    val len = str.length - 1

    val arr = str.toCharArray()

    for (i in 0..len) {
        for (j in 0..len) {
            val strBuilder = StringBuilder()
            val temp = arr[j]
            arr[j] = arr[i]
            arr[i] = temp
            for (n in arr) {
                strBuilder.append(n.toString())
            }
            set.add(strBuilder.toString())
//            println(strBuilder.toString())
        }
    }

    println()

    for (i in 0..len) {
        for (j in 0..len) {
            val strBuilder = StringBuilder()
            val temp = arr[j]
            arr[j] = arr[i]
            arr[i] = temp
            for (n in arr)
                strBuilder.append(n.toString())
            set.add(strBuilder.toString())
//            println(strBuilder.toString())
        }
    }

    return set.toList()

}

fun stringPermutationRecursive(str: String, prefix: String, result: MutableSet<String>) {
    if (str.isEmpty()) {
        result.add(prefix)
    } else {
        for (i in str.indices) {
            val rem = str.substring(0, i) + str.substring(i + 1)
            stringPermutationRecursive(rem, prefix + str[i], result)
        }
    }
}