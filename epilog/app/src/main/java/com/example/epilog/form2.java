package com.example.epilog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class form2 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE1= "com.example.project.MESSAGE1";
    public static final String EXTRA_MESSAGE2= "com.example.project.MESSAGE2";
    public static final String EXTRA_MESSAGE3= "com.example.project.MESSAGE3";
    public static final String EXTRA_MESSAGE4= "com.example.project.MESSAGE4";
    public static final String EXTRA_MESSAGE5= "com.example.project.MESSAGE5";
    public static final String EXTRA_MESSAGE6= "com.example.project.MESSAGE6";


    Button btnNext;
    Button btnRew;
    EditText editEmail;
    EditText editTel;
    EditText editNaiss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);
        editEmail = findViewById(R.id.txtEmail);
        editTel = findViewById(R.id.txtPhone);
        editNaiss = findViewById(R.id.txtDate);



        btnNext = findViewById(R.id.btnNext2);
        btnRew = findViewById(R.id.btnRev);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateTel() && validateEmail() && validateNaiss() ) {
                    Intent intent = getIntent();

                    String M1 = intent.getStringExtra(connexion.EXTRA_MESSAGE1);
                    String M2 = intent.getStringExtra(connexion.EXTRA_MESSAGE2);
                    String M3 = intent.getStringExtra(connexion.EXTRA_MESSAGE3);
                    Intent form3 = new Intent(form2.this, form3.class);

                    String Message4 = editNaiss.getText().toString();
                    String Message5 = editEmail.getText().toString();
                    String Message6 = editTel.getText().toString();

                    form3.putExtra(EXTRA_MESSAGE1, M1);
                    form3.putExtra(EXTRA_MESSAGE2, M2);
                    form3.putExtra(EXTRA_MESSAGE3, M3);
                    form3.putExtra(EXTRA_MESSAGE4, Message4);
                    form3.putExtra(EXTRA_MESSAGE5, Message5);
                    form3.putExtra(EXTRA_MESSAGE6, Message6);




                    startActivity(form3);
                }





            }
        });

        btnRew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent form3 = new Intent(form2.this, MainActivity.class);
                startActivity(form3);
            }
        });
    }

    private boolean validateTel(){
        String TelInput = editTel.getText().toString().trim();
        if (TelInput.isEmpty()){
            editTel.setError("Veuillez remplir ce champ");
            return false;

        } else if (!TelInput.matches("[0-9]{8}")) {
            editTel.setError("Veuillez taper seulement 8 chiffres");
            return false;
        }else{
            editTel.setError(null);
            return true;
        }
    }

    private boolean validateEmail(){
        String EmailInput = editEmail.getText().toString().trim();
        if (EmailInput.isEmpty() ){
            editEmail.setError("Veuillez remplir ce champ");
            return false;

        }else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(EmailInput).matches()) {
            editEmail.setError("Veuillez respecter cet format name@exemple.com ");
            return false;
        }else{
            editEmail.setError(null);
            return true;
        }
    }
    private boolean validateNaiss(){
        String NaissInput = editNaiss.getText().toString().trim();
        if (NaissInput.isEmpty()){
            editNaiss.setError("Veuillez remplir ce champ");
            return false;

        }else if (!NaissInput.matches("[1-9]{2}[1-12]{2}[1-9]{4}")) {
            editNaiss.setError("Veuillez respecter le format d'une date");
            return false;
        }else{
            editNaiss.setError(null);
            return true;
        }
    }


}