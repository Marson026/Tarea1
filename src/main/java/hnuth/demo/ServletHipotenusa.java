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
        out.println("  <div style='margin-top:24px;'>");
        out.println("    <h3 style='color:var(--primario);margin-bottom:16px;'>👥 Integrantes del Proyecto</h3>");
        out.println("    <div class='integrantes-container'>");
        out.println("      <div class='integrante-card'><strong>Cristhian Roberto Illa Sanchez</strong><div class='cuenta'>202210020278</div></div>");
        out.println("      <div class='integrante-card'><strong>Brayan Edgardo Aguilar Aguilera</strong><div class='cuenta'>202320110146</div></div>");
        out.println("      <div class='integrante-card'><strong>Emerson Ricardo Jimenez</strong><div class='cuenta'>202310080212</div></div>");
        out.println("      <div class='integrante-card'><strong>Luis Alberto Colindres Ventura</strong><div class='cuenta'>201930060108</div></div>");
        out.println("      <div class='integrante-card'><strong>Marlon Jared Saenz Blanco</strong><div class='cuenta'>202230010131</div></div>");
        out.println("    </div>");
        out.println("  </div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}


