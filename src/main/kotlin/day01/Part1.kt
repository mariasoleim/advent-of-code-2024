import java.io.File
import kotlin.math.abs

fun getLocationsFromFile(filePath: String): Pair<List<Int>, List<Int>> {
    val firstList = mutableListOf<Int>()
    val secondList = mutableListOf<Int>()
    File(filePath).forEachLine {
        val line = it
        val firstAndSecond = line.split("   ")
        try {
            firstList.add(firstAndSecond.first.toInt())
            secondList.add(firstAndSecond[1].toInt())
        } catch (e: NoSuchElementException) {
            throw IllegalArgumentException("Something is wrong with the file format", e)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Something is wrong with the file format", e)
        }
    }
    return Pair(firstList, secondList)
}

fun getLocationDiff(locationId1: Int, locationId2: Int): Int {
    return abs(locationId1 - locationId2)
}

fun getTotalDiff(filePath: String): Int {
    val (locationsList1, locationsList2) = getLocationsFromFile(filePath)
    val sortedLocations1 = locationsList1.sorted()
    val sortedLocations2 = locationsList2.sorted()
    val diffs = sortedLocations1.mapIndexed{ i, location -> getLocationDiff(location, sortedLocations2[i]) }
    return diffs.sum()
}

fun main() {
    val testResult = getTotalDiff("./src/main/kotlin/day01/input-test.txt")
    println("Task 1 test result: $testResult")

    val result = getTotalDiff("./src/main/kotlin/day01/input.txt")
    println("Task 1 result: $result")
}
