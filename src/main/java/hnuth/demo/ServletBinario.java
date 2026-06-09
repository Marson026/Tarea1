package hnuth.demo;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "binarios", value = "/binarios")
public class ServletBinario extends HttpServlet {
	private String escapar(String s) {
		if (s == null) return "";
		return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("binario.html");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String operacion = request.getParameter("operacion");
		String numero = request.getParameter("numero");
		String descripcion = "";
		String resultado = "";
		if ("binarioAdecimal".equals(operacion)) {
			descripcion = "Cálculo de número binario a decimal";
			try {
				int dec = Integer.parseInt(numero, 2);
				resultado = String.valueOf(dec);
			} catch (Exception e) {
				resultado = "Entrada inválida";
			}
		} else if ("decimalAbinario".equals(operacion)) {
			descripcion = "Cálculo de número decimal a binario";
			try {
				int dec = Integer.parseInt(numero);
				resultado = Integer.toBinaryString(dec);
			} catch (Exception e) {
				resultado = "Entrada inválida";
			}
		} else {
			descripcion = "Operación desconocida";
			resultado = "Operación no seleccionada";
		}
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang='es'>");
		out.println("<head>");
		out.println("  <meta charset='UTF-8'>");
		out.println("  <meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.println("  <title>Resultado - Conversión Binaria</title>");
		out.println("  <link rel='stylesheet' href='css/styles.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='formulario'>");
		out.println("  <h1>✅ Resultado de Conversión Binaria</h1>");
		out.println("  <h3 style='color:#5b9eff;margin-top:24px;'>" + descripcion + "</h3>");
		out.println("  <table>");
		out.println("    <tr><th>Entrada</th><th>Respuesta</th></tr>");
		out.println("    <tr><td>" + escapar(numero) + "</td><td><strong>" + escapar(resultado) + "</strong></td></tr>");
		out.println("  </table>");
		out.println("  <div class='acciones' style='margin-top:32px;justify-content:center;'>");
		out.println("    <a class='boton' href='binario.html'>🔄 Realizar otra conversión</a>");
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

