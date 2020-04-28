package DataService.Despachadores.Impl;

import BusinessService.ProductoBean;
import static DataService.Despachadores.Conexion.ConectaDB.conectar;
import DataService.Despachadores.Interfaces.ProductoDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class ProductoDaoImpl implements ProductoDao {

    @Override
    public String Registrar(ProductoBean producto) {
        String resultado = null;
        CallableStatement cstm = null;
        Connection cn = conectar();
        String sql = "call sp_RegistroProducto(?,?,?,?,?,?,?,?)";
        try {

            cstm = cn.prepareCall(sql);
            cstm.setString(1, producto.getNombre());
            cstm.setInt(2, producto.getIdcategoria());
            cstm.setInt(3, producto.getIdproveedor());
            cstm.setInt(4, producto.getStock_inicial());
            cstm.setInt(5, producto.getStock_minimo());
            cstm.setString(6, producto.getCodigo_barra());
            cstm.setDate(7, producto.getFecha_ven());
            cstm.setDouble(8, producto.getPrecio_unitario());
            cstm.executeQuery();

        } catch (SQLException e) {
            resultado = "Error en el metodo Registrar producto: " + e.getMessage();
        } finally {
            try {
                if (cstm != null) {
                    cstm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                resultado = "Error al cerrar las conexiones: " + e.getMessage();
            }
        }
        return resultado;
    }

    @Override
    public String Editar(ProductoBean producto) {
        String resultado = null;
        CallableStatement cstm = null;
        Connection cn = conectar();
        String sql = "call sp_EditarProducto(?,?,?,?,?,?,?,?,?)";
        try {

            cstm = cn.prepareCall(sql);
            cstm.setInt(1, producto.getCodigo());
            cstm.setString(2, producto.getNombre());
            cstm.setInt(3, producto.getIdcategoria());
            cstm.setInt(4, producto.getIdproveedor());
            cstm.setInt(5, producto.getStock_inicial());
            cstm.setInt(6, producto.getStock_minimo());
            cstm.setString(7, producto.getCodigo_barra());
            cstm.setDate(8, producto.getFecha_ven());
            cstm.setDouble(9, producto.getPrecio_unitario());
            cstm.executeUpdate();

        } catch (SQLException e) {
            resultado = "Error en el metodo Editar producto: " + e.getMessage();
        } finally {
            try {
                if (cstm != null) {
                    cstm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                resultado = "Error al cerrar las conexiones: " + e.getMessage();
            }
        }
        return resultado;
    }

    @Override
    public String Eliminar(int codigo) {
        String resultado = null;
        CallableStatement cstm = null;
        Connection cn = conectar();
        String sql = "call sp_EliminarProducto(?)";
        try {

            cstm = cn.prepareCall(sql);
            cstm.setInt(1, codigo);
            cstm.executeQuery();

        } catch (SQLException e) {
            resultado = "Error en el metodo Editar producto: " + e.getMessage();
        } finally {
            try {
                if (cstm != null) {
                    cstm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                resultado = "Error al cerrar las conexiones: " + e.getMessage();
            }
        }
        return resultado;
    }

    @Override
    public ProductoBean Buscar(int codigo) {

        ProductoBean producto = null;
        CallableStatement cstm = null;
        Connection cn = conectar();
        ResultSet rs = null;
        String sql = "call sp_BuscarProducto(?)";
        try {
            cstm = cn.prepareCall(sql);
            cstm.setInt(1, codigo);
            rs = cstm.executeQuery();
            while (rs.next()) {
                producto = new ProductoBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                         rs.getInt(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getDate(9), rs.getDouble(10));

            }

        } catch (SQLException e) {
            System.out.println("Error en el metodo Buscar producto: " + e.getMessage());
        } finally {
            try {
                if (cstm != null) {
                    cstm.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar las conexiones: " + e.getMessage());
            }
        }

        return producto;
    }

    @Override
    public List<ProductoBean> Listar() {
        Connection cn = conectar();
        List<ProductoBean> list = null;
        ResultSet rs = null;
        CallableStatement cstm = null;
        String sql = "call sp_ListarProductos()";
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {

            cstm = cn.prepareCall(sql);
            list = new LinkedList<>(); //Inicializamos el objeto lista de productos, que recibira un objeto producto
            rs = cstm.executeQuery();
            while (rs.next()) { //Mientra haya una fila entonces

                ProductoBean proveedor = new ProductoBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getDate(9), rs.getDouble(10));
                //Obteniendo los datos y guardando al objeto producto
                list.add(proveedor); //agregando los registro obtenido al objeto lista mientras haya una fila

            }
        } catch (SQLException e) {
            System.out.println("Error en el metodo listar: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cstm != null) {
                    cstm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar las conexiones metodo Listar: " + e.getMessage());
            }
        }

        return list;
    }

}
