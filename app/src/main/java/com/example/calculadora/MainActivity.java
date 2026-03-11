package com.example.calculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtNumero1, edtNumero2;
    TextView txtResultado;
    Button btnSumar, btnRestar, btnMultiplicar, btnDividir, btnLimpiar, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumero1 = findViewById(R.id.edtNumero1);
        edtNumero2 = findViewById(R.id.edtNumero2);
        txtResultado = findViewById(R.id.txtResultado);

        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnSalir = findViewById(R.id.btnSalir);

        btnSumar.setOnClickListener(v -> {
            Double[] numeros = obtenerNumeros();
            if (numeros != null) {
                double resultado = numeros[0] + numeros[1];
                txtResultado.setText("Resultado: " + resultado);
                Toast.makeText(MainActivity.this, "Suma realizada", Toast.LENGTH_SHORT).show();
            }
        });

        btnRestar.setOnClickListener(v -> {
            Double[] numeros = obtenerNumeros();
            if (numeros != null) {
                double resultado = numeros[0] - numeros[1];
                txtResultado.setText("Resultado: " + resultado);
                Toast.makeText(MainActivity.this, "Resta realizada", Toast.LENGTH_SHORT).show();
            }
        });

        btnMultiplicar.setOnClickListener(v -> {
            Double[] numeros = obtenerNumeros();
            if (numeros != null) {
                double resultado = numeros[0] * numeros[1];
                txtResultado.setText("Resultado: " + resultado);
                Toast.makeText(MainActivity.this, "Multiplicación realizada", Toast.LENGTH_SHORT).show();
            }
        });

        btnDividir.setOnClickListener(v -> {
            Double[] numeros = obtenerNumeros();
            if (numeros != null) {
                if (numeros[1] == 0) {
                    Toast.makeText(MainActivity.this, "No se puede dividir entre cero", Toast.LENGTH_LONG).show();
                } else {
                    double resultado = numeros[0] / numeros[1];
                    txtResultado.setText("Resultado: " + resultado);
                    Toast.makeText(MainActivity.this, "División realizada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLimpiar.setOnClickListener(v -> {
            edtNumero1.setText("");
            edtNumero2.setText("");
            txtResultado.setText("Resultado: ");
            Toast.makeText(MainActivity.this, "Campos limpiados", Toast.LENGTH_SHORT).show();
        });

        btnSalir.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Saliendo de la aplicación", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private Double[] obtenerNumeros() {
        String num1Texto = edtNumero1.getText().toString().trim();
        String num2Texto = edtNumero2.getText().toString().trim();

        if (num1Texto.isEmpty() || num2Texto.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show();
            return null;
        }

        try {
            double numero1 = Double.parseDouble(num1Texto);
            double numero2 = Double.parseDouble(num2Texto);
            return new Double[]{numero1, numero2};
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingrese valores numéricos válidos", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}