package com.aiesec.testandroidui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

import com.aiesec.testandroidui.adapter.ViewPagerAdapter;

public class TabActivity extends FragmentActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener
{
	private TabHost tabHost;
	private ViewPager viewPager;
	private ViewPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle arg0) 
	{
		super.onCreate(arg0);
		setContentView(R.layout.tab_activity);
		initTabHost();
		initViewPager();
	}

	private void initTabHost()
	{
		tabHost = (TabHost)findViewById(R.id.tab_host);
		tabHost.setup();

		TabSpec tabSpec = tabHost.newTabSpec("account_list");
		tabSpec.setIndicator("Account List");
		tabSpec.setContent(new TabContentFactory());
		tabHost.addTab(tabSpec);
		
		tabSpec = tabHost.newTabSpec("empty_view");
		tabSpec.setIndicator("Empty View");
		tabSpec.setContent(new TabContentFactory());
		tabHost.addTab(tabSpec);
		
		tabHost.setOnTabChangedListener(this);

	}
	
	private void initViewPager()
	{
		viewPager = (ViewPager)findViewById(R.id.view_pager);
		adapter = new ViewPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(this);
	}
	
	@SuppressWarnings("unused")
	private TextView getTabWidget(String text)
	{
		TextView textView = (TextView)getLayoutInflater().inflate(R.layout.tab_widget_layout, null);
		textView.setText(text);
		
		return textView;
	}

	class TabContentFactory implements android.widget.TabHost.TabContentFactory
	{

		public View createTabContent(String tag)
		{
			View v = new View(TabActivity.this);
			v.setMinimumWidth(0);
			v.setMinimumHeight(0);
			return v;
		}

	}

	@Override
	public void onPageScrollStateChanged(int arg0)	{  }

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) { }

	@Override
	public void onPageSelected(int position) 
	{			
		tabHost.setCurrentTab(position);
	}

	@Override
	public void onTabChanged(String tabId)
	{
		viewPager.setCurrentItem(tabHost.getCurrentTab());
	}
}
