fun main(args:Array<String>){
    var items= listOf("hello","World",123,123.456,"hello") // immutable
    println(items.get(1))
    for( i in items)
    {
        println(i.toString() + " : " + i::class.simpleName  )
    }

    var items2= mutableListOf("hello","World",123,123.456,"hello") // mutable
items2.set(4,"hello world")
    items2.add(1,"ei ei")
    for( i in items2)
    {
        println(i.toString() + " : " + i::class.simpleName  )
    }
}