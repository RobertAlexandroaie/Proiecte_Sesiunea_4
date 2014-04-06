package com.aiesec.testandroidui.adapter;

import com.aiesec.testandroidui.fragments.AccountListFragment;
import com.aiesec.testandroidui.fragments.SplashFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter
{
	private AccountListFragment listFragment;
	private SplashFragment splashFragment;
	
	public ViewPagerAdapter(FragmentManager fragmentManager)
	{
		super(fragmentManager);
		listFragment = new AccountListFragment();
		splashFragment = new SplashFragment();
	}

	public Fragment getItem(int position)
	{
		if (position == 0)
			return listFragment;
		if (position == 1)
			return splashFragment;
		return listFragment;
	}

	public int getCount()
	{
		return 2;
	}

}
