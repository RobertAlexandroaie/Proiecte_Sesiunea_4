package com.aiesec.testandroidui.data.manager;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.aiesec.testandroidui.data.AccountEntity;
import com.aiesec.testandroidui.networking.NetworkingService;

public class AccountDataManager 
{
	private List<AccountEntity> accounts;

	public AccountDataManager()
	{
		accounts = new ArrayList<AccountEntity>();
	}
	
	public List<AccountEntity> getAccounts()
	{
		return accounts;
	}

	public boolean retrieveAccounts()
	{
		try
		{
			String accountsJSON = NetworkingService.getInstance().
					makeGetRequest("http://androidaccservice.appspot.com/service/account");
			if (accountsJSON != null)
			{
				JSONArray accountArray = new JSONObject(accountsJSON)
					.getJSONArray("account");
				for (int i = 0; i < accountArray.length(); i++)
				{
					JSONObject object = accountArray.getJSONObject(i);
					AccountEntity accountEntity = new AccountEntity();
					accountEntity.parseJSON(object);
					accounts.add(accountEntity);
				}
				return true;
			}
			else
				return false;

		}
		catch (JSONException e)
		{
			Log.e("JSON PARSING ERROR", "Error occured while parsing json", e);
			return false;
		}
	}
}
