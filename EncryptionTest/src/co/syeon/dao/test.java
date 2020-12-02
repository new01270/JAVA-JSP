package co.syeon.dao;

public class test {

	public static void main(String[] args) {

		String pw = "password";
		String enPW = "";
		for (int i = pw.length() - 1; i >= 0; i--) {
			System.out.print(pw.charAt(i));
			enPW += (char)((int)pw.charAt(i)-3);
		}
		// String enPW = String.valueOf(change);

		System.out.println("변환 전  문자" + pw);
		System.out.println("변환 된 문자 : " + enPW);

	}

}
