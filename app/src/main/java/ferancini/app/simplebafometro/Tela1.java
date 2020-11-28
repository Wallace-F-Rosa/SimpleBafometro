package ferancini.app.simplebafometro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import testIntentFilter.Tela2;

public class Tela1 extends AppCompatActivity {
    private EditText edtPeso;
    private EditText edtSexo;
    private EditText edtCopos;
    private EditText edtJejum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            float alcoolemia = data.getFloatExtra("alcoolemia", 0f);
            String classificacao = data.getStringExtra("classificacao");

            Toast.makeText(this, "Taxa de alcoolemia : "+alcoolemia + "\nClassificação : "+classificacao, Toast.LENGTH_LONG).show();
        }
    }

    public void click(View v){
        Intent it = new Intent(this, Tela2.class);
        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtSexo = (EditText) findViewById(R.id.edtSexo);
        edtCopos = (EditText) findViewById(R.id.edtCopos);
        edtJejum = (EditText) findViewById(R.id.edtJejum);

        float peso = Float.parseFloat(edtPeso.getText().toString());
        String sexo = edtSexo.getText().toString();
        int copos = Integer.parseInt(edtCopos.getText().toString());
        String jejum = edtJejum.getText().toString();

        it.putExtra("peso", peso);
        it.putExtra("sexo", sexo);
        it.putExtra("copos", copos);
        it.putExtra("jejum", jejum);

        startActivityForResult(it,1);
    }

}