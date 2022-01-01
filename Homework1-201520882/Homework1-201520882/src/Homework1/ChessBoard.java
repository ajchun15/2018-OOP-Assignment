package Homework1;

public class ChessBoard
{
	//체스판은 단 하나이기에 static으로 선언하는게 이상적이나, 일단 private으로 멤버를 선언하라는 제한이 걸려있어서 일반 클래스로 선언.
	private ChessMan[][] chessBoard = new ChessMan[10][10];
	
	//다른 말에 의해 이동 경로가 막혀있는지 판별하는 함수.
	private boolean isBlocked(Position current, Position next)
	{
		//진행방향이 수직인 경우
		if(current.getX() == next.getX())
		{
			if(current.getY() > next.getY()) //아래로 가는 경우
			{
				for(int i =1; i< Math.abs(next.getY() - current.getY()) ; i++)
					if(chessBoard[current.getY()-i][current.getX()] != null) return false;
			}
			else //위로가  가는 경우
			{
				for(int i =1; i< Math.abs(next.getY() - current.getY()) ; i++)
					if(chessBoard[current.getY()+i][current.getX()] != null) return false;
			}
		}
		else if(current.getY() == next.getY()) //진행 방향이 수평인 경우
		{
			if(current.getX() > next.getX()) //왼쪽으로 가는 경우
			{
				for(int i =1; i< Math.abs(next.getX() - current.getX()) ; i++)
					if(chessBoard[current.getY()][current.getX()-i] != null) return false;
			}
			else //오른쪽으로 가는 경우
			{
				for(int i =1; i< Math.abs(next.getX() - current.getX()) ; i++)
					if(chessBoard[current.getY()][current.getX()+i] != null) return false;
			}
		}
		else if(Math.abs(next.getX() - current.getX()) == Math.abs(next.getY() - current.getY()))
		{
			if(current.getX() > next.getX() && current.getY() < next.getY() ) //북서방향
			{
				for(int i = 1; i < Math.abs(current.getX() - next.getX()); i++)
					if(chessBoard[current.getY() +i][current.getX()-i] != null) return false;
			}
			else if(current.getX() < next.getX() && current.getY() < next.getY() ) //북동방향
			{
				for(int i = 1; i < Math.abs(current.getX() - next.getX()); i++)
					if(chessBoard[current.getY()+i][current.getX()+i] != null) return false;
			}
			else if(current.getX() > next.getX() && current.getY() > next.getY() ) //남서방향
			{
				for(int i = 1; i < Math.abs(current.getX() - next.getX()); i++)
					if(chessBoard[current.getY()-i][current.getX()-i] != null) return false;
			}
			else if(current.getX() < next.getX() && current.getY() > next.getY() ) //남동방향
			{
				for(int i = 1; i < Math.abs(current.getX() - next.getX()); i++)
					if(chessBoard[current.getY()-i][current.getX()+i] != null) return false;
			}
			
		}//진행방향이 대각선인 경우  각각 북서 북동 남서 남동
		
		return true;
	}
	
	//체스판을 깨끗히 지우는 함수
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
			System.out.println("잘못된 입력입니다.");
			return;
		}
		
		if(chessBoard[p.getY()][p.getX()] == null)
		{
			System.out.println("해당 위치에 체스 말이 없습니다.");
		}
		else
		{
			chessBoard[p.getY()][p.getX()] = null;
			System.out.println("체스 말이 삭제되었습니다.");
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
		
		//미리 배치할 체스들을 정의해둔다.
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
	
	//target : 움직일 말, dest : 움직일 곳.
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
				System.out.println("해당 말이 존재하지 않습니다.");
				return;
			}
			
			isMoveable = chessBoard[targetPosition.getY()][targetPosition.getX()].move(targetPosition, destPosition);
			
			
			if(isMoveable == true  )
			{
				//나이트가 아니라면 막혀있는지 검사를 해야한다.
				if(!(chessBoard[targetPosition.getY()][targetPosition.getX()] 
						instanceof Knight))isMoveable = isBlocked(targetPosition, destPosition);
				
				if(isMoveable == true && chessBoard[destPosition.getY()][destPosition.getX()] != null)
				{
					//같은 팀이면
					if(chessBoard[destPosition.getY()][destPosition.getX()].getcamp()
							== chessBoard[targetPosition.getY()][targetPosition.getX()].getcamp() )
					{
						isMoveable  = false;
					}
					else isMoveable = true;
				}
			}
			
			if(isMoveable == false) System.out.println("해당 위치로 이동할 수 없습니다.");
			else
			{
				chessBoard[destPosition.getY()][destPosition.getX()]
						= chessBoard[targetPosition.getY()][targetPosition.getX()];
				
				chessBoard[targetPosition.getY()][targetPosition.getX()] =  null;
				System.out.printf("말을 %s(으)로 이동시켰습니다.\n", dest);
			}
		}
		catch(IllegalArgumentException e) //입력과 관련된 예외.
		{
			System.out.println("해당 위치로 이동할 수 없습니다.");
		}
	}
}
