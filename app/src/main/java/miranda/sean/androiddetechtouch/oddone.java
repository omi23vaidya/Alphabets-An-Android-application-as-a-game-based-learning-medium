package miranda.sean.androiddetechtouch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.Random;


public class oddone extends Activity {

    final Random rnd = new Random();
    MediaPlayer question1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oddone);
        stopService(new Intent(getBaseContext(), MyService.class));
        question1 = MediaPlayer.create(this, R.raw.odd_one_out);
        question1.start();
        final ImageView img1 = (ImageView) findViewById(R.id.imgRandom1);
        final ImageView img2 = (ImageView) findViewById(R.id.imgRandom2);
        final ImageView img3 = (ImageView) findViewById(R.id.imgRandom3);

        final Intent k = new Intent(oddone.this, Alphabets_numbers.class);
        //random images
        final int rimg1 = rnd.nextInt(10);
        int rimg2 = rnd.nextInt(10);
        int check1 = rimg1%2;
        int check2 = rimg2%2;

        while(rimg2==rimg1 || (check1!=check2 && ((rimg1==rimg2+1)||(rimg2==rimg1+1))))
        {
            rimg2 = rnd.nextInt(10);
            check1 = rimg1%2;
            check2 = rimg2%2;
        }

        int rimg3 = rnd.nextBoolean() ? rimg1 : rimg2;

        if(rimg3%2==0)
        {
            rimg3=rimg3+1;
        }
        else
        {
            rimg3=rimg3-1;
        }

        final int rimg3_ = rimg3;
        final int rimg2_ = rimg2;

        //finding the odd one
        final int oddone;
        if((rimg1%2==0 && rimg2_%2==1 && rimg2_==rimg1+1)||(rimg2_%2==0 && rimg1%2==1 && rimg1==rimg2_+1))
        {
            oddone=rimg3_;
        } else

        if((rimg2_%2==0 && rimg3_%2==1 && rimg3_==rimg2+1)||(rimg3_%2==0 && rimg2_%2==1 && rimg2_==rimg3_+1))
        {
            oddone=rimg1;
        }

        else
        {
            oddone=rimg2_;
        }

        final String str1 = "img_" + rimg1;
        final String str2 = "img_" + rimg2_;
        final String str3 = "img_" + rimg3_;
        img1.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(str1, "drawable",
                                getApplicationContext()))
                );
        img2.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(str2, "drawable",
                                getApplicationContext()))
                );
        img3.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(str3, "drawable",
                                getApplicationContext()))
                );

        //listeners
        img1.setClickable(true);
        img2.setClickable(true);
        img3.setClickable(true);

        final Intent intent = new Intent(oddone.this,display_congo.class);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rimg1 == oddone){
                    startActivity(intent);
                    finish();
                }

                    //Toast.makeText(MainActivity.this, "Yeaaaaah"+rimg1, Toast.LENGTH_SHORT).show();
                else {
                    //Toast.makeText(oddone.this, "uh oh" + rimg3, Toast.LENGTH_SHORT).show();
                    startActivity(k);
                    finish();
                }
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rimg2_ == oddone){
                    startActivity(intent);
                    finish();
                }

                    //Toast.makeText(MainActivity.this, "Yeaaaaaah"+rimg2_, Toast.LENGTH_LONG).show();
                else {
                    //Toast.makeText(oddone.this, "uh oh" + rimg1, Toast.LENGTH_SHORT).show();
                    startActivity(k);
                    finish();
                }
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rimg3_==oddone){
                    startActivity(intent);
                    finish();
                }

                    //Toast.makeText(MainActivity.this, "Yeaaaaaaah"+rimg3_, Toast.LENGTH_LONG).show();
                else {
                    //Toast.makeText(oddone.this, "uh oh" + rimg2, Toast.LENGTH_SHORT).show();
                    startActivity(k);
                    finish();
                }
            }
        });


    }

    protected final static int getResourceID
            (final String resName, final String resType, final Context ctx)
    {
        final int ResourceID =
                ctx.getResources().getIdentifier(resName, resType,
                        ctx.getApplicationInfo().packageName);
        if (ResourceID == 0)
        {
            throw new IllegalArgumentException
                    (
                            "No resource string found with name " + resName
                    );
        }
        else
        {
            return ResourceID;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        question1.stop();
        startActivity(new Intent(oddone.this, Alphabets_numbers.class));
        finish();

    }

    @Override
    public void onPause()
    {
        super.onPause();
        question1.pause();
    }
}
