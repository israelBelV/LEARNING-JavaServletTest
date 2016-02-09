
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Map<String, String[]> parameters = request.getParameterMap();
//		Map<String, Transformation[]> transformations = new HashMap<String, Transformation[]>();
//
//		for (Map.Entry<String, String[]> parameter : parameters.entrySet()) {
//			// response.getWriter().append(parameter.getKey()).append(parameter.getValue()[0]).append('\n');
//			String[] values = parameter.getValue();
//			Transformation[] transformationValue = new Transformation[values.length];
//			for (int i = 0; i < values.length; i++) {
//				if (Pattern.matches("^\\d+$", values[i]))
//					transformationValue[i] = new IntTransformation(Integer.parseInt(values[i]));
//				else
//					transformationValue[i] = new StringTransformation(values[i]);
//			}
//
//			transformations.put(parameter.getKey(), transformationValue);
//		}
//
//		for (Entry<String, Transformation[]> parameter : transformations.entrySet()) {
//			response.getWriter().append(parameter.getKey()).append('\n');
//			for (Transformation value : parameter.getValue())
//				response.getWriter().append('\t' + value.getTransformation().toString()).append('\n');
//		}

		Map<String, String[]> parameters = request.getParameterMap();
		Map<String, Object> formattedParameters = new HashMap<>();

		for (Map.Entry<String, String[]> parameter : parameters.entrySet()) {
			// response.getWriter().append(parameter.getKey()).append(parameter.getValue()[0]).append('\n');
			String[] values = parameter.getValue();
			Object finalValue;
			if (values.length == 1) {
				
				String value = values[0];
				Transformation transformation;
				
				if (Pattern.matches("^\\d+$", value))
					transformation = new IntTransformation(Integer.parseInt(value));
				else
					transformation = new StringTransformation(value);
				
				formattedParameters.put(parameter.getKey(), transformation.getAllAsMap());
			} else if (values.length > 1) {

				ArrayList<Object> transformationValue = new ArrayList<Object>();
				for (int i = 0; i < values.length; i++) {
					String value = values[i];
					Transformation transformation;
					
					if (Pattern.matches("^\\d+$", value))
						transformation = new IntTransformation(Integer.parseInt(value));
					else
						transformation = new StringTransformation(value);
					
					transformationValue.add(transformation.getAllAsMap());		
				}
				

				formattedParameters.put(parameter.getKey(), transformationValue);
			}
		}

		response.getWriter().append("\n\n" + JSONValue.toJSONString(formattedParameters));

	}

}
