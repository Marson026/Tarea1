package hnuth.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "hipotenusa", value = "/hipotenusa")
public class ServletHipotenusa extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("hipotenusa.html");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String aStr = request.getParameter("a");
        String bStr = request.getParameter("b");
        double a = 0;
        double b = 0;
        String resultado = "";
        try {
            a = Double.parseDouble(aStr);
            b = Double.parseDouble(bStr);
            double c = Math.sqrt(a * a + b * b);
            DecimalFormat df = new DecimalFormat("0.####");
            resultado = df.format(c);
        } catch (Exception e) {
            resultado = "Entrada inválida";
        }
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <meta name='viewport' content='width=device-width, initial-scale=1'>");
        out.println("  <title>Resultado - Cálculo de Hipotenusa</title>");
        out.println("  <link rel='stylesheet' href='css/styles.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='formulario'>");
        out.println("  <h1>✅ Resultado del Cálculo</h1>");
        out.println("  <h3 style='color:#5b9eff;margin-top:24px;'>Cálculo de la hipotenusa</h3>");
        out.println("  <table>");
        out.println("    <tr><th>Entrada</th><th>Respuesta</th></tr>");
        out.println("    <tr><td>a=" + aStr + ", b=" + bStr + "</td><td><strong>" + resultado + "</strong></td></tr>");
        out.println("  </table>");
        out.println("  <div class='acciones' style='margin-top:32px;justify-content:center;'>");
        out.println("    <a class='boton' href='hipotenusa.html'>🔄 Realizar otro cálculo</a>");
        out.println("    <a class='sec' href='menu.html'>🏠 Volver al menú</a>");
        out.println("  </div>");
        out.println("  <div style='background:#f0f4f8;border-left:4px solid #27ae60;padding:16px;border-radius:6px;margin-top:24px;font-size:13px;'>");
        out.println("    <strong>👥 Integrantes:</strong> Brayan Edgardo Aguilar Aguilera, Zurisaday Alvarenga Almendárez, Cristhian Roberto Illa Sánchez, Emerson Ricardo Jiménez Lorenzo, Luis Alberto Colindres Ventura, Marlón Jared Saenz Blanco<br>");
        out.println("    <strong>🔐 Cuenta:</strong> 2020123456789");
        out.println("  </div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}


