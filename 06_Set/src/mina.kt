fun main(args:Array<String>){
   // do not allow duplicate
    var letter= setOf("a","b","c","g","a","b","c","a","c")
  println(letter)
    var text="dfhdj,fvhdvjkbvfjkfbhnklggdvjhklfjkxdvgfzdjf"
    var alphabet= text.toSet()
    println(alphabet)
var grams= mutableMapOf<Char,Int>()
for(c in text.toCharArray()){
    grams.set(c,(grams?.get(c)?:0)+1)
}
    println(grams)
}