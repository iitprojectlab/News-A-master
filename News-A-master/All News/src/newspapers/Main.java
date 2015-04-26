package newspapers;

import java.io.ObjectInputStream.GetField;
import java.util.List;

public class Main {
  
	public static void main(String[] args) {
		//testProthomAloBn(new ProthomAloBn());
		testDailySun(new TheDailySun());
		//newspaperTest(new NewAge());
		/*INewspaper newspaper=new BangladeshToday();
		List<Headline>headlines =newspaper.getALLBusinessHeadlines();
		for (Headline headline : headlines) {
			System.out.println(headline.getHeading()+" "+headline.getUrl());
			System.out.println(newspaper.getBusinessNews(headline));

		}
		System.out.println(newspaper.getSportsNews(headlines.get(0)));
*/		//newspaperTest(new IttefaqBangla());
		/*INewspaper newspaper=new TheDailyStar();
		List<Headline>headlines =newspaper.getAllSportsHeadLines();
		//System.out.println(newspaper.getSportsNews(headlines.get(1)));
		
		headlines=newspaper.getALLBusinessHeadlines();
		System.out.println(newspaper.getBusinessNews(headlines.get(0)));
		
		headlines=newspaper.getALLEntertainmentHeadlines();
		System.out.println(newspaper.getEntertainmentNews(headlines.get(0)));
		*//*
		headlines=newspaper.getALLPoliticalHeadlines();
		System.out.println(newspaper.getPoliticalNews(headlines.get(0)));
	   */
	}

	private static void newspaperTest(Newspaper newspaper) {
		List<Headline>headlines=newspaper.getAllSportsHeadLines();
		/*for (Headline headline : headlines) {
			System.out.println(headline.getHeading()+" "+headline.getUrl());
		}*/
//		System.out.println(newspaper.getSportsNews(headlines.get(0)));
//		
//		headlines =newspaper.getALLBusinessHeadlines();
//		System.out.println(newspaper.getBusinessNews(headlines.get(0)));
//		
//		headlines=newspaper.getALLEntertainmentHeadlines();
//		System.out.println(newspaper.getEntertainmentNews(headlines.get(0)));
//		
//		headlines=newspaper.getALLPoliticalHeadlines();
//		System.out.println(newspaper.getPoliticalNews(headlines.get(0)));
		System.out.println(newspaper.getSportsNews(headlines.get(0)));
		System.out.println(headlines.get(0).getHeading());
	}
	
	private static void testDailySun(Newspaper newspaper){
		List<Headline> headlines = newspaper.getAllSportsHeadLines();
		for (Headline headline : headlines) {
			String news = newspaper.getNews(headline);
			System.out.println(news);
		}
	}
	
	private static void testProthomAloBn(Newspaper newspaper){
		List<Headline> headlines = newspaper.getAllSportsHeadLines();
		for (Headline headline : headlines) {
			String news = newspaper.getNews(headline);
			//System.out.println(headline.getUrl());
			System.out.println(news);
		}
		
	}
}
