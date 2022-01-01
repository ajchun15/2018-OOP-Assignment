package Homework1;

//���� ü������ ���� ��ġ�� ���� ��ġ ������� ������ �� �ִ��� ���θ� �����ָ�
//���� �Ǵ��� ChessBoard Ŭ�������� �̷������.
public abstract class ChessMan
{
	//false = �鸻 true = ������
	
	private boolean camp;
	
	public ChessMan(boolean camp)
	{
		this.camp = camp;
	}
	
	public boolean getcamp() {
		return this.camp;
	}
	
	//N, E, W, S�� �����̴� ��� ���鿡�� �Ϲ������� ���� �� �����̵��� �������� Ȯ���ϴ� �Լ�.
	//Position�� ��ġ, limit�� �̵� ���� ĭ���� �ǹ��Ѵ�. abstract move�� �����ϴ� �����ؼ�
	//keystroke�� ���̱� ���� ���δ�.(�����Ƽ�)
	public boolean moveStraight(char direction, Position current, Position next, int limit )
	{
		if(current.equals(next)) return false;
		//������ �ȵ�
		
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
	
	//�밢������ �̵��� �� �ִ��� Ȯ�����ִ� �Լ� �Լ�. �Է� ������ NE NW SE SW
	public boolean moveCross(String direction, Position current, Position next, int limit) 
	{
		if(current.equals(next)) return false;
		
		if(Math.abs(next.getX() - current.getX())!= Math.abs(next.getY()- current.getY())) return false;
		//�밢���� �̵��� ������ ���� �̵� ĭ���� ���ƾ� �Ѵ�.
		
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

