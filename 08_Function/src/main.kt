fun main(args:Array<String>){
   var x=add(2,5)
    println(x)
    println(add(b=5,a=2))
    println(mux(5,10))
    println(mux(5))
    println(sub(10,7))
    printme("hello world")
}
fun add(a:Int,b:Int):Int{
  println("a = $a   b= $b")
   return a+b
}
fun mux(a:Int,b:Int=1):Int{
    println("a = $a   b= $b")
    return a*b
}
fun sub(a:Int,b:Int):Int= a-b
fun printme(s:String):Unit=println("Message:$s")