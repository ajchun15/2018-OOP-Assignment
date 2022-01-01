package Homework1;

//모듵 체스말은 현재 위치와 다음 위치 기반으로 움직일 수 있는지 여부를 돌려주며
//최종 판단은 ChessBoard 클래스에서 이루어진다.
public abstract class ChessMan
{
	//false = 백말 true = 검은말
	
	private boolean camp;
	
	public ChessMan(boolean camp)
	{
		this.camp = camp;
	}
	
	public boolean getcamp() {
		return this.camp;
	}
	
	//N, E, W, S로 움직이는 모든 말들에게 일반적으로 정의 된 직선이동이 가능한지 확인하는 함수.
	//Position은 위치, limit는 이동 가능 칸수를 의미한다. abstract move를 정의하는 과정해서
	//keystroke를 줄이기 위해 쓰인다.(귀찮아서)
	public boolean moveStraight(char direction, Position current, Position next, int limit )
	{
		if(current.equals(next)) return false;
		//같으면 안됨
		
		switch(direction)
		{
		case 'N':
			if( next.getY() > current.getY() && next.getY() - current.getY() <= limit 
			&& next.getX() ==current.getX()) return true;
			else return false;
		case 'S':
			if(next.getY() < current.getY() && current.getY() - next.getY() <= limit 
			&& next.getX() == current.getX()) return true;
			else return false;
		case 'W':
			if(current.getX() > next.getX() && current.getX() - next.getX() <= limit 
			&& next.getY() == current.getY()) return true;
			break;
		case 'E':
			if(current.getX() < next.getX() && next.getX() - current.getX()  <= limit 
			&& next.getY() == current.getY()) return true;
			else return false;
		default:
			break;
		}	
		
		return false;
	}
	
	//대각선으로 이동할 수 있는지 확인해주는 함수 함수. 입력 변수는 NE NW SE SW
	public boolean moveCross(String direction, Position current, Position next, int limit) 
	{
		if(current.equals(next)) return false;
		
		if(Math.abs(next.getX() - current.getX())!= Math.abs(next.getY()- current.getY())) return false;
		//대각선의 이동은 수직과 평행 이동 칸수가 같아야 한다.
		
		switch(direction)
		{
		case "NW":
			if(current.getX() > next.getX() && current.getY() < next.getY() )
			{
				if(next.getY() - current.getY() <= limit) return true;
			}
			break;
		case "NE":
			if(current.getX() < next.getX() && current.getY() < next.getY() )
			{
				if(next.getY() - current.getY() <= limit) return true;
			}
			break;
		case "SW":
			if(current.getX() > next.getX() && current.getY() > next.getY() )
			{
				if(current.getY() - next.getY() <= limit) return true;
			}
			break;
		case "SE":
			if(current.getX() < next.getX() && current.getY() > next.getY() )
			{
				if(current.getY() - next.getY() <= limit) return true;
			}
			break;
		default:
			break;
		}
		return false;
	}
	
	public abstract boolean move(Position current, Position next);
}

