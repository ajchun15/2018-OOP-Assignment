package Homework1;

//x, y 좌표를 나타내는 개발편의성 클래스
public class Position
{
	private int x;
	private int y;
	
	public Position(int x, int y)
	{
		setX(x);
		setY(y);
	}
	
	//인수의 길이가 알맞지 않으면, 범위를 벗어나면 IllegalArgumentException()을 throw 한다.
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
