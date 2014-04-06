package com.aiesec.testandroidui.networking;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class NetworkingService
{
	private static NetworkingService instance;
	private HttpClient client;

	private NetworkingService()
	{
		client = new DefaultHttpClient();
	}

	public static NetworkingService getInstance()
	{
		if (instance == null)
			instance = new NetworkingService();

		return instance;
	}

	public String makeGetRequest(String url)
	{
		try
		{
			HttpGet get = new HttpGet(url);
			HttpResponse response = client.execute(get);
			return EntityUtils.toString(response.getEntity());
		}
		catch (Exception e)
		{
			Log.e("NETWORKING ERROR",
					"Error occured while making get request to: " + url, 
					e);	
			return null;
		}
	}
}
