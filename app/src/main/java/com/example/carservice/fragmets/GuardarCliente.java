package com.example.carservice.fragmets;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.carservice.R;
import com.example.carservice.mto.Conexion;
import com.example.carservice.mto.mtoCliente;
import com.example.carservice.mto.mtoEmpleado;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuardarCliente extends Fragment {
    Conexion cn;
    Button guardar,cancelar;
    EditText codigo,usuario,nombre,apellido,telefono,direccion,dui;
    TextView fecha_ingreso;
    Context thiscontext = null;
    long ahora = System.currentTimeMillis();
    Date fecha = new Date(ahora);
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String salida = df.format(fecha);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_guardar_cliente, container, false);
        guardar = (Button)v.findViewById(R.id.btnGuardarCli);
        cancelar = (Button)v.findViewById(R.id.btnCancelarClienG);
        codigo = (EditText)v.findViewById(R.id.txtCodigoClienG);
        usuario = (EditText)v.findViewById(R.id.txtUsuarioClienG);
        nombre = (EditText)v.findViewById(R.id.txtNombreClienG);
        apellido = (EditText)v.findViewById(R.id.txtApellidosClienG);
        telefono = (EditText)v.findViewById(R.id.txtTelefonoClienG);
        fecha_ingreso = (TextView)v.findViewById(R.id.txtFechaClienG);
        direccion = (EditText)v.findViewById(R.id.txtDireccClienG);
        dui = (EditText) v.findViewById(R.id.editTextTextPersonName31);
        fecha_ingreso.setText(salida);
        guardar.setOnClickListener(onclick);
        cancelar.setOnClickListener(onclick);
        thiscontext = this.getActivity();
        cn = new Conexion(thiscontext);
        return v;
    }

    View.OnClickListener onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btnGuardarCli:
                    String resp;
                    mtoCliente cliente = new mtoCliente();
                    cliente.setId_cliente(Integer.parseInt(codigo.getText().toString()));
                    cliente.setNombre(nombre.getText().toString());
                    cliente.setApellidos(apellido.getText().toString());
                    cliente.setUsuario(usuario.getText().toString());
                    cliente.setFecha_registro(salida);
                    cliente.setTelefono(telefono.getText().toString());
                    cliente.setDireccion(direccion.getText().toString());
                    cliente.setDui(dui.getText().toString());
                    cn.abrir();
                    resp=cn.insertar(cliente);
                    cn.cerrar();
                    Toast.makeText(v.getContext(), resp, Toast.LENGTH_SHORT).show();
                    limpiarTxt();
                    break;
                case R.id.btnCancelarClienG:
                    limpiarTxt();
                    break;
            }
        }
    };

    private void limpiarTxt(){
        codigo.setText("");
                usuario.setText("");
        nombre.setText("");
                apellido.setText("");
        telefono.setText("");
                direccion.setText("");
        dui.setText("");
    }
}