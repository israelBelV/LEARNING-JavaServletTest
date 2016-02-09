package transformationWebService;

import java.util.HashMap;
import java.util.Map;

public class IntTransformation implements Transformation {
	private int intValue;

	public IntTransformation(int value) {
		intValue = value;
	}

	@Override
	public Object getOriginal() {
		return new Integer(intValue);
	}

	@Override
	public Object getTransformation() {
		return Integer.toHexString(intValue);
	}

	@Override
	public Map<String, Object> getAllAsMap() {
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("original", getOriginal());
		result.put("hex", getTransformation());

		return result;
	}
}
