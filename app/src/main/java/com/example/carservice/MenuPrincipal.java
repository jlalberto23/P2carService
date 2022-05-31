package com.example.carservice;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {
    Button auto,usuario,cliente,falla,mto,factura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        auto = (Button) findViewById(R.id.btnAuto);
        usuario = (Button) findViewById(R.id.btnUsuario);
        cliente = (Button)findViewById(R.id.btnCliente);
        falla = (Button) findViewById(R.id.btnFalla);
        mto = (Button) findViewById(R.id.btnMantenimiento);
        factura = (Button) findViewById(R.id.btnFacturacion);
        auto.setOnClickListener(onclick);
        usuario.setOnClickListener(onclick);
        cliente.setOnClickListener(onclick);
        falla.setOnClickListener(onclick);
        mto.setOnClickListener(onclick);
        factura.setOnClickListener(onclick);
    }

    View.OnClickListener onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                switch (v.getId()){
                    case R.id.btnAuto:
                        Intent intent = new Intent(MenuPrincipal.this,Auto.class);
                        MenuPrincipal.this.startActivity(intent);
                        break;
                    case R.id.btnUsuario:
                        Intent intent1 = new Intent(MenuPrincipal.this,Usuario.class);
                        MenuPrincipal.this.startActivity(intent1);
                        break;
                    case R.id.btnCliente:
                        Intent intent2 = new Intent(MenuPrincipal.this,Cliente.class);
                        MenuPrincipal.this.startActivity(intent2);
                        break;
                    case R.id.btnFalla:
                        Intent intent3 = new Intent(MenuPrincipal.this,Falla.class);
                        MenuPrincipal.this.startActivity(intent3);
                        break;
                    case R.id.btnMantenimiento:
                        Intent intent4 = new Intent(MenuPrincipal.this,Mantenimiento.class);
                        MenuPrincipal.this.startActivity(intent4);
                        break;
                    case R.id.btnFacturacion:
                        Intent intent5 = new Intent(MenuPrincipal.this,Facturacion.class);
                        MenuPrincipal.this.startActivity(intent5);
                        break;
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    };
}