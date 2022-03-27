package com.example.pam_exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainMenu extends AppCompatActivity {

    EditText edttask, edtjns, edttm;

    FloatingActionButton fabadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        fabadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edttask.getText().toString().isEmpty()||
                edtjns.getText().toString().isEmpty()||
                edttm.getText().toString().isEmpty()){
                    Snackbar.make(view, "wajib isi seluruh data!", Snackbar.LENGTH_LONG).show();
                }else{
                    Snackbar.make(view, "berhasil ditambah!", Snackbar.LENGTH_LONG).show();

                    Bundle b = new Bundle();xx

                    b.putString("a", edttask.trim());
                    b.putString("b", edtjns.trim());
                    b.putString("c", edttm.trim());

                    Intent i = new Intent(getApplicationContext(), viewpage.class);

                    i.putExtras(b);

                    startActivity(i);
                }
            }
        });
    }
}