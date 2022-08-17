package codingTestReady

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    while(true){
        val line = br.readLine() ?: break
        bw.append(findSmallest(br.readLine().toInt()).toString()+"\n")
    }
    bw.flush()
    bw.close()

}

fun findSmallest(n: Int): Int {
    var count = 1
    var now = 1L
    while(true){
        if(now % n.toLong() == 0L) break
        now = now*10 + 1
        count += 1
    }
    return count
}
