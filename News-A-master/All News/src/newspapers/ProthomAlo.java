package newspapers;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ProthomAlo extends Newspaper{

	@Override
	protected List<Headline> getHeadlines(String baseUrl) {
		List<Headline> headlines = new ArrayList<Headline>();

		Document document = connectToTheWebpage(baseUrl);

		Elements elements = document.select("body a");

		for (org.jsoup.nodes.Element element : elements) {
			
			String absoluteUrlOfElement = "http://en.prothom-alo.com/"+element.attr("href");
			
			if (absoluteUrlOfElement.startsWith(baseUrl) && !absoluteUrlOfElement.equals(baseUrl)) {
				Headline headline = new Headline(element.text(),
						absoluteUrlOfElement);
				headlines.add(headline);
			}
		}
		return headlines;
	}

	protected String getNews(Headline headline) {
		Document document = connectToTheWebpage(headline.getUrl());
		
		return document.getElementsByAttributeValue("itemprop", "articleBody").text();
	}

	@Override
	public List<Headline> getAllSportsHeadLines() {
		return getHeadlines("http://en.prothom-alo.com/sports");
	}


	@Override
	public List<Headline> getALLPoliticalHeadlines() {
		return getHeadlines("http://en.prothom-alo.com/bangladesh");
	}

	@Override
	public List<Headline> getALLEntertainmentHeadlines() {
		return getHeadlines("http://en.prothom-alo.com/entertainment");
	}


	@Override
	public List<Headline> getALLBusinessHeadlines() {
		return getHeadlines("http://en.prothom-alo.com/economy");
	}

}
