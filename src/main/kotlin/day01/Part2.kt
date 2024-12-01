fun countOccurrences(number: Int, list: List<Int>): Int {
    return list.count { it == number }
}

fun getNumberOfOccurrences(locationsList1: List<Int>, locationsList2: List<Int>): List<Int> {
    return locationsList1.map { countOccurrences(it, locationsList2) }
}

fun getTotalSimilarityScore(locationsList1: List<Int>, locationsList2: List<Int>): Int {
    return getNumberOfOccurrences(locationsList1, locationsList2)
        .mapIndexed { i, value -> locationsList1[i] * value }
        .sum()
}

fun getTotalSimilarityScore(filePath: String): Int {
    val (locationsList1, locationsList2) = getLocationsFromFile(filePath)
    return getTotalSimilarityScore(locationsList1, locationsList2)
}

fun main() {
    val testResult2 = getTotalSimilarityScore("./src/main/kotlin/day01/input-test.txt")
    println("Task 2 test result: $testResult2")

    val result2 = getTotalSimilarityScore("./src/main/kotlin/day01/input.txt")
    println("Task 2 result: $result2")
}
