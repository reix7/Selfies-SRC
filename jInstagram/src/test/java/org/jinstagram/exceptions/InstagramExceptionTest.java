package org.jinstagram.exceptions;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * The class <code>InstagramExceptionTest</code> contains tests for the class
 * <code>{@link InstagramException}</code>.
 */
public class InstagramExceptionTest {
	/**
	 * Run the InstagramException(String) constructor test.
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testInstagramException_1() throws Exception {
		String message = "";

		InstagramException result = new InstagramException(message);

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1, result.getAPILimitStatus());
		assertEquals(-1, result.getRemainingLimitStatus());
		assertEquals(null, result.getCause());
		assertEquals("org.jinstagram.exceptions.InstagramException: ", result.toString());
		assertEquals("", result.getLocalizedMessage());
		assertEquals("", result.getMessage());
	}

	/**
	 * Run the InstagramException(String,Exception) constructor test.
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testInstagramException_2() throws Exception {
		String message = "";
		Exception e = new Exception();

		InstagramException result = new InstagramException(message, e);

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1, result.getAPILimitStatus());
		assertEquals(-1, result.getRemainingLimitStatus());
		assertEquals("org.jinstagram.exceptions.InstagramException: ", result.toString());
		assertEquals("", result.getLocalizedMessage());
		assertEquals("", result.getMessage());
	}

	/**
	 * Run the InstagramException(String,Map<String,String>) constructor test.
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testInstagramException_3() throws Exception {
		String message = "";
		Map<String, String> responseHeaders = new HashMap<String, String>();

		InstagramException result = new InstagramException(message, responseHeaders);

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1, result.getAPILimitStatus());
		assertEquals(-1, result.getRemainingLimitStatus());
		assertEquals(null, result.getCause());
		assertEquals("org.jinstagram.exceptions.InstagramException: ", result.toString());
		assertEquals("", result.getLocalizedMessage());
		assertEquals("", result.getMessage());
	}

	/**
	 * Run the InstagramException(String,Exception,Map<String,String>)
	 * constructor test.
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testInstagramException_4() throws Exception {
		String message = "";
		Exception e = new Exception();
		Map<String, String> responseHeaders = new HashMap<String, String>();

		InstagramException result = new InstagramException(message, e, responseHeaders);

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1, result.getAPILimitStatus());
		assertEquals(-1, result.getRemainingLimitStatus());
		assertEquals("org.jinstagram.exceptions.InstagramException: ", result.toString());
		assertEquals("", result.getLocalizedMessage());
		assertEquals("", result.getMessage());
	}

	/**
	 * Run the int getAPILimitStatus() method test.
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testGetAPILimitStatus_1() throws Exception {
		InstagramException fixture = new InstagramException("", new Exception(), null);

		int result = fixture.getAPILimitStatus();

		// add additional test code here
		assertEquals(-1, result);
	}

	/**
	 * Run the int getRemainingLimitStatus() method test.
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testGetRemainingLimitStatus_1() throws Exception {
		InstagramException fixture = new InstagramException("", new Exception(), null);

		int result = fixture.getRemainingLimitStatus();

		// add additional test code here
		assertEquals(-1, result);
	}

	/**
	 * Run the int getErrorType() method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetErrorType() throws Exception {
		InstagramException fixture = new InstagramException(
			"APINotAllowedError",
			"APINotAllowedError: you cannot view this resource",
			null
		);

		assertEquals("APINotAllowedError", fixture.getErrorType());
		assertEquals("APINotAllowedError: you cannot view this resource", fixture.getMessage());
	}

}