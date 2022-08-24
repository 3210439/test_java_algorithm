package codingTestReady

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var list = mutableListOf<Int>()
    var sum = 0
    var index1 = 0
    var index2 = 0

    for (i in 0 until 9){
        list.add(sc.nextInt())
        sum += list[i]
    }

    for(i in 0 until list.size-1){
        for(j in i+1 until list.size){
            if(100 == (sum - list[i] - list[j])){
                index2 = j
                index1 = i
            }
        }
    }

    list.removeAt(index2)
    list.removeAt(index1)
    list.sort()

    for(value in list){
        println(value)
    }
}
