package com.vogella.build.maven.java;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String args[])
    {
    	String searchQuery = "";
    	String searchUrl = "";
    	String searchSite = "";
    	if (args.length > 0)
    	{
			searchUrl = args[0];
    		if (args.length > 1)
    		{
    			searchQuery = args[1];
    		}
    	}
    	//TODO GUI prompt if args not set.
    	searchQuery = "AWD";
    	searchUrl = "https://newlondon.craigslist.org/search/cto";
    	searchSite = "craigslist";
    	
    	PageScraper page = new PageScraper(searchUrl);
    	List<Item> results = page.searchPage(searchQuery);
    	
    	for (Item result : results)
    	{
    		System.out.println(result.toJSONString());
    	}
    	
    }
}
