package com.example.carservice.fragmets;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.carservice.R;
import com.example.carservice.mto.Conexion;

public class GuardarCargoE extends Fragment {
    Conexion cn;
    Button guardar,cancelar;
    EditText txt;
    Context thiscontext = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_guardar_cargo_e, container, false);
        //guardar = (Button)v.findViewById(R.id.btnModificar);
        cancelar = (Button)v.findViewById(R.id.btnCancelar);
        //user = (EditText)v.findViewById(R.id.txtUsuario);
        //pwd = (EditText)v.findViewById(R.id.txtContra);
        //guardar.setOnClickListener(onclick);
        //cancelar.setOnClickListener(onclick);
        thiscontext = this.getActivity();
        cn = new Conexion(thiscontext);
        return  v;
    }


}