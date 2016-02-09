

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.dsig.Transform;

import transformationWebService.IntTransformation;
import transformationWebService.StringTransformation;
import transformationWebService.Transformation;

/**
 * Servlet implementation class TransformationWebService
 */
@WebServlet("/transform")
public class TransformationWebService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransformationWebService() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Map<String, String[]> parameters = request.getParameterMap();
		Map<String, Transformation[]> transformations = new HashMap<String, Transformation[]>();
		
		for (Map.Entry<String, String[]> parameter : parameters.entrySet()) {
//			response.getWriter().append(parameter.getKey()).append(parameter.getValue()[0]).append('\n');
			String[] values = parameter.getValue();
			Transformation[] transformationValue = new Transformation[values.length];
			for (int i = 0; i < values.length; i++)
			{
				if (Pattern.matches("^\\d+$", values[i]))
					transformationValue[i] = new IntTransformation(Integer.parseInt(values[i]));
				else
					transformationValue[i] = new StringTransformation(values[i]);
			}
			
			transformations.put(parameter.getKey(), transformationValue);
		}
		
		
		for (Entry<String, Transformation[]> parameter : transformations.entrySet()) {
			response.getWriter().append(parameter.getKey()).append('\n');
			for(Transformation value: parameter.getValue())
				response.getWriter().append('\t' + value.getTransformation().toString()).append('\n');
		}
		
	}

}
