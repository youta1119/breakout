package applicatipn.android.breakout

/**
 * Created by Youta on 2016/02/20.
 */
class Ball(x:Float,y:Float,w:Float,h:Float){
    var SpeedX:Int=20
    var SpeedY:Int=20
    val size:Float =30f
    var x:Float = 0f
    var y:Float=0f
    var h:Float=0f
    var w:Float=0f


    init {
        this.x=x;
        this.y=y;
        this.h=h;
        this.w=w;
    }
    fun move(){
        if(x>=w-size||x<=0){
            SpeedX=-SpeedX;
        }
        if(y>=h-size||y<=0) {
            SpeedY=-SpeedY;
        }
        x+=SpeedX;
        y+=SpeedY;

    }
}