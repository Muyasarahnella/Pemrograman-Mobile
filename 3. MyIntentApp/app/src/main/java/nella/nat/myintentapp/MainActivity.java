package nella.nat.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.UFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnMoveActivity;
    Button btnMoveActivityWithData;
    Button btndial;
    Button btnwebsite;
    Button btnexplicit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveActivityWithData = findViewById(R.id.btn_move_data);
        btnMoveActivityWithData.setOnClickListener(this);

        btndial = findViewById((R.id.btn_dial));
        btndial.setOnClickListener(this);

        btnwebsite = findViewById(R.id.btn_website);
        btnwebsite.setOnClickListener(this);

        btnexplicit = findViewById(R.id.btn_explicit);
        btnexplicit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_data:
                Intent moveData = new Intent(MainActivity.this,MoveAcitivityWithData.class);
                moveData.putExtra(MoveAcitivityWithData.EXTRA_NAME,"Muyasarah Nella");
                moveData.putExtra(MoveAcitivityWithData.EXTRA_AGE,19);
                startActivity(moveData);
                break;

            case R.id.btn_dial:
                String phoneNumber = "085642378085";
                Intent dialPhone = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhone);
                break;

            case R.id.btn_website:
                String web = "http://www.polines.ac.id";
                Intent openweb = new Intent(Intent.ACTION_VIEW,Uri.parse(web)); //uri.parse("www.polines.ac.id")//
                startActivity(openweb);
                break;

            case R.id.btn_explicit:
                Intent exp = new Intent(MainActivity.this, HalamanActivity1.class);
                startActivity(exp);
                break;



        }
    }
}
