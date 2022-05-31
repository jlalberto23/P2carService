package com.example.carservice.fragmets;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carservice.R;
import com.example.carservice.mto.Conexion;
import com.example.carservice.mto.mtoUsuario;

public class GuardarUsuario extends Fragment {
    Conexion cn;
    Button guardar,cancelar;
    EditText user,pwd;
    Context thiscontext = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_guardar_usuario, container, false);
        guardar = (Button)v.findViewById(R.id.btnGuardarU);
        cancelar = (Button)v.findViewById(R.id.btnCancelarU);
        user = (EditText)v.findViewById(R.id.txtUsuario2);
        pwd = (EditText)v.findViewById(R.id.txtContra2);
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
                case R.id.btnGuardarU:
                    String resp;
                    mtoUsuario usuario = new mtoUsuario();
                    Toast.makeText(v.getContext(), "Llega", Toast.LENGTH_SHORT).show();
                    usuario.setUsuario(user.getText().toString());
                    usuario.setContra(pwd.getText().toString());
                    cn.abrir();
                    Toast.makeText(v.getContext(), "entra", Toast.LENGTH_SHORT).show();
                    resp=cn.insertar(usuario);
                    cn.cerrar();
                    Toast.makeText(v.getContext(), resp, Toast.LENGTH_SHORT).show();
                    limpiarTxt();
                    break;
                case R.id.btnCancelarU:
                    limpiarTxt();
                    break;
            }
        }
    };

    private void limpiarTxt(){
        user.setText("");
        pwd.setText("");
    }
}