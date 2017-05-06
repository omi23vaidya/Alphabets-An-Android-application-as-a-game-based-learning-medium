package miranda.sean.androiddetechtouch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

/**
 * Created by Sean Miranda on 28-Feb-16.
 */
public class Exit extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_numbers_screen,container,false);
    }


    @Override
    public void onStart() {
        super.onStart();
        getActivity().stopService(new Intent(getActivity().getBaseContext(), MyService.class));
        System.exit(0);

    }
}
