package newspapers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ProthomAloBn extends Newspaper{

	private final String NEWSPAPER_URL = "http://www.prothom-alo.com/";
	
	@Override
	public List<Headline> getAllSportsHeadLines() {
		return getHeadlines("http://www.prothom-alo.com/sports");
	}

	@Override
	public List<Headline> getALLPoliticalHeadlines() {
		// TODO Auto-generated method stub
		return getHeadlines("http://www.prothom-alo.com/bangladesh-politics");
	}

	@Override
	public List<Headline> getALLEntertainmentHeadlines() {
		// TODO Auto-generated method stub
		return getHeadlines("http://www.prothom-alo.com/entertainment");
	}

	@Override
	public List<Headline> getALLBusinessHeadlines() {
		// TODO Auto-generated method stub
		return getHeadlines("http://www.prothom-alo.com/economy");
	}

	@Override
	protected List<Headline> getHeadlines(String baseUrl) {
		
		List<Headline> headlines = new ArrayList<Headline>();
		Document document = connectToTheWebpage(baseUrl);
		Elements elements = document.getElementsByClass("p_d").select("a");
		
		Set<String> headlineUrls = new HashSet<String>();

		for (org.jsoup.nodes.Element element : elements) {
			
			String absoluteUrlOfElement = NEWSPAPER_URL + element.attr("href");
			
			if (absoluteUrlOfElement.startsWith(baseUrl + "/article/") && !headlineUrls.contains(absoluteUrlOfElement)) {
				headlineUrls.add(absoluteUrlOfElement);
				headlines.add(new Headline(element.text(), absoluteUrlOfElement));
			}
		}
		headlineUrls.clear();
		return headlines;
		
	}

	@Override
	protected String getNews(Headline headline) {
		Document document = connectToTheWebpage(headline.getUrl());
		try {
			String paragraph = document.getElementsByAttributeValue("itemprop", "articleBody").text();
			return paragraph;
		} catch (Exception e) {
			return "This page contains no description.";
		}
		
	}
	
}
