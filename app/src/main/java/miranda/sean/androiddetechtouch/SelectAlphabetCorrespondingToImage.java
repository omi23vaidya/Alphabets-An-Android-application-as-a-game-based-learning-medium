package miranda.sean.androiddetechtouch;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class SelectAlphabetCorrespondingToImage extends ActionBarActivity {
    final Random r = new Random();
    String alpha1;
    String alpha2;
    String alpha3;

    MediaPlayer question3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_alphabet_corresponding_to_image);
        stopService(new Intent(getBaseContext(), MyService.class));
        final Intent z =new Intent(SelectAlphabetCorrespondingToImage.this,Alphabets_numbers.class);
        question3 = MediaPlayer.create(this, R.raw.alphabet_corresponding_to_image);
        question3.start();
        final ImageView displayAlpha = (ImageView)findViewById(R.id.findAlpha);
        final ImageView displayAlphabet1 = (ImageView)findViewById(R.id.displayAlphabet1);
        final ImageView displayAlphabet2 = (ImageView)findViewById(R.id.displayAlphabet2);
        final ImageView displayAlphabet3 = (ImageView)findViewById(R.id.displayAlphabet3);

        final int rimg = r.nextInt(30);
        final int sum;
        if(rimg%2==0)
        {
            sum = (2*rimg)+1;
        }
        else
        {
            sum = (2*rimg)-1;
        }

        final int alpha= (sum+3)/4;

        int choice = r.nextInt(3);

        switch (choice)
        {
            case 0:
                alpha1="alpha"+alpha;
                alpha2="alpha"+(r.nextInt(3)+1);
                while(alpha2.equals(alpha1))
                    alpha2="alpha"+(r.nextInt(3)+1);
                alpha3="alpha"+(r.nextInt(3)+1);
                while(alpha3.equals(alpha1) || alpha3.equals(alpha2))
                    alpha3="alpha"+(r.nextInt(3)+1);
                break;
            case 1:
                alpha2="alpha"+alpha;
                alpha1="alpha"+(r.nextInt(3)+1);
                while(alpha1.equals(alpha2))
                    alpha1="alpha"+(r.nextInt(3)+1);
                alpha3="alpha"+(r.nextInt(3)+1);
                while(alpha3.equals(alpha1) || alpha3.equals(alpha2))
                    alpha3="alpha"+(r.nextInt(3)+1);
                break;
            case 2:
                alpha3="alpha"+alpha;
                alpha2="alpha"+(r.nextInt(3)+1);
                while(alpha2.equals(alpha3))
                    alpha2="alpha"+(r.nextInt(3)+1);
                alpha1="alpha"+(r.nextInt(3)+1);
                while(alpha3.equals(alpha1) || alpha1.equals(alpha2))
                    alpha1="alpha"+(r.nextInt(3)+1);
                break;
            default:
                break;
        }

        final String str1 = "img_" + rimg;

        displayAlpha.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(str1, "drawable",
                                getApplicationContext()))
                );
        displayAlphabet1.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(alpha1, "drawable",
                                getApplicationContext()))
                );
        displayAlphabet2.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(alpha2, "drawable",
                                getApplicationContext()))
                );
        displayAlphabet3.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(alpha3, "drawable",
                                getApplicationContext()))
                );

        //listeners
        displayAlphabet1.setClickable(true);
        displayAlphabet2.setClickable(true);
        displayAlphabet3.setClickable(true);

        displayAlphabet1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alpha1.equals("alpha"+alpha)){
                    //Toast.makeText(SelectAlphabetCorrespondingToImage.this, "yeah", Toast.LENGTH_SHORT).show();
                    Intent b = new Intent(SelectAlphabetCorrespondingToImage.this, Display_congo3.class);
                    startActivity(b);
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

        displayAlphabet2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alpha2.equals("alpha" + alpha)){
                    //Toast.makeText(SelectAlphabetCorrespondingToImage.this, "yeah", Toast.LENGTH_SHORT).show();
                    Intent b = new Intent(SelectAlphabetCorrespondingToImage.this, Display_congo3.class);
                    startActivity(b);
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

        displayAlphabet3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alpha3.equals("alpha"+alpha)){
                    //Toast.makeText(SelectAlphabetCorrespondingToImage.this, "yeah", Toast.LENGTH_SHORT).show();
                    Intent b = new Intent(SelectAlphabetCorrespondingToImage.this, Display_congo3.class);
                    startActivity(b);
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

    protected static int getResourceID
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
        startActivity(new Intent(SelectAlphabetCorrespondingToImage.this, Alphabets_numbers.class));
        finish();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        question3.pause();
    }
}
