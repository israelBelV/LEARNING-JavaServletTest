package transformationWebService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
}