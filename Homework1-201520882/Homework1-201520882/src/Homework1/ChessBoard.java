package Homework1;

public class ChessBoard
{
	//ü������ �� �ϳ��̱⿡ static���� �����ϴ°� �̻����̳�, �ϴ� private���� ����� �����϶�� ������ �ɷ��־ �Ϲ� Ŭ������ ����.
	private ChessMan[][] chessBoard = new ChessMan[10][10];
	
	//�ٸ� ���� ���� �̵� ��ΰ� �����ִ��� �Ǻ��ϴ� �Լ�.
	private boolean isBlocked(Position current, Position next)
	{
		//��������� ������ ���
		if(current.getX() == next.getX())
		{
			if(current.getY() > next.getY()) //�Ʒ��� ���� ���
			{
				for(int i =1; i< Math.abs(next.getY() - current.getY()) ; i++)
					if(chessBoard[current.getY()-i][current.getX()] != null) return false;
			}
			else //���ΰ�  ���� ���
			{
				for(int i =1; i< Math.abs(next.getY() - current.getY()) ; i++)
					if(chessBoard[current.getY()+i][current.getX()] != null) return false;
			}
		}
		else if(current.getY() == next.getY()) //���� ������ ������ ���
		{
			if(current.getX() > next.getX()) //�������� ���� ���
			{
				for(int i =1; i< Math.abs(next.getX() - current.getX()) ; i++)
					if(chessBoard[current.getY()][current.getX()-i] != null) return false;
			}
			else //���������� ���� ���
			{
				for(int i =1; i< Math.abs(next.getX() - current.getX()) ; i++)
					if(chessBoard[current.getY()][current.getX()+i] != null) return false;
			}
		}
		else if(Math.abs(next.getX() - current.getX()) == Math.abs(next.getY() - current.getY()))
		{
			if(current.getX() > next.getX() && current.getY() < next.getY() ) //�ϼ�����
			{
				for(int i = 1; i < Math.abs(current.getX() - next.getX()); i++)
					if(chessBoard[current.getY() +i][current.getX()-i] != null) return false;
			}
			else if(current.getX() < next.getX() && current.getY() < next.getY() ) //�ϵ�����
			{
				for(int i = 1; i < Math.abs(current.getX() - next.getX()); i++)
					if(chessBoard[current.getY()+i][current.getX()+i] != null) return false;
			}
			else if(current.getX() > next.getX() && current.getY() > next.getY() ) //��������
			{
				for(int i = 1; i < Math.abs(current.getX() - next.getX()); i++)
					if(chessBoard[current.getY()-i][current.getX()-i] != null) return false;
			}
			else if(current.getX() < next.getX() && current.getY() > next.getY() ) //��������
			{
				for(int i = 1; i < Math.abs(current.getX() - next.getX()); i++)
					if(chessBoard[current.getY()-i][current.getX()+i] != null) return false;
			}
			
		}//��������� �밢���� ���  ���� �ϼ� �ϵ� ���� ����
		
		return true;
	}
	
	//ü������ ������ ����� �Լ�
	private void clearChessBoard()
	{
		for(int i =0; i< 10; i++)
			for(int j = 0; j<10; j++)
				chessBoard[i][j] = null;
	}
	
	public void drawChessBoard()
	{
		
		
		for(int i =9; i >=0; i--)
		{
			for(int j = 0; j<10; j++)
			{
				if(chessBoard[i][j] == null) 
				{
					if(j % 2 == 0)
					{
						if(i%2 == 0) System.out.print("1  ");
						else System.out.print("0  ");
					}
					else
					{
						if(i%2 == 0) System.out.print("0  ");
						else System.out.print("1  ");
					}
				}
				else
				{
					if(chessBoard[i][j] instanceof Pawn) System.out.print("P");
					if(chessBoard[i][j] instanceof Rook) System.out.print("R");
					if(chessBoard[i][j] instanceof Knight) System.out.print("N");
					if(chessBoard[i][j] instanceof Bishop) System.out.print("B");
					if(chessBoard[i][j] instanceof King) System.out.print("K");
					if(chessBoard[i][j] instanceof Queen) System.out.print("Q");
					
					if(chessBoard[i][j].getcamp() == false) System.out.print("0 ");
					else System.out.print("1 ");
				}
				
			}
			System.out.println("");
		}
	}
	
	public void deleteChessMan(String s)
	{
		Position p;
		try
		{
			p = new Position(s);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		}
		
		if(chessBoard[p.getY()][p.getX()] == null)
		{
			System.out.println("�ش� ��ġ�� ü�� ���� �����ϴ�.");
		}
		else
		{
			chessBoard[p.getY()][p.getX()] = null;
			System.out.println("ü�� ���� �����Ǿ����ϴ�.");
		}
	}
	
