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

public class FindMissingAlphabet extends AppCompatActivity {

    String img1;
    String img2;
    String img3;
    String img4;
    String img5;
    String opt1;
    String opt2;

    MediaPlayer question4;

    int a,b,c,j,k=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_missing_alphabet);

        final Intent u = new Intent(FindMissingAlphabet.this,Display_congo4.class);
        final Intent z = new Intent(FindMissingAlphabet.this,Alphabets_numbers.class);

        stopService(new Intent(getBaseContext(), MyService.class));

        question4 = MediaPlayer.create(this, R.raw.missing_alphabet);
        question4 = MediaPlayer.create(this, R.raw.missing_alphabet);
        question4.start();

        final ImageView displayImage1 = (ImageView)findViewById(R.id.displayImage1);
        final ImageView displayImage2 = (ImageView)findViewById(R.id.displayImage2);
        final ImageView displayImage3 = (ImageView)findViewById(R.id.displayImage3);
        final ImageView displayImage4 = (ImageView)findViewById(R.id.displayImage4);
        final ImageView displayImage5 = (ImageView)findViewById(R.id.displayImage5);

        Random r=new Random();
        int i=r.nextInt(20);

        if(i==0||i==1)
        {
            a=1;
            b=2;
            c=3;
        }
        else if (i==19)
        {
            a=i-1;
            b=i;
            c=i+1;
        }
        else
        {
            switch (r.nextInt(2))
            {
                case 0:
                    a=i;
                    b=i+1;
                    c=i+2;
                    break;
                case 1:
                    a=i-1;
                    b=i;
                    c=i+1;
                    break;
            }
        }

        switch (r.nextInt(3)) {
            case 0:
                img1 = "alpha" + a;
                img2 = "alpha" + b;
                img3 = "ques";
                img4 = "alpha" + c;
                j = r.nextInt(26);
                img5 = "alpha" + (j + 1);
                while (img5.equals(img1) || img5.equals(img2) || img5.equals(img4)) {
                    j = r.nextInt(26);
                    img5 = "alpha" + (j + 1);
                }
                switch (r.nextInt(2)) {
                    case 0:
                        opt1=img4;
                        opt2=img5;
                        break;
                    case 1:
                        opt1=img5;
                        opt2=img4;
                        break;
                }
                break;
            case 1:
                img1 = "alpha" + a;
                img2 = "ques";
                img3 = "alpha" + c;
                img4 = "alpha" + b;
                j = r.nextInt(26);
                img5 = "alpha" + (j + 1);
                while (img5.equals(img1) || img5.equals(img3) || img5.equals(img4)) {
                    j = r.nextInt(26);
                    img5 = "alpha" + (j + 1);
                }
                switch (r.nextInt(2)) {
                    case 0:
                        opt1=img4;
                        opt2=img5;
                        break;
                    case 1:
                        opt1=img5;
                        opt2=img4;
                        break;
                }
                break;
            case 2:
                img1 = "ques";
                img2 = "alpha" + b;
                img3 = "alpha" + c;
                img4 = "alpha" + a;
                j = r.nextInt(26);
                img5 = "alpha" + (j + 1);
                while (img5.equals(img3) || img5.equals(img2) || img5.equals(img4)) {
                    j = r.nextInt(26);
                    img5 = "alpha" + (j + 1);
                }
                switch (r.nextInt(2)) {
                    case 0:
                        opt1=img4;
                        opt2=img5;
                        break;
                    case 1:
                        opt1=img5;
                        opt2=img4;
                        break;
                }
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
                        getResources().getDrawable(getResourceID(opt1, "drawable",
                                getApplicationContext()))
                );
        displayImage5.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(opt2, "drawable",
                                getApplicationContext()))
                );

        //listeners

        displayImage4.setClickable(true);
        displayImage5.setClickable(true);

        displayImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt1.equals(img4)) {
                    //Toast.makeText(FindMissingAlphabet.this, "yeah", Toast.LENGTH_SHORT).show();
                    startActivity(u);
                    finish();
                }

                else
                {
                    //Toast.makeText(SelectAlphabetCorrespondingToImage.this, "uh oh", Toast.LENGTH_SHORT).show();
                    startActivity(z);
                    finish();
                }
            }
        });

        displayImage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt2.equals(img4)) {
                    //Toast.makeText(FindMissingAlphabet.this, "yeah", Toast.LENGTH_SHORT).show();
                    startActivity(u);
                    finish();
                }
                else
                {
                    //Toast.makeText(SelectAlphabetCorrespondingToImage.this, "uh oh", Toast.LENGTH_SHORT).show();
                    startActivity(z);
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
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(FindMissingAlphabet.this, Alphabets_numbers.class));
        finish();

    }

    @Override
    public void onPause()
    {
        super.onPause();
        question4.pause();
    }
}