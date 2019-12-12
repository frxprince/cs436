fun main(args:Array<String>){
    var x=shape()
    x.width=10.0
    x.height=20.0
    x.area=100.0
    x.print_attr()
    var x2=shape(10.0,20.0)
    x2.print_attr()
    var x3=rectangle(100.0,50.0)
    x3.find_area()
    x3.print_attr()
    var x4=square(50.0)
    x4.find_area()
    x4.print_attr()
    var x5=circle(3.0)
    x5.find_area()
    x5.print_attr()

    var x6=square2(3.0)
    x6.find_area()
    x6.print_data(object:User_Print{
        override fun myPrint(w: Double, h: Double, area: Double) {
            println("w=$w , h=$h, area=$area")
         }
    })
    x6.print_attr()
}
open class shape(var width:Double=0.0, var height:Double=0.0){
     var area:Double=0.0
    fun print_attr(){
        println("width= $width , height=$height, area=$area")
    }
    init { println("Class shape Activated!")}
}
open class rectangle( w:Double=0.0,  h:Double=0.0):shape(w,h){
    open fun find_area(){
        area=width * height
    }
}
open class square(w:Double=0.0):rectangle(w,w)
class circle(r:Double=0.0):square(r){
    override fun find_area(){
       area=Math.PI *width*width
    }
}
open class square2(w:Double=0.0):rectangle(w,w)
{
    fun print_data(myprint:User_Print){
        myprint.myPrint(width,height,area)
    }
}
interface User_Print{
    fun myPrint(w:Double,h:Double,area:Double)
}

/*
class shape{
    var width:Double=0.0
    var height:Double=0.0
    var area:Double=0.0
    fun print_attr(){
     println("width= $width , height=$height, area=$area")
    }
    init { println("Class shape Activated!")}
}

 */