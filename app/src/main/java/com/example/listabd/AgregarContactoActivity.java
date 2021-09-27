package com.example.listabd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AgregarContactoActivity extends AppCompatActivity {
    private EditText nombre, apellido, numero;
    private Button agregar;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);

        Referenciar();
        Accion();
    }
    public void Referenciar(){
        nombre = (EditText) findViewById(R.id.AcaEtNombre);
        apellido = (EditText) findViewById(R.id.AcaEtApellido);
        numero = (EditText) findViewById(R.id.AcaEtNumero);
        agregar = (Button) findViewById(R.id.AcaBtnAgregar);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
    }
    public void ExtracerDatos(){
        String name = nombre.getText().toString();
        String lastName = apellido.getText().toString();
        String number = numero.getText().toString();
        SubirFireBase(name, lastName, number);
    }
    private void SubirFireBase(String name, String lastName, String number) {
        Map<String, Object> datoContact = new HashMap<>();
        datoContact.put("Nombre", name);
        datoContact.put("Apellido", lastName);
        datoContact.put("Numero", number);
        reference.child("Contacto").push().setValue(datoContact);
    }
    public void Accion(){
        agregar.setOnClickListener(v -> {
            if (nombre.getText().toString().isEmpty() && apellido.getText().toString().isEmpty() && numero.getText().toString().isEmpty()) {
                nombre.setError("Faltó ingresar el nombre");
                apellido.setError("Faltó ingresar el apellido");
                numero.setError("Faltó ingresar número");

            } else if (nombre.getText().toString().isEmpty()){
                nombre.setError("Faltó ingresar el nombre");

            } else if(apellido.getText().toString().isEmpty()){
                apellido.setError("Faltó ingresar el apellido");

            } else if(numero.getText().toString().isEmpty() ){
                numero.setError("Faltó ingresar número");

            } else {
                ExtracerDatos();
                Intent intent = new Intent(AgregarContactoActivity.this, ListContactActivity.class);
                startActivity(intent);
            }


        });
    }
}