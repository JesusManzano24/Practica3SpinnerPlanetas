package com.jesusmanzano.practica3listadeplanetas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ImageView imageViewPlanet;
    TextView textViewDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner1);
        imageViewPlanet = (ImageView) findViewById(R.id.imageViewPlanet); // Inicializa el ImageView
        textViewDescripcion = (TextView) findViewById(R.id.textViewDescription); // Inicializa el TextView

        final String[] planetas = {
                "Selecciona un planeta", "Mercurio", "Venus", "Tierra", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno"
        };
        final String[] descripciones = {
                "Selecciona un planeta del sistema solar",
                "Mercurio es el planeta más cercano al sol y el más pequeño del sistema solar. Su superficie está llena de cráteres debido a numerosos impactos.",
                "Venus es el segundo planeta del sistema solar y es similar en estructura y tamaño a la Tierra. Su atmósfera densa y caliente provoca un efecto invernadero extremo.",
                "La Tierra es nuestro hogar, el tercer planeta del sistema solar y el único conocido que alberga vida. Tiene una gran diversidad de ecosistemas.",
                "Marte, conocido como el planeta rojo, es el cuarto planeta del sistema solar. Tiene el volcán más grande y el cañón más profundo conocidos.",
                "Júpiter es el planeta más grande del sistema solar y es conocido por sus grandes tormentas, como la Gran Mancha Roja, una tormenta más grande que la Tierra.",
                "Saturno es el sexto planeta del sistema solar famoso por sus impresionantes anillos compuestos principalmente de hielo y roca.",
                "Urano es un gigante gaseoso con un distintivo color azul verdoso, séptimo planeta del sistema solar. Es único por su rotación lateral.",
                "Neptuno es el octavo y más lejano planeta del sistema solar, conocido por sus fuertes vientos y su tormenta gigante, la Mancha Oscura."
        };


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, planetas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0) {
                    int imageId = getResources().getIdentifier(planetas[position].toLowerCase(), "drawable", getPackageName());
                    imageViewPlanet.setImageResource(imageId);
                    textViewDescripcion.setText(descripciones[position]); // Establecer la descripción del planeta seleccionado
                    Toast.makeText(parent.getContext(), "Seleccionaste el planeta: " + planetas[position], Toast.LENGTH_SHORT).show();
                } else {
                    imageViewPlanet.setImageResource(0); // Limpiar la imagen
                    textViewDescripcion.setText(descripciones[position]); // Mostrar mensaje inicial
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}


