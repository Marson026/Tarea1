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
		out.println("  <div style='background:#f0f4f8;border-left:4px solid #27ae60;padding:16px;border-radius:6px;margin-top:24px;font-size:13px;'>");
		out.println("    <strong>👥 Integrantes:</strong> Brayan Edgardo Aguilar Aguilera, Zurisaday Alvarenga Almendárez, Cristhian Roberto Illa Sánchez, Emerson Ricardo Jiménez Lorenzo, Luis Alberto Colindres Ventura, Marlón Jared Saenz Blanco<br>");
		out.println("    <strong>🔐 Cuenta:</strong> 20223456789, 2022");
		out.println("  </div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}

