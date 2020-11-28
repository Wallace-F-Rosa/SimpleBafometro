package testIntentFilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ferancini.app.simplebafometro.R;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
    }

    public void click(View v){
        Intent it_result = new Intent();

        Intent it = getIntent();
        float peso = it.getFloatExtra("peso", 0);
        String sexo = it.getStringExtra("sexo");
        int copos = it.getIntExtra("copos", 0);
        String jejum = it.getStringExtra("jejum");

        float coeficiente = 0.7f;
        if(jejum.equals("n"))
            coeficiente = 1.1f;
        else if(sexo.equals("f"))
            coeficiente = 0.6f;

        float alcoolemia = (copos*4.8f)/(peso*coeficiente);

        it_result.putExtra("alcoolemia",alcoolemia);
        String classificacao = "Pessoa Alcoolizada";
        if(alcoolemia < 0.2)
            classificacao = "Pessoa NÂO Alcoolizada";
        it_result.putExtra("classificacao", classificacao);
        setResult(1, it_result);
        finish();
    }


}