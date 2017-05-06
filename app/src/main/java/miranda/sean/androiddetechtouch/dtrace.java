package miranda.sean.androiddetechtouch;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class dtrace extends ActionBarActivity {

    MediaPlayer d_sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtrace);
        stopService(new Intent(getBaseContext(), MyService.class));

        d_sound = MediaPlayer.create(dtrace.this,R.raw.d);
        d_sound.start();
        Button b = (Button)findViewById(R.id.button2);
        Button dsound =(Button)findViewById(R.id.sound_icon);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dtrace.this,D.class);
                startActivity(i);
                finish();

            }
        });

        dsound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d_sound= MediaPlayer.create(dtrace.this,R.raw.d);
                d_sound.start();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dtrace, menu);
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
        startActivity(new Intent(dtrace.this, Alphabets_numbers.class));
        finish();

    }
}
