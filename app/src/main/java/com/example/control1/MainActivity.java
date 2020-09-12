package com.example.control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView monto, total, promedio, folioA, montoAlto, folioB, montoBajo, boletaTotal,pFolio,uFolio;
    public Button guardar;
    int montoIngreso, alto = 0, bajo = 99999999, montoTotal = 0, contador = 0, prom, folA = 0, folB = 0, primerContador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total = (TextView) findViewById(R.id.textoTotal);
        promedio = (TextView) findViewById(R.id.textoPromedio);
        folioA = (TextView) findViewById(R.id.folioAlto);
        montoAlto = (TextView) findViewById(R.id.textoAlto);
        folioB = (TextView) findViewById(R.id.folioBajo);
        montoBajo = (TextView) findViewById(R.id.textoBajo);
        monto = (TextView) findViewById(R.id.ingresoMonto);
        guardar = (Button) findViewById(R.id.botonGuardar);
        boletaTotal = (TextView) findViewById(R.id.boletaTotal);
        pFolio = (TextView) findViewById(R.id.primerFolio);
        uFolio = (TextView) findViewById(R.id.ultimoFolio);
    }

    public void recibo(View view){
        montoIngreso = Integer.parseInt(""+monto.getText());
        if(montoIngreso >= 190){
            primerContador = 1;
            contador ++;
            montoTotal += montoIngreso;
            if (montoIngreso > alto){
                alto = montoIngreso;
                folA = contador;
            }
            if(montoIngreso < bajo){
                bajo = montoIngreso;
                folB = contador;
            }
        }
        prom = montoTotal / contador;
        total.setText("Cantidad Total: $"+montoTotal);
        promedio.setText("Cantidad Promedio: $"+prom);
        folioA.setText("Nro Folio Alto: "+folA);
        montoAlto.setText("Monto alto: $"+alto);
        folioB.setText("Nro Folio bajo: "+folB);
        montoBajo.setText("Monto Bajo: $"+bajo);
        boletaTotal.setText("Cantidad de boletas: "+contador);
        pFolio.setText("Primer Folio: "+primerContador);
        uFolio.setText("Ultimo Folio: "+contador);
    }
}