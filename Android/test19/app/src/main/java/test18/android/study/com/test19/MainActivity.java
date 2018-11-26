package test18.android.study.com.test19;

import android.app.Activity;
import android.media.AudioManager;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class StartActivity extends Activity {



    public int no1;

    public int btn = 1;

    SoundPool sound;

    int soundId1;

    int soundId2;

    int soundId3;​

    int soundId4;​

    int soundId5;​



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);



        ImageButton btn = (ImageButton) findViewById(R.id.btn);



        sound = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

        soundId = sound.load(this, R.raw.sound1, 1);

        soundId2 = sound.load(this, R.raw.sound2, 1);

        soundId3 = sound.load(this, R.raw.sound3,1);

        soundId4 = sound.load(this, R.raw.sound4,1);

        soundId5 = sound.load(this, R.raw.sound5,1);



        Button button = (Button) findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {



                rand r = new rand();



                if(btn == 1){

                    no1 = r.num;

                    if(no1 == 1)

                    {

                        sound.play(soundId1, 1f, 1f, 0, 0, 1f);

                        btn += 1;

                    }

                    else if(no1 ==2)

                    {

                        sound.play(soundId2, 1f, 1f, 0, 0, 1f);

                        btn += 1;

                    }

                }

                else if(btn == 2)

                {

                    no1 = r.num;

                    if(no1 == 1)

                    {

                        sound.play(soundId3, 1f, 1f, 0, 0, 1f);

                        btn += 1;

                    }

                    else if(no1 == 2)

                    {

                        sound.play(soundId5, 1f, 1f, 0, 0, 1f);

                        btn += 1;

                    }



                }

                else if(btn == 3)

                {

                    sound.play(soundId4, 1f, 1f, 0, 0, 1f);

                    btn = 1;

                }

            }



        });

    }