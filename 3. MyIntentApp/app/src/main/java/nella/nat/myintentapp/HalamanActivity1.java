package nella.nat.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HalamanActivity1 extends AppCompatActivity {

    Button btnhal2;
    EditText edithal2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman1);
        btnhal2 = findViewById(R.id.btnhal2);
        edithal2 = findViewById(R.id.edithal2);

        btnhal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = edithal2.getText().toString();
                startActivity(new Intent(HalamanActivity1.this, HalamanActivity2.class).putExtra("nama",nama));
            }
        });
    }
}
