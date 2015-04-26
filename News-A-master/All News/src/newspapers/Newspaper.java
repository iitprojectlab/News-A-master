package newspapers;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class Newspaper {

	public abstract List<Headline>getAllSportsHeadLines();
	public String getSportsNews(Headline headline)
	{
		return getNews(headline);	
	}
	
	public abstract List<Headline>getALLPoliticalHeadlines();
	public  String getPoliticalNews(Headline headline)
	{
		return getNews(headline);
	}
	
	public abstract List<Headline>getALLEntertainmentHeadlines();
	public  String getEntertainmentNews(Headline headline)
	{
		return getNews(headline);
	}
	
	public abstract List<Headline>getALLBusinessHeadlines();
	public  String getBusinessNews(Headline headline)
	{
		return getNews(headline);
	}
	
	protected abstract List<Headline> getHeadlines(String baseUrl);
	protected abstract String getNews(Headline headline);
	
	protected Document connectToTheWebpage(String baseUrl) {
		Document document = null;
		try {
			document = Jsoup.connect(baseUrl).timeout(10 * 10000000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}
	
}
