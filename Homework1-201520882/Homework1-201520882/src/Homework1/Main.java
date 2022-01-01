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
			System.out.println("���ϴ� �޴��� �����ϼ���.");
			System.out.println("1. ü�� �� ����");
			System.out.println("2. ü�� �� ���� ����");
			System.out.println("3. ü�� �� ����");
			System.out.println("4. ü���� ����");
			System.out.println("5. ü�� �� �̵�");
			System.out.println("6. ����");
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
			//����ϰ� ����ϰ� ������ �ּ��� Ǫ�ʽÿ�.
			
			switch(buffer)
			{
			case 1:
				board.createChessMan();
				System.out.println("ü���� ������ �Ϸ�Ǿ����ϴ�.");
				break;
			case 2:
				board.creatRandomChessMan();
				System.out.println("ü������ �����Ǿ����ϴ�.");
				break;
			case 3:
				System.out.println("������ ���ϴ� ü�� ���� ��ġ�� �Է��ϼ���. ");
				stringBuffer = input.nextLine();
				board.deleteChessMan(stringBuffer);
				break;
			case 4:
				board.drawChessBoard();
				break;
			case 5:
			    System.out.println("������ ���� ��ġ�� �Է��ϼ���.");
				stringBuffer = input.nextLine();
				System.out.println("���� �̵��� ��ġ�� �Է��ϼ���.");
				stringBuffer2 = input.nextLine();
				board.moveChessMan(stringBuffer, stringBuffer2);
				break;
			case 6: 
				isExit = true;
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
			
			if(isExit == true)break;
			
		}
		
		input.close();
		
	}
}
