package applicatipn.android.breakout

import android.content.Context
import android.graphics.Canvas
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView


class Surface : SurfaceView, SurfaceHolder.Callback,Runnable {
    val thread=Thread(this);
    var game:Game?=null;
    var flag=true;
    var w=0f;
    var h=0f;
    constructor(context: Context) : super(context) {
        holder.addCallback(this);//コールバックの登録
    }
    //surface変更時に呼ばれる
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        w=width.toFloat();
        h=height.toFloat();
        game= Game(w,h);
    }

    //surface生成時に呼ばれる
    override fun surfaceCreated(holder: SurfaceHolder) {
        thread.start();

    }
    //surface破棄時に呼ばれる
    override fun surfaceDestroyed(holder: SurfaceHolder) {
        flag=false;
    }
    override fun onTouchEvent(e:MotionEvent):Boolean{
        if(e.action== MotionEvent.ACTION_MOVE) {
            game?.touchX = e.x;
        }
        return  true;
    }
    override  fun run(){
       while(flag){
           var canvas=holder.lockCanvas();
           if(canvas != null) {
               game?.play(canvas);
               holder.unlockCanvasAndPost(canvas);
           }
       }
    }

}