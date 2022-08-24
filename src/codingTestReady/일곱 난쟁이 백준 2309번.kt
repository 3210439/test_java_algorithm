package codingTestReady

import java.util.*

// 실패 코드
fun main() {
    val sc = Scanner(System.`in`)
    var a = arrayOfNulls<Int>(10) as Array<Int>
    var visited = arrayOfNulls<Boolean>(10) as Array<Boolean>
    var list = mutableListOf<Int>()


    for(i in 1 until a.size){
        a[i] = sc.nextInt()
        visited[i] = false
    }
    val result = findReally(a, visited, 0, 1, 0)
    var sum = 0

    for(i in 1..9){
        if(visited[i]) list.add(a[i])
    }
    list = list.sorted() as MutableList<Int>
    for(i in list.indices){
        println(list[i])
    }
}

fun findReally(a: Array<Int>, visited: Array<Boolean>,sum: Int, index: Int, count: Int): Array<Boolean>? {

    if(sum <= 100 && count <= 7){
        if( 1 <= index && index < a.size ){
            if(!visited[index]) {
                visited[index] = true
                findReally(a, visited, sum + a[index], index - 1, count + 1)
                findReally(a, visited, sum + a[index], index+1,count+1)
            }
            else{
                findReally(a, visited, sum, index+1, count)
            }
        }
    } else if(count == 8 && sum == 100){
        return visited
    }
    return null
}