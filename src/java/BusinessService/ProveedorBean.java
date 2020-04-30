package BusinessService;

import java.io.Serializable;

public class ProveedorBean implements Serializable {

//    Create table tbl_proveedor
//(
//	codigo int AUTO_INCREMENT primary key,
//    nombre varchar(50) not null,
//    direccion varchar(50) not null,
//    idterritorio int not null,
//    telefono varchar(12),
//    email varchar(50),
//    
//    /*Creando referencia entidad relacion*/
//    Foreign key (idterritorio) references tbl_territorio (codigo)
//);
    private int codigo;
    private String nombre;
    private String direccion;
    private int codigo_territorio;
    

    public ProveedorBean(int codigo, String nombre, String direccion, int codigo_territorio, String telefono, String email) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigo_territorio = codigo_territorio;
        this.telefono = telefono;
        this.email = email;
    }

    public ProveedorBean(int codigo, String nombre, String direccion, String telefono, String distrito, String email) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.distrito = distrito;
        this.email = email;
    }

    public ProveedorBean(int codigo, String nombre, String direccion, int codigo_territorio, String telefono, String distrito, String email) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigo_territorio = codigo_territorio;
        this.telefono = telefono;
        this.distrito = distrito;
        this.email = email;
    }

    public ProveedorBean() {
    }
    private String telefono;
    private String distrito;
    private String email;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo_territorio() {
        return codigo_territorio;
    }

    public void setCodigo_territorio(int codigo_territorio) {
        this.codigo_territorio = codigo_territorio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
   

}
