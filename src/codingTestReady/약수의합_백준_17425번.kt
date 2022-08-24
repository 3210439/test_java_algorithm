package codingTestReady

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 시간 초과 남
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val a = arrayOfNulls<Int>(n+1)
    var ans = 0L

    // 테스트케이스 만큼 반복
    for(i in 1..n){
        a[i] = reader.readLine().toInt()

        ans = 0L
        for(j in 1..a[i]!!){
            ans += j*(a[i]?.div(j)!!)
        }
        writer.write("${ans}\n")
    }

    writer.flush()
    writer.close()
}