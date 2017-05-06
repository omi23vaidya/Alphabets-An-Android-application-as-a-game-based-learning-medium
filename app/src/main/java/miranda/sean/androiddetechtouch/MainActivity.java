package miranda.sean.androiddetechtouch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.FileNotFoundException;

public class MainActivity extends Activity {

    VideoView vid;
    private Handler mHandler = new Handler();

    /** Called when the activity is first created.*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*SharedPreferences access = getSharedPreferences("access file",MODE_PRIVATE);
        SharedPreferences.Editor editor = access.edit();
        editor.clear();
        editor.commit();*/


        vid = (VideoView)findViewById(R.id.videoView);
        String urlpath ="android.resource://" + getPackageName() + "/" + R.raw.launcher;
        vid.setVideoURI(Uri.parse(urlpath));
        vid.start();


        mHandler.postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(MainActivity.this,Alphabets_numbers.class);
                startActivity(i);
                finish();

            }
        }, 7000);

        startService(new Intent(getBaseContext(),MyService.class));
    }

    /*@Override
    protected void onPause()
    {
        super.onPause();
        stopService(new Intent(getBaseContext(),MyService.class));
    }*/

}