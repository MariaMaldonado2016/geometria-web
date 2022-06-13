package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Rectangulo;

import java.io.IOException;


public class RectanguloControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public RectanguloControllerServlet() {
        super();
        
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// paso 1 : recuperar los valores enviados desde el formulario
		String operacion	= request.getParameter("operacion");
		String baseStr	 	= request.getParameter("base");
		String alturaStr    = request.getParameter("altura");
		
		// paso 2 : convertir al tipo de dato deseado
		int base 	= Integer.parseInt(baseStr);
		int altura  = Integer.parseInt(alturaStr); //parseInt() es un miembro de Clase (static)
		
		// PASO 3 : utilizar las clases modelos para hacer calculos o acciones
		Rectangulo rectangulo = new Rectangulo(base, altura);
		if (operacion.equalsIgnoreCase("area") ) {
			int area = rectangulo.calcularArea();//calcularArea() es un miembro de Instancia
			request.setAttribute("resultado", area );
			request.setAttribute("operacion", operacion);
	
		} else {
			int perimetro = rectangulo.calcularPerimetro();
			request.setAttribute("resultado", perimetro);
			request.setAttribute("operacion", operacion);
		}
		
		// paso 4 : Delegar a una vista para que muestres el o los resultados 
		String rutaJSP = "/WEB-INF/jsp/view/rectangulo.jsp";
		//pasamos los datos al JSP
		request.getRequestDispatcher(rutaJSP).forward(request, response);
		
		
	}
}
		// esto de aca No corresponde porque es responsanbilidad de la vista 
		
		/*response.getWriter()
		.append("Base = "+base+"\n")
		.append("Altura = "+altura);**/
	
		
	

