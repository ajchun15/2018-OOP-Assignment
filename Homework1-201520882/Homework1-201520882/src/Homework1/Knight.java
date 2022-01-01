package Homework1;

public class Knight extends ChessMan
{
	public Knight(boolean camp)
	{
		super(camp);
	}
	
	public boolean move(Position current, Position next)
	{
		//나이트 특유의 움직임.
		if(Math.abs(next.getX()-current.getX()) == 2)
		{
			if(Math.abs(next.getY() - current.getY()) == 1) return true;
		}
		else if(Math.abs(next.getY()-current.getY()) == 2)
		{
			if(Math.abs(next.getX() - current.getX()) == 1) return true;
		}
		//상하좌우 두칸 무빙.
		if(this.moveStraight('N', current, next, 2)) return true;
		else if(this.moveStraight('E', current, next, 2)) return true;
		else if(this.moveStraight('S', current, next, 2)) return true;
		else if(this.moveStraight('W', current, next, 2)) return true;
		
		return false;
	}
}
