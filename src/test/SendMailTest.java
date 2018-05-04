package test;

import plast.org.ua.upu.sendemail.SendEmailAdvert;

public class SendMailTest {
	public static void main(String[] args) {
		SendEmailAdvert emailAdvert = new SendEmailAdvert("techniclsuport@gmail.com", "@ctiv@tion");
		emailAdvert.send("asdasd", "asdasd", "vasylshvv@gmail.com", "vasylshvv@gmail.com");
	}
}
