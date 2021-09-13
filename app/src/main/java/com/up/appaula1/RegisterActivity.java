package com.up.appaula1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    private TextInputEditText textInputLayoutLink ;
    private Button buttonSaveLink ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Cadastro de URL");

        textInputLayoutLink = findViewById(R.id.input_link_text);
        buttonSaveLink = findViewById(R.id.button_save_link);

        buttonSaveLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(),"teste",Toast.LENGTH_LONG).show();
                saveSiteLink();
            }
        });

    }


    private void saveSiteLink(){
        String link = textInputLayoutLink.getEditableText().toString();
        if (link.isEmpty()){
            textInputLayoutLink.setError("Erro no campo");
        } else {
            Toast.makeText(getBaseContext(),link,Toast.LENGTH_LONG).show();
        }
    }


}
