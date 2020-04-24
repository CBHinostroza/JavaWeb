/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataService.Despachadores.Impl;

import BusinessService.TerritorioBean;
import static DataService.Despachadores.Conexion.ConectaDB.conectar;
import DataService.Despachadores.Interfaces.TerritorioDao;
import com.mysql.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


public class TerritorioDaoImpl implements TerritorioDao {

    @Override
    public TerritorioBean Buscar(int codigo) {

        TerritorioBean territorio = null;
        Connection cn = conectar();
        CallableStatement cstm = null;
        ResultSet rs = null;
        String sql = "call sp_BuscarTerritorio(?)";

        try {
            cstm = (CallableStatement) cn.prepareCall(sql);
            rs = cstm.executeQuery();
            while(rs.next()){
                territorio = new TerritorioBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo Buscar territorio: " + e.getMessage());
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
                System.out.println("Error al desconectar: " + e.getMessage());
            }
        }

        return territorio;
    }

}
