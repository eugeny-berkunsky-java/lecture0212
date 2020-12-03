import java.lang.Integer.max

/* Lecture 02.12.2020 */

fun main() {
    val a = Array(10) { row -> IntArray(10) {
            column -> (row+1) * (column+1)
        }
    }

    printArray2D(a)

    val s = sum(a)
    println("s = $s")

    val matrix = Array(15) {IntArray(15) { (-99..99).random() } }
    printArray2D(matrix)
    val max = max(matrix)
    println("max = $max")
    val (row, column) = indicesOfMax(matrix)
    println("Indices of max: $row $column")
    printMainDiag(matrix)
    printSecondDiag(matrix)
}

fun printMainDiag(matrix: Array<IntArray>) {
    for (i in matrix.indices) {
        print("%4d".format(matrix[i][i]))
    }
    println()
}

fun printSecondDiag(matrix: Array<IntArray>) {
    val N = matrix.size
    for (i in matrix.indices) {
        print("%4d".format(matrix[i][N-1 - i]))
    }
    println()
}

fun max(matrix: Array<IntArray>): Int {
    var res = matrix[0][0]
    for (row in matrix) {
        for (x in row) {
            res = max(res, x)
        }
    }
    return res
}

fun indicesOfMax(matrix:Array<IntArray>) : Pair<Int,Int> {
    var max = matrix[0][0]
    var result = Pair(0,0)
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] > max) {
                max = matrix[i][j]
                result = Pair(i,j)
            }
        }
    }
    return result
}

private fun printArray2D(a: Array<IntArray>) {
    for (row in a) {
        for (x in row) {
            print("%4d".format(x))
        }
        println()
    }
}

fun sum(array: Array<IntArray>): Int {
    var sum = 0
    for (r in array) {
        for (x in r) {
            sum += x
        }
    }
    return sum
}