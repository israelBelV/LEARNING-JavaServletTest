package transformationWebServiceTest;

import org.junit.Test;
import junit.framework.TestCase;
import transformationWebService.IntTransformation;

public class TestIntTransformation extends TestCase {

	@Test
	public void testIntTransformation() {
		try {
			new IntTransformation(3);
		} catch (Exception ex) {
			fail("Unexpected exception. Message: " + ex.getMessage());
		}
	}

	@Test
	public void testGetOriginal() {
		try {
			int value = 3;
			IntTransformation intTransform = new IntTransformation(value);
			Integer intValue = (Integer) intTransform.getOriginal();
			assertTrue("Failed test, not valid integer value.", intValue.intValue() == value);
		} catch (Exception ex) {
			fail("Unexpected exception. Message: " + ex.getMessage());
		}
	}

	@Test
	public void testGetTransformation() {
		try {
			int value = 131;
			IntTransformation intTransform = new IntTransformation(value);
			String strVal = (String) intTransform.getTransformation();
			assertTrue("Failed test, not valid hex value.", "83".equals(strVal));
		} catch (Exception ex) {
			fail("Unexpected exception. Message: " + ex.getMessage());
		}
	}

}
