package lab5;
import java.util.ArrayList;


public class TestDriver {
	
	public static void main(String[] args ){
		//외부 컨텐츠들의 정보
		String[] externalContentName = { "StarTreck : Beyond" , "Spiderman : Homecoming" , "DoctorStrange" , "WorkingDead" };
		int [] externalContentProfit = {50, 70, 60, 90};
		int [] externalContentCost = {40, 30, 30, 40};
		float [] externalContentQuality = {( float ) 7.1, ( float ) 7.5, ( float ) 8.3, ( float ) 6.2};
		//자체 제작 컨텐츠들의 정보
		String[] originalContentName = { "DareDevil" , "GoodPlace" , "BlackMirror" ,
		"Punisher" };
		int [] originalContentProfit = {52, 65, 72, 85};
		int [] originalContentCost = {30, 20, 40, 30};
		float [] originalContentQuality = {( float ) 6.2, ( float ) 5.9, ( float ) 8.7, ( float ) 5.9};
		Netflix netflix1 ;
		Netflix netflix2 ;
		//외부 컨텐츠가 담길 ArrayList
		ArrayList<VideoContent> externalContent = new ArrayList<VideoContent>();
	
		for(int i = 0; i < externalContentName.length; i++)
		{
			externalContent.add(new VideoContent(externalContentName[i]
					, externalContentProfit[i], externalContentCost[i], externalContentQuality[i]));	
		}
		
		netflix1 = new Netflix(externalContent);
		netflix2 = new Netflix(originalContentName, originalContentProfit, originalContentCost, originalContentQuality);
		
		System.out.printf("External Contents Quality : %.2f vs Original Contents Quality: %.2f\n"
				, netflix1.calculateQuality(), netflix2.calculateQuality());
		
		if(netflix1.calculateQuality() > netflix2.calculateQuality())
			System.out.println("External contents have better quality");
		else
			System.out.println("Original contents have better quality");
		
		System.out.printf("Exterior Contents Profit : %.2f vs Original Contents Profit: %.2f\n"
				, netflix1.calculateProfit(), netflix2.calculateProfit());
		
		if(netflix1.calculateProfit() > netflix2.calculateProfit())
			System.out.println("External contents have more profit");
		else
			System.out.println("Original contents have more profit");
		
	}
}
