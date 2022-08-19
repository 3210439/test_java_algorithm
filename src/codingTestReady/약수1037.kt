package codingTestReady

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    val st = StringTokenizer(reader.readLine())
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    for(i in 0 until n){
        val a = st.nextToken().toInt()
        if(min > a) min = a
        if(max < a) max = a
    }
    println(min * max)
}