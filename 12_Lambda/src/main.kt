fun main(args:Array<String>){
    var a= listOf<Int>(1,2,4,3,2,3,11,6,7,8,9,7,6,5,4,3,0,13,23)
    println(a)
    var b=SortList(a,10)
    println(b)
    var c=SortList(a) {
        i -> i.sorted()
             }
    println(c)
    ForEach(a){
        i,j->println("$i $j")
        println(i+j)
    }
}
fun ForEach(x:List<Int>,job:(Int,Int)->Unit):Unit{
    for((index,item) in x.withIndex()){
      job(index,item)
    }
}



fun SortList(x:List<Int>,m:Int=0):List<Int>{
    if (m>0)
        return x.sortedDescending()
    return x.sorted()
}
fun SortList(x:List<Int>, algorithm:(List<Int>)-> List<Int>):List<Int>{
    println("function call")
    return algorithm(x)
}

