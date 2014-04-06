package com.aiesec.testandroidui.fragments;

import com.aiesec.testandroidui.MainActivity;
import com.aiesec.testandroidui.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SplashFragment extends Fragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.splash_layout,
				container, false);
		view.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) 
			{
				((MainActivity)getActivity()).hideSplashFragment();
			}
		});
		return view;
	}
}
