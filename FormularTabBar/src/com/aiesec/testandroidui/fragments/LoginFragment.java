package com.aiesec.testandroidui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aiesec.testandroidui.R;
import com.aiesec.testandroidui.TabActivity;

public class LoginFragment extends Fragment
{
	private EditText usernameEditText;
	private EditText passwordEditText;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View parentView = inflater.inflate(R.layout.login_layout, container, false);
		initUIElements(parentView);
		
		return parentView;
	}

	private void initUIElements(View parentView)
	{
		Button loginButton = (Button)parentView.findViewById(R.id.btn_login);
		usernameEditText = (EditText)parentView.findViewById(R.id.edt_username);
		passwordEditText = (EditText)parentView.findViewById(R.id.edt_password);
		loginButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) 
			{
				if (usernameEditText.getText().toString().equals("")
						&& passwordEditText.getText().toString().equals(""))
				{
					Intent intent = new Intent(getActivity(), TabActivity.class);
					startActivity(intent);
				}
				else
				{
					Toast.makeText(getActivity(), "Wrong username / password", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
}
