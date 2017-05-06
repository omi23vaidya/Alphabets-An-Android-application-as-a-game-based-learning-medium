package miranda.sean.androiddetechtouch;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FilePermission;
import java.util.Random;

public class FlipTheTile extends AppCompatActivity {

    String img1;
    String img2;
    String img3;
    String img4;
    MediaPlayer question5;

    int a,b,c,d,k=0,flag1=0,flag2=0,flag3=0,flag4=0,pair1=0,pair2=0,z=2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_the_tile);
        stopService(new Intent(getBaseContext(), MyService.class));
        question5 = MediaPlayer.create(this, R.raw.flip_the_tile);
        question5.start();

        final ImageView displayImage1 = (ImageView)findViewById(R.id.displayImage1);
        final ImageView displayImage2 = (ImageView)findViewById(R.id.displayImage2);
        final ImageView displayImage3 = (ImageView)findViewById(R.id.displayImage3);
        final ImageView displayImage4 = (ImageView)findViewById(R.id.displayImage4);
        final Intent z1 = new Intent(FlipTheTile.this, Display_congo5.class);

        final Intent z2 = new Intent(FlipTheTile.this,Alphabets_numbers.class);

        Random r=new Random();
        int i=r.nextInt(52);
        int j=r.nextInt(52);

        if(i%2==0)
        {
            a=i;
            b=i+1;
        }
        else
        {
            a=i;
            b=i-1;
        }

        if(j%2==0)
        {
            c=j;
            d=j+1;
        }
        else
        {
            c=j;
            d=j-1;
        }
        while(j==a || j==b)
        {
            j=r.nextInt(52);
            if(j%2==0)
            {
                c=j;
                d=j+1;
            }
            else
            {
                c=j;
                d=j-1;
            }
        }

        switch(r.nextInt(3))
        {
            case 0:
                img1="img_" +a;
                img2="img_" +b;
                img3="img_" +c;
                img4="img_" +d;
                break;

            case 1:
                img1="img_" +a;
                img2="img_" +c;
                img3="img_" +d;
                img4="img_" +b;
                break;

            case 2:
                img1="img_" +a;
                img2="img_" +d;
                img3="img_" +b;
                img4="img_" +c;
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
                        getResources().getDrawable(getResourceID(img3, "drawable",
                                getApplicationContext()))
                );
        displayImage4.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(img4, "drawable",
                                getApplicationContext()))
                );

        //listeners
        displayImage1.setClickable(true);
        displayImage2.setClickable(true);
        displayImage3.setClickable(true);
        displayImage4.setClickable(true);


        displayImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (img1.equals("img_" + a)) {
                    flag1++;
                    k++;
                    if(k==1) {
                        //Toast.makeText(FlipTheTile.this, "Choose its match!", Toast.LENGTH_SHORT).show();
                        displayImage1.setVisibility(View.INVISIBLE);
                    }
                    else if (k==2 && flag1==1 && flag2==1){
                        k=0;
                        pair1=1;
                        //Toast.makeText(FlipTheTile.this, "Yeah!", Toast.LENGTH_SHORT).show();
                        z--;
                        if(z==0)
                        {
                            //Toast.makeText(FlipTheTile.this, "complete!", Toast.LENGTH_SHORT).show();
                            startActivity(z1);
                            finish();
                        }

                        displayImage1.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        flag1=0;
                        flag2=0;
                        flag3=0;
                        flag4=0;
                        k=0;
                        //Toast.makeText(FlipTheTile.this, "Uh oh!", Toast.LENGTH_SHORT).show();
                        startActivity(z2);
                        finish();
                        if (pair2==1)
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                        }
                        else if (pair1==1)
                        {
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });

        displayImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (img2.equals("img_" + b)) {
                    flag2++;
                    k++;
                    if (k == 1) {
                        //Toast.makeText(FlipTheTile.this, "Choose its match!", Toast.LENGTH_SHORT).show();
                        displayImage2.setVisibility(View.INVISIBLE);
                    } else if (k == 2 && flag1 == 1 && flag2 == 1) {
                        k=0;
                        pair1=1;
                        //Toast.makeText(FlipTheTile.this, "Yeah!", Toast.LENGTH_SHORT).show();
                        z--;
                        if(z==0)
                        {
                            //Toast.makeText(FlipTheTile.this, "complete!", Toast.LENGTH_SHORT).show();
                            startActivity(z1);
                            finish();
                        }
                        displayImage2.setVisibility(View.INVISIBLE);
                    } else
                    {
                        k=0;
                        flag1=0;
                        flag2=0;
                        flag3=0;
                        flag4=0;
                        //Toast.makeText(FlipTheTile.this, "Uh oh!", Toast.LENGTH_SHORT).show();

                        startActivity(z2);
                        finish();


                        if (pair2==1)
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                        }
                        else if (pair1==1)
                        {
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                    }
                }
                else if (img2.equals("img_" + c)) {
                    flag3++;
                    k++;
                    if (k == 1) {
                        //Toast.makeText(FlipTheTile.this, "Choose its match!", Toast.LENGTH_SHORT).show();
                        displayImage2.setVisibility(View.INVISIBLE);
                    } else if (k == 2 && flag3 == 1 && flag4 == 1) {
                        k=0;
                        pair2=1;
                        //Toast.makeText(FlipTheTile.this, "Yeah!", Toast.LENGTH_SHORT).show();
                        z--;
                        if(z==0)
                        {
                            //Toast.makeText(FlipTheTile.this, "complete!", Toast.LENGTH_SHORT).show();
                            startActivity(z1);
                            finish();
                        }
                        displayImage2.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        k=0;
                        flag1=0;
                        flag2=0;
                        flag3=0;
                        flag4=0;
                        //Toast.makeText(FlipTheTile.this, "Uh oh!", Toast.LENGTH_SHORT).show();
                        startActivity(z2);
                        finish();
                        if (pair2==1)
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                        }
                        else if (pair1==1)
                        {
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                    }
                }
                else {
                    flag4++;
                    k++;
                    if (k == 1) {
                        //Toast.makeText(FlipTheTile.this, "Choose its match!", Toast.LENGTH_SHORT).show();
                        displayImage2.setVisibility(View.INVISIBLE);
                    } else if (k == 2 && flag3 == 1 && flag4 == 1) {
                        k=0;
                        pair2=1;
                        //Toast.makeText(FlipTheTile.this, "Yeah!", Toast.LENGTH_SHORT).show();
                        z--;
                        if(z==0)
                        {
                            //Toast.makeText(FlipTheTile.this, "complete!", Toast.LENGTH_SHORT).show();
                            startActivity(z1);
                            finish();
                        }
                        displayImage2.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        k=0;
                        flag1=0;
                        flag2=0;
                        flag3=0;
                        flag4=0;
                        //Toast.makeText(FlipTheTile.this, "Uh oh!", Toast.LENGTH_SHORT).show();
                        startActivity(z2);
                        finish();
                        if (pair2==1)
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                        }
                        else if (pair1==1)
                        {
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });

        displayImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (img3.equals("img_" + b)) {
                    flag2++;
                    k++;
                    if (k == 1) {
                        //Toast.makeText(FlipTheTile.this, "Choose its match!", Toast.LENGTH_SHORT).show();
                        displayImage3.setVisibility(View.INVISIBLE);
                    } else if (k == 2 && flag1 == 1 && flag2 == 1) {
                        k=0;
                        pair1=1;
                        //Toast.makeText(FlipTheTile.this, "Yeah!", Toast.LENGTH_SHORT).show();
                        z--;
                        if(z==0)
                        {
                            //Toast.makeText(FlipTheTile.this, "complete!", Toast.LENGTH_SHORT).show();
                            startActivity(z1);
                            finish();
                        }
                        displayImage3.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        k=0;
                        flag1=0;
                        flag2=0;
                        flag3=0;
                        flag4=0;
                        //Toast.makeText(FlipTheTile.this, "Uh oh!", Toast.LENGTH_SHORT).show();
                        startActivity(z2);
                        finish();
                        if (pair2==1)
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                        }
                        else if (pair1==1)
                        {
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                    }
                }
                else if (img3.equals("img_" + c)) {
                    flag3++;
                    k++;
                    if (k == 1) {
                        //Toast.makeText(FlipTheTile.this, "Choose its match!", Toast.LENGTH_SHORT).show();
                        displayImage3.setVisibility(View.INVISIBLE);
                    } else if (k == 2 && flag3 == 1 && flag4 == 1) {
                        k=0;
                        pair2=1;
                        //Toast.makeText(FlipTheTile.this, "Yeah!", Toast.LENGTH_SHORT).show();
                        z--;
                        if(z==0)
                        {
                            //Toast.makeText(FlipTheTile.this, "complete!", Toast.LENGTH_SHORT).show();
                            startActivity(z1);
                            finish();
                        }
                        displayImage3.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        k=0;
                        flag1=0;
                        flag2=0;
                        flag3=0;
                        flag4=0;
                        //Toast.makeText(FlipTheTile.this, "Uh oh!", Toast.LENGTH_SHORT).show();
                        startActivity(z2);
                        finish();
                        if (pair2==1)
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                        }
                        else if (pair1==1)
                        {
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                    }
                }
                else {
                    flag4++;
                    k++;
                    if (k == 1) {
                        //Toast.makeText(FlipTheTile.this, "Choose its match!", Toast.LENGTH_SHORT).show();
                        displayImage3.setVisibility(View.INVISIBLE);
                    } else if (k == 2 && flag3 == 1 && flag4 == 1) {
                        k=0;
                        pair2=1;
                        //Toast.makeText(FlipTheTile.this, "Yeah!", Toast.LENGTH_SHORT).show();
                        z--;
                        if(z==0)
                        {
                            //Toast.makeText(FlipTheTile.this, "complete!", Toast.LENGTH_SHORT).show();
                            startActivity(z1);
                            finish();
                        }
                        displayImage3.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        k=0;
                        flag1=0;
                        flag2=0;
                        flag3=0;
                        flag4=0;
                        //Toast.makeText(FlipTheTile.this, "Uh oh!", Toast.LENGTH_SHORT).show();
                        startActivity(z2);
                        finish();
                        if (pair2==1)
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                        }
                        else if (pair1==1)
                        {
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });

        displayImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (img4.equals("img_" + b)) {
                    flag2++;
                    k++;
                    if(k==1) {
                        //Toast.makeText(FlipTheTile.this, "Choose its match!", Toast.LENGTH_SHORT).show();
                        displayImage4.setVisibility(View.INVISIBLE);
                    }
                    else if (k==2 && flag1==1 && flag2==1){
                        k=0;
                        pair1=1;
                        //Toast.makeText(FlipTheTile.this, "Yeah!", Toast.LENGTH_SHORT).show();
                        z--;
                        if(z==0)
                        {
                            //Toast.makeText(FlipTheTile.this, "complete!", Toast.LENGTH_SHORT).show();
                            startActivity(z1);
                            finish();
                        }
                        displayImage4.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        k=0;
                        flag1=0;
                        flag2=0;
                        flag3=0;
                        flag4=0;
                        //Toast.makeText(FlipTheTile.this, "Uh oh!", Toast.LENGTH_SHORT).show();
                        startActivity(z2);
                        finish();
                        if (pair2==1)
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                        }
                        else if (pair1==1)
                        {
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                    }
                }
                else if (img4.equals("img_" + c)) {
                    flag3++;
                    k++;
                    if (k == 1) {
                        //Toast.makeText(FlipTheTile.this, "Choose its match!", Toast.LENGTH_SHORT).show();
                        displayImage4.setVisibility(View.INVISIBLE);
                    } else if (k == 2 && flag3 == 1 && flag4 == 1) {
                        k=0;
                        pair2=1;
                        //Toast.makeText(FlipTheTile.this, "Yeah!", Toast.LENGTH_SHORT).show();
                        z--;
                        if(z==0)
                        {
                            //Toast.makeText(FlipTheTile.this, "complete!", Toast.LENGTH_SHORT).show();
                            startActivity(z1);
                            finish();
                        }
                        displayImage4.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        k=0;
                        flag1=0;
                        flag2=0;
                        flag3=0;
                        flag4=0;
                        //Toast.makeText(FlipTheTile.this, "Uh oh!", Toast.LENGTH_SHORT).show();
                        startActivity(z2);
                        finish();
                        if (pair2==1)
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                        }
                        else if (pair1==1)
                        {
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                    }
                }
                else {
                    flag4++;
                    k++;
                    if (k == 1) {
                        //Toast.makeText(FlipTheTile.this, "Choose its match!", Toast.LENGTH_SHORT).show();
                        displayImage4.setVisibility(View.INVISIBLE);
                    } else if (k == 2 && flag3 == 1 && flag4 == 1) {
                        k=0;
                        pair2=1;
                        //Toast.makeText(FlipTheTile.this, "Yeah!", Toast.LENGTH_SHORT).show();
                        z--;
                        if(z==0)
                        {
                            //Toast.makeText(FlipTheTile.this, "complete!", Toast.LENGTH_SHORT).show();
                            startActivity(z1);
                            finish();
                        }
                        displayImage4.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        k=0;
                        flag1=0;
                        flag2=0;
                        flag3=0;
                        flag4=0;
                        //Toast.makeText(FlipTheTile.this, "Uh oh!", Toast.LENGTH_SHORT).show();
                        startActivity(z2);
                        finish();
                        if (pair2==1)
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                        }
                        else if (pair1==1)
                        {
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            displayImage1.setVisibility(View.VISIBLE);
                            displayImage2.setVisibility(View.VISIBLE);
                            displayImage3.setVisibility(View.VISIBLE);
                            displayImage4.setVisibility(View.VISIBLE);
                        }
                    }
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
        startActivity(new Intent(FlipTheTile.this, Alphabets_numbers.class));
        finish();

    }
    @Override
    public void onPause()
    {
        super.onPause();
        question5.pause();
    }
}