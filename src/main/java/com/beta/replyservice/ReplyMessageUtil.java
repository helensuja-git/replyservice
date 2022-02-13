package com.beta.replyservice;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

public class ReplyMessageUtil {
	/**
	 * final variable containing the allowed rules, if new rules are added we can
	 * simple add them here.
	 */
	private final static List<String> RULES_LIST = Arrays.asList(new String[] { "1", "2" });

	/**
	 * Method: splitMessage This method takes the input string and splits it into 2
	 * using hyphen separator.
	 * 
	 * @param message
	 * @return String[] array
	 */
	public static String[] splitMessage(String message) {
		String[] array = null;
		if (null != message && message.length() > 0 && message.contains("-")) {
			array = message.split("-");
		}
		return array;
	}

	/**
	 * Method: isValidMessage 
	 * This method takes the input string and validates it
	 * based on given requirements.
	 * 
	 * @param message
	 * @return boolean
	 */
	public static boolean isValidMessage(String message) {
		if (message == null || message.length() == 0) {
			// when Message is empty
			return false;
		}
		if (countHyphens(message) > 1) {
			// when message has more than one hyphen
			return false;
		}
		if (splitMessage(message).length != 2) {
			// when message has less than 2 parts separated by hyphen
			return false;
		} else {
			String rules[] = splitMessage(message)[0].split("");
			if (rules.length != 2) {
				// when there is less than two rules in message
				return false;
			} else {
				for (String s : rules) {
					if (!RULES_LIST.contains(s)) {
						// when rules in message is not found in the set rules list -> 1,2
						return false;
					}
				}
			}
			
		}
		return true;
	}

	/**
	 * Method: countHyphens 
	 * This method takes the input string and counts the no. 
	 * of hyphens in the string.
	 * 
	 * @param input
	 * @return
	 */
	private static long countHyphens(String input) {
		long count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '-') {
				count++;
			}
		}
		return count;
	}

	/**
	 * Method: reverseString 
	 * This method takes the input string and reverses it.
	 * 
	 * @param input
	 * @return
	 */
	public static String reverseString(String input) {
		String reverse = "";
		char ch;
		for (int i = 0; i < input.length(); i++) {
			ch = input.charAt(i);
			reverse = ch + reverse;
		}
		return reverse;
	}

	/**
	 * Method: md5Hashing 
	 * This method takes the input string and encodes it
	 * using MD5.
	 * 
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String md5Hashing(String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(input.getBytes());
		byte[] digest = md.digest();
		String md5Hash = DatatypeConverter.printHexBinary(digest).toLowerCase();
		return md5Hash;
	}
}
