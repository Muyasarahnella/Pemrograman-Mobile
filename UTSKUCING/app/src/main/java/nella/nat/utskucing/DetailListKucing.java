package nella.nat.utskucing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class DetailListKucing extends AppCompatActivity {

    private int kucing_id;
    ImageView imgDetail;
    TextView tvName, tvDesc;
    private ArrayList<Kucing> listKucing = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_kucing);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        kucing_id = getIntent().getIntExtra("kucing_id",0);
        tvName = findViewById(R.id.nama_kucing);
        tvDesc = findViewById(R.id.desc_detail);
        imgDetail = findViewById(R.id.img_detail);

        listKucing.addAll(KucingData.getListData());

        setLayout();
        namakucing();
    }

    void setLayout() {

        tvName.setText(listKucing.get(kucing_id).getName());
        tvDesc.setText(listKucing.get(kucing_id).getDescrption());
        Glide.with(this)
                .load(listKucing.get(kucing_id).getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(imgDetail);
    }

    void namakucing(){
        getSupportActionBar().setTitle(listKucing.get(kucing_id).getName());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
