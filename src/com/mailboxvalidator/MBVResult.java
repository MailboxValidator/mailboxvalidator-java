/**
* MBVResult.java
*/

package com.mailboxvalidator;

public class MBVResult {
	String email_address;
	String domain;
	String is_free;
	String is_syntax;
	String is_domain;
	String is_smtp;
	String is_verified;
	String is_server_down;
	String is_greylisted;
	String is_disposable;
	String is_suppressed;
	String is_role;
	String is_high_risk;
	String is_catchall;
	float mailboxvalidator_score;
	float time_taken;
	String status;
	int credits_available;
	String error_code;
	String error_message;
	String version = "1.0.0";
	MBVResult(String email) {
		email_address = email;
	}
/**
 * This method to get the email address being validated.
 * @return the email address being validated.
 */
	public String getEmailAddress() { return email_address; }
/**
 * This method to get the domain name of the email address.
 * @return the domain name.
 */
	public String getDomain() { return domain; }
/**
 * This method to get whether the email address is from a free email provider.
 * @return "True", "False" or "-" if not applicable.
 */
	public String getIsFree() { return is_free; }
/**
 * This method to get whether the email address is syntactically correct.
 * @return "True", "False" or "-" if not applicable.
 */
	public String getIsSyntax() { return is_syntax; }
/**
 * This method to get whether the email domain has a valid MX record in the DNS entries.
 * @return "True", "False" or "-" if not applicable.
 */
	public String getIsDomain() { return is_domain; }
/**
 * This method to get whether the mail server is responding to connection.
 * @return "True", "False" or "-" if not applicable.
 */
	public String getIsSMTP() { return is_smtp; }
/**
 * This method to get whether the mail server confirms that the email address actually exists.
 * @return "True", "False" or "-" if not applicable.
 */
	public String getIsVerified() { return is_verified; }
/**
 * This method to get whether the mail server is currently down or unresponsive.
 * @return "True", "False" or "-" if not applicable.
 */
	public String getIsServerDown() { return is_server_down; }
/**
 * This method to get whether the mail server employs greylisting.
 * @return "True", "False" or "-" if not applicable.
 */
	public String getIsGreylisted() { return is_greylisted; }
/**
 * This method to get whether the email address is from a disposable email provider.
 * @return "True", "False" or "-" if not applicable.
 */
	public String getIsDisposable() { return is_disposable; }
/**
 * This method to get whether the email address is in our blacklist.
 * @return "True", "False" or "-" if not applicable.
 */
	public String getIsSuppressed() { return is_suppressed; }
/**
 * This method to get whether the email address is a role-based email address.
 * @return "True", "False" or "-" if not applicable.
 */
	public String getIsRole() { return is_role; }
/**
 * This method to get whether the email address contains high risk keywords.
 * @return "True", "False" or "-" if not applicable.
 */
	public String getIsHighRisk() { return is_high_risk; }
/**
 * This method to get whether the email address is a catch-all address.
 * @return "True", "False" or "-" if not applicable.
 */
	public String getIsCatchall() { return is_catchall; }
/**
 * This method to get the email reputation score.
 * @return the email reputation score; score > 0.70 means good; score > 0.40 means fair; score ≤ 0.40 means poor.
 */
	public float getMailboxValidatorScore() { return mailboxvalidator_score; }
/**
 * This method to get the execution time of the API in seconds.
 * @return the time taken for the API execution in seconds.
 */
	public float getTimeTaken() { return time_taken; }
/**
 * This method to get whether our system think the email address is valid based on the various result fields.
 * @return "True", "False" or "-" if not applicable.
 */
	public String getStatus() { return status; }
/**
 * This method to get the number of remaining query credits.
 * @return the number of remaining query credits.
 */
	public int getCreditsAvailable() { return credits_available; }
/**
 * This method to get the error code.
 * @return the error code if an error occurred or blank if none.
 */
	public String getErrorCode() { return error_code; }
/**
 * This method to get the error message.
 * @return the error message if an error occurred or blank if none.
 */
	public String getErrorMessage() { return error_message; }
/**
 * This method to get component version.
 * @return the component version.
 */
	public String getVersion() { return version; }
/**
 * This method to return all the fields.
 * @return the result in a formatted string.
 */
	public String toString() {
		String NL = System.getProperty("line.separator");
		StringBuffer buf = new StringBuffer("MBVResult:"+NL);
		buf.append("\temail_address = "+email_address+NL);
		buf.append("\tdomain = "+domain+NL);
		buf.append("\tis_free = "+is_free+NL);
		buf.append("\tis_syntax = "+is_syntax+NL);
		buf.append("\tis_domain = "+is_domain+NL);
		buf.append("\tis_smtp = "+is_smtp+NL);
		buf.append("\tis_verified = "+is_verified+NL);
		buf.append("\tis_server_down = "+is_server_down+NL);
		buf.append("\tis_greylisted = "+is_greylisted+NL);
		buf.append("\tis_disposable = "+is_disposable+NL);
		buf.append("\tis_suppressed = "+is_suppressed+NL);
		buf.append("\tis_role = "+is_role+NL);
		buf.append("\tis_high_risk = "+is_high_risk+NL);
		buf.append("\tis_catchall = "+is_catchall+NL);
		buf.append("\tmailboxvalidator_score = "+mailboxvalidator_score+NL);
		buf.append("\ttime_taken = "+time_taken+NL);
		buf.append("\tstatus = "+status+NL);
		buf.append("\tcredits_available = "+credits_available+NL);
		buf.append("\terror_code = "+error_code+NL);
		buf.append("\terror_message = "+error_message+NL);
		buf.append("\tversion = "+version+NL);
		return buf.toString();
	}
}
