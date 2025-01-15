package mira.algo.sortingandsearching

fun main() {
    val result = firstBadVersion(5)
    println(result)
}

// 1 2 3 4 5
fun firstBadVersion(n: Int): Int {
    var index1 = n
    var index2 = n/2
    var count1 = 0
    var count2 = 0
    while (index1 >= index2 || index2>0) {
        if (isBadVersion(index1)) {
            count1++
        } else {
            if (count1 > 0) {
                return index1 + 1
            }
        }
        index1--

        if (isBadVersion(index2)) {
            count2++
        } else {
            if (count2 > 0) {
                return index2 + 1
            }
        }
        index2--
    }

    return index1
}

fun isBadVersion(n: Int): Boolean {
    if (n == 4 || n == 5) return true

    return false
}