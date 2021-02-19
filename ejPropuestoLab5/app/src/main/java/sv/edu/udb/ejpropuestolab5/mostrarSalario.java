package sv.edu.udb.ejpropuestolab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class mostrarSalario extends AppCompatActivity {
    private TextView txtvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_salario);
        txtvResultado = (TextView)findViewById(R.id.txtvMostrar);
        Mostrar();
    }

    public void Mostrar(){
        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("txtNombre");
        int anios = datos.getInt("txtAnios");
        String mensaje="";
        double salario = datos.getDouble("txtSalario");
        if(salario < 500 && anios >= 10) salario = salario +(salario * 0.20);
        else if(salario < 500 && anios < 10) salario = salario +(salario*0.05);
        else if(salario >= 500) salario=salario;
        else{
            Toast.makeText(this,"Lo sentimos, ha sucedido un error!",Toast.LENGTH_LONG).show();
            return;
        }
        mensaje += "Nombre de empleado :" +nombre +"\n\n"+ "Años trabajados : "+ anios+"\n\n"+ "Salario a pagar : "+salario;
        txtvResultado.setText(mensaje);
    }
}