package applicatipn.android.breakout

/**
 * Created by Youta on 2016/02/20.
 */
class Ball(x:Float,y:Float,w:Float,h:Float){
    var SpeedX=20;
    var SpeedY=20;
    val size=30f;
    var x =x;
    var y=y;
    val h=h;
    val w=w;

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