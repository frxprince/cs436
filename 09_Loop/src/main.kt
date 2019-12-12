fun main(args:Array<String>){
    var data= listOf("Hello","World","abcd","csmju",1234)
    // -- for each
    for ((i,item) in data.withIndex()){
       println(" data at ${i+1} is $item")
    }
    // -- for range
    for (i in 10..100){
        print(" $i")
    }
    println()
    for (i in 0..10 step 2){
        print(" $i")
    }
    println()
    for (i in 10 downTo 0 step 2){
        print(" $i")
    }
 // ----- repeat
    println()
    repeat(10){
        print(" X ")
    }
    println()
    repeat(10){
    j->print(" X$j ")
    }

    //------ while do
    println()
    var i=0
    while (i<10){
        print(i)
        i++
    }

   // ----- do while
    println()
    var j=0
    do {
        print(j)
        j++
    }while (j<10)

  // break  continue
    println()
    for (i in 0..10){
        if (i==5)
            continue
            print(" $i")
            print(",")
        if(i==8)
            break
    }
    // labelling
    println()
loop1@    for (r in 1..5){
loop2@        for (c in 1..6){
        if (r==4)
            break@loop1
        if(c==4)
            break@loop2
         print(" ($r,$c)")
        }
        println()
    }






}