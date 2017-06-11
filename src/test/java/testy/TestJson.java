package testy;

import com.styloop.common.util.TestYUtil;
import com.styloop.model.Usuario;

public class TestJson {
public static void main(String[] args) {
	try {
		System.out.println(TestYUtil.convertToJson(new Usuario()));
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	
}
}
