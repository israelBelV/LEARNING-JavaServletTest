package transformationWebService;



public class IntTransformation implements Transformation {
	private int intValue;

	public IntTransformation (int value) {
	intValue = value;
	}

	@Override
	public Object getOriginal () {
		return new Integer(intValue);
	}

	@Override
	public Object getTransformation () {
		return Integer.toHexString(intValue);
	}
}
