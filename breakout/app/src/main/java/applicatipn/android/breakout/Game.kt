package applicatipn.android.breakout

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import java.util.*

/**
 * Created by Youta on 2016/02/21.
 */
class Game(w:Float,h:Float){
    var w=0f;
    var h=0f;
    val list= ArrayList<Brock>();
    init {
        this.w=w;
        this.h=h;
        set_brock();
    }


    val ball= Ball(w/2,h/2,w,h);
    val bar= Bar(h-h/5);
    var touchX=w/2;
    fun set_brock() {
        val width= ((w / 8).toInt()).toFloat();
        val height= 40f;
        var sumW= 0f;
        var sumH= 0f;
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

    fun play(canvas: Canvas){
        val paint =Paint();
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
        ball.move();
        bar.move(touchX);
        collision_brock();
        collision_bar();
        paint.color = Color.YELLOW;
        canvas.drawCircle(ball.x,ball.y,ball.size,paint);
        paint.color = Color.WHITE;
        canvas.drawRect(bar.left,bar.top,bar.right,bar.bottom,paint);
        for(i in list){
            if(i.flag) {
                paint.color=Color.RED;
                canvas.drawRect(i.left,i.top, i.right,i.bottom, paint);
            }
        }

    }
    fun  collision_bar() {
        if ((ball.x > bar.left) && (ball.x < bar.right)) {
            if ((ball.y > bar.top - ball.size) && (ball.y < bar.bottom + ball.size)) {
                ball.SpeedY = -ball.SpeedY;
                ball.SpeedX = -ball.SpeedX;
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
