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
import com.example.carservice.mto.mtoFalla;

public class ModificarFalla extends Fragment {
    Conexion cn;
    Button modificar,cancelar;
    EditText codigo,descripcion,cat;
    Context thiscontext = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_modificar_falla, container, false);
        thiscontext = this.getActivity();
        cn = new Conexion(thiscontext);
        modificar = (Button) v.findViewById(R.id.btnModificarF);
        cancelar = (Button) v.findViewById(R.id.btnCancelarFM);
        codigo = (EditText) v.findViewById(R.id.txtCodigoFallaFM);
        descripcion = (EditText) v.findViewById(R.id.txtDescripcionFM);
        cat = (EditText) v.findViewById(R.id.txtCodCatFG);
        modificar.setOnClickListener(onclick);
        cancelar.setOnClickListener(onclick);
        return v;
    }
    View.OnClickListener onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btnModificarF:
                    String resp;
                    mtoFalla falla = new mtoFalla();
                    falla.setId_falla(Integer.parseInt(codigo.getText().toString()));
                    falla.setDescripcion(descripcion.getText().toString());
                    falla.setId_categoria_falla(Integer.parseInt(cat.getText().toString()));
                    cn.abrir();
                    resp=cn.actualizar(falla);
                    cn.cerrar();
                    Toast.makeText(v.getContext(), resp, Toast.LENGTH_SHORT).show();
                    limpiarTxt();
                    break;
                case R.id.btnCancelarFM:
                    limpiarTxt();
                    break;
            }
        }
    };

    private void limpiarTxt(){
        codigo.setText("");
        descripcion.setText("");
        cat.setText("");
    }
}