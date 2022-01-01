package lab5;
import java.util.ArrayList;

public class Netflix {
	private ArrayList<VideoContent> videos = new ArrayList<VideoContent>();
	
	public Netflix(ArrayList<VideoContent> videos)
	{
		this.videos.addAll(videos);
	}
	
	public Netflix(String[] names, int[] profit, int[] cost, float[] quality)
	{
		for(int i =0; i< names.length; i++)
		{
			videos.add(new VideoContent(names[i], profit[i], cost[i], quality[i]));
		}
	}
	
	public float calculateQuality()
	{
		float sum = 0;
		
		for(int i =0; i< videos.size(); i++)
		{
			sum += videos.get(i).getPotentialQuality();
		}
		
		return sum;
	}
	
	public float calculateProfit()
	{
		float sum = 0;
		
		for(int i = 0; i< videos.size(); i++)
		{
			sum += videos.get(i).getPotentialProfit() - videos.get(i).getPotentialCost();
		}
		
		return sum;
	}
}
