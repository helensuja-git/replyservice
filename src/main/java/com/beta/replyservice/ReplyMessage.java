package com.beta.replyservice;

/**
 * @author Helen Suja
 *
 */
public class ReplyMessage {

	private final String message;
	private String statusCode;
	private final String ONE = "1";
	private final String TWO = "2";
	
	public ReplyMessage(String message) {
		this.message = getReplyMessage(message);
	}

	public String getMessage() {
		return message;
	}
	
	public String getstatusCode() {
		return statusCode;
	}

	/**
	 * Method:getReplyMessage This method takes the input string and applies the
	 * rules and send back the reply.
	 * 
	 * @param String message - input message from URL
	 * @return String reply message after applying rules
	 */
	private String getReplyMessage(String message) {
		String reply = "";
		try {
			if (ReplyMessageUtil.isValidMessage(message)) {
				String rules[] = ReplyMessageUtil.splitMessage(message)[0].split("");
				reply = ReplyMessageUtil.splitMessage(message)[1];
				for (String ruleNumber : rules) {
					switch (ruleNumber) {
					case ONE:
						// reverse the given string
						reply = ReplyMessageUtil.reverseString(reply);
						break;
					case TWO:
						// encode the given string using MD5 hashing algorithm
						reply = ReplyMessageUtil.md5Hashing(reply);
						break;
					default:

					}
				}
				statusCode = "200";
			} else {
				reply = "Invalid Input.";
				statusCode = "400";
			}

		} catch (Exception e) {
			reply = "Invalid Input.";
			statusCode = "400";
		}
		return reply;
	}

}