package com.example.listabd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListContactActivity extends AppCompatActivity {
    ListView listContact;
    FloatingActionButton agregar;
    DatabaseReference reference;
    FirebaseDatabase database;
    ArrayList<Contact> infContact;
    AdapterListContact adapterListContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);

        Referenciar();

        AccionButton();


        reference.child("Contacto").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for (DataSnapshot ds : snapshot.getChildren()){
                        String nombre = ds.child("Nombre").getValue().toString();
                        String apellido = ds.child("Apellido").getValue().toString();
                        String numero = ds.child("Numero").getValue().toString();

                        infContact.add(new Contact(nombre, apellido, numero));
                    }
                    adapterListContact = new AdapterListContact(infContact, ListContactActivity.this,R.layout.items_list_cantact);
                    listContact.setAdapter(adapterListContact);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    public void Referenciar(){
        listContact = (ListView) findViewById(R.id.AlcListContact);
        agregar = (FloatingActionButton) findViewById(R.id.AlcFabtnAgregar);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        infContact = new ArrayList<>();


    }

    public void AccionButton(){
        agregar.setOnClickListener(v -> {
            Intent intent = new Intent(ListContactActivity.this, AgregarContactoActivity.class);
            startActivity(intent);
        });
    }
}