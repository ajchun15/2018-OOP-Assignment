package Homework1;

public class Rook extends ChessMan
{
	public Rook(boolean camp)
	{
		super(camp);
	}
	
	public boolean move(Position current, Position next)
	{
		if(this.moveStraight('N', current, next, 2)) return true;
		else if(this.moveStraight('E', current, next, 2)) return true;
		else if(this.moveStraight('S', current, next, 2)) return true;
		else if(this.moveStraight('W', current, next, 2)) return true;
		else if(this.moveCross("NE", current, next, 1)) return true;
		else if(this.moveCross("NW", current, next, 1)) return true;
		else if(this.moveCross("SE", current, next, 1)) return true;
		else if(this.moveCross("SW", current, next, 1)) return true;
		else return false;
	}
}
