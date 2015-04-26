package newspapers;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewAge extends Newspaper{


	protected List<Headline> getHeadlines(String baseUrl) {
		List<Headline> headlines = new ArrayList<Headline>();

		Document document = connectToTheWebpage(baseUrl);

		Elements elements = document.select("h2 a");
		

		for (Element element : elements) {
			
				Headline headline = new Headline(element.text(),
						element.attr("href"));
				headlines.add(headline);
			
		}
//		System.out.println(""+headlines);
		return headlines;
	}

	protected String getNews(Headline headline) {
		Document document = connectToTheWebpage(headline.getUrl());
		
		return document.select("body p").get(0).text();
	}

	@Override
	public List<Headline> getAllSportsHeadLines() {
		// TODO Auto-generated method stub		
		return getHeadlines("http://newagebd.net/category/sport/");
	}


	
	@Override
	public List<Headline> getALLPoliticalHeadlines() {
		// TODO Auto-generated method stub
		return getHeadlines("http://newagebd.net/category/politics/");
	}

	
	
	@Override
	public List<Headline> getALLEntertainmentHeadlines() {
		// TODO Auto-generated method stub
		return getHeadlines("http://newagebd.net/category/entertain/");
	}
	

	@Override
	public List<Headline> getALLBusinessHeadlines() {
		// TODO Auto-generated method stub
		return getHeadlines("http://newagebd.net/category/bizn/");
	}
	
	
}
