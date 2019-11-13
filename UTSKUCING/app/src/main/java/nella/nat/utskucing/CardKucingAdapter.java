package nella.nat.utskucing;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardKucingAdapter extends RecyclerView.Adapter<CardKucingAdapter.ListViewHolder> {
    private ArrayList<Kucing> listKucing;
    private Context context;

    public CardKucingAdapter (Context context, ArrayList<Kucing> listKucing){
        this.listKucing = listKucing;
        this.context = context;
    }
    @NonNull
    @Override
    public CardKucingAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_kucing,parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardKucingAdapter.ListViewHolder holder, int position) {
        final Kucing kucing = listKucing.get(position);
        Glide.with(holder.itemView.getContext())
                .load(kucing.getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(holder.imgPhoto);

        holder.tvName.setText(kucing.getName());
        holder.tvDesc.setText(kucing.getDescrption());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(context, DetailListKucing.class);
                detail.putExtra("kucing_id", kucing.getId());
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() { return listKucing.size(); }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvDesc;
        CardView cv;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_kucing_list);
            tvName = itemView.findViewById(R.id.name_list_kucing);
            tvDesc = itemView.findViewById(R.id.desc_kucing_list);
            cv = itemView.findViewById(R.id.cardview_item);
        }
    }
}
