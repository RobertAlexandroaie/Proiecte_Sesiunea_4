package com.aiesec.testandroidui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.aiesec.testandroidui.fragments.AccountListFragment;
import com.aiesec.testandroidui.fragments.SplashFragment;

public class AccountListActivity extends FragmentActivity 
{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_list_activity);
		ViewPager pager = (ViewPager)findViewById(R.id.view_pager);
		pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account_list, menu);
		return true;
	}
}

class ViewPagerAdapter extends FragmentPagerAdapter
{
	private AccountListFragment listFragment = new AccountListFragment();
	private SplashFragment splashFragment = new SplashFragment();

	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int position) 
	{
		if (position == 0)
			return listFragment;
		if (position == 1)
			return splashFragment;
		return listFragment;
	}

	@Override
	public int getCount() 
	{
		return 2;
	}
	
}
