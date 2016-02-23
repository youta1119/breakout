package applicatipn.android.breakout

/**
 * Created by Youta on 2016/02/20.
 */
class Bar(y:Float){
    var left=0f;
    val top=y-20;
    var right=0f;
    val bottom=y+20;
    var touchX=0f;

    fun move(touchX:Float){
        this.touchX=touchX;
        right=touchX+150
        left=touchX-150;
    }
}
