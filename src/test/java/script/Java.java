package script;

import java.util.Scanner;

public class Java {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("please enter a language:\n1.kannada\n2.telugu");
		int language=sc.nextInt();
		sc.close();
//		if(language==1)
//		{
//			System.out.println("you have selected: kananda");
//		}
//		else if (language==2)
//		{
//			System.out.println("you have selected: telugu");
//		}
//		else
//		{
//			System.out.println("invalid input");
//		}
		switch (language) {
		case 1:System.out.println("you have selected: kananda");
			break;
		case 2:System.out.println("you have selected: telugu");
			break;
		default:System.out.println("invalid input");
			break;
		}
		System.out.println("thank you");
	}

}