	public void createChessMan()
	{
		clearChessBoard();
		
		for(int i = 0; i<10 ;i++) chessBoard[1][i] = new Pawn(false);
		
		chessBoard[0][0] = new Pawn(false);
		chessBoard[0][1] = new Rook(false);
		chessBoard[0][2] = new Knight(false);
		chessBoard[0][3] = new Bishop(false);
		chessBoard[0][4] = new King(false);
		chessBoard[0][5] = new Queen(false);
		chessBoard[0][6] = new Bishop(false);
		chessBoard[0][7] = new Knight(false);
		chessBoard[0][8] = new Rook(false);
		chessBoard[0][9] = new Pawn(false);
		
		for(int i =0; i<10; i++)chessBoard[8][i] = new Pawn(true);
		chessBoard[9][0] = new Pawn(true);
		chessBoard[9][1] = new Rook(true);
		chessBoard[9][2] = new Knight(true);
		chessBoard[9][3] = new Bishop(true);
		chessBoard[9][4] = new King(true);
		chessBoard[9][5] = new Queen(true);
		chessBoard[9][6] = new Bishop(true);
		chessBoard[9][7] = new Knight(true);
		chessBoard[9][8] = new Rook(true);
		chessBoard[9][9] = new Pawn(true);
	}
	
	public void creatRandomChessMan()
	{
		clearChessBoard();
		
		ChessMan[] chessTmp = new ChessMan[40];
		int tmp1, tmp2;
		
		//�̸� ��ġ�� ü������ �����صд�.
		for(int i = 0; i<12; i++) chessTmp[i] = new Pawn(false);
		chessTmp[12] = new Rook(false);
		chessTmp[13] = new Knight(false);
		chessTmp[14] = new Bishop(false);
		chessTmp[15] = new King(false);
		chessTmp[16] = new Queen(false);
		chessTmp[17] = new Bishop(false);
		chessTmp[18] = new Knight(false);
		chessTmp[19] = new Rook(false);
		for(int i = 20; i<32; i++) chessTmp[i] = new Pawn(true);
		chessTmp[32] = new Rook(true);
		chessTmp[33] = new Knight(true);
		chessTmp[34] = new Bishop(true);
		chessTmp[35] = new King(true);
		chessTmp[36] = new Queen(true);
		chessTmp[37] = new Bishop(true);
		chessTmp[38] = new Knight(true);
		chessTmp[39] = new Rook(true);
		
		for(int i =0; i<40; i++)
		{
			while(true)
			{
				tmp1 = (int)(Math.random()*9+0);
				tmp2 = (int)(Math.random()*9+0);
				
				if(chessBoard[tmp1][tmp2] == null) 
				{
					chessBoard[tmp1][tmp2] = chessTmp[i];
					break;
				}
			}
		}
		
		
	}
	
	//target : ������ ��, dest : ������ ��.
	public void moveChessMan(String target, String dest)
	{
		Position destPosition , targetPosition;
		boolean isMoveable;
		try
		{
			targetPosition = new Position(target);
			destPosition = new Position(dest);
			
			if(chessBoard[targetPosition.getY()][targetPosition.getX()] == null)
			{
				System.out.println("�ش� ���� �������� �ʽ��ϴ�.");
				return;
			}
			
			isMoveable = chessBoard[targetPosition.getY()][targetPosition.getX()].move(targetPosition, destPosition);
			
			
			if(isMoveable == true  )
			{
				//����Ʈ�� �ƴ϶�� �����ִ��� �˻縦 �ؾ��Ѵ�.
				if(!(chessBoard[targetPosition.getY()][targetPosition.getX()] 
						instanceof Knight))isMoveable = isBlocked(targetPosition, destPosition);
				
				if(isMoveable == true && chessBoard[destPosition.getY()][destPosition.getX()] != null)
				{
					//���� ���̸�
					if(chessBoard[destPosition.getY()][destPosition.getX()].getcamp()
							== chessBoard[targetPosition.getY()][targetPosition.getX()].getcamp() )
					{
						isMoveable  = false;
					}
					else isMoveable = true;
				}
			}
			
			if(isMoveable == false) System.out.println("�ش� ��ġ�� �̵��� �� �����ϴ�.");
			else
			{
				chessBoard[destPosition.getY()][destPosition.getX()]
						= chessBoard[targetPosition.getY()][targetPosition.getX()];
				
				chessBoard[targetPosition.getY()][targetPosition.getX()] =  null;
				System.out.printf("���� %s(��)�� �̵����׽��ϴ�.\n", dest);
			}
		}
		catch(IllegalArgumentException e) //�Է°� ���õ� ����.
		{
			System.out.println("�ش� ��ġ�� �̵��� �� �����ϴ�.");
		}
	}
}
