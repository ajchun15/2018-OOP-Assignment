package Homework1;

public class King extends ChessMan 
{
	public King(boolean camp)
	{
		super(camp);
	}
	
	public boolean move(Position current, Position next)
	{
		//흰말(false)는 위로만 진행해야하고 반대는 아래로 진행해야한다.
		if(this.getcamp() == false)
		{
			if(this.moveStraight('N', current, next, 10)) return true;
			else if(this.moveCross("NE", current, next, 10)) return true;
			else if(this.moveCross("NW", current, next, 10)) return true;
			else return false;
		}
		else
		{
			if(this.moveStraight('S', current, next, 10)) return true;
			else if(this.moveCross("SE", current, next, 10)) return true;
			else if(this.moveCross("SW", current, next, 10)) return true;
			else return false;
		}
	}
}
