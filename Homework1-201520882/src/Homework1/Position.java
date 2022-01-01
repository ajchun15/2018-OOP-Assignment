package Homework1;

//x, y ��ǥ�� ��Ÿ���� �������Ǽ� Ŭ����
public class Position
{
	private int x;
	private int y;
	
	public Position(int x, int y)
	{
		setX(x);
		setY(y);
	}
	
	//�μ��� ���̰� �˸��� ������, ������ ����� IllegalArgumentException()�� throw �Ѵ�.
	public Position(String s)
	{
		String letter;
		int y;
		int x;
		
		if(s.length() > 3 || s.length() <= 1) throw new IllegalArgumentException();
		
		letter = s.substring(0, 1);
		
		try
		{
			if(s.length() == 3)	y = Integer.parseInt(s.substring(1, 3)) - 1;
			else y = Integer.parseInt(s.substring(1, 2)) - 1;
			
		}
		catch(NumberFormatException e)
		{
			throw new IllegalArgumentException();
		}
		
		letter = letter.toLowerCase();
		x = letter.charAt(0) - 'a';
		
		setX(x);
		setY(y);
	}
	
	public int getX() 
	{
		return x;
	}
	public void setX(int x) 
	{
		if(x < 0 || x >= 10) throw new IllegalArgumentException();
		else
		{
			this.x = x;
		}
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		if(y < 0 || y >= 10) throw new IllegalArgumentException();
		else
		{
			this.y = y;
		}
	}
	
	
}
