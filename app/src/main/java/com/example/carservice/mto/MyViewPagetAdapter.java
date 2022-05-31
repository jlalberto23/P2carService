package com.example.carservice.mto;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.carservice.fragmets.ConsultarAuto;
import com.example.carservice.fragmets.ConsultarCargoE;
import com.example.carservice.fragmets.ConsultarCatFalla;
import com.example.carservice.fragmets.ConsultarCliente;
import com.example.carservice.fragmets.ConsultarEmpleado;
import com.example.carservice.fragmets.ConsultarFacturacion;
import com.example.carservice.fragmets.ConsultarFalla;
import com.example.carservice.fragmets.ConsultarMarca;
import com.example.carservice.fragmets.ConsultarModelo;
import com.example.carservice.fragmets.ConsultarMto;
import com.example.carservice.fragmets.ConsultarSucursal;
import com.example.carservice.fragmets.ConsultarTipoAuto;
import com.example.carservice.fragmets.ConsultarTipoMto;
import com.example.carservice.fragmets.ConsultarUsuario;
import com.example.carservice.fragmets.GuardarAuto;
import com.example.carservice.fragmets.GuardarCargoE;
import com.example.carservice.fragmets.GuardarCatFalla;
import com.example.carservice.fragmets.GuardarCliente;
import com.example.carservice.fragmets.GuardarEmpleado;
import com.example.carservice.fragmets.GuardarFacturacion;
import com.example.carservice.fragmets.GuardarFalla;
import com.example.carservice.fragmets.GuardarMarca;
import com.example.carservice.fragmets.GuardarModelo;
import com.example.carservice.fragmets.GuardarMto;
import com.example.carservice.fragmets.GuardarSucursal;
import com.example.carservice.fragmets.GuardarTipoAuto;
import com.example.carservice.fragmets.GuardarTipoMto;
import com.example.carservice.fragmets.GuardarUsuario;
import com.example.carservice.fragmets.ModificarAuto;
import com.example.carservice.fragmets.ModificarCargoE;
import com.example.carservice.fragmets.ModificarCatFalla;
import com.example.carservice.fragmets.ModificarCliente;
import com.example.carservice.fragmets.ModificarEmpleado;
import com.example.carservice.fragmets.ModificarFacturacion;
import com.example.carservice.fragmets.ModificarFalla;
import com.example.carservice.fragmets.ModificarMarca;
import com.example.carservice.fragmets.ModificarModelo;
import com.example.carservice.fragmets.ModificarMto;
import com.example.carservice.fragmets.ModificarSucursal;
import com.example.carservice.fragmets.ModificarTipoAuto;
import com.example.carservice.fragmets.ModificarUsuario;

public class MyViewPagetAdapter extends FragmentStateAdapter {

    String x;
    public MyViewPagetAdapter(@NonNull FragmentActivity fragmentActivity,String menu) {
        super(fragmentActivity);
        x = menu;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment resp = null;
        switch (x) {
            case "auto":
                switch (position) {
                    case 0:
                        resp = new ConsultarAuto();
                        break;
                    case 1:
                        resp = new GuardarAuto();
                        break;
                    case 2:
                        resp = new ModificarAuto();
                        break;
                    default:
                        resp = new ConsultarAuto();
                        break;
                }
                break;
            case "cargoEmp":
                switch (position) {
                    case 0:
                        resp = new ConsultarCargoE();
                        break;
                    case 1:
                        resp = new GuardarCargoE();
                        break;
                    case 2:
                        resp = new ModificarCargoE();
                        break;
                    default:
                        resp = new ConsultarCargoE();
                        break;
                }
                break;
            case "catFalla":
                switch (position){
                    case 0:
                        resp = new ConsultarCatFalla();
                        break;
                    case 1:
                        resp = new GuardarCatFalla();
                        break;
                    case 2:
                        resp = new ModificarCatFalla();
                        break;
                    default:
                        resp = new ConsultarCatFalla();
                        break;
                }
                break;
            case "cliente":
                switch (position){
                    case 0:
                        resp = new ConsultarCliente();
                        break;
                    case 1:
                        resp = new GuardarCliente();
                        break;
                    case 2:
                        resp = new ModificarCliente();
                        break;
                    default:
                        resp = new ConsultarCliente();
                        break;
                }
                break;
            case "empleado":
                switch (position){
                    case 0:
                        resp = new ConsultarEmpleado();
                        break;
                    case 1:
                        resp = new GuardarEmpleado();
                        break;
                    case 2:
                        resp = new ModificarEmpleado();
                        break;
                    default:
                        resp = new ConsultarEmpleado();
                        break;
                }
                break;
            case "factura":
                switch (position){
                    case 0:
                        resp = new ConsultarFacturacion();
                        break;
                    case 1:
                        resp = new GuardarFacturacion();
                        break;
                    case 2:
                        resp = new ModificarFacturacion();
                        break;
                    default:
                        resp = new ConsultarFacturacion();
                        break;
                }
                break;
            case "falla":
                switch (position){
                    case 0:
                        resp = new ConsultarFalla();
                        break;
                    case 1:
                        resp = new GuardarFalla();
                        break;
                    case 2:
                        resp = new ModificarFalla();
                        break;
                    default:
                        resp = new ConsultarFalla();
                        break;
                }
                break;
            case "mto":
                switch (position){
                    case 0:
                        resp = new ConsultarMto();
                        break;
                    case 1:
                        resp = new GuardarMto();
                        break;
                    case 2:
                        resp = new ModificarMto();
                        break;
                    default:
                        resp = new ConsultarMto();
                        break;
                }
                break;
            case "marca":
                switch (position){
                    case 0:
                        resp = new ConsultarMarca();
                        break;
                    case 1:
                        resp = new GuardarMarca();
                        break;
                    case 2:
                        resp = new ModificarMarca();
                        break;
                    default:
                        resp = new ConsultarMarca();
                        break;
                }
                break;
            case "modelo":
                switch (position){
                    case 0:
                        resp = new ConsultarModelo();
                        break;
                    case 1:
                        resp = new GuardarModelo();
                        break;
                    case 2:
                        resp = new ModificarModelo();
                        break;
                    default:
                        resp = new ConsultarModelo();
                        break;
                }
                break;
            case "sucursal":
                switch (position){
                    case 0:
                        resp = new ConsultarSucursal();
                        break;
                    case 1:
                        resp = new GuardarSucursal();
                        break;
                    case 2:
                        resp = new ModificarSucursal();
                        break;
                    default:
                        resp = new ConsultarSucursal();
                        break;
                }
                break;
            case "tipoAuto":
                switch (position){
                    case 0:
                        resp = new ConsultarTipoAuto();
                        break;
                    case 1:
                        resp = new GuardarTipoAuto();
                        break;
                    case 2:
                        resp = new ModificarTipoAuto();
                        break;
                    default:
                        resp = new ConsultarTipoAuto();
                        break;
                }
                break;
            case "tipoMto":
                switch (position){
                    case 0:
                        resp = new ConsultarTipoMto();
                        break;
                    case 1:
                        resp = new GuardarTipoMto();
                        break;
                    case 2:
                        resp = new ModificarTipoAuto();
                        break;
                    default:
                        resp = new ConsultarTipoMto();
                        break;
                }
                break;
            case "usuario":
                switch (position){
                    case 0:
                        resp = new ConsultarUsuario();
                        break;
                    case 1:
                        resp = new GuardarUsuario();
                        break;
                    case 2:
                        resp = new ModificarUsuario();
                        break;
                    default:
                        resp = new ConsultarUsuario();
                        break;
                }
                break;
        }
        return resp;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
