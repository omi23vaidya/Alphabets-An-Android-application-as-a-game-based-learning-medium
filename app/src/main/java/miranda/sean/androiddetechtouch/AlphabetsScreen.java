package miranda.sean.androiddetechtouch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import static android.media.MediaPlayer.create;


/**
 * Created by Sean Miranda on 28-Feb-16.
 */
public class AlphabetsScreen extends Fragment {

    MediaPlayer asound;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
       return inflater.inflate(R.layout.activity_alphabets_screen,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        //setContentView(R.layout.activity_main);

        final ScrollView scrollview = ((ScrollView)getView().findViewById(R.id.scrollview));
        scrollview.post(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

        final Button a = (Button)getView().findViewById(R.id.A);
        Button b = (Button)getView().findViewById(R.id.B);
        Button c = (Button)getView().findViewById(R.id.C);
        Button d = (Button)getView().findViewById(R.id.D);
        Button e = (Button)getView().findViewById(R.id.E);
        Button f = (Button)getView().findViewById(R.id.F);
        Button g = (Button)getView().findViewById(R.id.G);
        Button h = (Button)getView().findViewById(R.id.H);
        Button i = (Button)getView().findViewById(R.id.I);
        Button j = (Button)getView().findViewById(R.id.J);
        Button k = (Button)getView().findViewById(R.id.K);
        Button l = (Button)getView().findViewById(R.id.L);
        Button m = (Button)getView().findViewById(R.id.M);
        Button n = (Button)getView().findViewById(R.id.N);
        Button o = (Button)getView().findViewById(R.id.O);
        Button p = (Button)getView().findViewById(R.id.P);
        Button q = (Button)getView().findViewById(R.id.Q);
        Button r = (Button)getView().findViewById(R.id.R);
        Button s = (Button)getView().findViewById(R.id.S);
        Button t = (Button)getView().findViewById(R.id.T);
        Button u = (Button)getView().findViewById(R.id.U);
        Button v = (Button)getView().findViewById(R.id.V);
        Button w = (Button)getView().findViewById(R.id.W);
        Button x = (Button)getView().findViewById(R.id.X);
        Button y = (Button)getView().findViewById(R.id.Y);
        Button z = (Button)getView().findViewById(R.id.Z);
        Button puzzle1 = (Button)getView().findViewById(R.id.oddone);
        Button puzzle2 = (Button)getView().findViewById(R.id.nextAlphabet);
        Button puzzle3 = (Button)getView().findViewById(R.id.selectAlphabet);
        Button puzzle4 = (Button)getView().findViewById(R.id.FindMissingAlphabet);
        Button puzzle5 = (Button)getView().findViewById(R.id.FlipTheTile);



        final SharedPreferences access = getActivity().getSharedPreferences("access file", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = access.edit();

        a.setBackground(getResources().getDrawable(R.drawable.star_pressed));

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "A", Toast.LENGTH_SHORT).show();
                getActivity().stopService(new Intent(getActivity().getBaseContext(), MyService.class));
                //asound = MediaPlayer.create(getActivity(),R.raw.a);
                Intent i = new Intent(getActivity(),Atrace.class);
                startActivity(i);
                //asound.start();
                getActivity().finish();


            }
        });

        if(access.getInt("b",2)==1) {
            b.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("b",2)==1) {
                    Intent i = new Intent(getActivity(), Btrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
                else
                {

                }
            }
        });

        if(access.getInt("c",2)==1) {
            c.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }


        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("c",2)==1) {
                    getActivity().stopService(new Intent(getActivity().getBaseContext(), MyService.class));
                    Intent i = new Intent(getActivity(), ctrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
                else
                {

                }
            }
        });

        if(access.getInt("d",2)==1) {
            d.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("d",2)==1) {
                    getActivity().stopService(new Intent(getActivity().getBaseContext(), MyService.class));
                    Intent i = new Intent(getActivity(),dtrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
                else
                {

                }
            }
        });

        if(access.getInt("e",2)==1) {
            e.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("e",2)==1) {
                    getActivity().stopService(new Intent(getActivity().getBaseContext(), MyService.class));
                    Intent i = new Intent(getActivity(),Etrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
                else
                {

                }

            }
        });

        if(access.getInt("puzzle1",2)==1) {
            puzzle1.setBackground(getResources().getDrawable(R.drawable.chest_open));
        }

        puzzle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("puzzle1",2)==1) {
                    getActivity().stopService(new Intent(getActivity().getBaseContext(), MyService.class));
                    Intent i = new Intent(getActivity(), oddone.class);
                    startActivity(i);
                    getActivity().finish();
                }

            }
        });

        if(access.getInt("f",2)==1) {
            f.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("f",2)==1) {
                    getActivity().stopService(new Intent(getActivity().getBaseContext(), MyService.class));
                    Intent i = new Intent(getActivity(), Ftrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
                else{
                }

            }
        });

        if(access.getInt("g",2)==1) {
            g.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("g",2)==1) {
                    Intent i = new Intent(getActivity(), Gtrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
                else{
                }
            }
        });

        if(access.getInt("h",2)==1) {
            h.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("h",2)==1) {
                    Intent i = new Intent(getActivity(), Htrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
                else{
                }

            }
        });

        if(access.getInt("i",2)==1) {
            i.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("i",2)==1) {
                    Intent i = new Intent(getActivity(), Itrace.class);
                    startActivity(i);
                    getActivity().finish();
                }

            }
        });

        if(access.getInt("j",2)==1) {
           j.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("j",2)==1) {
                    Intent i = new Intent(getActivity(), Jtrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("puzzle2",2)==1) {
            puzzle2.setBackground(getResources().getDrawable(R.drawable.chest_open));
        }

        puzzle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("puzzle2",2)==1) {
                    Intent i = new Intent(getActivity(), NextAlphabet.class);
                    startActivity(i);
                    getActivity().finish();
                }

            }
        });

        if(access.getInt("k",2)==1) {
            k.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("k",2)==1) {
                    Intent i = new Intent(getActivity(), Ktrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("l",2)==1) {
            l.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("l",2)==1) {
                    Intent i = new Intent(getActivity(), Ltrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("m",2)==1) {
            m.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("m",2)==1) {
                    Intent i = new Intent(getActivity(), Mtrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("n",2)==1) {
            n.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("n",2)==1) {
                    Intent i = new Intent(getActivity(), Ntrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("o",2)==1) {
            o.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("o",2)==1) {
                    Intent i = new Intent(getActivity(), Otrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("puzzle3",2)==1) {
            puzzle3.setBackground(getResources().getDrawable(R.drawable.chest_open));
        }

        puzzle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("puzzle3",2)==1) {
                    Intent i = new Intent(getActivity(), SelectAlphabetCorrespondingToImage.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("p",2)==1) {
            p.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("p",2)==1) {
                    Intent i = new Intent(getActivity(), Ptrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("q",2)==1) {
            q.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("q",2)==1) {
                    Intent i = new Intent(getActivity(), Qtrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("r",2)==1) {
            r.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                if(access.getInt("r",2)==1) {
                    Intent i = new Intent(getActivity(), Rtrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("s",2)==1) {
            s.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("s",2)==1) {
                    Intent i = new Intent(getActivity(), Strace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("t",2)==1) {
            t.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("t",2)==1) {
                    Intent i = new Intent(getActivity(), Ttrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("puzzle4",2)==1) {
            puzzle4.setBackground(getResources().getDrawable(R.drawable.chest_open));
        }

        puzzle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("puzzle4",2)==1) {
                    Intent i = new Intent(getActivity(), FindMissingAlphabet.class);
                    startActivity(i);
                    getActivity().finish();
                }

            }
        });

        if(access.getInt("u",2)==1) {
            u.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("u",2)==1) {
                    Intent i = new Intent(getActivity(), Utrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("v",2)==1) {
            v.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("v",2)==1) {
                    Intent i = new Intent(getActivity(), Vtrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("w",2)==1) {
            w.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("w",2)==1) {
                    Intent i = new Intent(getActivity(), Wtrace.class);
                    startActivity(i);
                    getActivity().finish();
                }

            }
        });

        if(access.getInt("x",2)==1) {
            x.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("x",2)==1) {
                    Intent i = new Intent(getActivity(), Xtrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("y",2)==1) {
            y.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("y",2)==1) {
                    Intent i = new Intent(getActivity(), Ytrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("z",2)==1) {
            z.setBackground(getResources().getDrawable(R.drawable.star_pressed));
        }

        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("z",2)==1) {
                    Intent i = new Intent(getActivity(), Ztrace.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        if(access.getInt("puzzle5",2)==1) {
            puzzle5.setBackground(getResources().getDrawable(R.drawable.chest_open));
        }

        puzzle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(access.getInt("puzzle5",2)==1) {
                    Intent i = new Intent(getActivity(), FlipTheTile.class);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });



    }

    public void onBackPressed()
    {
        super.getActivity().onBackPressed();
        getActivity().stopService(new Intent(getActivity().getBaseContext(), MyService.class));
        System.exit(0);
    }

    /*View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.activity_alphabets_screen,container,false);
        return rootview;
    }*/
}

