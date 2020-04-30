/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataService.Despachadores.Interfaces;

import BusinessService.ProveedorBean;
import java.util.List;

/**
 *
 * @author bryan
 */
public interface ProveedorDao {
    
    public String Registrar (ProveedorBean proveedor);
    public String Editar (ProveedorBean proveedor);
    public String Eliminar(int codigo);
    public ProveedorBean Buscar(int codigo);
    public List<ProveedorBean> Listar();
}
