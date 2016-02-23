package applicatipn.android.breakout

import java.util.*

/**
 * Created by Youta on 2016/02/21.
 */
class Game(w:Float,h:Float){
    val w:Float=w;
    val h:Float=h;
    val list= ArrayList<Brock>();
    val ball:Ball= Ball(this.w/2,this.h/2,this.w,this.h);
    val bar:Bar= Bar(this.h-this.h/5);

    fun set_brock() {
        val width: Float = ((w / 8).toInt()).toFloat();
        val height: Float = 40f;
        var sumW: Float = 0f;
        var sumH: Float = 0f;
        for (i in 1..7) {
            for (j in 1..8){
                val brock: Brock = Brock();
                brock.left = sumW + 1;
                brock.top = sumH + 1;
                brock.right = width + sumW - 1;
                brock.bottom = height + sumH - 1
                sumW += width;
                list.add(brock);
            }
            sumH += height;
            sumW = 0f;
        }
    }

    fun  collision_bar() {
        if ((ball.x > bar.left) && (ball.x < bar.right)) {
            if ((ball.y > bar.top - ball.size) && (ball.y < bar.bottom + ball.size)) {
                if(ball.x<bar.touchX){
                    ball.SpeedX = 3;
                }else{
                    ball.SpeedX = -3;
                }
                ball.SpeedY = -ball.SpeedY;

            }
        }
    }
    fun  collision_brock() {
        for (i in list) {
            if (i.flag && (ball.x > i.left) && (ball.x < i.right) &&
                    (ball.y > i.top - ball.size) && (ball.y < i.bottom + ball.size)) {
                ball.SpeedY = -ball.SpeedY;
                ball.SpeedX = -ball.SpeedX;
                i.flag = false;
            }
        }
    }
}
