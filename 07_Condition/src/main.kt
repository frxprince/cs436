fun main(args:Array<String>){
    var score=51
    if(score>=80){
        println("A")
    }else if (score >=70){
        println("B")
    }else if (score>=60){
        println("C")
    }else if(score>=50){
        println("D")
    }else{
        println("F")
    }
/*
   var result:String
   if(score>=50)
       result="pass"
   else
       result="fail"
    println(result)
*/

var result =if(score>=50)"pass" else "fail"
    println(result)

 var grade=   if(score>=80){
        "A"
    }else if (score >=70){
        "B"
    }else if (score>=60){
        "C"
    }else if(score>=50){
        "D"
    }else{
        "F"
    }
    println(grade)
//----------------
    var lang="en"
    when(lang){
       "th"-> {
           println("Thailand")
           println("My country")
              }
        "en"-> println("English")
        "jp" -> println("Japan")
        else-> println("I don't know")
    }
   var name= when(lang){
        "th"-> "Thailand"
        "en"-> "English"
        "jp" -> "Japan"
        else-> "I don't know"
    }
    println(name)

}