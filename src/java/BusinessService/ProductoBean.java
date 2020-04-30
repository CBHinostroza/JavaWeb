package BusinessService;

import java.io.Serializable;
import java.sql.Date;

public class ProductoBean implements Serializable{

    private int codigo;
    private String nombre;
    private String nombre_categoria;
    private String nombre_proveedor;
    private int idcategoria;
    private int idproveedor;
    private int stock_inicial;
    private Date fecha_Registro;
    private int stock_minimo;
    private String codigo_barra;
    private Date fecha_ven;

    public ProductoBean(int codigo, String nombre, String nombre_categoria, String nombre_proveedor, int stock_inicial, Date fecha_Registro, int stock_minimo, String codigo_barra, Date fecha_ven, double precio_unitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombre_categoria = nombre_categoria;
        this.nombre_proveedor = nombre_proveedor;
        this.stock_inicial = stock_inicial;
        this.fecha_Registro = fecha_Registro;
        this.stock_minimo = stock_minimo;
        this.codigo_barra = codigo_barra;
        this.fecha_ven = fecha_ven;
        this.precio_unitario = precio_unitario;
    }

    public ProductoBean(int codigo, String nombre, int idcategoria, int idproveedor, int stock_inicial, Date fecha_Registro, int stock_minimo, String codigo_barra, Date fecha_ven, double precio_unitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idcategoria = idcategoria;
        this.idproveedor = idproveedor;
        this.stock_inicial = stock_inicial;
        this.fecha_Registro = fecha_Registro;
        this.stock_minimo = stock_minimo;
        this.codigo_barra = codigo_barra;
        this.fecha_ven = fecha_ven;
        this.precio_unitario = precio_unitario;
    }

    public ProductoBean() {
    }
    private double precio_unitario;

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

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public int getStock_inicial() {
        return stock_inicial;
    }

    public void setStock_inicial(int stock_inicial) {
        this.stock_inicial = stock_inicial;
    }

    public Date getFecha_Registro() {
        return fecha_Registro;
    }

    public void setFecha_Registro(Date fecha_Registro) {
        this.fecha_Registro = fecha_Registro;
    }

    public int getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(int stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public Date getFecha_ven() {
        return fecha_ven;
    }

    public void setFecha_ven(Date fecha_ven) {
        this.fecha_ven = fecha_ven;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    
}
