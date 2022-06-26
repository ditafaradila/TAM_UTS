package com.example.readingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText Uname,Password;
    Button Login;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Uname = findViewById(R.id.email);
        Password = findViewById(R.id.pass);
        Login = findViewById(R.id.btnLogin);

        preferences = getSharedPreferences("UserDetail" , Context.MODE_PRIVATE);

        cekSession();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = Uname.getText().toString();
                String password = Password.getText().toString();

                boolean isEmptyFields = false;
                if (TextUtils.isEmpty(user)) {
                    isEmptyFields = true;
                    Uname.setError("Field ini tidak boleh kosong");
                }

                if (TextUtils.isEmpty(password)) {
                    isEmptyFields = true;
                    Password.setError("Field ini tidak boleh kosong");
                }

                if (!isEmptyFields) {
                    //Menyimpan Data
                    editor = preferences.edit();
                    //Mengambil data
                    editor.putString("user", user);
                    editor.putString("password", password);
                    editor.apply();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        });

    }

    private void cekSession() {
        String data = preferences.getString("user", null);
        if (data==null){
            Toast.makeText(getApplication(),"Tidak ada Session", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
