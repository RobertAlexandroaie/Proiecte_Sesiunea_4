package com.aiesec.testandroidui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aiesec.testandroidui.R;
import com.aiesec.testandroidui.data.AccountEntity;
import com.aiesec.testandroidui.data.manager.AccountDataManager;

public class AccountListAdapter extends BaseAdapter
{
	private LayoutInflater layoutInflater;
	private AccountDataManager manager;

	public AccountListAdapter(Activity activity, AccountDataManager manager)
	{
		layoutInflater = (LayoutInflater)activity.
				getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.manager = manager;
	}

	@Override
	public int getCount()
	{
		return manager.getAccounts().size();
	}

	@Override
	public Object getItem(int arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if (convertView == null)
		{
			convertView = layoutInflater.
					inflate(R.layout.cell_account_list, null);
		}
		AccountEntity entity = manager.getAccounts().get(position);
		TextView accountBankName = (TextView)convertView.findViewById
				(R.id.txt_account_bank_name);
		TextView accountNumber = (TextView)convertView.
				findViewById(R.id.txt_account_number);

		accountBankName.setText(entity.getBankName());
		accountNumber.setText(entity.getAccountNumber());
		

		return convertView;
	}

}
