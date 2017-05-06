package miranda.sean.androiddetechtouch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

/**
 * Created by Sean Miranda on 28-Feb-16.
 */
public class NumbersScreen extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_numbers_screen,container,false);

    }


    @Override
    public void onStart() {
        super.onStart();
        //setContentView(R.layout.activity_main);

        final ScrollView scrollview = ((ScrollView) getView().findViewById(R.id.scrollview));
        scrollview.post(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

        Button n0 = (Button)getView().findViewById(R.id.b0);
        Button n1 = (Button)getView().findViewById(R.id.b1);
        Button n2 = (Button)getView().findViewById(R.id.b2);
        Button n3 = (Button)getView().findViewById(R.id.b3);
        Button n4 = (Button)getView().findViewById(R.id.b4);
        Button n5 = (Button)getView().findViewById(R.id.b5);
        Button n6 = (Button)getView().findViewById(R.id.b6);
        Button n7 = (Button)getView().findViewById(R.id.b7);
        Button n8 = (Button)getView().findViewById(R.id.b8);
        Button n9 = (Button)getView().findViewById(R.id.b9);
        Button puzzle1 = (Button)getView().findViewById(R.id.puzzle1);
        Button puzzle2 = (Button)getView().findViewById(R.id.puzzle2);

        final SharedPreferences access = getActivity().getSharedPreferences("access file", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = access.edit();

        n0.setBackground(getResources().getDrawable(R.drawable.star_pressed));

        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "A", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity(),Trace0.class);
                startActivity(i);

                getActivity().finish();

            }
        });

        if(access.getInt("no1",2)==1) {
            n1.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("no1",2)==1){
                Intent i = new Intent(getActivity(),Trace1.class);
                startActivity(i);
                getActivity().finish();
                }

            }
        });

        if(access.getInt("no2",2)==1) {
            n2.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("no2",2)==1) {
                    Intent i = new Intent(getActivity(), Trace2.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("no3",2)==1) {
            n3.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("no3",2)==1) {
                    Intent i = new Intent(getActivity(), Trace3.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("no4",2)==1) {
            n4.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("no4",2)==1) {
                    Intent i = new Intent(getActivity(), Trace4.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("puzzle_1",2)==1) {
            puzzle1.setBackground(getResources().getDrawable(R.drawable.chest_open));
        }

        puzzle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("puzzle_1",2)==1) {
                    Intent i = new Intent(getActivity(), NumberPuzzle1.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("no5",2)==1) {
            n5.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("no5",2)==1) {
                    Intent i = new Intent(getActivity(), Trace5.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("no6",2)==1) {
            n6.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }


        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("no6",2)==1) {
                    Intent i = new Intent(getActivity(), Trace6.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("no7",2)==1) {
            n7.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }


        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("no7",2)==1) {
                    Intent i = new Intent(getActivity(), Trace7.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("no8",2)==1) {
            n8.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }


        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("no8",2)==1) {
                    Intent i = new Intent(getActivity(), Trace8.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("no9",2)==1) {
            n9.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("no9",2)==1) {
                    Intent i = new Intent(getActivity(), Trace9.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("puzzle_2",2)==1) {
            puzzle2.setBackground(getResources().getDrawable(R.drawable.chest_open));
        }

        puzzle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("puzzle_2",2)==1) {
                    Intent i = new Intent(getActivity(), NumberPuzzle2.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });
    }
}
