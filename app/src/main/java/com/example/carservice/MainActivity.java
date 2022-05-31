package com.example.carservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carservice.mto.Conexion;

public class MainActivity extends AppCompatActivity {

    Conexion cn;
    Button ingresar, cancelar;
    EditText usuario, contras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cn = new Conexion(this);
        cn.llenarBDCarnet();
        setContentView(R.layout.activity_main);
        ingresar = (Button) findViewById(R.id.button);
        cancelar = (Button) findViewById(R.id.button2);
        usuario = (EditText) findViewById(R.id.txtUsuario);
        contras = (EditText) findViewById(R.id.txtContra);
        ingresar.setOnClickListener(onclick);
        cancelar.setOnClickListener(onclick);
    }

    View.OnClickListener onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                switch (v.getId())
                {
                    case R.id.button:
                        cn.abrir();
                        if(cn.login(usuario.getText().toString(),contras.getText().toString())){
                            Intent intent = new Intent(MainActivity.this,MenuPrincipal.class);
                            MainActivity.this.startActivity(intent);
                            Toast.makeText(v.getContext(),"Bienvenido",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(v.getContext(),"Usuario o contraseña incorrectos",Toast.LENGTH_LONG).show();
                        }
                        cn.cerrar();
                        break;
                    case R.id.button2:
                        break;
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    };
}