package miranda.sean.androiddetechtouch;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {

    MediaPlayer bgsound;
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        bgsound=MediaPlayer.create(this,R.raw.backgroundmusic);
        bgsound.start();
        bgsound.setLooping(true);

        return START_STICKY;
    }


    @Override
    public void onDestroy()
    {
        super.onDestroy();
        bgsound.pause();
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
