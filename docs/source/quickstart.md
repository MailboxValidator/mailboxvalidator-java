# Quickstart

## Dependencies

An API key is required for this module to function.

Go to [https://www.mailboxvalidator.com/plans#api](https://www.mailboxvalidator.com/plans#api) to sign up for FREE API plan and you'll be given an API key.

## Installation

To use this module in your Java project, you can visit [https://central.sonatype.com/artifact/com.mailboxvalidator/mailboxvalidator-java/overview](https://central.sonatype.com/artifact/com.mailboxvalidator/mailboxvalidator-java/overview) to copy the corrensponding code to your building tool.

## Sample Codes

### Validate email

You can validate whether an email address is invalid or not as below:

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
			
			if (rec.getErrorMessage() == null) {
				System.out.println("email_address: " + rec.getEmailAddress());
				System.out.println("base_email_address: " + rec.getBaseEmailAddress());
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
				System.out.println("is_dmarc_enforced: " + rec.getIsDMARCEnforced());
				System.out.println("is_strict_spf: " + rec.getIsStrictSPF());
				System.out.println("website_exist: " + rec.getWebsiteExist());
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

### Check if an email is from a disposable email provider

You can validate whether an email address is disposable email address or not as below:

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
			MBVResult rec = mbv.DisposableEmail("example@example.com");
			// System.out.println(rec); // for dumping out all result fields
			
			if (rec.getErrorMessage() == null) {
				System.out.println("email_address: " + rec.getEmailAddress());
				System.out.println("is_disposable: " + rec.getIsDisposable());
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

### Check if an email is from a free email provider

You can validate whether an email address is free email address or not as below:

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
			MBVResult rec = mbv.FreeEmail("example@example.com");
			// System.out.println(rec); // for dumping out all result fields
			
			if (rec.getErrorMessage() == null) {
				System.out.println("email_address: " + rec.getEmailAddress());
				System.out.println("is_free: " + rec.getIsFree());
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
