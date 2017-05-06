package miranda.sean.androiddetechtouch;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;


public class NextAlphabet extends ActionBarActivity {
    String imgName1,imgName2,imgName3;
    MediaPlayer nxtalpha,cheering;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_alphabet);
        nxtalpha = MediaPlayer.create(this, R.raw.next_alphabet);
        cheering = MediaPlayer.create(NextAlphabet.this, R.raw.cheering);
        nxtalpha.start();

        stopService(new Intent(getBaseContext(), MyService.class));
        final Intent k = new Intent(NextAlphabet.this,Display_congo2.class);
        final Intent z = new Intent(NextAlphabet.this,Alphabets_numbers.class);

        final ImageView img1 = (ImageView) findViewById(R.id.imgRandom1);
        final ImageView img2 = (ImageView) findViewById(R.id.imgRandom2);
        final ImageView img3 = (ImageView) findViewById(R.id.imgRandom3);
        final ImageView img4 = (ImageView) findViewById(R.id.imgRandom4);


        Random rand = new Random();
        final int rndInt = rand.nextInt(9) + 1; // n = the number of images, that start at idx 1

        String imgName = "alpha" + rndInt;

        img1.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(imgName, "drawable",
                                getApplicationContext()))
                );


        int rndintswitch= rand.nextInt(3) + 1;


        if(rndInt == 1)
            rndintswitch = 2;
        else
        if(rndInt == 2)
            rndintswitch = 1;
        else
        if(rndInt == 7)
            rndintswitch = 3;
        else
        if(rndInt == 8)
            rndintswitch = 3;
        else
        if(rndInt == 9)
            rndintswitch = 3;



        switch(rndintswitch)
        {

            case 1:
                imgName1 = "alpha" + ((rndInt)-1);
                imgName2 = "alpha" + ((rndInt)+2);
                imgName3 = "alpha" + ((rndInt)+1);

                img2.setImageDrawable(

                        getResources().getDrawable(getResourceID(imgName1, "drawable",
                                getApplicationContext()))
                );

                img3.setImageDrawable(

                        getResources().getDrawable(getResourceID(imgName2, "drawable",
                                getApplicationContext()))
                );

                img4.setImageDrawable(

                        getResources().getDrawable(getResourceID(imgName3, "drawable",
                                getApplicationContext()))
                );
                break;

            case 2:
                imgName1 = "alpha" + ((rndInt)+1);
                imgName2 = "alpha" + ((rndInt)+3);
                imgName3 = "alpha" + ((rndInt)+2);

                img2.setImageDrawable(

                        getResources().getDrawable(getResourceID(imgName1, "drawable",
                                getApplicationContext()))
                );

                img3.setImageDrawable(

                        getResources().getDrawable(getResourceID(imgName2, "drawable",
                                getApplicationContext()))
                );

                img4.setImageDrawable(

                        getResources().getDrawable(getResourceID(imgName3, "drawable",
                                getApplicationContext()))
                );
                break;

            case 3:
                imgName1 = "alpha" + ((rndInt)-2);
                imgName2 = "alpha" + ((rndInt)+1);
                imgName3 = "alpha" + ((rndInt)-1);

                img2.setImageDrawable(

                        getResources().getDrawable(getResourceID(imgName1, "drawable",
                                getApplicationContext()))
                );

                img3.setImageDrawable(

                        getResources().getDrawable(getResourceID(imgName2, "drawable",
                                getApplicationContext()))
                );

                img4.setImageDrawable(

                        getResources().getDrawable(getResourceID(imgName3, "drawable",
                                getApplicationContext()))
                );
                break;

        }


        img2.setClickable(true);
        img3.setClickable(true);
        img4.setClickable(true);


        //final Intent intent = new Intent(MainActivity.this,display_congo.class);

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgName1.equals("alpha" + ((rndInt)+1))) {//startActivity(intent);
                    nxtalpha = MediaPlayer.create(NextAlphabet.this, R.raw.nxtalpha);
                    cheering.start();
                    //Toast.makeText(NextAlphabet.this, "Yeaaaaah", Toast.LENGTH_SHORT).show();
                    startActivity(k);
                    finish();
                }else
                {
                    //Toast.makeText(NextAlphabet.this, "uh oh" , Toast.LENGTH_SHORT).show();
                    startActivity(z);
                    finish();
                }

            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgName2.equals("alpha" + ((rndInt)+1))) {  //startActivity(intent);
                    cheering.start();
                    //Toast.makeText(NextAlphabet.this, "Yeaaaaaah", Toast.LENGTH_LONG).show();
                    startActivity(k);
                    finish();
                }

                else
                {
                    //Toast.makeText(NextAlphabet.this, "uh oh" , Toast.LENGTH_SHORT).show();
                    startActivity(z);
                    finish();
                }
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgName3.equals("alpha" + ((rndInt)+1))) { //startActivity(intent);
                    cheering.start();
                    //Toast.makeText(NextAlphabet.this, "Yeaaaaaaah", Toast.LENGTH_LONG).show();
                    startActivity(k);
                    finish();
                }

                else
                {
                    //Toast.makeText(NextAlphabet.this, "uh oh" , Toast.LENGTH_SHORT).show();
                    startActivity(z);
                    finish();
                }
            }
        });





    }

    private int getResourceID(String resName, String resType, Context ctx)
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
    protected void onPause() {
        super.onPause();
        //nxtalpha.release();
        nxtalpha.pause();
        cheering.release();
        finish();
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
        startActivity(new Intent(NextAlphabet.this, Alphabets_numbers.class));
        finish();

    }

}