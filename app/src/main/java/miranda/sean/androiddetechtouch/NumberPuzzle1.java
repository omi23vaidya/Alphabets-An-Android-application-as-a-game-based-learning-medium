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

public class NumberPuzzle1 extends AppCompatActivity {

    String img1;
    String img2;
    String img3;
    String img4;
    String opt1;
    String opt2;
    String opt3;

    MediaPlayer question6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent k = new Intent(NumberPuzzle1.this,Display_congo6.class);


        setContentView(R.layout.activity_number_puzzle1);
        stopService(new Intent(getBaseContext(), MyService.class));
        question6 = MediaPlayer.create(this, R.raw.next_number);
        question6.start();
        final Intent z = new Intent(NumberPuzzle1.this,Alphabets_numbers.class);
        final ImageView displayImage1 = (ImageView)findViewById(R.id.displayImage1);
        final ImageView displayImage2 = (ImageView)findViewById(R.id.displayImage2);
        final ImageView displayImage3 = (ImageView)findViewById(R.id.displayImage3);
        final ImageView displayImage4 = (ImageView)findViewById(R.id.displayImage4);

        Random r= new Random();
        int a,b;
        int i=r.nextInt(4);
        img1="pic"+i;

        img2="no"+(i+1);
        a=r.nextInt(5);
        while((i+1)==a)
        {
            a=r.nextInt(5);
        }
        img3="no"+a;
        b=r.nextInt(5);
        while((i+1)==b || b==a)
        {
            b=r.nextInt(5);
        }
        img4="no"+b;

        switch(r.nextInt(3))
        {
            case 0:
                opt1=img2;
                opt2=img3;
                opt3=img4;
                break;
            case 1:
                opt1=img3;
                opt2=img2;
                opt3=img4;
                break;
            case 2:
                opt1=img4;
                opt2=img3;
                opt3=img2;
                break;
        }
        displayImage1.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(img1, "drawable",
                                getApplicationContext()))
                );
        displayImage2.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(opt1, "drawable",
                                getApplicationContext()))
                );
        displayImage3.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(opt2, "drawable",
                                getApplicationContext()))
                );
        displayImage4.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(opt3, "drawable",
                                getApplicationContext()))
                );

        //listeners
        displayImage2.setClickable(true);
        displayImage3.setClickable(true);
        displayImage4.setClickable(true);

        displayImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt1.equals(img2)) {
                    //Toast.makeText(NumberPuzzle1.this, "yeah", Toast.LENGTH_SHORT).show();
                    startActivity(k);
                    finish();
                } else {
                    startActivity(z);
                    finish();
                    //Toast.makeText(NumberPuzzle1.this, "uh oh", Toast.LENGTH_SHORT).show();
                }
            }
        });

        displayImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt2.equals(img2)) {
                    //Toast.makeText(NumberPuzzle1.this, "yeah", Toast.LENGTH_SHORT).show();
                    startActivity(k);
                    finish();
                } else {
                    startActivity(z);
                    finish();
                    //Toast.makeText(NumberPuzzle1.this, "uh oh", Toast.LENGTH_SHORT).show();
                }
            }
        });

        displayImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt3.equals(img2)) {
                    //Toast.makeText(NumberPuzzle1.this, "yeah", Toast.LENGTH_SHORT).show();
                    startActivity(k);
                    finish();
                } else {
                    startActivity(z);
                    finish();
                    //Toast.makeText(NumberPuzzle1.this, "uh oh", Toast.LENGTH_SHORT).show();
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
        startActivity(new Intent(NumberPuzzle1.this, Alphabets_numbers.class));
        finish();

    }

    @Override
    public void onPause()
    {
        super.onPause();
        question6.pause();
    }
}