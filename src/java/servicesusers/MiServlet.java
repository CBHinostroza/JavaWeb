/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesUsers;

import BusinessService.ProveedorBean;
import BusinessService.TerritorioBean;
import DataService.Despachadores.Impl.ProveedorDaoImpl;
import DataService.Despachadores.Impl.TerritorioDaoImpl;
import DataService.Despachadores.Interfaces.ProveedorDao;
import DataService.Despachadores.Interfaces.TerritorioDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bryan
 */
@WebServlet(name = "MiServlet", urlPatterns = {"/MiServlet"})
public class MiServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String resultado = "";
        String target = null;
        String accion = request.getParameter("accion");
        ProveedorDao proveedorDao = new ProveedorDaoImpl();
        TerritorioDao territorioDao = new TerritorioDaoImpl();
        ProveedorBean proveedor = null;
        List<ProveedorBean> list = null;

        switch (accion) {
            case "INS":
               
                proveedor = new ProveedorBean();
                proveedor.setNombre(request.getParameter("nombre"));
                proveedor.setDireccion(request.getParameter("direccion"));
                proveedor.setCodigo_territorio(Integer.parseInt(request.getParameter("territorio")));
                proveedor.setTelefono(request.getParameter("telefono"));
                proveedor.setEmail(request.getParameter("email"));
                resultado = proveedorDao.Registrar(proveedor);
                if (resultado == null) {
                    target = "index.jsp";
                }
                break;
            case "QRY":
                list = proveedorDao.Listar();
                if(list!=null){
                    request.setAttribute("lista", list);
                    target = "ListarProveedor.jsp";
                }
                else{
                    target = "mensaje.jsp";
                }
                 
                break;
            case "DEL":
                resultado = proveedorDao.Eliminar(Integer.parseInt(request.getParameter("codigo")));
                if(resultado==null){
                    target = "index.jsp";
                }
                else{
                    target = "mensaje.jsp";
                }
                break;
            case "GET":
                proveedor = proveedorDao.Buscar(Integer.parseInt(request.getParameter("codigo")));
                if(proveedor!=null){
                    request.setAttribute("proveedor",proveedor);
                    target = "EditarProveedor.jsp";
                }
                else{
                    target = "mensaje.jsp";
                }
                break;
            case "UPD":
                proveedor = new ProveedorBean();
                proveedor.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                proveedor.setNombre(request.getParameter("nombre"));
                proveedor.setDireccion(request.getParameter("direccion"));
                proveedor.setCodigo_territorio(Integer.parseInt(request.getParameter("territorio")));
                proveedor.setTelefono(request.getParameter("telefono"));
                proveedor.setEmail(request.getParameter("email"));
                resultado = proveedorDao.Editar(proveedor);
                if(resultado == null){
                   target =  "index.jsp";
                }
                else{
                    target = "mensaje.jsp";
                }
                break;
            default:
                resultado = "Error en la decision switch del proveedor";
                break;

        }
        request.setAttribute("resultado", resultado);
        /*
        Para visualizar los errores en otro JSP
         */
//        if (resultado != null) {
//            request.setAttribute("resultado", resultado);
//            target = "mensaje.jsp";
//        }

        RequestDispatcher disPatcher = request.getRequestDispatcher(target);
        disPatcher.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
