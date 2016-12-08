package com.vogella.build.maven.java;

public enum Site {
	CRAIGSLIST ("craigslist.com"),
	REDDIT ("reddit.com"),
	IMZY ("imzy.com"),
	UNKNOWN_SITE_INVALID ("invalid site.")
	;
		
	private final String siteUrl;
		
	Site(String siteUrl)
	{
		this.siteUrl = siteUrl;
	}
	
	public String getSiteUrl()
	{
		return this.siteUrl;
	}
}
