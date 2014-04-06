package com.aiesec.testandroidui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;

import com.aiesec.testandroidui.fragments.LoginFragment;
import com.aiesec.testandroidui.fragments.SplashFragment;

public class MainActivity extends FragmentActivity 
{
	private LoginFragment loginFragment;
	private SplashFragment splashFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        initFragments();
        initUIElements();
    }
    
    private void initFragments()
    {
    	loginFragment = new LoginFragment();
    	splashFragment = new SplashFragment();
    	
    	FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    	transaction.add(R.id.container_fragments, loginFragment);
    	transaction.add(R.id.container_fragments, splashFragment);
    	transaction.commit();
    }
    
    private void initUIElements()
    {
    	findViewById(R.id.container_fragments).setOnClickListener(new View.OnClickListener() 
    	{
			public void onClick(View v) 
			{
				if (splashFragment.isVisible())
				{
					FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
					transaction.setCustomAnimations(0, R.anim.slide_up_outside);
					transaction.remove(splashFragment);
					transaction.commit();
				}
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
