package org.jinstagram.utils;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jinstagram.auth.model.OAuthConstants;

/**
 * Utils for checking preconditions and invariants
 */
public class Preconditions {
	private static final String DEFAULT_MESSAGE = "Received an invalid parameter";

	private static final Pattern URL_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+");
	private static final Pattern LAT_LONG_PATTERN = Pattern.compile("(-)?[0-9]+(\\.)?[0-9]*");
	private static final Pattern NUMERIC_PATTERN = Pattern.compile("[0-9]+");

	/**
	 * Checks that an object is not null.
	 *
	 * @param object   any object
	 * @param errorMsg error message
	 * @throws IllegalArgumentException if the object is null
	 */
	public static void checkNotNull(Object object, String errorMsg) {
		check(object != null, errorMsg);
	}

	/**
	 * Checks that at least one of object1 or object2 is not null
	 *
	 * @param object1 any object
	 * @param object2 any object
	 * @param errorMsg error message
	 * @throws IllegalArgumentException if both object1 and object2 are null
	 */
	public static void checkBothNotNull(Object object1, Object object2, String errorMsg) {
		check(!(object1 == null && object2 == null), errorMsg);
	}

	/**
	 * Checks that a string is not null or empty
	 * @param string   any string
	 * @param errorMsg error message
	 * @throws IllegalArgumentException if the string is null or empty
	 */
	public static void checkEmptyString(String string, String errorMsg) {
		check(StringUtils.isNotBlank(string), errorMsg);
	}

	/**
	 * Checks that a URL is valid
	 *
	 * @param url      any string
	 * @param errorMsg error message
	 */
	public static void checkValidUrl(String url, String errorMsg) {
		checkEmptyString(url, errorMsg);
		check(isUrl(url), errorMsg);
	}

	/**
	 * Checks that a URL is a valid OAuth callback
	 *
	 * @param url      any string
	 * @param errorMsg error message
	 */
	public static void checkValidOAuthCallback(String url, String errorMsg) {
		checkEmptyString(url, errorMsg);

		if (url.toLowerCase().compareToIgnoreCase(OAuthConstants.OUT_OF_BAND) != 0) {
			check(isUrl(url), errorMsg);
		}
	}

	/**
	 * Checks that a string is a valid longitude or latitude value ('lat' and 'lng') 
	 * as shown in <a href="http://instagram.com/developer/realtime/">Instagram Developer real time section</a>
	 * 
	 * @param latOrLong any string
	 * @param errorMsg error message
	 */
	public static void checkValidLatLong(String latOrLong, String errorMsg) {
		checkEmptyString(latOrLong, errorMsg);
		check(isLatLong(latOrLong), errorMsg);
	}

	/**
	 * Check that a string is a valid radius value ('radius') 
	 * as shown in <a href="http://instagram.com/developer/realtime/">Instagram Developer real time section</a>
	 * 
	 * @param radiusString any string that is supposed to be a radius
	 * @param errorMsg error message
	 */
	public static void checkValidRadius(String radiusString, String errorMsg) {
		checkEmptyString(radiusString, errorMsg);
		check(isNumeric(radiusString), errorMsg);
	}

	private static boolean isUrl(String url) {
		return URL_PATTERN.matcher(url).matches();
	}

	private static boolean isLatLong(String latOrLong) {
		return LAT_LONG_PATTERN.matcher(latOrLong).matches();
	}

	private static boolean isNumeric(String numericString) {
		return NUMERIC_PATTERN.matcher(numericString).matches();
	}

	private static void check(boolean requirements, String error) {
		String message = StringUtils.isBlank(error) ? DEFAULT_MESSAGE : error;

		if (!requirements) {
			throw new IllegalArgumentException(message);
		}
	}
}
