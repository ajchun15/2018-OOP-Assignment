package lab5;

public class VideoContent {
	private String name;
	private int potentialProfit;
	private int potentialCost;
	private float potentialQuality;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPotentialProfit() {
		return potentialProfit;
	}
	public void setPotentialProfit(int potentialProfit) {
		this.potentialProfit = potentialProfit;
	}
	public int getPotentialCost() {
		return potentialCost;
	}
	public void setPotentialCost(int potentialCost) {
		this.potentialCost = potentialCost;
	}
	public float getPotentialQuality() {
		return potentialQuality;
	}
	public void setPotentialQuality(float potentialQuality) {
		this.potentialQuality = potentialQuality;
	}
	
	public VideoContent(String name, int profit, int cost, float quality)
	{
		this.name = name;
		this.potentialCost = cost;
		this.potentialProfit = profit;
		this.potentialQuality = quality;
	}
	
}
