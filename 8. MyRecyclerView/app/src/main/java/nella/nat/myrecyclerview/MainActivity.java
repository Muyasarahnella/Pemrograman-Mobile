package nella.nat.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {
    public RecyclerView rvHmj;
    private ArrayList<Hmj> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHmj=findViewById(R.id.rv_hmj);
        rvHmj.setHasFixedSize(true);

        if (getSupportActionBar() !=null ){
            getSupportActionBar().setTitle("HM & UKM Polines");
        }
        list.addAll(getListHmj());
        showRecycleList();

        //Membuat Underline pada Setiap Item Didalam List
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.line));
        rvHmj.addItemDecoration(itemDecoration);
        rvHmj.setItemAnimator(new DefaultItemAnimator());
    }

    public Collection<? extends Hmj> getListHmj() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        String[] dataPhoto = getResources().getStringArray(R.array.photo);

        ArrayList<Hmj> listHmj = new ArrayList<>();
        for (int i=0;i<dataName.length; i++){
            Hmj hmj = new Hmj();
            hmj.setName(dataName[i]);
            hmj.setDescription(dataDescription[i]);
            hmj.setPhoto(dataPhoto[i]);

            listHmj.add(hmj);
        }
        return listHmj;
    }


    private void showRecycleList(){
        rvHmj.setLayoutManager(new LinearLayoutManager(this));
        ListHMJAdapter listHMJAdapter = new ListHMJAdapter(list);
        rvHmj.setAdapter(listHMJAdapter);
    }

}
