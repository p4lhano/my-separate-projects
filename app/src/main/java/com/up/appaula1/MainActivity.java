package com.up.appaula1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fabAddLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabAddLink = findViewById(R.id.fab_Add_Link) ;
        fabAddLink.setImageResource(R.drawable.ic_launcher_background);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Usuario Clicou3", Toast.LENGTH_LONG).show();
                callRegisterActivity();
            }
        };

        fabAddLink.setOnClickListener(listener);





    }

    private void callRegisterActivity(){
        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivityForResult(intent,1000);
    }


}