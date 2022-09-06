package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//빈이  하나만 있을 때는 바로 맞춰 준다. 하지만 두개 이상이라면 
 @Component 
 public class Encoder {
	 //(추상화 과정) 
	 private IEncoder iEncoder;
	 // DI 라는 개념을 추가 하면 외부에서 주입을 시켜준다.
	 // @Qualifier - 클래스 이름을 소문자로 사용 또는 빈 객체의 @Component("이름지정가능")
	 public Encoder(@Qualifier("urlEncoder") IEncoder iEncoder) {
		this.iEncoder = iEncoder; 
	}
	public IEncoder getiEncoder() {
		return iEncoder;
	}
	public void setiEncoder(IEncoder iEncoder) {
		this.iEncoder = iEncoder;
	}
	public String encode(String messag) {
		return iEncoder.encode(messag);
	}
}

// 또 다른 방법
// 만약 두개의 Encoder 를 사용하고 싶다면 어떻게 해야 할까???
// Configuration - 하나의 클래스에서 여러개의 빈들 등록할 때 사용한다. 
@Configuration // 내부에 들어가면 component 가 선언 되어 있다. 
class AppConfig {
	// encoder 이름이 동일하기 때문에 따로 설정해 주면 된다. 
	@Bean("myBase64Encode")
	public Encoder encoder(Base64Encoder base64Encoder) {
		return new Encoder(base64Encoder);
	}
	
	// 주의 : 스프링 컨테이너에 올라가 객체들 중 이름이 같다면 충돌이 발생 
	@Bean("urlEncod")
	public Encoder encoder(UrlEncoder urlEncoder) {
		return new Encoder(urlEncoder);
	}
	
}




