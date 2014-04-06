package com.aiesec.testandroidui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.ListView;

import com.aiesec.testandroidui.adapter.AccountListAdapter;
import com.aiesec.testandroidui.data.manager.AccountDataManager;

public class AccountListActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_list);
	
		ListView accountListView = (ListView)findViewById(R.id.list_accounts);
		
		final AccountDataManager manager = new AccountDataManager();
		final AccountListAdapter adapter = new AccountListAdapter(this, manager);
		accountListView.setAdapter(adapter);
		new Thread()
		{
			public void run()
			{
				manager.retrieveAccounts();
				runOnUiThread(new Runnable() 
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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account_list, menu);
		return true;
	}

}
