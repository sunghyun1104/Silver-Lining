package com.example.sanghun.withkey;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private boolean buttonClicked[] = new boolean[6];
    private TextView textView;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            translate();
            handler.removeCallbacks(runnable);
            for(int i = 0; i < 6 ; i++)
                buttonClicked[i] = false;
        }
    };

    public void translate(){

        if(buttonClicked[0] == false && buttonClicked[1] == true && buttonClicked[2] == false &&
                buttonClicked[3] == false && buttonClicked[4] == false && buttonClicked[5] == false)
            textView.setText("ㄱ 입니다");

        if(buttonClicked[0] == true && buttonClicked[1] == true && buttonClicked[2] == false &&
                buttonClicked[3] == false && buttonClicked[4] == false && buttonClicked[5] == false)
            textView.setText("ㄴ 입니다");

        if(buttonClicked[0] == false && buttonClicked[1] == true && buttonClicked[2] == true &&
                buttonClicked[3] == false && buttonClicked[4] == false && buttonClicked[5] == false)
            textView.setText("ㄷ 입니다");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);

        button1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    buttonClicked[0] = true;
                    vibrator.vibrate(200);   // 밑으로 내려야함 또는 쓰레드
                    handler.postDelayed(runnable, 300);
                }
                return true;
            }
        });

        button2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    buttonClicked[1] = true;
                    vibrator.vibrate(200);
                    handler.postDelayed(runnable, 300);
                }
                return true;
            }
        });

        button3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    buttonClicked[2] = true;
                    vibrator.vibrate(200);
                    handler.postDelayed(runnable, 300);
                }
                return true;
            }
        });

        button4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    buttonClicked[3] = true;
                    vibrator.vibrate(200);
                    handler.postDelayed(runnable, 300);
                }
                return true;
            }
        });

        button5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    buttonClicked[4] = true;
                    vibrator.vibrate(200);
                    handler.postDelayed(runnable, 300);
                }
                return true;
            }
        });

        button6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    buttonClicked[5] = true;
                    vibrator.vibrate(200);
                    handler.postDelayed(runnable, 300);
                }
                return true;
            }
        });

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
}
