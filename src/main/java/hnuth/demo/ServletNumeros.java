package hnuth.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "numeros", value = "/numeros")
public class ServletNumeros extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String operacion = request.getParameter("operacion");
        String n1 = request.getParameter("n1");
        String n2 = request.getParameter("n2");
        String n3 = request.getParameter("n3");
        String lista = request.getParameter("numeros");
        String descripcion = "";
        String resultado = "";
        if ("mayor".equals(operacion)) {
            descripcion = "Encontrar el mayor de 3 números";
            try {
                int a = Integer.parseInt(n1);
                int b = Integer.parseInt(n2);
                int c = Integer.parseInt(n3);
                int mayor = Math.max(a, Math.max(b, c));
                resultado = String.valueOf(mayor);
            } catch (Exception e) {
                resultado = "Entrada inválida";
            }
        } else if ("menor".equals(operacion)) {
            descripcion = "Encontrar el menor de 3 números";
            try {
                int a = Integer.parseInt(n1);
                int b = Integer.parseInt(n2);
                int c = Integer.parseInt(n3);
                int menor = Math.min(a, Math.min(b, c));
                resultado = String.valueOf(menor);
            } catch (Exception e) {
                resultado = "Entrada inválida";
            }
        } else if ("masRepetido".equals(operacion)) {
            descripcion = "Encontrar el valor que más se repita";
            try {
                List<Integer> nums = new ArrayList<>();
                if (lista != null && !lista.trim().isEmpty()) {
                    String[] partes = lista.split("[,;\\s]+");
                    for (String p : partes) {
                        nums.add(Integer.parseInt(p));
                    }
                }
                if (nums.isEmpty()) {
                    resultado = "Entrada inválida";
                } else {
                    Map<Integer, Integer> freq = new HashMap<>();
                    for (int v : nums) freq.put(v, freq.getOrDefault(v, 0) + 1);
                    int mejor = nums.get(0);
                    int maxf = 0;
                    for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                        int val = e.getKey();
                        int f = e.getValue();
                        if (f > maxf || (f == maxf && val < mejor)) {
                            mejor = val;
                            maxf = f;
                        }
                    }
                    resultado = String.valueOf(mejor);
                }
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
        out.println("  <title>Resultado - Análisis de Números</title>");
        out.println("  <link rel='stylesheet' href='css/styles.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='formulario'>");
        out.println("  <h1>✅ Resultado del Análisis</h1>");
        out.println("  <h3 style='color:#5b9eff;margin-top:24px;'>" + descripcion + "</h3>");
        out.println("  <table>");
        out.println("    <tr><th>Entrada</th><th>Respuesta</th></tr>");
        String entrada = "";
        if ("mayor".equals(operacion) || "menor".equals(operacion)) entrada = "n1=" + n1 + ", n2=" + n2 + ", n3=" + n3;
        else entrada = lista;
        out.println("    <tr><td>" + escapar(entrada) + "</td><td><strong>" + escapar(resultado) + "</strong></td></tr>");
        out.println("  </table>");
        out.println("  <div class='acciones' style='margin-top:32px;justify-content:center;'>");
        out.println("    <a class='boton' href='numeros.html'>🔄 Realizar otro análisis</a>");
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

    private String escapar(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;");
    }
}


