package nella.nat.myclass_ik_2b;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLihat = findViewById(R.id.lihatbtn);
        Button btnInput = findViewById(R.id.inputtbtn);
        Button btnInfo = findViewById(R.id.informasi);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent InputData = new Intent(MainActivity.this, InputData.class);
                startActivity(InputData);
            }
        });

        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LihatData = new Intent(MainActivity.this, LihatData.class);
                startActivity(LihatData);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Informasi = new Intent(MainActivity.this, Informasi.class);
                startActivity(Informasi);
            }
        });
    }
}
