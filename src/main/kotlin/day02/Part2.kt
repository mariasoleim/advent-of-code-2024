import java.io.File

fun isSafeWithDampener(report: List<Int>): Boolean {
    if (isSafe(report)) return true
    // Try removing each level once
    for (i in report.indices) {
        val modified = report.toMutableList()
        modified.removeAt(i)
        if (isSafe(modified)) return true
    }
    return false
}

fun countSafeReportsWithDampener(filePath: String): Int {
    val reports = File(filePath).readLines().map { line ->
        line.trim().split(" ").filter { it.isNotBlank() }.map { it.toInt() }
    }
    return reports.count { isSafeWithDampener(it) }
}

fun main() {
    val result = countSafeReportsWithDampener("./src/main/kotlin/day02/input.txt")
    println("Safe reports with dampener: $result")
}
