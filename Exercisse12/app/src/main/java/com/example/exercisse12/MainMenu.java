package com.example.exercisse12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainMenu extends AppCompatActivity {

    private EditText edttask, edtjns, edttm;

    FloatingActionButton fabadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        edttask = findViewById(R.id.task1);
        edtjns = findViewById(R.id.jnstask);
        edttm = findViewById(R.id.timetask);
        fabadd = findViewById(R.id.fabadd);

        fabadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(edttask.getText().toString().isEmpty()||
                        edtjns.getText().toString().isEmpty()||
                        edttm.getText().toString().isEmpty()){
                    Snackbar.make(view, "wajib isi seluruh data!", Snackbar.LENGTH_LONG).show();
                }else{
                    Snackbar.make(view, "berhasil ditambah!", Snackbar.LENGTH_LONG).show();

                    Bundle b = new Bundle();

                    b.putString("a", edttask.getText().toString());
                    b.putString("b", edtjns.getText().toString());
                    b.putString("c", edttm.getText().toString());

                    Intent in = new Intent(getApplicationContext(), viewpage.class);

                    in.putExtras(b);

                    startActivity(in);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if (item.getItemId() == R.id.submit) {
            Bundle b = new Bundle();

            b.putString("a", edttask.getText().toString());
            b.putString("b", edtjns.getText().toString());
            b.putString("c", edttm.getText().toString());

            Intent in = new Intent(getApplicationContext(), viewpage.class);

            in.putExtras(b);

            startActivity(in);
        }else{
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}