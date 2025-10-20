import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		int input;
		
		try {
			System.out.println("키보드에서 문자를 입력하세요 (종료하려면 Ctrl+Z 또는 Ctrl+C):");
			
			while ((input = System.in.read()) != -1) {
				// 읽은 문자를 에코 프린팅
				System.out.print((char) input);
				
				// Enter 키 입력 시 새 줄로 이동
				if (input == '\n') {
					System.out.flush();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}