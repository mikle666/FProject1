package com.example.mike.fproject1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    public static final String TEXT_KEY = "TEXT_KEY";

    private TextView mTextView02;
    private Button mButtonView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mTextView02 = findViewById(R.id.tvTextView2);
        mButtonView2 = findViewById(R.id.buttonView2);

        Bundle bundle = getIntent().getExtras();
        mTextView02.setText(bundle.getString(TEXT_KEY));

    }
}
