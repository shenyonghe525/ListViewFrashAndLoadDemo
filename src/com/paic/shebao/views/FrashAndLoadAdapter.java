package com.paic.shebao.views;

import java.util.List;

import com.paic.shebao.dto.ApkEntity;
import com.paic.shebao.utils.MyBaseAdapter;
import com.paic.shebao.utils.ViewHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FrashAndLoadAdapter extends MyBaseAdapter<ApkEntity> {

	public FrashAndLoadAdapter(Context context, List<ApkEntity> datas,
			int itemId)
	{
		super(context, datas, itemId);
	}
	
	
	@Override
	public void convert(View convertView, ViewGroup parent, ApkEntity t)
	{
		TextView name = ViewHolder.get(convertView,
				com.example.listviewfrashdemo1.R.id.item3_apkname);
		TextView des = ViewHolder.get(convertView,
				com.example.listviewfrashdemo1.R.id.item3_apkdes);
		TextView info = ViewHolder.get(convertView,
				com.example.listviewfrashdemo1.R.id.item3_apkinfo);
		// TODO 控件的响应事件

		name.setText(t.getName());
		des.setText(t.getDes());
		info.setText(t.getInfo());

	}

}
