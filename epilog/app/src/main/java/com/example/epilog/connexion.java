package com.example.epilog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class connexion extends AppCompatActivity {
    public static final String EXTRA_MESSAGE1= "com.example.project.MESSAGE1";
    public static final String EXTRA_MESSAGE2= "com.example.project.MESSAGE2";
    public static final String EXTRA_MESSAGE3= "com.example.project.MESSAGE3";

    private EditText editTextNom;
    private EditText editTextPrenom;
    private RadioGroup genreG;
    private RadioButton genreB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        //gestionBd maBD = new gestionBd(this);
       // maBD.insertData("Elheni", "Khouloud");


        editTextNom =  findViewById(R.id.txtNom);
        editTextPrenom =  findViewById(R.id.txtPrenom);
        genreG = findViewById(R.id.radioGroup);
        Button btn = (Button) findViewById(R.id.btnNext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateNom() && validatePrenom()) {
                    Intent form2 = new Intent(connexion.this, form2.class);

                    String Message1 = editTextNom.getText().toString();
                    String Message2 = editTextPrenom.getText().toString();
                    int msg = genreG.getCheckedRadioButtonId();
                    genreB = (RadioButton) findViewById(msg);
                    String Message3 = genreB.getText().toString();


                    form2.putExtra(EXTRA_MESSAGE1, Message1);
                    form2.putExtra(EXTRA_MESSAGE2, Message2);
                    form2.putExtra(EXTRA_MESSAGE3, Message3);
                    startActivity(form2);


                }
            }
        });

    }

    private boolean validateNom(){
        String nomInput = editTextNom.getText().toString().trim();
        if (nomInput.isEmpty()){
            editTextNom.setError("Veuillez remplir ce champ");
            return false;

        }else if(!nomInput.matches("[A-Z,a-z]+")){
            editTextNom.setError("Veuillez entrer seulement des caractéres ");
            return false;
        }else{
            editTextNom.setError(null);
            return true;
        }
    }

    private boolean validatePrenom(){
        String prenomInput = editTextPrenom.getText().toString().trim();
        if (prenomInput.isEmpty()){
            editTextPrenom.setError("Veuillez remplir ce champ");
            return false;

        }else if(!prenomInput.matches("[A-Z,a-z]+")){
            editTextPrenom.setError("Veuillez entrer seulement des caractéres ");
            return false;
        }else{
            editTextPrenom.setError(null);
            return true;
        }
    }
}