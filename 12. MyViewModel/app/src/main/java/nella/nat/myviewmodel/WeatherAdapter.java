package nella.nat.myviewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>{

    private ArrayList<Weatheritems>mData=new ArrayList<>();

    public void setData (ArrayList<Weatheritems> items){
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View MView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weather_items,viewGroup,false);
        return new WeatherViewHolder(MView);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.WeatherViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView TvNamakota,TvDesc,TvTemperatur;

        public WeatherViewHolder(View itemview) {
            super(itemview);
            TvNamakota=itemview.findViewById(R.id.textKota);
            TvTemperatur=itemview.findViewById(R.id.textTemp);
            TvDesc=itemview.findViewById(R.id.textDesc);
        }

        public void bind(Weatheritems weatherItem) {
            TvNamakota.setText(weatherItem.getName());
            TvDesc.setText(weatherItem.getTemperature());
            TvTemperatur.setText(weatherItem.getDescription());
        }
    }
}
