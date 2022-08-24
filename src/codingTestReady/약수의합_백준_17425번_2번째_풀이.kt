package codingTestReady

const val MAX = 1000000
val reader = System.`in`.bufferedReader()
val writer = System.out.bufferedWriter()
val g =  LongArray(MAX){1}

fun solveF() {
    for(i in 2 until MAX){
        for(j in i until MAX step i){
            g[j] += i.toLong()
        }
    }
}

fun solveG(){
    for(i in 2 until MAX){
        g[i] += g[i-1]
    }
}

fun main() {
    val n = reader.readLine().toInt()
    solveF()
    solveG()
    repeat(n){
        writer.write("${g[reader.readLine().toInt()]}\n")
    }
    writer.flush()
    writer.close()
}

