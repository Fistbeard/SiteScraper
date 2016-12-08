package com.vogella.build.maven.java;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class PageScraper {
	
	HtmlPage page = null;
	String searchString = null;
	Site searchSite = null;
	
	//if passed a page
	PageScraper(HtmlPage page)
	{
		this.page = page;
		this.setSearchSite();
	}
	
	//if passed a URL
	PageScraper(String searchUrl)
	{
		//construct the page from a URL
		this.page = createPage(searchUrl);
		this.setSearchSite();
	}
	
	
	
	public HtmlPage getPage() {
		return page;
	}

	public void setPage(HtmlPage page) {
		this.page = page;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	private void setSearchSite()
	{
		this.searchSite = SitePicker.pickSite(page);
	}

	//given a URL, constructs the page and returns it
	private HtmlPage createPage(String searchUrl)
	{
		WebClient client = new WebClient();
    	
    	client.getOptions().setCssEnabled(false);
    	client.getOptions().setJavaScriptEnabled(false);
    	try {
    		HtmlPage page = client.getPage(searchUrl);
    		client.close();
        	return page;
    	} catch (Exception e)
    	{
    		e.printStackTrace();
    		client.close();
    		return null;
    	}
	}
	
	//checks if a search string was ever provided - if not, tell user and do not search.
	public void searchPage()
	{
		if (this.searchString == null)
		{
			System.out.println("No search term ever passed!");
		} else {
			searchPage(searchString);
		}
	}
	
	//returns a list of results from a search query
	//returns empty list if site not found. Results empty list if no results returned.
	public List<Item> searchPage(String searchString)
	{
		List<Item> results = new ArrayList<Item>();
		if (searchSite.getSiteUrl().equals("craigslist.com"))
		{
			CraigsListSearch cls = new CraigsListSearch(page);
		
			results = cls.scrapeXml();
		} 
		return results;
	}
}
