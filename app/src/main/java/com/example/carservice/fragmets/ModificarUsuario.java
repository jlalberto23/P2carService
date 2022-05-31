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

public class ModificarUsuario extends Fragment {
    Conexion cn;
    Button modificar,cancelar;
    EditText user,pwd;
    Context thiscontext = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_modificar_usuario, container, false);
        modificar = (Button)v.findViewById(R.id.btnModificarU);
        cancelar = (Button)v.findViewById(R.id.btnCancelarU1);
        user = (EditText)v.findViewById(R.id.txtUsuario1);
        pwd = (EditText)v.findViewById(R.id.txtContra1);
        modificar.setOnClickListener(onclick);
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
                case R.id.btnModificarU:
                    String resp = null;
                    mtoUsuario usuario = new mtoUsuario();
                    usuario.setUsuario(user.getText().toString());
                    usuario.setContra(pwd.getText().toString());
                    cn.abrir();
                    resp=cn.actualizar(usuario);
                    cn.cerrar();
                    Toast.makeText(v.getContext(), resp, Toast.LENGTH_SHORT).show();
                    limpiarTxt();
                    break;
                case R.id.btnCancelarU1:
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