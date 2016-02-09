package transformationWebServiceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import transformationWebService.StringTransformation;

public class TestStringTransformation extends TestCase {

	@Test
	public void testStringTransformation() {
		try {
			new StringTransformation("Hello, this is a test");
		} catch (Exception ex) {
			fail("Unexpected exception. Message: " + ex.getMessage());
		}
	}

	@Test
	public void testGetOriginal() {
		try {
			String strValue = "Hello, this is a test";
			StringTransformation str = new StringTransformation(strValue);
			String strOutput = (String) str.getOriginal();
			assertTrue("The string are not equal.", strValue.equals(strOutput));
		} catch (Exception ex) {
			fail("Unexpected exception. Message: " + ex.getMessage());
		}
	}

	@Test
	public void testGetTransformation() {
		try {
			String strValue = "Hello, this is a test";
			String[] strArrResult = { "Hello,", "a", "is", "test", "this" };
			StringTransformation str = new StringTransformation(strValue);
			List<String> output = (ArrayList<String>) str.getTransformation();
			
			assertTrue("The array does not have the correct length.", strArrResult.length == output.size());
			
			for (int i = 0; i < strArrResult.length; i++) {
				assertTrue("Values not properly ordered.", strArrResult[i].equals(output.get(i)));
			}
		} catch (Exception ex) {
			fail("Unexpected exception. Message: " + ex.getMessage());
		}
	}

}
