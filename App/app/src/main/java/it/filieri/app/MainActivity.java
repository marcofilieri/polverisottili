package it.filieri.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import it.filieri.app.dto.Centralina;
import it.filieri.app.dto.Feeds;

public class MainActivity extends AppCompatActivity {
    String resp = "";
    private TextView tw;
    private Button btn_medi, btn_municipio, btn_capp, btn_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tw = findViewById(R.id.textView);
        btn_medi = findViewById(R.id.button1);
        btn_municipio = findViewById(R.id.button2);
        btn_capp = findViewById(R.id.button3);
        btn_info = findViewById(R.id.button4);


        btn_medi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getJSON("780613");
            }
        });

        btn_capp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getJSON("752822");
            }
        });

        btn_municipio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJSON("789925");
            }
        });

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String text = "Benvenuto nell'app realizzata durante il 'PON Monitoraggio Particolato Atmosferico' dal gruppo studenti della IV a & III A Inf. 2019 dell'IISS E.Medi Galatone con l'esperto esterno F. P. Paolicelli ed il Prof. Cesare De Rosa.";
                final Toast notification = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                notification.show();
            }
        });
    }


    private void getJSON(String channel) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://thingspeak.com/channels/"+channel+"/feed.json?results=1";



        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        resp = response;
                        parse();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tw.setText("That didn't work!");
            }
        });
        queue.add(stringRequest);
    }


    private void parse() {
        Gson gson = new Gson();
        Centralina centralina = gson.fromJson(resp, Centralina.class);
        Feeds al = centralina.getFeeds().get(0);
        tw.setText(al.toString());
    }



}
