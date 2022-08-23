package codingTestReady

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


val read = BufferedReader(InputStreamReader(System.`in`))
val write = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = read.readLine().toInt()
    var a = arrayOfNulls<Int>(n+1)
    val st = StringTokenizer(read.readLine())
    var num = 0

    for(i in 1 .. n){
        a[i] = st.nextToken().toInt()

        if(a[i]!! < 3){
            num++
            if(a[i]!! == 1){
                num--
            }
        }
        else {
            for (j in 2 until a[i]!!) {
                if (a[i]!! % j == 0) {
                    break
                }
                if(j == a[i]!! -1) num++
            }
        }
    }

    write.write("${num}")
    write.flush()
    write.close()
}