/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataService.Despachadores.Impl;

import BusinessService.ProveedorBean;

import static DataService.Despachadores.Conexion.ConectaDB.conectar;
import DataService.Despachadores.Interfaces.ProveedorDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class ProveedorDaoImpl implements ProveedorDao {

    @Override
    public String Registrar(ProveedorBean proveedor) {
        String resultado = null;
        CallableStatement cstm = null;
        Connection cn = conectar();
        String sql = "call sp_RegistroProveedor(?,?,?,?,?)";
        try {

            cstm = cn.prepareCall(sql);
            cstm.setString(1, proveedor.getNombre());
            cstm.setString(2, proveedor.getDireccion());
            cstm.setInt(3, proveedor.getCodigo_territorio());
            cstm.setString(4, proveedor.getTelefono());
            cstm.setString(5, proveedor.getEmail());
            cstm.executeQuery();

        } catch (Exception e) {
            resultado = "Error en el metodo Registrar proveedor: " + e.getMessage();
        } finally {
            try {
                if (cstm != null) {
                    cstm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                resultado = "Error al desconectar: " + e.getMessage();
            }
        }
        return resultado;
    }

    @Override
    public String Editar(ProveedorBean proveedor) {

        String sql = "call sp_EditarProveedor(?,?,?,?,?,?)";
        CallableStatement cstm = null;
        String resultado = null;
        Connection cn = conectar();
        try {
            cstm = cn.prepareCall(sql);
            cstm.setInt(1, proveedor.getCodigo());
            cstm.setString(2, proveedor.getNombre());
            cstm.setString(3, proveedor.getDireccion());
            cstm.setInt(4, proveedor.getCodigo_territorio());
            cstm.setString(5, proveedor.getTelefono());
            cstm.setString(6, proveedor.getEmail());
            cstm.executeUpdate();

        } catch (Exception e) {
            resultado = "Error en el metodo editar proveedor: " + e.getMessage();
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

        String sql = "call sp_EliminarProveedor(?)";
        CallableStatement cstm = null;
        Connection cn = conectar();
        String resultado = null;
        try {
            cstm = cn.prepareCall(sql);
            cstm.setInt(1, codigo);
            cstm.executeQuery();
        } catch (Exception e) {
            resultado = "Error en el metodo Eliminar proveedor: " + e.getMessage();
        } finally {
            try {
                if (cstm != null) {
                    cstm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                resultado = "Error al cerrar las conexion en el metodo Eliminar: " + e.getMessage();
            }
        }

        return resultado;

    }

    @Override
    public ProveedorBean Buscar(int codigo) {
        String sql = "call sp_BuscarProveedor(?)";
        ProveedorBean proveedor = null;
        CallableStatement cstm = null;
        Connection cn = conectar();
        ResultSet rs = null;
        try {
            cstm = cn.prepareCall(sql);
            cstm.setInt(1, codigo);
            rs = cstm.executeQuery();
            while(rs.next()){
                proveedor = new ProveedorBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
            }
            
        } catch (Exception e) {
            System.out.println("Error en el metodo Buscar Proveedor: " + e.getMessage());
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
                System.out.println("Error al cerrar las conexiones en metodo Buscar Proveedor: "+e.getMessage());
            }
        }

        return proveedor;
    }

    @Override
    public List<ProveedorBean> Listar() {

        Connection cn = conectar();
        List<ProveedorBean> list = null;
        ResultSet rs = null;
        CallableStatement cstm = null;
        String sql = "call sp_ListarProveedor()";

        try {

            cstm = cn.prepareCall(sql);
            list = new LinkedList<>(); //Inicializamos el objeto lista de proveedores, que recibira un objeto proveedor
            rs = cstm.executeQuery();
            while (rs.next()) { //Mientra haya una fila entonces

                ProveedorBean proveedor = new ProveedorBean(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)); //Obteniendo los datos y guardando la objeto proveedor
                list.add(proveedor); //agregando los registro obtenido al objeto lista mientras haya una fila

            }
        } catch (Exception e) {
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
