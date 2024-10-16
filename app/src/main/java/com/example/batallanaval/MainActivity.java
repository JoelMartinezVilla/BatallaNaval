package com.example.batallanaval;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] rowLabels = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
    private String[] colLabels = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Crear la fila de etiquetas de columnas
        TableRow headerRow = new TableRow(this);
        headerRow.addView(new Button(this)); // Espacio vacío para la esquina superior izquierda
        for (String colLabel : colLabels) {
            Button button = new Button(this);
            button.setText(colLabel);
            button.setEnabled(false); // Deshabilitar el botón de etiqueta
            headerRow.addView(button);
        }

        // Crear la matriz de botones
        for (int i = 0; i < rowLabels.length; i++) {
            TableRow tableRow = new TableRow(this);

            for (int j = 0; j < colLabels.length; j++) {
                final String cellId = rowLabels[i] + colLabels[j];
                Button button = new Button(this);
                button.setText(cellId); // Mostrar el nombre de la casilla
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT, 1.0f)); // Ajustar el tamaño del botón

                // Establecer el tamaño y el comportamiento del botón
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Mostrar el ID de la celda clicada
                        Toast.makeText(MainActivity.this, "Casella clicada: " + cellId, Toast.LENGTH_SHORT).show();
                    }
                });

                tableRow.addView(button);
            }
            tableLayout.addView(tableRow); // Añadir la fila a la tabla
        }
    }
}
