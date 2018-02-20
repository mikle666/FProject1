package com.example.mike.fproject1;

import android.os.StrictMode;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    // private EditText mMainInput1;
    private TextView mJSONTextBTC;
    private TextView mJSONTextETH;
    private TextView mJSONTextBCH;
    private TextView mJSONTextXRP;

    private Button mMainButton1;





    String getJSON(String coin_request, String curr_pair) {
        try {
            URL get_request = new URL(coin_request);
            URLConnection connection = get_request.openConnection();
            connection.setDoOutput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(get_request.openStream()));
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();

            String jsonStr = sb.toString();

            JSONObject json = new JSONObject(jsonStr);
            JSONObject jsonResponse = json.getJSONObject(curr_pair);
            String value1 = jsonResponse.getString("bid_top");

            return value1;

        } catch(Exception e){
           return(e.toString());
    }
}
    private View.OnClickListener mMainButton1OnClickListener;


    {
        mMainButton1OnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getCoinPairsData();
                    } catch (Exception e){
                        ;
                        mJSONTextBTC.setText(e.toString());
                    }

            }
        };
    }


    private void showMessage(@StringRes android.text.Editable string){
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }
    private void getCoinPairsData(){
        mJSONTextBTC.setText("BTC:  " + getJSON("https://api.exmo.me/v1/order_book/?pair=BTC_USD", "BTC_USD"));
        mJSONTextETH.setText("ETH:  " + getJSON("https://api.exmo.me/v1/order_book/?pair=ETH_USD", "ETH_USD"));
        mJSONTextBCH.setText("BCH:  " + getJSON("https://api.exmo.me/v1/order_book/?pair=BCH_USD", "BCH_USD"));
        mJSONTextXRP.setText("XRP:  " + getJSON("https://api.exmo.me/v1/order_book/?pair=XRP_USD", "XRP_USD"));
    }

    class UpdateTimeTask extends TimerTask {
    @Override
        public void run() {

        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                getCoinPairsData();

            }
        });

    }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
       // mMainInput1 = findViewById(R.id.etInputMain);
        mMainButton1 = findViewById(R.id.buttonInputMain);
        mJSONTextBTC = findViewById(R.id.tvBTC);
        mJSONTextETH = findViewById(R.id.tvETH);
        mJSONTextBCH = findViewById(R.id.tvBCH);
        mJSONTextXRP = findViewById(R.id.tvXRP);

        mMainButton1.setOnClickListener(mMainButton1OnClickListener);

        getCoinPairsData();

        Timer timer = new Timer();
        timer.schedule(new UpdateTimeTask(), 0, 2000);
      }
}
