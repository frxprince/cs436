fun main(args:Array<String>){
    //Immutable
    val pi:Double=3.1415926
    val pii=2.3456789
    val abcd:Int
    abcd=123
    println(pi)
    println(pii)
    println(abcd)
    // mutable
    var mpi=3.14159
    println(mpi)
    mpi=12345.0
    println(mpi)
    println(mpi::class.simpleName  + mpi.toString() )
}