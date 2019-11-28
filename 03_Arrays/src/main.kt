fun main(args:Array<String>){
    var a= arrayOf(1,2,3,4,5,6,7,8)
    a[0]=100
    println(a[0])
    a.set(0,200)
    println(a.get(0))
    //var b=Array<Int>(8,init = {index->index+1})
var b=Array<Int>(8,init={index->index+1})

    var c=Array<String>(10,init={index->"Hello World ${index+1} "})

 var d= arrayOfNulls<String>(5)
    d.set(0,"john")
    d.set(1,"pater")
    d.set(2,"ann")
    d.set(3,"tom")
    d.set(4,"mike")
    d.sort()
    for((i,item) in d.withIndex())
        println("index:$i   data:$item")
var temp= readLine()
var param=temp!!.split(" ")
 var area=0.5 * param[0].toDouble() * param[1].toDouble()
   println(  "%.4f".format(area)   )
}