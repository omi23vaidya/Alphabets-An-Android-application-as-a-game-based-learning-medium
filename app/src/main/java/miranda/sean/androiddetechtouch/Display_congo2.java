package miranda.sean.androiddetechtouch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Display_congo2 extends ActionBarActivity {

    MediaPlayer mycheering;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_congo2);
        mycheering = MediaPlayer.create(this, R.raw.cheering);
        mycheering.setLooping(true);
        mycheering.start();

        Button b = (Button)findViewById(R.id.button2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Display_congo2.this,Ktrace.class);
                startActivity(i);
                SharedPreferences access = getSharedPreferences("access file",MODE_PRIVATE);
                SharedPreferences.Editor edit = access.edit();
                edit.putInt("k",1);
                edit.commit();
                finish();

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mycheering.release();
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_congo, menu);
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
        startActivity(new Intent(Display_congo2.this, Alphabets_numbers.class));
        finish();

    }
}