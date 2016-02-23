package applicatipn.android.breakout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView


/**
 * Created by Youta on 2016/02/19.
 */
class Surface : SurfaceView, SurfaceHolder.Callback,Runnable {
    var thread:Thread?=null;
    var flag:Boolean=true;
    var game:Game?=null;
    var w:Float=0f;
    var h:Float=0f;
    constructor(context: Context) : super(context) {
        holder.addCallback(this);
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        w= width.toFloat();
        h=height.toFloat();
        game= Game(w,h);
        //game?.set_brock()
    }
    override fun surfaceCreated(holder: SurfaceHolder) {
        thread= Thread(this);
        thread?.start();
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        flag=false;
    }
    override fun onTouchEvent(e:MotionEvent):Boolean{
        if(e.action==MotionEvent.ACTION_MOVE) {
            game?.touchX = e.x;
        }
        return  true;
    }

    override  fun run(){
       while(flag){
           var canvas:Canvas=holder.lockCanvas();
           game?.play(canvas);
           holder.unlockCanvasAndPost(canvas);
       }
    }

}