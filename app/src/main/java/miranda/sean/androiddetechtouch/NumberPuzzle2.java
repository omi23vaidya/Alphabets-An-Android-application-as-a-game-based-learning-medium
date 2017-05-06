package miranda.sean.androiddetechtouch;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class NumberPuzzle2 extends AppCompatActivity {

    String img1;
    String img2;
    String img3;
    String img4;
    String img5;
    String opt1;
    String opt2;
    String opt3;

    MediaPlayer question7;

    int a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_puzzle2);
        stopService(new Intent(getBaseContext(), MyService.class));
        question7 = MediaPlayer.create(this, R.raw.previous_number);
        question7.start();
        final ImageView displayImage1 = (ImageView)findViewById(R.id.displayImage1);
        final ImageView displayImage2 = (ImageView)findViewById(R.id.displayImage2);
        final ImageView displayImage3 = (ImageView)findViewById(R.id.displayImage3);
        final ImageView displayImage4 = (ImageView)findViewById(R.id.displayImage4);
        final ImageView displayImage5 = (ImageView)findViewById(R.id.displayImage5);

        final Intent k = new Intent(NumberPuzzle2.this,Display_congo7.class);
        final Intent z = new Intent(NumberPuzzle2.this,Alphabets_numbers.class);

        Random r=new Random();
        int i=r.nextInt(9);

        img1="ques";
        img2="no"+(i+1);
        img3="no"+i;
        a=r.nextInt(9);
        img4="no"+a;
        while(a==(i+1)|| a==i)
        {
            a=r.nextInt(9);
            img4="no"+a;
        }
        b=r.nextInt(9);
        img5="no"+b;
        while(b==(i+1) || b==a || b==i)
        {
            b=r.nextInt(9);
            img5="no"+b;
        }

        switch(r.nextInt(3))
        {
            case 0:
                opt1=img3;
                opt2=img4;
                opt3=img5;
                break;
            case 1:
                opt1=img4;
                opt2=img3;
                opt3=img5;
                break;
            case 2:
                opt1=img4;
                opt2=img5;
                opt3=img3;
                break;
        }

        displayImage1.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(img1, "drawable",
                                getApplicationContext()))
                );
        displayImage2.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(img2, "drawable",
                                getApplicationContext()))
                );
        displayImage3.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(opt1, "drawable",
                                getApplicationContext()))
                );
        displayImage4.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(opt2, "drawable",
                                getApplicationContext()))
                );
        displayImage5.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(opt3, "drawable",
                                getApplicationContext()))
                );

        //listeners

        displayImage3.setClickable(true);
        displayImage4.setClickable(true);
        displayImage5.setClickable(true);

        displayImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt1.equals(img3)) {
                    //Toast.makeText(NumberPuzzle2.this, "yeah", Toast.LENGTH_SHORT).show();
                    startActivity(k);
                    finish();
                } else {
                    startActivity(z);
                    finish();
                    //Toast.makeText(NumberPuzzle2.this, "uh oh", Toast.LENGTH_SHORT).show();
                }
            }
        });

        displayImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt2.equals(img3)) {
                    //Toast.makeText(NumberPuzzle2.this, "yeah", Toast.LENGTH_SHORT).show();
                    startActivity(k);
                    finish();

                } else {
                    startActivity(z);
                    finish();
                    //Toast.makeText(NumberPuzzle2.this, "uh oh", Toast.LENGTH_SHORT).show();
                }
            }
        });

        displayImage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt3.equals(img3)) {
                    //Toast.makeText(NumberPuzzle2.this, "yeah", Toast.LENGTH_SHORT).show();
                    startActivity(k);
                    finish();
                } else {
                    startActivity(z);
                    finish();
                    //Toast.makeText(NumberPuzzle2.this, "uh oh", Toast.LENGTH_SHORT).show();
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
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(NumberPuzzle2.this, Alphabets_numbers.class));
        finish();

    }

    @Override
    public void onPause()
    {
        super.onPause();
        question7.pause();
    }
}