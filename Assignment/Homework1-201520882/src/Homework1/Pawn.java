package Homework1;

public class Pawn extends ChessMan
{
	public boolean move(Position current, Position next)
	{
		if(this.moveStraight('S', current, next, 1)) return true; //�������� ��ĭ���Ϸ� �����̸�
		else if(this.moveStraight('N', current, next, 1)) return true; //�������� ��ĭ���Ϸ� �����̸�
		else return false;
	}
	
	public Pawn(boolean camp)
	{
		super(camp);
	}
}
