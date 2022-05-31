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

public class ModificarCargoE extends Fragment {
    Conexion cn;
    Button guardar,cancelar;
    EditText txt;
    Context thiscontext = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_modificar_cargo_e, container, false);
        return v;
    }
}