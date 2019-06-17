package misha.graphsecondattempt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Level.MyCallback {
    private GLSurfaceView glSurfaceView;
    private Level game;
    private OpenGLRenderer oGlRend;
    boolean mode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!supportES2()) {
            Toast.makeText(this, "OpenGl ES 2.0 is not supported", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        getScreenResolution();
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
//        setContentView(R.layout.activity_main);



        glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setEGLContextClientVersion(2);
        game = new Level1();
        oGlRend = new OpenGLRenderer(this, game);
        glSurfaceView.setRenderer(oGlRend);
        game.start();//this);
        game.registerCallBack(this);
        setContentView(glSurfaceView);
        glSurfaceView.setOnTouchListener(onTouch);
        mode = true;
//        SomeUtils.game = game;
        GameUtils.setGame(game);

    }
    View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    View.OnTouchListener onTouch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (game.isRunning()){// && event.getActionIndex() == 0) {//  && event.getAction() == MotionEvent.ACTION_DOWN) );
                //st();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        game.wasTouched(event.getX(), event.getY(), 0);
                        return true;
                    // break;
                    case MotionEvent.ACTION_MOVE:
                        game.wasTouched(event.getX(), event.getY(), 1);
                        break;
                    case MotionEvent.ACTION_UP:
                        game.wasTouched(event.getX(), event.getY(), 2);
                        break;
                }
                //int pointerIndex = event.getActionIndex();
                //if (pointerIndex == 5) game.startLevel2();
            }
            return false;
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        if (mode)
            glSurfaceView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mode)
            glSurfaceView.onResume();
    }

    private boolean supportES2() {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        return (configurationInfo.reqGlEsVersion >= 0x20000);
    }

    @Override
    public void callBackReturn(int id) {

    }

    private void getScreenResolution() {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        ScreenUtils.setScreenParameters(metrics.widthPixels, metrics.heightPixels);

//        ScreenUtils.setScreenWidth(metrics.widthPixels);


    }
}
