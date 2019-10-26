package com.example.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_login;
    EditText txt_user;
    EditText txt_password;
    final String MESSAGE_WELCOME = "Bienvenido!";
    final String MESSAGE_USER_INCORRECT = "Usuario no encontrado!";
    final String MESSAGE_EMPTY_FIELD = "Existen datos por llenar!";
    final String USER = "admin";
    final String PASSWORD = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //event Login onclick
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                logIn();
            }
        });
    }

    public void logIn(){
        txt_user = findViewById(R.id.txt_user);
        txt_password = findViewById(R.id.txt_password);
        if(validate_empty_fields(txt_user,txt_password) && validate_user(txt_user,txt_password) ){
            Toast.makeText(
                    MainActivity.this,
                    this.MESSAGE_WELCOME + " "+txt_user.getText().toString(),
                    Toast.LENGTH_LONG)
                    .show();
            Intent intent = new Intent(MainActivity.this, mainPage.class);
            startActivity(intent);
        }else if(!validate_empty_fields(txt_user,txt_password)){
            Toast.makeText(
                    MainActivity.this,
                    this.MESSAGE_EMPTY_FIELD,
                    Toast.LENGTH_LONG)
                    .show();
        }else if(!validate_user(txt_user,txt_password)){
            Toast.makeText(
                    MainActivity.this,
                    this.MESSAGE_USER_INCORRECT,
                    Toast.LENGTH_LONG)
                    .show();
        }

    }

    private boolean validate_empty_fields(TextView user, TextView password){
        if(user.getText().toString().equals("") || password.getText().toString().equals("") ){
            return false;
        }
        return true;
    }

    private boolean validate_user(TextView user, TextView password){
        if(user.getText().toString().equals(this.USER) || password.getText().toString().equals(this.PASSWORD)){
            return true;
        }
        return false;
    }
}
