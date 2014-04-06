package com.aiesec.testandroidui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aiesec.testandroidui.R;
import com.aiesec.testandroidui.adapter.AccountListAdapter;
import com.aiesec.testandroidui.data.manager.AccountDataManager;

public class AccountListFragment extends Fragment
{
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View parentView = inflater.inflate(R.layout.account_list, container, false);
		initList(parentView);
		return parentView;
	}
	
	private void initList(View parentView)
	{
		ListView accountListView = (ListView)parentView.findViewById(R.id.list_accounts);

		final AccountDataManager manager = new AccountDataManager();
		final AccountListAdapter adapter = new AccountListAdapter(getActivity(), manager);
		accountListView.setAdapter(adapter);
		new Thread()
		{
			public void run()
			{
				manager.retrieveAccounts();
				getActivity().runOnUiThread(new Runnable() 
				{
					@Override
					public void run() 
					{
						adapter.notifyDataSetChanged();		
					}
				});
			}
		}.start();
	}
}
