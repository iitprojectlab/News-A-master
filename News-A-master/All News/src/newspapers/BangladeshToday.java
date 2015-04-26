package newspapers;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class BangladeshToday extends Newspaper{

	@Override
	protected List<Headline> getHeadlines(String baseUrl) {
		List<Headline> headlines = new ArrayList<Headline>();

		Document document = connectToTheWebpage(baseUrl);

		Elements elements = document.select("article a");

		for (org.jsoup.nodes.Element element : elements) {
			if(element.attr("href").startsWith("http://thebangladeshtoday.com/author/"))
				continue;
			if(element.attr("href").startsWith("http://thebangladeshtoday.com/category/"))
				continue;
			if(element.text().equals(""))
				continue;
				Headline headline = new Headline(element.text(),
						element.attr("href"));
				headlines.add(headline);
			
		}
		return headlines;
	}

	@Override
	protected String getNews(Headline headline) {
		Document document = connectToTheWebpage(headline.getUrl());
		
		return document.select("body p").get(0).text();
	}

	@Override
	public List<Headline> getAllSportsHeadLines() {
		return getHeadlines("http://thebangladeshtoday.com/category/sports/");
	}


	@Override
	public List<Headline> getALLPoliticalHeadlines() {
		return getHeadlines("http://thebangladeshtoday.com/category/national/");
	}

	

	@Override
	public List<Headline> getALLEntertainmentHeadlines() {
		return getHeadlines("http://thebangladeshtoday.com/category/entertainment/");
	}

	

	@Override
	public List<Headline> getALLBusinessHeadlines() {
		return getHeadlines("http://thebangladeshtoday.com/category/business/");
	}

	
}
