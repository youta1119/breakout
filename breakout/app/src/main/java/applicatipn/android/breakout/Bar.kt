package applicatipn.android.breakout

/**
 * Created by Youta on 2016/02/20.
 */
class Bar(y:Float){
    var left:Float=0f;
    var top:Float=0f;
    var right:Float=0f;
    var bottom:Float=0f;
    val helfSize:Float=150f;
    var touchX:Float=0f;

    init{
        top=y-20;
        bottom=y+20;
    }
    fun move(touchX:Float){
        this.touchX=touchX;
        right=touchX+ helfSize
        left=touchX- helfSize;
    }
}
