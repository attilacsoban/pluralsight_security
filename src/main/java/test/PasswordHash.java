package test;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import junit.framework.TestCase;

public class PasswordHash extends TestCase {

//	public void testMD5Hash(){
//		String password = "attila";
//		Md5PasswordEncoder passEncoder = new Md5PasswordEncoder();
//		String hashedPassword = passEncoder.encodePassword(password, null);
//		//System.out.println(hashedPassword);
//		
//	}
	
	public void testBCryptHash(){
		String password = "admin";
			//String password = "1234";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashedPassword = encoder.encode(password);
		System.out.println(hashedPassword);
	}
	
}
