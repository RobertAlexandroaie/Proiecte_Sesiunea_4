package com.aiesec.testandroidui.networking.asynctasks;

import android.os.AsyncTask;
import android.widget.Toast;

import com.aiesec.testandroidui.data.manager.AccountDataManager;
import com.aiesec.testandroidui.fragments.AccountListFragment;

public class AccountDataAsyncTask extends AsyncTask<String, Void, Boolean>
{
	private AccountListFragment parentFragment;
	private AccountDataManager manager;
	
	public AccountDataAsyncTask(AccountListFragment parentFragment, AccountDataManager manager)
	{
		this.parentFragment = parentFragment;
		this.manager = manager;
	}
	
	
	@Override
	protected void onPreExecute() 
	{
		super.onPreExecute();
		parentFragment.showSpinnerHideList();
	}

	@Override
	protected Boolean doInBackground(String... params) 
	{
		return manager.retrieveAccounts();
	}
	
	@Override
	protected void onPostExecute(Boolean result) 
	{
		parentFragment.showListHideSpinner();
		if (!result.booleanValue())
			Toast.makeText(parentFragment.getActivity(), "Something went wrong",
					Toast.LENGTH_LONG).show();
	}
	
	@Override
	protected void onProgressUpdate(Void... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}

}



