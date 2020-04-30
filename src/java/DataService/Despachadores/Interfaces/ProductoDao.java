
package DataService.Despachadores.Interfaces;

import BusinessService.ProductoBean;
import java.util.List;


public interface ProductoDao {
    public String Registrar (ProductoBean producto);
    public String Editar (ProductoBean producto);
    public String Eliminar(int codigo);
    public ProductoBean Buscar(int codigo);
    public List<ProductoBean> Listar();
}
