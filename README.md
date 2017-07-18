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

Go to http://www.mailboxvalidator.com/plans#api to sign up for a FREE API plan and you'll be given an API key.

Sample Usage
============

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

Copyright
=========

Copyright (C) 2017 by MailboxValidator.com, support@mailboxvalidator.com
