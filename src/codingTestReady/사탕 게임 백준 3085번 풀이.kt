package codingTestReady

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()
    var max = 1
    var arr = Array(n+1) { Array(n+1) { "x" } }

    for(i in 1..n){
        val str = reader.readLine()
        for(j in 1..n){
            arr[i][j] = str[j-1].toString()
        }
    }

    for(i in 1..n){
        for(j in 1..n){
            val left =leftToRight(arr, i ,j)
            val up = upToDown(arr, i, j)

            if(max < left) max = left
            if(max < up) max = up
        }
    }

    println(max)
}

fun leftToRight(arr : Array<Array<String>>, i: Int, j: Int): Int {

    var count = 1
    var max = 1

    if(arr[i].size > j+1) {
        val temp = arr[i][j]
        arr[i][j] = arr[i][j + 1]
        arr[i][j + 1] = temp


    for(i in 1 until arr.size){
        for(j in 1 until arr.size-1){
            if(arr[i][j] == arr[i][j+1]) count += 1
            else if(count > 1){
                if( count > max) max = count
                count = 1
            }
        }
        if(count > 0){
            if( count > max) max = count
            count = 1
        }

        for(j in 1 until arr.size-1){
            if(arr[j][i] == arr[j+1][i]) count += 1
            else if(count > 1){
                if( count > max) max = count
                count = 1
            }

        }
        if(count > 0){
            if( count > max) max = count
            count = 1
        }
    }

        arr[i][j + 1] = arr[i][j]
        arr[i][j] = temp

    }

    return max
}

fun upToDown(arr : Array<Array<String>>, i: Int, j: Int): Int {
    var count = 1
    var max = 1

    if(arr.size > i+1) {
        val temp = arr[i][j]
        arr[i][j] = arr[i+1][j]
        arr[i+1][j] = temp


    for(i in 1 until arr.size){
        for(j in 1 until arr.size-1){
            if(arr[i][j] == arr[i][j+1]) count += 1
            else if(count > 1){
                if( count > max) max = count
                count = 1
            }
        }

        if(count > 1){
            if( count > max) max = count
            count = 1
        }

        for(j in 1 until arr.size-1){
            if(arr[j][i] == arr[j+1][i]) count += 1
            else if(count > 0){
                if( count > max) max = count
                count = 1
            }
        }

        if(count > 1){
            if( count > max) max = count
            count = 1
        }
    }

        arr[i+1][j] = arr[i][j]
        arr[i][j] = temp
    }

    return max
}
