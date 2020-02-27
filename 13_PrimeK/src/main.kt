fun main(args:Array<String>){
    println(FindPrimeK(100))
}

fun isPrime(x:Long):Boolean{
    for (i in 2..x-1)
    {
        if((x%i)==0L)
            return false
    }
    return true
}
fun FindPrimeK(k:Long):Long{
    var i=3L
    var c=0L
    while (true)
    {  if(isPrime(i))
       {  c++
           if(c==k)
               return i
        }
        i++
    }
}