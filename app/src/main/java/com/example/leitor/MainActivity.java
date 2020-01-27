package com.example.leitor;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    //====================================
    TextView textGorjeta;
    TextView textTotal;
    TextView textPorcentagemSeek;
    SeekBar  seekPorcentagem;
    TextInputEditText editValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //============================================================
        textGorjeta = findViewById(R.id.textGorjeta);
        textTotal = findViewById(R.id.textTotal);
        textPorcentagemSeek  = findViewById(R.id.textPorcentagemSeek);
        seekPorcentagem = findViewById(R.id.seekPorcentagem);
        editValor = findViewById(R.id.editValor);
        seekPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textPorcentagemSeek.setText(String.valueOf(progress) + "%");
                calcular(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(int progress){

        String valorRecuperado = editValor.getText().toString();

        if (valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(getApplicationContext(),"Digite um valor primeiro",Toast.LENGTH_LONG).show();
        }else{
            double valorDigitado = Float.valueOf(valorRecuperado);

            double gorjeta = (valorDigitado * progress/100);
            double total = (valorDigitado * progress/100) + valorDigitado;
            textTotal.setText("R$ " + String.format("%.2f", total));
            textGorjeta.setText("R$ " + String.format("%.2f", gorjeta));
        }

    }
}
