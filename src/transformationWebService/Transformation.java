package transformationWebService;

import java.util.Map;

public interface Transformation {

	public Object getOriginal();
	public Object getTransformation();
	public Map<String, Object> getAllAsMap();
}
