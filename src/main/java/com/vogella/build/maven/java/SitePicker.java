package com.vogella.build.maven.java;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class SitePicker {
	
	public static Site pickSite(HtmlPage page)
	{
		//if site URL resolves to string below, set site ENUM and return true.
		//TODO regex to pick site fqd out of full URL.
		switch ("craigslist.com")
		{
			case ("craigslist.com"):
			{
				//set site ENUM for page to craigslist
				return Site.CRAIGSLIST;
			}
				//other sites as above
			default:
				//set site to SITE NOT FOUND
				return Site.UNKNOWN_SITE_INVALID;
			}
	}
}
