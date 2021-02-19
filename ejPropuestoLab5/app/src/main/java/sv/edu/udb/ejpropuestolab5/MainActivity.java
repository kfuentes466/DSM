package sv.edu.udb.ejpropuestolab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre, txtSalario, txtAnios;
    int anios=0;
    double salario=0;
    String nombre="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtAnios = (EditText) findViewById(R.id.txtAnios);
        txtSalario = (EditText)findViewById(R.id.txtSalario);

    }

    public void calcularSalario(View view){
        Intent i = new Intent(this,mostrarSalario.class);
        nombre = String.valueOf(txtNombre.getText());
        anios = Integer.parseInt(String.valueOf(txtAnios.getText()));
        salario = Double.parseDouble(String.valueOf(txtSalario.getText()));
        if(nombre.isEmpty()) Toast.makeText(this,"Usuario vacio!",Toast.LENGTH_LONG).show();
        else if(anios < 0) Toast.makeText(this,"No se permiten número negativos",Toast.LENGTH_LONG).show();
        else if(salario < 100) Toast.makeText(this,"No se permiten Salarios menores a 100",Toast.LENGTH_LONG).show();
        else {
            i.putExtra("txtNombre", txtNombre.getText().toString());
            i.putExtra("txtSalario", Double.parseDouble(txtSalario.getText().toString()));
            i.putExtra("txtAnios", Integer.parseInt(txtAnios.getText().toString()));
            startActivity(i);
        }
    }

}