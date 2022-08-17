package codingTestReady

import kotlin.Throws
import java.io.IOException
import kotlin.jvm.JvmStatic
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

object 나머지_10430번 {

    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        val A = st.nextToken().toInt()
        val B = st.nextToken().toInt()
        val C = st.nextToken().toInt()

        println((A + B) % C)
        println((A % C + B % C) % C)
        println(A * B % C)
        println(A % C * (B % C) % C)
    }
}