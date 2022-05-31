package com.example.carservice.mto;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Conexion {
    private static final String[] cargoEmpleado = new String[]{"id_cargo","nombre_cargo"};
    private static final String[] usuario = new String[]{"usuario","contra"};
    private static final String[] empleado = new String[]{"id_empleado","id_cargo","nombre","apellidos","usuario"};
    private static final String[] cliente = new String[]{"id_cliente","nombre","apellidos","direccion","telefono","dui","usuario","fecha_registro"};
    private static final String[] categoriaFalla = new String[]{"id_categoria_falla","nombre_categoria_falla","descripcion"};
    private static final String[] tipoMto = new String[]{"id_tipo_mto","nombre_tipo_mto"};
    private static final String[] tipoAuto = new String[]{"id_tipo_auto","tipo_auto"};
    private static final String[] sucursal = new String[]{"id_sucursal","nombre_sucursal","direccion"};
    private static final String[] marcaAuto = new String[]{"id_marca","nombre_marca","id_modelo"};
    private static final String[] falla = new String[]{"id_falla","descripcion","id_categoria_falla"};
    private static final String[] auto = new String[]{"id_auto","id_tipo_auto","año","placa","id_modelo"};
    private static final String[] diagnosticoFalla = new String[]{"id_falla","id_diagnostico"};
    private static final String[] mantenimiento = new String[]{"id_mto","id_diagnostico","id_tipo_mto","id_sucursal","id_empleado","estado_mto","descripcion","fecha_mto","proximo_mto"};
    private static final String[] detalleMto = new String[]{"id_mto","id_falla"};
    private static final String[] diagnosticoMto = new String[]{"id_diagnostico_mto","descripcion"};
    private static final String[] facturacion = new String[]{"id_facturacion","id_mto","monto","efectivo","cambio","fecha_factura"};


    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public Conexion(Context context) {
        this.context = context;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "carservice.s3db";
        private static final int VERSION = 1;

        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null , VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                //CREANDO TABLA CARGO EMPLEADO
                db.execSQL("CREATE TABLE cargoEmpleado(id_cargo INTEGER NOT NULL PRIMARY KEY,nombre_cargo VARCHAR(50) NOT NULL);");

                //CREANDO TABLA USUARIO
                db.execSQL("CREATE TABLE usuario(usuario CHAR(50) NOT NULL PRIMARY KEY,contra CHAR(50) NOT NULL);");

                //CREANDO TABLA EMPLEADO
                db.execSQL("CREATE TABLE empleado(id_empleado INTEGER NOT NULL PRIMARY KEY,nombre VARCHAR(50) NOT NULL,apellidos VARCHAR(50) NOT NULL,id_cargo int, usuario CHAR(50) NOT NULL UNIQUE,FOREIGN KEY(id_cargo) REFERENCES cargoEmpleado(id_cargo),FOREIGN KEY(usuario) REFERENCES usuario(usuario));");

                //CREANDO TABLA CLIENTE
                db.execSQL("CREATE TABLE cliente(id_cliente INTEGER NOT NULL PRIMARY KEY,nombre VARCHAR(50) NOT NULL,apellidos VARCHAR(50),direccion VARCHAR(150),telefono CHAR(9),dui CHAR(9) NOT NULL UNIQUE,fecha_ingreso VARCHAR(10) NOT NULL,usuario CHAR(50) NOT NULL UNIQUE,FOREIGN KEY(usuario) REFERENCES usuario(usuario));");

                //CREANDO TABLA TIPO AUTO
                db.execSQL("CREATE TABLE tipoAuto(id_tipo_auto INTEGER NOT NULL PRIMARY KEY,nombre_tipo_auto VARCHAR(50) NOT NULL UNIQUE);");

                //CREATE TABLA SUCURSAL
                db.execSQL("CREATE TABLE sucursal(id_sucursal INTEGER NOT NULL PRIMARY KEY,nombre_sucursal VARCHAR(50) NOT NULL UNIQUE,direccion_sucursal VARCHAR(150))");

                //CREANDO TABLA CATEGORIA FALLA
                db.execSQL("CREATE TABLE categoriaFalla(id_categoria_falla INTEGER NOT NULL PRIMARY KEY,nombre_categoria_falla VARCHAR(50) NOT NULL UNIQUE,descripcion VARCHAR(150))");

                //CREANDO TABLA TIPO MANTENIMIENTO
                db.execSQL("CREATE TABLE tipoMantenimiento(id_tipo_mto INTEGER NOT NULL PRIMARY KEY,nombre_tipo_mto VARCHAR(50) NOT NULL UNIQUE)");

                //CREANDO TABLA MODELO AUTO
                db.execSQL("CREATE TABLE modeloAuto(id_modelo_auto INTEGER NOT NULL PRIMARY KEY, nombre_modelo VARCHAR(50) NOT NULL UNIQUE)");

                //CREANDO TABLA MARCA AUTO
                db.execSQL("CREATE TABLE marcaAuto(id_marca_auto INTEGER NOT NULL PRIMARY KEY,nombre_marca VARCHAR(50) NOT NULL UNIQUE,id_modelo_auto INTEGER NOT NULL,FOREIGN KEY(id_modelo_auto) REFERENCES modeloAuto(id_modelo_auto))");

                //CREANDO TABLA AUTO
                db.execSQL("CREATE TABLE auto(id_auto INTEGER NOT NULL PRIMARY KEY,anio INTEGER NOT NULL, placa VARCHAR(8) NOT NULL UNIQUE, id_marca INTEGER NOT NULL, id_tipo_auto INTEGER NOT NULL, FOREIGN KEY(id_marca) REFERENCES marcaAuto(id_marca), FOREIGN KEY(id_tipo_auto) REFERENCES tipoAuto(id_tipo_auto))");

                //CREANDO TABLA FALLA
                db.execSQL("CREATE TABLE falla(id_falla INTEGER NOT NULL PRIMARY KEY, descripcion_falla VARCHAR(150) NOT NULL, id_categoria_falla INTEGER NOT NULL, FOREIGN KEY(id_categoria_falla) REFERENCES categoriaFalla(id_categoria_falla))");

                //CREANDO TABLA DIAGNOSTICO MANTENIMIENTO
                db.execSQL("CREATE TABLE diagnostico_mto(id_diagnostico INTEGER NOT NULL PRIMARY KEY,descripcion VARHCAR(150) NOT NULL)");

                //CREANDO TABLA DIAGNOSTICO-FALLA
                db.execSQL("CREATE TABLE diagnostico_falla(id_diagnostico INTEGER NOT NULL,id_falla INTEGER NOT NULL,FOREIGN KEY(id_diagnostico) REFERENCES diagnostico_mto(id_diagnostico),FOREIGN KEY(id_falla) REFERENCES falla(id_falla))");

                //CREANDO TABLA MANTENIMIENTO
                db.execSQL("CREATE TABLE mantenimiento(id_mantenimiento INTEGER NOT NULL PRIMARY KEY,descripcion_mto VARCHAR(200) NOT NULL,fecha_mto VARHCAR(10) NOT NULL,proximo_mto VARHCAR(10),estado_mto VARHCAR(1) NOT NULL,id_diagnostico INTEGER NOT NULL,id_tipo_mto INTEGER NOT NULL,id_sucursal INTEGER NOT NULL,id_empleado INTEGER NOT NULL,FOREIGN KEY(id_diagnostico) REFERENCES diagnostico(id_diagnostico),FOREIGN KEY(id_tipo_mto) REFERENCES tipoMantenimiento(id_tipo_mto),FOREIGN KEY(id_sucursal) REFERENCES sucursal(id_sucursal),FOREIGN KEY(id_empleado) REFERENCES empleado(id_empleado))");

                //CREANDO TABLA DETALLE MANTENIMIENTO
                db.execSQL("CREATE TABLE detalle_mto(id_mto INTEGER NOT NULL,id_falla INTEGER NOT NULL,FOREIGN KEY(id_mto) REFERENCES mantenimiento(id_mantenimiento),FOREIGN KEY(id_falla) REFERENCES falla(id_falla))");

                //CREANDO TABLA FACTURA
                db.execSQL("CREATE TABLE facturacion(id_factura INTEGER NOT NULL PRIMARY KEY,monto REAL NOT NULL,efectivo REAL NOT NULL,cambio REAL NOT NULL,fecha_factura VARHCAR(10) NOT NULL,id_mto INTEGER NOT NULL,FOREIGN KEY(id_mto) REFERENCES mantenimiento(id_mantenimiento))");
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    }

    public void abrir() throws SQLException{
        db = DBHelper.getWritableDatabase();
        return;
    }
    public void cerrar(){
        DBHelper.close();
    }

    public String insertar(mtoCargoEmpleado cargo){
        String regInsertados="ERROR!";
        long contador=0;
        try{
            ContentValues dato = new ContentValues();
            dato.put("id_cargo", cargo.getId_cargo());
            dato.put("nombre_cargo", cargo.getNombre_cargo());
            contador=db.insert("cargoEmpleado", null, dato);
            if(contador==-1 || contador==0) regInsertados= "Error al guardar los datos";
            else regInsertados = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return regInsertados;
    }

    public String actualizar(mtoCargoEmpleado cargo){
        String resp = null;
        try {

            String[] id = {String.valueOf(cargo.getId_cargo())};
            ContentValues cv = new ContentValues();
            cv.put("nombre_cargo", cargo.getNombre_cargo());
            db.update("cargoEmpleado", cv, "id_cargo = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public boolean login(String usuario, String contra){
        boolean resp = false;
        Cursor cursor = db.rawQuery("SELECT * FROM usuario WHERE usuario = '"+usuario+"' AND contra = '"+contra+"'",null);
        if(cursor.moveToFirst())
            resp = true;
        return resp;
    }

    public String insertar(mtoUsuario usuario){
        String resp="ERROR!";
        long contador=0;
        try{
            ContentValues dato = new ContentValues();
            dato.put("usuario",usuario.getUsuario());
            dato.put("contra",usuario.getContra());
            contador=db.insert("usuario", null, dato);
            if(contador==-1 || contador==0) resp= "Error al guardar los datos";
            else resp = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return resp;
    }

    public String actualizar(mtoUsuario usuario){
        String resp = null;
        try {
            String[] id = {usuario.getUsuario()};
            ContentValues cv = new ContentValues();
            cv.put("contra",usuario.getContra());
            db.update("usuario", cv, "usuario = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public String insertar(mtoEmpleado empleado){
        String resp = "ERROR!";
        long contador=0;
        try{
            ContentValues dato = new ContentValues();
            dato.put("id_empleado",empleado.getId_empleado());
            dato.put("nombre",empleado.getNombre());
            dato.put("apellidos",empleado.getApellidos());
            dato.put("id_cargo",empleado.getId_cargo());
            dato.put("usuario",empleado.getUsuario());
            contador=db.insert("empleado", null, dato);
            if(contador==-1 || contador==0) resp= "Error al guardar los datos";
            else resp = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return resp;
    }

    public String actualizar(mtoEmpleado empleado){
        String resp = null;
        try {
            String[] id = {String.valueOf(empleado.getId_empleado())};
            ContentValues cv = new ContentValues();
            cv.put("nombre",empleado.getNombre());
            cv.put("apellidos",empleado.getApellidos());
            cv.put("id_cargo",empleado.getId_cargo());
            cv.put("usuario",empleado.getUsuario());
            db.update("empleado", cv, "id_empleado = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public String insertar(mtoCliente cliente){
        String resp = "ERROR!";
        long contador=0;
        try{
            ContentValues dato = new ContentValues();
            dato.put("id_cliente",cliente.getId_cliente());
            dato.put("nombre",cliente.getNombre());
            dato.put("apellidos",cliente.getApellidos());
            dato.put("direccion",cliente.getDireccion());
            dato.put("telefono",cliente.getTelefono());
            dato.put("dui",cliente.getDui());
            dato.put("fecha_ingreso",cliente.getFecha_registro());
            dato.put("usuario",cliente.getUsuario());
            contador=db.insert("cliente", null, dato);
            if(contador==-1 || contador==0) resp= "Error al guardar los datos";
            else resp = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return resp;
    }

    public String actualizar(mtoCliente cliente){
        String resp = null;
        try {
            String[] id = {String.valueOf(cliente.getId_cliente())};
            ContentValues cv = new ContentValues();
            cv.put("nombre",cliente.getNombre());
            cv.put("apellidos",cliente.getApellidos());
            cv.put("direccion",cliente.getDireccion());
            cv.put("telefono",cliente.getTelefono());
            cv.put("dui",cliente.getDui());
            cv.put("fecha_ingreso",cliente.getFecha_registro());
            cv.put("usuario",cliente.getUsuario());
            db.update("cliente", cv, "id_cliente = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public String insertar(mtoTipoAuto tipoAuto){
        String resp = "ERROR!";
        long contador=0;
        try{
            ContentValues dato = new ContentValues();
            dato.put("id_tipo_auto",tipoAuto.getId_tipo_auto());
            dato.put("nombre_tipo_auto",tipoAuto.getTipo_auto());
            contador=db.insert("tipoAuto", null, dato);
            if(contador==-1 || contador==0) resp= "Error al guardar los datos";
            else resp = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return resp;
    }

    public String actualizar(mtoTipoAuto tipoAuto){
        String resp = null;
        try {
            String[] id = {String.valueOf(tipoAuto.getId_tipo_auto())};
            ContentValues cv = new ContentValues();
            cv.put("nombre_tipo_auto",tipoAuto.getTipo_auto());
            db.update("tipoAuto", cv, "id_tipo_auto = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public String insertar(mtoSucursal sucursal){
        String regInsertados="";
        long contador=0;
        try {
            ContentValues dato = new ContentValues();
            dato.put("id_sucursal",sucursal.getId_sucursal());
            dato.put("nombre_sucursal",sucursal.getNombre_sucursal());
            dato.put("direccion_sucursal",sucursal.getDireccion());
            contador=db.insert("sucursal",null,dato);
            if(contador==-1 || contador==0) regInsertados= "Error al guardar los datos";
            else regInsertados = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return regInsertados;
    }

    public String actualizar(mtoSucursal sucursal){
        String resp = null;
        try {
            String[] id = {String.valueOf(sucursal.getId_sucursal())};
            ContentValues cv = new ContentValues();
            cv.put("nombre_sucursal",sucursal.getNombre_sucursal());
            cv.put("direccion_sucursal",sucursal.getDireccion());
            db.update("sucursal", cv, "id_sucursal = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public String insertar(mtoAuto auto){
        String regInsertados="";
        long contador=0;
        try {
            ContentValues dato = new ContentValues();
            dato.put("id_auto",auto.getId_auto());
            dato.put("anio",auto.getAño());
            dato.put("placa",auto.getPlaca());
            dato.put("id_marca",auto.getId_marca());
            dato.put("id_tipo_auto",auto.getId_tipo_auto());
            contador=db.insert("auto",null,dato);
            if(contador==-1 || contador==0) regInsertados= "Error al guardar los datos";
            else regInsertados = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return regInsertados;
    }

    public String actualizar(mtoAuto auto){
        String resp = null;
        try {
            String[] id = {String.valueOf(auto.getId_auto())};
            ContentValues cv = new ContentValues();
            cv.put("anio",auto.getAño());
            cv.put("placa",auto.getPlaca());
            cv.put("id_marca",auto.getId_marca());
            cv.put("id_tipo_auto",auto.getId_tipo_auto());
            db.update("auto", cv, "id_auto = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public String insertar(mtoCategoriaFalla catFall){
        String regInsertados="";
        long contador=0;
        try {
            ContentValues dato = new ContentValues();
            dato.put("id_categoria_falla",catFall.getId_categoria_falla());
            dato.put("nombre_categoria_falla",catFall.getNombre_categoria_falla());
            dato.put("descripcion",catFall.getDescripcion());
            contador=db.insert("categoriaFalla",null,dato);
            if(contador==-1 || contador==0) regInsertados= "Error al guardar los datos";
            else regInsertados = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return regInsertados;
    }

    public String actualizar(mtoCategoriaFalla catFall){
        String resp = null;
        try {
            String[] id = {String.valueOf(catFall.getId_categoria_falla())};
            ContentValues cv = new ContentValues();
            cv.put("nombre_categoria_falla",catFall.getNombre_categoria_falla());
            cv.put("descripcion",catFall.getDescripcion());
            db.update("categoriaFalla", cv, "id_categoria_falla = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public String insertar(mtoDetalleMto detalleMto){
        String regInsertados="";
        long contador=0;
        try {
            ContentValues dato = new ContentValues();
            dato.put("id_mto",detalleMto.getId_mto());
            dato.put("id_falla",detalleMto.getId_falla());
            contador=db.insert("detalle_mto",null,dato);
            if(contador==-1 || contador==0) regInsertados= "Error al guardar los datos";
            else regInsertados = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return regInsertados;
    }

    public String actualizar(mtoDetalleMto detalleMto){
        String resp = null;
        try {
            String[] id = {String.valueOf(detalleMto.getId_mto())};
            ContentValues cv = new ContentValues();
            cv.put("id_falla",detalleMto.getId_falla());
            db.update("detalle_mto", cv, "id_mto = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public String insertar(mtoDiagnosticoFalla diagFall){
        String regInsertados="";
        long contador=0;
        try {
            ContentValues dato = new ContentValues();
            dato.put("id_diagnostico",diagFall.getId_diagnostico());
            dato.put("id_falla",diagFall.getId_falla());
            contador=db.insert("diagnostico_falla",null,dato);
            if(contador==-1 || contador==0) regInsertados= "Error al guardar los datos";
            else regInsertados = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return regInsertados;
    }

    public String actualizar(mtoDiagnosticoFalla diagFall){
        String resp = null;
        try {
            String[] id = {String.valueOf(diagFall.getId_diagnostico())};
            ContentValues cv = new ContentValues();
            cv.put("id_falla",diagFall.getId_falla());
            db.update("diagnostico_falla", cv, "id_diagnostico = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public String insertar(mtoDiagnosticoMto diagMto){
        String regInsertados="";
        long contador=0;
        try {
            ContentValues dato = new ContentValues();
            dato.put("id_diagnostico",diagMto.getId_diagnostico_mto());
            dato.put("descripcion",diagMto.getDescripcion());
            contador=db.insert("diagnostico_mto",null,dato);
            if(contador==-1 || contador==0) regInsertados= "Error al guardar los datos";
            else regInsertados = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return regInsertados;
    }

    public String actualizar(mtoDiagnosticoMto diagMto){
        String resp = null;
        try {
            String[] id = {String.valueOf(diagMto.getId_diagnostico_mto())};
            ContentValues cv = new ContentValues();
            cv.put("descripcion",diagMto.getDescripcion());
            db.update("diagnostico_mto", cv, "id_diagnostico = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public String insertar(mtoFacturacion factura){
        String regInsertados="";
        long contador=0;
        try {
            ContentValues dato = new ContentValues();
            dato.put("id_factura",factura.getId_facturacion());
            dato.put("monto",factura.getMonto());
            dato.put("efectivo",factura.getEfectivo());
            dato.put("cambio",factura.getCambio());
            dato.put("fecha_factura",factura.getFecha_factura());
            dato.put("id_mto",factura.getMonto());
            contador=db.insert("facturacion",null,dato);
            if(contador==-1 || contador==0) regInsertados= "Error al guardar los datos";
            else regInsertados = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return regInsertados;
    }

    public String actualizar(mtoFacturacion factura){
        String resp = null;
        try {
            String[] id = {String.valueOf(factura.getId_facturacion())};
            ContentValues cv = new ContentValues();
            cv.put("monto",factura.getMonto());
            cv.put("efectivo",factura.getEfectivo());
            cv.put("cambio",factura.getCambio());
            cv.put("fecha_factura",factura.getFecha_factura());
            cv.put("id_mto",factura.getMonto());
            db.update("facturacion", cv, "id_factura = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public String insertar(mtoFalla falla){
        String regInsertados="";
        long contador=0;
        try {
            ContentValues dato = new ContentValues();
            dato.put("id_falla",falla.getId_falla());
            dato.put("descripcion_falla",falla.getDescripcion());
            dato.put("id_categoria_falla",falla.getId_categoria_falla());
            contador=db.insert("falla",null,dato);
            if(contador==-1 || contador==0) regInsertados= "Error al guardar los datos";
            else regInsertados = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return regInsertados;
    }

    public String actualizar(mtoFalla falla){
        String resp = null;
        try {
            String[] id = {String.valueOf(falla.getId_falla())};
            ContentValues cv = new ContentValues();
            cv.put("descripcion_falla",falla.getDescripcion());
            cv.put("id_categoria_falla",falla.getId_categoria_falla());
            db.update("falla", cv, "id_falla = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public String insertar(mtoMantenimiento mto){
        String regInsertados="";
        long contador=0;
        try {
            ContentValues dato = new ContentValues();
            dato.put("id_mantenimiento",mto.getId_mto());
            dato.put("descripcion_mto",mto.getDescripcion());
            dato.put("fecha_mto",mto.getFecha_mto());
            dato.put("proximo_mto",mto.getProximo_mto());
            dato.put("estado_mto",mto.getEstado_mto());
            dato.put("id_diagnostico",mto.getId_diagnostico());
            dato.put("id_tipo_mto",mto.getId_tipo_mto());
            dato.put("id_sucursal",mto.getId_sucursal());
            dato.put("id_empleado",mto.getId_empleado());
            contador=db.insert("mantenimiento",null,dato);
            if(contador==-1 || contador==0) regInsertados= "Error al guardar los datos";
            else regInsertados = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return regInsertados;
    }

    public String actualizar(mtoMantenimiento mto){
        String resp = null;
        try {
            String[] id = {String.valueOf(mto.getId_mto())};
            ContentValues cv = new ContentValues();
            cv.put("descripcion_mto",mto.getDescripcion());
            cv.put("fecha_mto",mto.getFecha_mto());
            cv.put("proximo_mto",mto.getProximo_mto());
            cv.put("estado_mto",mto.getEstado_mto());
            cv.put("id_diagnostico",mto.getId_diagnostico());
            cv.put("id_tipo_mto",mto.getId_tipo_mto());
            cv.put("id_sucursal",mto.getId_sucursal());
            cv.put("id_empleado",mto.getId_empleado());
            db.update("mantenimiento", cv, "id_mantenimiento = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public String insertar(mtoModeloAuto modelo){
        String regInsertados="";
        long contador=0;
        try {
            ContentValues dato = new ContentValues();
            dato.put("id_modelo_auto",modelo.getId_modelo());
            dato.put("nombre_modelo",modelo.getNombre_modelo());
            contador=db.insert("modeloAuto",null,dato);
            if(contador==-1 || contador==0) regInsertados= "Error al guardar los datos";
            else regInsertados = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return regInsertados;
    }

    public String actualizar(mtoModeloAuto modelo){
        String resp = null;
        try {
            String[] id = {String.valueOf(modelo.getId_modelo())};
            ContentValues cv = new ContentValues();
            cv.put("nombre_modelo",modelo.getNombre_modelo());
            db.update("modeloAuto", cv, "id_modelo_auto = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public String insertar(mtoMarcaAuto marca){
        String regInsertados="";
        long contador=0;
        try {
            ContentValues dato = new ContentValues();
            dato.put("id_marca_auto",marca.getId_marca());
            dato.put("nombre_marca",marca.getNombre_marca());
            dato.put("id_modelo_auto",marca.getId_modelo());
            contador=db.insert("marcaAuto",null,dato);
            if(contador==-1 || contador==0) regInsertados= "Error al guardar los datos";
            else regInsertados = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return regInsertados;
    }

    public String actualizar(mtoMarcaAuto marca){
        String resp = null;
        try {
            String[] id = {String.valueOf(marca.getId_marca())};
            ContentValues cv = new ContentValues();
            cv.put("nombre_marca",marca.getNombre_marca());
            cv.put("id_modelo_auto",marca.getId_modelo());
            db.update("marcaAuto", cv, "id_modelo_auto = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public String insertar(mtoTipoMto tipoMto){
        String regInsertados="";
        long contador=0;
        try {
            ContentValues dato = new ContentValues();
            dato.put("id_tipo_mto",tipoMto.getId_tipo_mto());
            dato.put("nombre_tipo_mto",tipoMto.getNombre_tipo_mto());
            contador=db.insert("tipoMantenimiento",null,dato);
            if(contador==-1 || contador==0) regInsertados= "Error al guardar los datos";
            else regInsertados = "¡Datos guardados con éxito!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return regInsertados;
    }

    public String actualizar(mtoTipoMto tipoMto){
        String resp = null;
        try {
            String[] id = {String.valueOf(tipoMto.getId_tipo_mto())};
            ContentValues cv = new ContentValues();
            cv.put("nombre_tipo_mto",tipoMto.getNombre_tipo_mto());
            db.update("tipoMantenimiento", cv, "id_tipo_mto = ?", id);
            resp = "Registro Actualizado Correctamente";
        }catch (Exception ex){
            ex.printStackTrace();
            resp = "Error al modificar!";
        }
        return resp;
    }

    public void llenarBDCarnet(){
        try {

            /*POR AGREGAR: categoria_falla, MARCA, MODELO,TIPOAUTO,TIPOMTO*/
            final int[] Codcargo = {1,2,3};
            final String[] Nomcargo = {"Administrador","Gerente","Mecanico"};
            final String[] user = {"admin","gerente1","mecanico1","cliente1","cliente2","cliente3"};
            final String[] pwd = {"admin","gerente1","mecanico1","cliente1","cliente2","cliente3"};
            final int[] Codempl = {1,2,3};
            final String[] NomEmp = {"Carlos","Jose","Jorge"};
            final String[] ApeEmp = {"Orellana","Duran","Lara"};
            final int[] Codcli = {1,2,3};
            final String[] Nomcli = {"Mario","Maria","Pablo"};
            final String[] Apecli = {"Zepeda","Lara","Ramirez"};
            final String[] Direcli = {
                    "Colonia Rio Chiquito #2, San Miguel",
                    "Residencial La Esquina #489, psj 1 pol 34 #490, Santa Ana",
                    "Barrio el Clavario #5043, San Salvador"
            };
            final String[] Duicli = {"0012314-9","0023156-9","0201266-7"};
            final String[] FechaCli = {"12/05/2022","12/05/2022","12/05/2022"};
            final String[] Telcli = {"2222-2222","2121-2121","2312-2312"};
            final int[] Tipoau = {1,2,3};
            final String[] Nomtp = {"Sedán","Hatchback","SUV"};
            final int[] Codsuc = {1,2,3};
            final String[] Nomsuc = {"Casa Matriz","Centro","San Miguel"};
            final String[] Dirsuc = {"San Salvador","Santa Ana","San Miguel"};

            final int[] id_categoria_falla = {1,2,3,4,5};
            final String[] nombre_categoria_falla = {"Chasis/Dirección","Motor/sistemas anticontaminación","Carrocería/interior","Frenos","Sistema electrico" };
            final String[] descripcion ={"Se comprueba el estado de la suspensión, (amortiguadores, muelles, puntos de anclaje…) y de la dirección (rótulas, bomba de asistencia…)",
            "Se centran en detectar posibles fallos de motor, incluido el sistema de escape, y sistema de transmisión (caja de cambios, diferencial..)",
            "Se vigilar su deterioro (corrosión, faros)… así como el cinturón de seguridad y desjustes del salpicadero.",
            "Para comprobar su eficacia y posibles fallos en el sistema de frenado (pastillas, discos, servofreno, líquidos…)",
            "Se localizan posibles fallos eléctricos (luces en el cuadro de mandos, cierre, climatizador..)"};
            final int[]  id_modelo_auto2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51};
            final String[] nombre_modelo = {"500","Grande Punto","Punto Evo","500c","695","Punto","155","156","159","164","145","147","146","Gtv","Spider","166","Gt","Crosswagon","Brera","90","75","33","Giulietta","Sprint","Mito","Expander","10","24","Dacia","Rocsta","Db7","V8","Db9","Vanquish","V8 Vantage","Vantage","Dbs","Volante","Virage","Vantage V8","Vantage V12","Rapide","Cygnet","80","A4","A6","S6","Coupe","S2","Rs2"};
            final int[] id_marca_auto = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
            final String[] nombre_marca = {"Alfa Romeo","Aston Martin","Audi","Bentley","BMW","Cadillac","Chevrolet","Daewoo","Daihatsu","Ford","GMC","Honda","Hyundai","Isuzu","Jaguar","Jeep","Kia","Mazda","Mercedes-benz","Mini","Mitsubishi","Nissan","Suzuki","Toyota","Volkswagen"};
            final int[]  id_modelo_auto1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51};
            final int[] id_tipo_auto = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
            final String[] nombre_tipo_auto = {"Sedán","Hatchback","Coupé","SUV","Mini van","Crossover","Convertible","MPV","Pick Up","Microbus","Bus","Camion 2T","Camion +2T","Otro"};
            //TABLA tipo_mto
            final int[] id_tipo = {1,2,3};
            final String[] nombre_mto = {"Mantenimiento correctivo","Mantenimiento preventivo","Mantenimiento predictivo"};

            abrir();

            db.execSQL("DELETE FROM empleado");
            db.execSQL("DELETE FROM cliente");
            db.execSQL("DELETE FROM cargoEmpleado");
            db.execSQL("DELETE FROM usuario");
            db.execSQL("DELETE FROM tipoAuto");
            db.execSQL("DELETE FROM categoriaFalla");
            db.execSQL("DELETE FROM modeloAuto");
            db.execSQL("DELETE FROM marcaAuto");
            db.execSQL("DELETE FROM tipoMantenimiento");
            db.execSQL("DELETE FROM sucursal");

            mtoCargoEmpleado cargo = new mtoCargoEmpleado();
            mtoUsuario usuario = new mtoUsuario();
            mtoEmpleado empleado = new mtoEmpleado();
            mtoCliente cliente = new mtoCliente();
            mtoTipoAuto tipoA = new mtoTipoAuto();
            mtoSucursal sucursal = new mtoSucursal();
            mtoCategoriaFalla categoriaFalla = new mtoCategoriaFalla();
            mtoMarcaAuto marca = new mtoMarcaAuto();
            mtoModeloAuto modelo = new mtoModeloAuto();
            mtoTipoMto tipoMto = new mtoTipoMto();

            for (int i=0;i<6;i++){
                usuario.setUsuario(user[i]);
                usuario.setContra(pwd[i]);
                insertar(usuario);
            }
            for (int i=0;i<3;i++){
                cargo.setId_cargo(Codcargo[i]);
                cargo.setNombre_cargo(Nomcargo[i]);
                insertar(cargo);
                tipoA.setId_tipo_auto(Tipoau[i]);
                tipoA.setTipo_auto(Nomtp[i]);
                insertar(tipoA);
                empleado.setId_empleado(Codempl[i]);
                empleado.setNombre(NomEmp[i]);
                empleado.setApellidos(ApeEmp[i]);
                empleado.setId_cargo(Codcargo[i]);
                empleado.setUsuario(user[i]);
                insertar(empleado);
                cliente.setId_cliente(Codcli[i]);
                cliente.setNombre(Nomcli[i]);
                cliente.setApellidos(Apecli[i]);
                cliente.setDireccion(Direcli[i]);
                cliente.setTelefono(Telcli[i]);
                cliente.setDui(Duicli[i]);
                cliente.setFecha_registro(FechaCli[i]);
                cliente.setUsuario(user[i+3]);
                insertar(cliente);
                sucursal.setId_sucursal(Codsuc[i]);
                sucursal.setNombre_sucursal(Nomsuc[i]);
                sucursal.setDireccion(Dirsuc[i]);
                insertar(sucursal);
            }
            for (int i=0;i<5;i++){
                categoriaFalla.setId_categoria_falla(id_categoria_falla[i]);
                categoriaFalla.setNombre_categoria_falla(nombre_categoria_falla[i]);
                categoriaFalla.setDescripcion(descripcion[i]);
                insertar(categoriaFalla);
            }
            for (int i=0;i<25;i++){
                modelo.setId_modelo(id_modelo_auto2[i]);
                modelo.setNombre_modelo(nombre_modelo[i]);
                insertar(modelo);
                marca.setId_marca(id_marca_auto[i]);
                marca.setNombre_marca(nombre_marca[i]);
                marca.setId_modelo(id_modelo_auto1[i]);
                insertar(marca);
            }
            for (int i=0;i<14;i++){
                tipoA.setId_tipo_auto(id_tipo_auto[i]);
                tipoA.setTipo_auto(nombre_tipo_auto[i]);
                insertar(tipoA);
            }
            for (int i=0;i<3;i++){
                tipoMto.setId_tipo_mto(id_tipo[i]);
                tipoMto.setNombre_tipo_mto(nombre_mto[i]);
                insertar(tipoMto);
            }
            cerrar();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
