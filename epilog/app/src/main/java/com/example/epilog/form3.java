package com.example.epilog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class form3  extends AppCompatActivity {
    public static final String EXTRA_MESSAGE1= "com.example.project.MESSAGE1";
    public static final String EXTRA_MESSAGE2= "com.example.project.MESSAGE2";
    public static final String EXTRA_MESSAGE3= "com.example.project.MESSAGE3";
    public static final String EXTRA_MESSAGE4= "com.example.project.MESSAGE4";
    public static final String EXTRA_MESSAGE5= "com.example.project.MESSAGE5";
    public static final String EXTRA_MESSAGE6= "com.example.project.MESSAGE6";
    public static final String EXTRA_MESSAGE7= "com.example.project.MESSAGE7";
    public static final String EXTRA_MESSAGE8= "com.example.project.MESSAGE8";
    Button boutonNext;
    Button boutonRev;
    EditText editAdr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form3);
        Spinner niveau = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(form3.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.choix));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        niveau.setAdapter(myAdapter);
        boutonNext = findViewById(R.id.btnNext3);
        boutonRev = findViewById(R.id.btnRev1);
        editAdr = findViewById(R.id.txtAdr);
        final Spinner niv = (Spinner) findViewById(R.id.spinner) ;
        boutonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateAdr()) {

                    Intent intent = getIntent();

                    String M1 = intent.getStringExtra(form2.EXTRA_MESSAGE1);
                    String M2 = intent.getStringExtra(form2.EXTRA_MESSAGE2);
                    String M3 = intent.getStringExtra(form2.EXTRA_MESSAGE3);

                    String M4 = intent.getStringExtra(form2.EXTRA_MESSAGE4);
                    String M5 = intent.getStringExtra(form2.EXTRA_MESSAGE5);
                    String M6 = intent.getStringExtra(form2.EXTRA_MESSAGE6);

                    Intent form4 = new Intent(form3.this, form4.class);

                    String Message7 = editAdr.getText().toString();
                    String Message8 = niv.getSelectedItem().toString();

                    form4.putExtra(EXTRA_MESSAGE1, M1);
                    form4.putExtra(EXTRA_MESSAGE2, M2);
                    form4.putExtra(EXTRA_MESSAGE3, M3);
                    form4.putExtra(EXTRA_MESSAGE4, M4);
                    form4.putExtra(EXTRA_MESSAGE5, M5);
                    form4.putExtra(EXTRA_MESSAGE6, M6);
                    form4.putExtra(EXTRA_MESSAGE7, Message7);
                    form4.putExtra(EXTRA_MESSAGE8, Message8);
                    startActivity(form4);
                }
            }
        });
        boutonRev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent form3 = new Intent(form3.this, form2.class);
                startActivity(form3);
            }
        });
    }

    private boolean validateAdr(){
        String AdrInput = editAdr.getText().toString().trim();
        if (AdrInput.isEmpty()){
            editAdr.setError("Veuillez remplir ce champ");
            return false;

        }else{
            editAdr.setError(null);
            return true;
        }
    }
}