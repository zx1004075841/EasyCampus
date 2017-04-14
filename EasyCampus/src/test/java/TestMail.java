import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.easycampus.utils.EmailUtil;

public class TestMail {

	public static void main(String[] a){
		EmailUtil emailUtil = new EmailUtil();
		try {
			emailUtil.sendToOne("test", "你好", "15771755096@163.com");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
