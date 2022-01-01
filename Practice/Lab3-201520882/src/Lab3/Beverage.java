package Lab3;

public class Beverage {
	private String name;
	private float volume;
	private int price;
	private int disc_rate;
	private int min_num;
	
	public Beverage(String name, float volume, int price, int disc_rate, int min_num)
	{
		this.name = name;
		this.volume = volume;
		this.price = price;
		this.disc_rate = disc_rate;
		this.min_num = min_num;
	}

	public int figureMlPerPrice()
	{
		int returnPrice;
		returnPrice = (int)(((float)(price) / volume)*(float)100);
		return returnPrice;
	}
	public float figureDiscPricePerBottle()
	{
		float returnPrice;
		returnPrice = (float)price*(100-(float)disc_rate)/100;
		return returnPrice;
	}
	
	public float figureDiscPricePerMl()
	{
		float returnPrice;
		int mlPerPrice = figureMlPerPrice();
		returnPrice = (float)mlPerPrice*(100-(float)disc_rate)/100;
		return returnPrice;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDisc_rate() {
		return disc_rate;
	}

	public void setDisc_rate(int disc_rate) {
		this.disc_rate = disc_rate;
	}

	public int getMin_num() {
		return min_num;
	}

	public void setMin_num(int min_num) {
		this.min_num = min_num;
	}
	
	
}
