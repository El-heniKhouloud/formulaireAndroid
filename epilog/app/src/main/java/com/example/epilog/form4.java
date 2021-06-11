package com.example.epilog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class form4 extends AppCompatActivity {
    FirebaseDatabase Fdb;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form4);
        Intent intent = getIntent();

        final String M1 = intent.getStringExtra(form3.EXTRA_MESSAGE1);
        final String M2 = intent.getStringExtra(form3.EXTRA_MESSAGE2);
        final String M3 = intent.getStringExtra(form3.EXTRA_MESSAGE3);
        final String M4 = intent.getStringExtra(form3.EXTRA_MESSAGE4);
        final String M5 = intent.getStringExtra(form3.EXTRA_MESSAGE5);
        final String M6 = intent.getStringExtra(form3.EXTRA_MESSAGE6);
        final String M7 = intent.getStringExtra(form3.EXTRA_MESSAGE7);
        final String M8 = intent.getStringExtra(form3.EXTRA_MESSAGE8);

        TextView nom = (TextView)findViewById(R.id.nom) ;
        TextView prenom = (TextView)findViewById(R.id.prenom) ;
        TextView genre = (TextView)findViewById(R.id.genre) ;
        TextView email = (TextView)findViewById(R.id.email) ;
        TextView adr = (TextView)findViewById(R.id.adr) ;
        TextView date = (TextView)findViewById(R.id.dataNaiss) ;
        TextView tel =(TextView)findViewById(R.id.Telephone);
        TextView niv = (TextView)findViewById(R.id.niv) ;



        nom.setText(M1);
        prenom.setText(M2);
        genre.setText(M3);
        date.setText(M4);
        email.setText(M5);
        tel.setText(M6);
        adr.setText(M7);
        niv.setText(M8);

        String name =M1+" "+M2;
        Fdb = FirebaseDatabase.getInstance();

        reference = Fdb.getReference("etudiant");
        Button BtnConf = (Button) findViewById(R.id.btnOk);
        BtnConf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Enregistrer les données dans firebase //
                etudiant etudiant = new etudiant(M1,M2,M3,M4,M5,M6,M7,M8);
                reference.child(M6).setValue(etudiant).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(form4.this, "l'enregistrement est effectué avec succées :) ", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(form4.this, "Echec de l'enregistrement !", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        Button BtnAffiche = (Button) findViewById(R.id.btnView);
        BtnAffiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent go = new Intent(form4.this, affichage.class);
                startActivity(go);
            }
        });




    }
}