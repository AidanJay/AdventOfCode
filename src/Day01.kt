import java.lang.Integer.parseInt

fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf {
            val nums = it.filter { it.isDigit() }
            (nums.first().toString() + nums.last()).toInt()
        }
    }

    // maps assign alternate values to a reference
    val numMap = mapOf("zero" to "0", "one" to "1", "two" to "2", "three" to "3",
            "four" to "4", "five" to "5", "six" to "6", "seven" to "7", "eight" to "8",
            "nine" to "9")

    fun part2(input: List<String>): Int {
        return input.sumOf {
            var firstNum = it.findAnyOf(numMap.keys + numMap.values)?.second!!
            var lastNum = it.findLastAnyOf(numMap.keys + numMap.values)?.second!!

            var wordFirst = false
            var wordLast = false

            try {
                val num = parseInt(firstNum)
            } catch (e: NumberFormatException) {
                wordFirst = true
            }

            try {
                val num = parseInt(lastNum)
            } catch (e: NumberFormatException) {
                wordLast = true
            }

            if (wordFirst) {
                firstNum = numMap[firstNum]!!
            }
            if (wordLast) {
                lastNum = numMap[lastNum]!!
            }
            (firstNum + lastNum).toInt()
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("numbers")
    part1(testInput).println()
    part2(testInput).println()
}
