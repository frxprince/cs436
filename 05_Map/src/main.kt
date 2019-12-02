fun main(args:Array<String>){
    // immutable
 var grade= mapOf( Pair(0,"F"),Pair(1,"D"),Pair(2,"C"),Pair(3,"B"),Pair(4,"A"))
 var grade2= mapOf( Pair("0","F"),Pair("1","D"),Pair("2","C"),
     Pair("3","B"),Pair("4","A"))
  var score=3
    println(grade.get(score))
    println(grade2.get("4"))
//-------------
var alphabet= mutableMapOf<Char,Int>()
var text="dsdrfksfekrfhertweufsdfhigtf"
    for(i in text.toCharArray())
    {  if(i in alphabet){
        alphabet.set(i,alphabet.get(i)!!.plus(1))
    }else{ alphabet.put(i,1)}
    }
    for(item in alphabet)
        println(item.key + "  " + item.value)
}