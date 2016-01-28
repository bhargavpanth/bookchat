package com.fossdevs.bookchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity implements RegisterPushyInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=(((EditText)findViewById(R.id.editText)).getText().toString());
                RegisterPushy registerPushy=new RegisterPushy(username);
                registerPushy.registerPushyInterface=SignUp.this;
                registerPushy.execute(getApplicationContext());
            }
        });
    }
    public void Registered(String registration_id) {
        finish();
    }

}
