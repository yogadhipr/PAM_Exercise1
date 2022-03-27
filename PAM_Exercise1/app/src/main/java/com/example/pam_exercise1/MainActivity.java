package com.example.pam_exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView registr;

    private EditText edemail, edpassword;

    String email, passw;

    Button btnSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edemail = findViewById(R.id.tEmail);
        edpassword = findViewById(R.id.tPassword);

        btnSignin = findViewById(R.id.btsignin);

        registr = findViewById(R.id.regissignin);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = edemail.getText().toString();
                passw = edpassword.getText().toString();

                String mail = "admin@mail.com";
                String pass = "123";

                if(email.isEmpty() || passw.isEmpty()){
                    edemail.setError("username tidak boleh kosong");
                    edpassword.setError("password tidak boleh kosong");
                }else{
                    if(email.equals(mail) && passw.equals(pass)){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "login berhasil", Toast.LENGTH_LONG);
                        t.show();

                        Intent i = new Intent(getApplicationContext(), MainMenu.class);

                        startActivity(i);
                    }else if(email.equals(mail)){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "password salah!", Toast.LENGTH_LONG);
                        t.show();
                    }else if(passw.equals(pass)){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "username salah!", Toast.LENGTH_LONG);
                        t.show();
                    }else{
                        Toast t = Toast.makeText(getApplicationContext(),
                                "username dan password salah!", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });

        registr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Registrasi.class);

                startActivity(i);
            }
        });

    }
}