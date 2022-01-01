package Homework1;

public class Pawn extends ChessMan
{
	public boolean move(Position current, Position next)
	{
		if(this.moveStraight('S', current, next, 1)) return true; //남쪽으로 한칸이하로 움직이면
		else if(this.moveStraight('N', current, next, 1)) return true; //북쪽으로 한칸이하로 움직이면
		else return false;
	}
	
	public Pawn(boolean camp)
	{
		super(camp);
	}
}
