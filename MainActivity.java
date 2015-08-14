Enter file contents herepackage com.example.withkey;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private boolean buttonClicked[] = new boolean[6];
    private TextView textView;
    private Handler handler = new Handler();
    private Vibrator vibrator;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            Log.d("with key", "run 실행");

            // translate 함수
            translate();
            handler.removeCallbacks(runnable);
            for(int i = 0; i < 6 ; i++)
                buttonClicked[i] = false;
        }
    };
    public void translate() {

        if(!buttonClicked[0] && buttonClicked[1] && !buttonClicked[2] &&
                !buttonClicked[3] && !buttonClicked[4] && !buttonClicked[5])
            Toast.makeText(getApplicationContext(), "ㄱ 입니다", Toast.LENGTH_LONG).show();

        if(buttonClicked[0] && buttonClicked[1] && !buttonClicked[2] &&
                !buttonClicked[3] && !buttonClicked[4] && !buttonClicked[5])
            Toast.makeText(getApplicationContext(), "ㄴ 입니다", Toast.LENGTH_LONG).show();

        if(!buttonClicked[0] && buttonClicked[1] && buttonClicked[2] &&
                !buttonClicked[3] && !buttonClicked[4] && !buttonClicked[5])
            Toast.makeText(getApplicationContext(), "ㄷ 입니다", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        textView = (TextView) findViewById(R.id.textView);

        ImageButton button1 = (ImageButton) findViewById(R.id.button1);
        ImageButton button2 = (ImageButton) findViewById(R.id.button2);
        ImageButton button3 = (ImageButton) findViewById(R.id.button3);
        ImageButton button4 = (ImageButton) findViewById(R.id.button4);
        ImageButton button5 = (ImageButton) findViewById(R.id.button5);
        ImageButton button6 = (ImageButton) findViewById(R.id.button6);

        Log.d("with key", "button 실행");
        button1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.d("with key", "눌러짐");
                    buttonClicked[0] = true;
                    vibrator.vibrate(200);
                    Log.d("with key", "진동");
                    handler.postDelayed(runnable, 500);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                    buttonClicked[0]=false;
                return true;
            }
        });

        button2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    buttonClicked[1] = true;
                    vibrator.vibrate(200);
                    handler.postDelayed(runnable, 500);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                    buttonClicked[1]=false;
                return true;
            }
        });

        button3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    buttonClicked[2] = true;
                    vibrator.vibrate(200);
                    handler.postDelayed(runnable, 500);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                    buttonClicked[2]=false;
                return true;
            }
        });

        button4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    buttonClicked[3] = true;
                    vibrator.vibrate(200);
                    handler.postDelayed(runnable, 500);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                    buttonClicked[3]=false;
                return true;
            }
        });

        button5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    buttonClicked[4] = true;
                    vibrator.vibrate(200);
                    handler.postDelayed(runnable, 500);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                    buttonClicked[4]=false;
                return true;
            }
        });

        button6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    buttonClicked[5] = true;
                    vibrator.vibrate(200);
                    handler.postDelayed(runnable, 500);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                    buttonClicked[5]=false;
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
