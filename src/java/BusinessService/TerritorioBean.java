/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessService;

/**
 *
 * @author bryan
 */
public class TerritorioBean  {
    
//    Create table tbl_territorio
//(
//	codigo int AUTO_INCREMENT primary key,
//    departamento varchar(50) not null,
//    provincia varchar(50) not null,
//    distrito varchar(50) not null
//);
    
    private int codigo;
    private String departamento;
    private String provincia;
    private String distrito;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public TerritorioBean() {
    }

    public TerritorioBean(int codigo, String departamento, String provincia, String distrito) {
        this.codigo = codigo;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
    }
    
    
}
