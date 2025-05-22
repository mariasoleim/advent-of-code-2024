import java.io.File

fun isSafe(report: List<Int>): Boolean {
    if (report.size < 2) return true
    val diffs = report.zipWithNext { a, b -> b - a }
    val increasing = diffs.all { it in 1..3 }
    val decreasing = diffs.all { it in -3..-1 }
    return increasing || decreasing
}

fun countSafeReports(filePath: String): Int {
    val reports = File(filePath).readLines().map { line ->
        line.trim().split(" ").filter { it.isNotBlank() }.map { it.toInt() }
    }
    return reports.count { isSafe(it) }
}

fun main() {
    val result = countSafeReports("./src/main/kotlin/day02/input.txt")
    println("Safe reports: $result")
}
