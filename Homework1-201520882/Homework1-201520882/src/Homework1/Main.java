package Homework1;
import java.util.Scanner;



public class Main 
{
	
	public static void clearConsole()
	{
		for(int i =0; i<80; i++) System.out.println("");
	}
	
	public static void main(String[] args)
	{
		int buffer;
		String stringBuffer, stringBuffer2;
		boolean isExit = false;
		Scanner input = new Scanner(System.in);
		ChessBoard board = new ChessBoard();
		
		while(true)
		{	
			System.out.println("\n<Ajou Chess Board>\n");		
			System.out.println("원하는 메뉴를 선택하세요.");
			System.out.println("1. 체스 말 생성");
			System.out.println("2. 체스 말 랜덤 생성");
			System.out.println("3. 체스 말 삭제");
			System.out.println("4. 체스판 보기");
			System.out.println("5. 체스 말 이동");
			System.out.println("6. 종료");
			System.out.print(">> ");
			
			try
			{
			stringBuffer = input.nextLine();
			buffer = Integer.parseInt(stringBuffer);
			}
			catch(NumberFormatException e)
			{
				buffer = -1;
			}
			
			//clearConsole();
			//깔끔하게 출력하고 싶으면 주석을 푸십시오.
			
			switch(buffer)
			{
			case 1:
				board.createChessMan();
				System.out.println("체스말 생성이 완료되었습니다.");
				break;
			case 2:
				board.creatRandomChessMan();
				System.out.println("체스판이 생성되엇습니다.");
				break;
			case 3:
				System.out.println("삭제를 원하는 체스 말의 위치를 입력하세요. ");
				stringBuffer = input.nextLine();
				board.deleteChessMan(stringBuffer);
				break;
			case 4:
				board.drawChessBoard();
				break;
			case 5:
			    System.out.println("움직일 말의 위치를 입력하세요.");
				stringBuffer = input.nextLine();
				System.out.println("말을 이동할 위치를 입력하세요.");
				stringBuffer2 = input.nextLine();
				board.moveChessMan(stringBuffer, stringBuffer2);
				break;
			case 6: 
				isExit = true;
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
			
			if(isExit == true)break;
			
		}
		
		input.close();
		
	}
}
