package ioc.company.di;

import java.util.Base64;


 public class Encoder {

	 //(추상화 과정) 
	 private IEncoder iEncoder;
	 
	 // DI 라는 개념을 추가 하면 외부에서 주입을 시켜준다. 
	 public Encoder(IEncoder iEncoder) {
		this.iEncoder = iEncoder; 
	}
		 
	public String encode(String messag) {
		return iEncoder.encode(messag);
		// return Base64.getEncoder().encodeToString(messag.getBytes());
	}

}
