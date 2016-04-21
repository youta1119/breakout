package applicatipn.android.breakout

import android.app.Activity
import android.os.Bundle

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //ビューにsurfaceviewをセット
        setContentView(Surface(this))
    }
}

