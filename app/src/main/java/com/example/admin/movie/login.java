package com.example.admin.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    EditText user,pass;
    Button login;

    @Override
    public void onCreate (Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.login_activity);

        user=(EditText)findViewById(R.id.et_user);
        pass=(EditText)findViewById(R.id.et_pass);
        login=(Button)findViewById(R.id.b_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pola.saveSharedsetting(login.this,"myclip","false");
                pola.SAVE(getApplicationContext(),user.getText().toString());
                Intent login = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(login);
                finish();
            }
        });


    }
}

