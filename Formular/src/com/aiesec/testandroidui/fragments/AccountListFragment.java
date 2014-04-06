package com.aiesec.testandroidui.fragments;

import com.aiesec.testandroidui.R;
import com.aiesec.testandroidui.adapter.AccountListAdapter;
import com.aiesec.testandroidui.data.manager.AccountDataManager;
import com.aiesec.testandroidui.networking.asynctasks.AccountDataAsyncTask;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

public class AccountListFragment extends Fragment
{
	private ProgressBar spinner;
	private ListView accountListView;
	private AccountListAdapter adapter; 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.account_list_layout,
				container, false);
		initUI(view);
		return view;
	}
	
	private void initUI(View view)
	{
		accountListView = (ListView)view.findViewById(R.id.list_accounts);
		spinner = (ProgressBar)view.findViewById(R.id.spinner);
		
		final AccountDataManager manager = new AccountDataManager();
		adapter = new AccountListAdapter(getActivity(), manager);
		accountListView.setAdapter(adapter);
		new AccountDataAsyncTask(this, manager).execute();
	
	}
	
	public void showSpinnerHideList()
	{
		accountListView.setVisibility(View.GONE);
		spinner.setVisibility(View.VISIBLE);
	}
	
	public void showListHideSpinner()
	{
		spinner.setVisibility(View.GONE);
		accountListView.setVisibility(View.VISIBLE);
		adapter.notifyDataSetChanged();
	}
}
