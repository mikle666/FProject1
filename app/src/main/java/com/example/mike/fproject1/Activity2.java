package com.example.mike.fproject1;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    public static final String TEXT_KEY = "TEXT_KEY";

    private TextView mTextView02;
    private Button mButtonView2;

    private void showMessage(@StringRes String string){
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }


    private View.OnClickListener mButtonView2OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String s1 = "http://www.google.com/search?q=";
            String url01 = s1.concat(mTextView02.getText().toString());
            //showMessage(url01);
            Uri address = Uri.parse(url01);
            Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
            startActivity(openlinkIntent);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mTextView02 = findViewById(R.id.tvTextView2);
        mButtonView2 = findViewById(R.id.buttonView2);

        Bundle bundle = getIntent().getExtras();
        mTextView02.setText(bundle.getString(TEXT_KEY));

        mButtonView2.setOnClickListener(mButtonView2OnClickListener);


    }
}
