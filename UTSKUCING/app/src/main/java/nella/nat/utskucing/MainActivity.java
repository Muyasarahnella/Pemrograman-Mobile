package nella.nat.utskucing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvKucing;
    private ArrayList<Kucing> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Kucing Ras");
        }

        rvKucing = findViewById(R.id.rv_Kucing);
        rvKucing.setHasFixedSize(true);

        list.addAll(KucingData.getListData());
        showRecycleList();

    }

    private void showRecycleList() {
        rvKucing.setLayoutManager(new LinearLayoutManager(this));
        CardKucingAdapter cardKucingAdapter = new CardKucingAdapter(this, list);
        rvKucing.setAdapter(cardKucingAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuprofil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.akunprofil:
                Intent activity1 = new Intent(this, datadiri.class);
                startActivity(activity1);
                return true;
            default:
                return true;

        }
    }
}