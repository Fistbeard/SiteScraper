package com.vogella.build.maven.java;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class CraigsListSearch {
	HtmlPage page = null;
	
	CraigsListSearch()
	{
	}

	CraigsListSearch(HtmlPage page)
	{
		this.page = page;
	}
	
	public List<Item> scrapeXml()
	{
		//pick out elements. All XPATHS need to be changed per site, and with site updates.
		List<Item> results = new ArrayList<Item>();
		@SuppressWarnings("unchecked")
		//holds all the items found.
		List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("//li[@class='result-row']/p") ;
				
		//if no items, give empty set.
		if(items.isEmpty())
		{  
			System.out.println("No items found !");
		} else {
			//iterate each element
			for(HtmlElement item : items)
			{  
				//split the item into name, URL, item price.
				HtmlAnchor itemAnchor = ((HtmlAnchor)    item.getFirstByXPath(".//a"));
				  String itemName = itemAnchor.asText();
				  String itemUrl = itemAnchor.getHrefAttribute() ;
				  HtmlElement spanPrice = ((HtmlElement) item.getFirstByXPath(".//span[@class='result-meta']/span[@class='result-price']")) ;
				  // It is possible that an item doesn't have any price
				  //spanPrice contains "$" at the start.
				  String itemPrice = spanPrice == null ? "0" : spanPrice.asText().substring(1) ;
				
				 //add results. Get price as a float just in case.
				 results.add(new Item(itemName, itemUrl, Double.parseDouble(itemPrice)));
			}
					
		}
		return results;
	}
}
