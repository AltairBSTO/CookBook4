package com.cookbook;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class agregarRecetas extends AppCompatActivity {

    private EditText etNombreReceta;
    private EditText etIngredientes;
    private EditText etInstrucciones;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_recetas);


        etNombreReceta = findViewById(R.id.etNombreReceta);
        etIngredientes = findViewById(R.id.etIngredientes);
        etInstrucciones = findViewById(R.id.etInstrucciones);
        btnGuardar = findViewById(R.id.btnGuardar);



        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarReceta();
            }
        });
    }

    private void guardarReceta() {

        String nombreReceta = etNombreReceta.getText().toString().trim();
        String ingredientes = etIngredientes.getText().toString().trim();
        String instrucciones = etInstrucciones.getText().toString().trim();


        if (nombreReceta.isEmpty() || ingredientes.isEmpty() || instrucciones.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Receta guardada con éxito", Toast.LENGTH_SHORT).show();


        etNombreReceta.setText("");
        etIngredientes.setText("");
        etInstrucciones.setText("");
    }
}
