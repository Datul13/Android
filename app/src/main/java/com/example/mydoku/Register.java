package com.example.mydoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    DatabaseHelper db;
    Button login, register;
    EditText username, password, Cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        username = (EditText)findViewById(R.id.userRegis);
        password = (EditText)findViewById(R.id.passwordRegis);
        Cpassword = (EditText)findViewById(R.id.CPasswordRegis);
        login = (Button)findViewById(R.id.btn_loginRegis);
        register = (Button)findViewById(R.id.btn_register);

        //register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                String strCPassword = Cpassword.getText().toString();
                if (strPassword.equals(strCPassword)) {
                    Boolean daftar = db.insertUser(strUsername, strPassword);
                    if (daftar == true) {
                        Toast.makeText(getApplicationContext(), "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(Register.this, login.class);
                        startActivity(loginIntent);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Registrasi Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Password Tidak Sesuai", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(Register.this, login.class);
                startActivity(loginIntent);
                finish();
            }
        });


    }


}