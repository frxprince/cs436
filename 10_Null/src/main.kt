fun main(args:Array<String>){
    var text:String?=null
//     object?: value if null
    //  object?.method?: value if null
    // object.method1.method2.?method3?: value if null
//text="hello"
     println(text?:"No data"   )
    println(text?.length?:"I don't have data"    )

   var data= listOf("Hello",1234,1234.0,'a',null,"World")
    for (item in data.filterNotNull())
        println(item)
}