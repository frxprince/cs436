fun main(args:Array<String>){
  // Escape String
    var S1:String="Hello\nWorld"
    var S2:String="Hello\\nWorld"
    // Raw String
    var S3:String="""Hello\nWorld\t\e\c\b\drf\xcv\sdf\ff\sg """
    var S4="""Hmm. We’re having trouble
   finding that site.

We can’t connect to the
        server at duckduckgo.com."""

    println(S1)
    println(S2)
    println(S4)
    //--------------------
 var a="hello"
 var b="world"
  //  println(a.equals(b))
    println(a==b)
 var x=100
    var y=3
  // String Template
    println(a+" "+b+" "+x.toString()+ " " +y.toString()+ " "+
            (x+y).toString())
println(" $a  $b   $x   $y " +(x+y))
    println(" $a  $b   $x   $y ${x+y}")
//-------------
    val h=readLine()!!.toDouble()
    val w= readLine()!!.toDouble()
    println(h * w)

}