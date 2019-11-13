package nella.nat.utskucing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;


public class SplashActivity extends AppCompatActivity {
    protected boolean _active = true;
    protected int _splashTime = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(100);
                        if(_active) {
                            waited += 100;
                        }
                    }
                } catch (Exception e) {

                }finally{

                    startActivity(new Intent(SplashActivity.this,
                            MainActivity.class));
                    finish();
                }
            };
        };
        splashTread.start();
    }
    }

