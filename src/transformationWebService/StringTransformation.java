package transformationWebService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StringTransformation implements Transformation {
	private String stringValue;

	public StringTransformation(String value) {
		stringValue = value;
	}

	@Override
	public Object getOriginal() {
		return stringValue;
	}

	@Override
	public Object getTransformation() {
		String[] splittedString = stringValue.split(" ");
		
		ArrayList<String> result = new ArrayList<String>();
		
		for (String string : splittedString) {
			result.add(string);
		}
		
		Collections.sort(result);
		
		return result;
	}

	@Override
	public Map<String, Object> getAllAsMap() {
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("original", getOriginal());
		
		ArrayList<String> transformation = (ArrayList) getTransformation();
		Iterator<String> iterator = transformation.iterator();
		
		ArrayList<Object> transformationList = new ArrayList<Object>();
		 
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			Map<String, Object> value = new HashMap<String, Object>();
			value.put("word", string);
			transformationList.add(value);
		}
				
		result.put("words", transformationList);

		return result;
	}
}