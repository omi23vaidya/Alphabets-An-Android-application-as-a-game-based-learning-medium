package miranda.sean.androiddetechtouch;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Trace0 extends ActionBarActivity {

    MediaPlayer sound0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trace0);

        stopService(new Intent(getBaseContext(), MyService.class));
        sound0= MediaPlayer.create(Trace0.this,R.raw.sound0);
        sound0.start();

        Button sound = (Button)findViewById(R.id.button3);

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound0.start();
            }
        });


        Button b = (Button)findViewById(R.id.button2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Trace0.this,Number0.class);
                startActivity(i);
                finish();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_btrace, menu);
        Button b = (Button)findViewById(R.id.button2);
        stopService(new Intent(getBaseContext(), MyService.class));

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Trace0.this,Number0.class);
                startActivity(i);
                finish();

            }
        });
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
        startActivity(new Intent(Trace0.this, Alphabets_numbers.class));
        finish();
    }
}
