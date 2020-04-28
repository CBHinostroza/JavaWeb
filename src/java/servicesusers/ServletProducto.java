/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesUsers;

import BusinessService.ProductoBean;
import DataService.Despachadores.Impl.ProductoDaoImpl;
import DataService.Despachadores.Interfaces.ProductoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "ServletProducto", urlPatterns = {"/ServletProducto"})
public class ServletProducto extends HttpServlet {

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

        String resultado = null; //Esta variable nos permite guardar el resultado de algunos metodos
        List<ProductoBean> list = null;
        ProductoDao productoDao = new ProductoDaoImpl();
        ProductoBean producto; //Inicializando el objeto producto
        String accion = request.getParameter("accion"); //Este parametro y el valor lo obtenemos como solicitud del cliente
        String target = ""; //Esta variable guardar el nombre de un jsp

        switch (accion) {
            case "QRY":
                list = productoDao.Listar();
                if (list != null) {
                    request.setAttribute("lista", list);
                    target = "ListarProducto.jsp";
                } else {
                    target = "mensaje.jsp";
                }
                break;
            case "INS":
                producto = new ProductoBean();
                producto.setNombre(request.getParameter("nombre"));
                producto.setIdcategoria(Integer.parseInt(request.getParameter("categoria")));
                producto.setIdproveedor(Integer.parseInt(request.getParameter("proveedor")));
                producto.setStock_inicial(Integer.parseInt(request.getParameter("stock_inicial")));
                producto.setStock_minimo(Integer.parseInt(request.getParameter("stock_minimo")));

                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date fechasql = null;
                try {
                    java.util.Date fechajava = f.parse(request.getParameter("fecha_ven"));
                    fechasql = new java.sql.Date(fechajava.getTime());
                } catch (Exception e) {
                    resultado = "Error al registrar el campo fecha_vencimiento: " + e.getMessage();
                }

                producto.setCodigo_barra(request.getParameter("codigo_barra"));
                producto.setFecha_ven(fechasql);
                producto.setPrecio_unitario(Double.parseDouble(request.getParameter("precio_unitario")));
                resultado = productoDao.Registrar(producto);
                if(resultado==null){
                    target = "Mantenimiento.jsp";
                }
                else{
                    target = "mensaje.jsp";
                }
                break;
            default:
                resultado = "Error en la condicion switch del servlet producto";
                break;
        }

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
