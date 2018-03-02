MailboxValidator Java Class
============================

This Java class provides an easy way to call the MailboxValidator API which validates if an email address is a valid one.

This class can be used in many types of projects such as:

 - validating a user's email during sign up
 - cleaning your mailing list prior to an email marketing campaign
 - a form of fraud check

Installation
============

To compile this class type the following:

```
javac com\mailboxvalidator\*.java
jar cf mailboxvalidator.jar com\mailboxvalidator\*.class
```

Dependencies
============

An API key is required for this class to function.

Go to https://www.mailboxvalidator.com/plans#api to sign up for a FREE API plan and you'll be given an API key.

Usage
=====

```java
import com.mailboxvalidator.*;

public class Main 
{
	public Main() 
	{
	}
	
	public static void main(String[] args) 
	{
		try
		{
			SingleValidation mbv = new SingleValidation("PASTE_YOUR_API_KEY_HERE");
			MBVResult rec = mbv.ValidateEmail("example@example.com");
			// System.out.println(rec); // for dumping out all result fields
			
			if (rec.getErrorMessage().equals("")) {
				System.out.println("email_address: " + rec.getEmailAddress());
				System.out.println("domain: " + rec.getDomain());
				System.out.println("is_free: " + rec.getIsFree());
				System.out.println("is_syntax: " + rec.getIsSyntax());
				System.out.println("is_domain: " + rec.getIsDomain());
				System.out.println("is_smtp: " + rec.getIsSMTP());
				System.out.println("is_verified: " + rec.getIsVerified());
				System.out.println("is_server_down: " + rec.getIsServerDown());
				System.out.println("is_greylisted: " + rec.getIsGreylisted());
				System.out.println("is_disposable: " + rec.getIsDisposable());
				System.out.println("is_suppressed: " + rec.getIsSuppressed());
				System.out.println("is_role: " + rec.getIsRole());
				System.out.println("is_high_risk: " + rec.getIsHighRisk());
				System.out.println("is_catchall: " + rec.getIsCatchall());
				System.out.println("mailboxvalidator_score: " + rec.getMailboxValidatorScore());
				System.out.println("time_taken: " + rec.getTimeTaken());
				System.out.println("status: " + rec.getStatus());
				System.out.println("credits_available: " + rec.getCreditsAvailable());
			}
			else {
				System.out.println("error_code: " + rec.getErrorCode());
				System.out.println("error_message: " + rec.getErrorMessage());
			}
			System.out.println("version: " + rec.getVersion());
		}
		catch(Exception e)
		{
			e.printStackTrace(System.out);
		}
	}
}
```

Functions
=========

### SingleValidation(api_key)

Creates a new instance of the MailboxValidator object with the API key.

### ValidateEmail(email_address)

Performs email validation on the supplied email address.

Result Fields
=============

### email_address

The input email address.

### domain

The domain of the email address.

### is_free

Whether the email address is from a free email provider like Gmail or Hotmail.

Return values: True, False

### is_syntax

Whether the email address is syntactically correct.

Return values: True, False

### is_domain

Whether the email address has a valid MX record in its DNS entries.

Return values: True, False, -&nbsp;&nbsp;&nbsp;(- means not applicable)

### is_smtp

Whether the mail servers specified in the MX records are responding to connections.

Return values: True, False, -&nbsp;&nbsp;&nbsp;(- means not applicable)

### is_verified

Whether the mail server confirms that the email address actually exist.

Return values: True, False, -&nbsp;&nbsp;&nbsp;(- means not applicable)

### is_server_down

Whether the mail server is currently down or unresponsive.

Return values: True, False, -&nbsp;&nbsp;&nbsp;(- means not applicable)

### is_greylisted

Whether the mail server employs greylisting where an email has to be sent a second time at a later time.

Return values: True, False, -&nbsp;&nbsp;&nbsp;(- means not applicable)

### is_disposable

Whether the email address is a temporary one from a disposable email provider.

Return values: True, False, -&nbsp;&nbsp;&nbsp;(- means not applicable)

### is_suppressed

Whether the email address is in our blacklist.

Return values: True, False, -&nbsp;&nbsp;&nbsp;(- means not applicable)

### is_role

Whether the email address is a role-based email address like admin@example.net or webmaster@example.net.

Return values: True, False, -&nbsp;&nbsp;&nbsp;(- means not applicable)

### is_high_risk

Whether the email address contains high risk keywords.

Return values: True, False, -&nbsp;&nbsp;&nbsp;(- means not applicable)

### is_catchall

Whether the email address is a catch-all address.

Return values: True, False, Unknown, -&nbsp;&nbsp;&nbsp;(- means not applicable)

### mailboxvalidator_score

Email address reputation score.

Score > 0.70 means good; score > 0.40 means fair; score <= 0.40 means poor.

### time_taken

The time taken to get the results in seconds.

### status

Whether our system think the email address is valid based on all the previous fields.

Return values: True, False

### credits_available

The number of credits left to perform validations.

### error_code

The error code if there is any error. See error table below.

### error_message

The error message if there is any error. See error table below.

Errors
======

| error_code | error_message |
| ---------- | ------------- |
| 100 | Missing parameter. |
| 101 | API key not found. |
| 102 | API key disabled. |
| 103 | API key expired. |
| 104 | Insufficient credits. |
| 105 | Unknown error. |

Copyright
=========

Copyright (C) 2018 by MailboxValidator.com, support@mailboxvalidator.com
