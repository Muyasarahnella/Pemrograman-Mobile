package nella.nat.myviewmodel;

import android.icu.text.DecimalFormat;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainViewModel extends ViewModel {
    private static final String API_KEY="6393040e75c38e2deaf018f4ead33680";
    private MutableLiveData<ArrayList<Weatheritems>>listWeather=new MutableLiveData<>();

    void setWeather(final String cities){
        AsyncHttpClient client=new AsyncHttpClient();
        final ArrayList<Weatheritems> listitems=new ArrayList<>();
        String url ="https://api.openweathermap.org/data/2.5/group?id="+cities+"&units=metric&appid="+API_KEY;

        client.get(url, new AsyncHttpResponseHandler() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result=new String (responseBody);
                    JSONObject responseObject=new JSONObject(result);
                    JSONArray list=responseObject.getJSONArray("list");
                    for (int i=0;i<list.length();i++){
                        JSONObject weather=list.getJSONObject(i);
                        Weatheritems Weatheritems=new Weatheritems();
                        Weatheritems.setId(weather.getInt("id"));
                        Weatheritems.setName(weather.getString("name"));
                        Weatheritems.setCurrentWeather(weather.getJSONArray("weather").getJSONObject(0).getString("main"));
                        Weatheritems.setDescription(weather.getJSONArray("weather").getJSONObject(0).getString("description"));
                        double templCelcius=weather.getJSONObject("main").getDouble("temp");
                        Weatheritems.setTemperature(new DecimalFormat("##,##").format(templCelcius));
                        listitems.add(Weatheritems);
                    }
                    listWeather.postValue(listitems);
                }catch (Exception e){
                    Log.d("Exception",e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure",error.getMessage());
            }
        });
    }
    LiveData<ArrayList<Weatheritems>> getWeathers(){
        return listWeather;
    }

}