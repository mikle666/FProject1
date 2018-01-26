package com.example.mike.fproject1;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mMainInput1;
    private Button mMainButton1;

    private View.OnClickListener mMainButton1OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!TextUtils.isEmpty(mMainInput1.getText())){
                showMessage(mMainInput1.getText());
                //Intent startProfileIntent =  new Intent(AuthActivity.this, ProfileActivity.class);
                //startProfileIntent.putExtra(ProfileActivity.USER_KEY, new User(mLogin.getText().toString(),
                //        mPassword.getText().toString()));
                //test



                Intent startView2 = new Intent (MainActivity.this, Activity2.class);
                startView2.putExtra(Activity2.TEXT_KEY, mMainInput1.getText().toString());
                startActivity(startView2);

            } else {

            }
            //todo
        }
    };



    private void showMessage(@StringRes android.text.Editable string){
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainInput1 = findViewById(R.id.etInputMain);
        mMainButton1 = findViewById(R.id.buttonInputMain);

        mMainButton1.setOnClickListener(mMainButton1OnClickListener);

    }
}
