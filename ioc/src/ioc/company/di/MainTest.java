package ioc.company.di;

public class MainTest {

	public static void main(String[] args) {
		
		String url = "www.naver.com/news/it?page=10&name=ytn";
		
		// 1. Base64
		// Encoder encoder = new Encoder(); 
		// String result = encoder.encode(url); 
		// System.out.println(result);
		
		// 추가 요청 
		// 2. url Encoder 
//		UrlEncoder urlEncoder = new UrlEncoder(); 
//		String urlResult = urlEncoder.encode(url);
//		System.out.println(urlResult);
		
		
		// 3. 또 다른 변경 사항이 나왔다면 
		// 추상화 과정을 거쳐야 한다. 
		// IEncoder iEncoder1 = new Base64Encoder(); // 
		// IEncoder iEncoder2 = new UrlEncoder(); // 
		// 다형성으로 가능 
		
		// 4. 진화 과정 (포함 관계로 만들어 버리기) 
		// 주입하는 객체만 변경하게 된다면 Encoder에 내부 본질을 안 건들여도 된다. 
		// url 
		// Encoder encoder2 = new Encoder(new UrlEncoder());
		// base64 
		Encoder encoder2 = new Encoder(new Base64Encoder());
		String diResult =  encoder2.encode(url);
		System.out.println(diResult);
		
		// 외부에서 주입 받는 형태를 DI라고 한다. 
		// 아직 까지도 개발자가 관여 하고 있다 
	}

}
