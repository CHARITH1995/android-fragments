package com.example.charyth.androidassigment1;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by charyth on 8/19/2019.
 */

public class hotels extends AppCompatActivity{

    private RecyclerView.LayoutManager layoutManager;
    ListView hotelList;
    String myResponse;
    JSONArray myJsonArray;
    JSONObject myJsonObject;
    private TextView tv;
    private ListView lv;
    String title;
    String location;
    String image;
    String Id;
    Dialog dialog;
    RecyclerView newRecycler;

    ArrayList<HashMap<String, String>> contactList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.hotels);

            dialog = new Dialog(this);
            contactList = new ArrayList<HashMap<String, String>>();

            newRecycler = findViewById(R.id.recycler_view);
            //tv = findViewById(R.id.listView);
            lv = findViewById(R.id.listView);

            OkHttpClient client = new OkHttpClient();
            String url = "http://fortunagate.com/Amaya/service.php?q=hotels";
            Request request= new Request.Builder()
                    .url(url)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if(response.isSuccessful()){
                        myResponse = response.body().string();
                        Log.e("json",myResponse);
                        try {
                           myJsonObject = new JSONObject(myResponse);
                           myJsonArray = myJsonObject.getJSONArray("topimages");

                            int count = 0;
                            String name , id ;
                            for (int i = 0;count < myJsonArray.length();i++){
                                JSONObject c = myJsonArray.getJSONObject(i);
                                 title = c.getString("title");
                                 location = c.getString("location");
                                 image = c.getString("thumb");
                                 Id = c.getString("hotelid");

                                HashMap<String, String> hotels = new HashMap<>();
                                hotels.put("id", Id);
                                hotels.put("name", title);
                                hotels.put("location",location);
                                hotels.put("image", image);

                                contactList.add(hotels);
                                 count ++;

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        hotels.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //layoutManager = new LinearLayoutManager(hotels.this);
                                //newRecycler.setLayoutManager(layoutManager);
                                //HotelAdapter adapter = new HotelAdapter(contactList, getApplicationContext());
                                ListAdapter adapter = new SimpleAdapter(hotels.this, contactList,
                                        R.layout.row_layout, new String[]{ "name","location"},
                                        new int[]{R.id.row_layout_name, R.id.row_layout_id});
                                lv.setAdapter(adapter);
                            }
                        });
                    }
                }
            });

        }

    public void popup(View view){
        dialog.setContentView(R.layout.popup);
        TextView txtClose;
        txtClose = (TextView) dialog.findViewById(R.id.tvclose);
        txtClose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

        }

