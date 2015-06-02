package webDashboards.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.redprairie.moca.MocaException;
import com.redprairie.moca.MocaResults;

import webDashboards.model.Consultas;

/**
 * Servlet implementation class ReceivingDashboards
 */
@WebServlet("/ReceivingDashboards")
public class ReceivingDashboards extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceivingDashboards() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
        
        Consultas con = new Consultas();
        MocaResults res = null;
        int col = 0;
        
        try {
            res = con.getReceivingDashboardsData("1");
        }
        catch (MocaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        out.println("<title>Dashboards de Recibo</title>");
        //out.println("<script type=\"text/javascript\">");
        //out.println("var int=self.setInterval(\"refresh()\",60000);");
        //out.println("function refresh()");
        //out.println("{");
        //out.println("location.reload(true);");
        //out.println("}");
        //out.println("</script>");
        out.println("</head>");
        out.println("<body>");
        //out.println("<%");
        //out.println("response.setIntHeader(\"Refresh\", 10);");
        //out.println("%>");
        out.println("<center>");
        out.println("<table border=1 width=\"1200px\">");
        out.println("<tr>");
        out.println("<td colspan=\"2\" valign=\"bottom\"><font face=\"Arial\" size=\"6\"><b>Area de Recibo</b></font><img src=\"img/fah_banner.jpg\" align=\"right\" /></td>");
        out.println("</tr>");
        
        col = 1;
        while(res.next()) {
            
            String anden = res.getString("yard_loc");
            String oc = res.getString("invnum");
            String proveedor = res.getString("first_name");
            String porcentaje_recibido = res.getString("percentage_rcvqty");
            String porcentaje_recibir = res.getString("percentage_to_rcvqty");
            int esperado = res.getInt("expqty");
            int recibido = res.getInt("rcvqty");
            int por_recibir = res.getInt("to_rcvqty");
            int sku = res.getInt("sku");
            String inicio = res.getString("arrdte");
            String fin = res.getString("close_dte");
            
            if(col%2 != 0){
                out.println("<tr>");
            }
            out.println("<td width=\"600px\">");
            out.println("<center>");
            out.println("<form id=\"" + anden + "\">");    
            out.println("<p><font face=\"Arial\"><b>");
            out.println("OC:<input type=\"text\" value=\"" + oc + "\" id=\"OC" + anden + "\" readonly=\"readonly\" size=\"10\" />");
            out.println("Proveedor:<input type=\"text\" value=\"" + proveedor + "\" id=\"SUP" + anden + "\" readonly=\"readonly\" size=\"25\" />");
            out.println("<font size=\"5\" >" + anden + "</font>");
            out.println("</b></font></p>");
            out.println("</form>");  
            out.println("<table>");
            out.println("<tr>");
            out.println("<td rowspan=\"2\">");
            out.println("<center>");
            out.println("<table border=1 align=\"center\">");
            out.println("<tr>");
            out.println("<th>Usuario</th>");
            out.println("<th>Piezas</th>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>" + esperado + "</td>");
            out.println("<td>" + recibido + "</td>");
            out.println("</tr>");
            
            out.println("</table>");
            out.println("</center>");
            out.println("</td>");
            out.println("<td rowspan=\"2\"><img src=\"pieChart?recibido=" + porcentaje_recibido + "&recibir=" + porcentaje_recibir + "\" border=\"0\" /></td>");
           
            if(Double.parseDouble(porcentaje_recibido) == 100){
                out.println("<td><img src=\"img/available-off.png\" width=\"80\" height=\"80\" /></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td><img src=\"img/receiving-off.png\" width=\"80\" height=\"80\" /></td>");
            }
            else if(Double.parseDouble(porcentaje_recibido) < 100 && Double.parseDouble(porcentaje_recibido) >= 0){
                out.println("<td><img src=\"img/available-off.png\" width=\"80\" height=\"80\" /></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td><img src=\"img/receiving-on.png\" width=\"80\" height=\"80\" /></td>");
            }
            else if(esperado == 0 ){
                out.println("<td><img src=\"img/available-on.png\" width=\"80\" height=\"80\" /></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td><img src=\"img/receiving-off.png\" width=\"80\" height=\"80\" /></td>");
            }
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>");
            out.println("</td>");
            out.println("<td>");
            out.println("<center>");
            out.println("<table border=1 align=\"center\">");
            out.println("<tr>");
            out.println("<th>Esperado</th>");
            out.println("<th>Recibido</th>");
            out.println("<th>Por Recibir</th>");
            out.println("<th>Sku's</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>" + esperado + "</td>");
            out.println("<td>" + recibido + "</td>");
            out.println("<td>" + por_recibir + "</td>");
            out.println("<td>" + sku + "</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</center>");
            out.println("</td>");
            out.println("<td>");
            out.println("Inicio: <input type=\"text\" value=\"" + inicio + "\" readonly=\"readonly\" size=\"8\"><br>");
            out.println("Fin: <input type=\"text\" value=\"" + fin + "\" readonly=\"readonly\" size=\"8\">" );
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</center>");
            out.println("</td>");
            if(col%2 == 0){
                out.println("</tr>");
            }
            col = col + 1;
        }

        out.println("</center>");
        out.println("</table>");
        out.println("</body>");
        response.setIntHeader("Refresh", 60);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
