package applicatipn.android.breakout

import android.content.Context
import android.graphics.Canvas
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView


/**
 * Created by Youta on 2016/02/19.
 */
class Surface : SurfaceView, SurfaceHolder.Callback,Runnable {
    val thread=Thread(this);
    var flag=true;
    var game:Game?=null;
    var w=0f;
    var h=0f;
    constructor(context: Context) : super(context) {
        holder.addCallback(this);
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        w= width.toFloat();
        h=height.toFloat();
        game= Game(w,h);
    }
    override fun surfaceCreated(holder: SurfaceHolder) {
        thread.start();
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
           var canvas:Canvas?=holder.lockCanvas();
           if(canvas != null) {
               game?.play(canvas);
               holder.unlockCanvasAndPost(canvas);
           }

       }
    }

}