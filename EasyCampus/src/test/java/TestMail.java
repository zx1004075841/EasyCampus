import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.easycampus.utils.EmailUtil;

public class TestMail {

	public static void main(String[] a){
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString().replaceAll("-", "").length());
	}
}
