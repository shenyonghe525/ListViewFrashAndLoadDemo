package com.paic.shebao.views;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.example.listviewfrashdemo1.R;
import com.paic.shebao.dto.ApkEntity;
import com.paic.shebao.views.ReFlashAndLoadListView.IReflashAndLoadListener;

public class MainActivity extends Activity implements IReflashAndLoadListener {
	ArrayList<ApkEntity> apk_list;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setData();
		showList(apk_list);
	}

	FrashAndLoadAdapter adapter;
	ReFlashAndLoadListView listview;

	private void showList(ArrayList<ApkEntity> apk_list)
	{
		if (adapter == null)
		{
			listview = (ReFlashAndLoadListView) findViewById(R.id.listview);
			listview.setInterface(this);
			adapter = new FrashAndLoadAdapter(this, apk_list,R.layout.item_layout);
			listview.setAdapter(adapter);
		} else
		{
			adapter.onDateChange(apk_list);
		}
	}

	private void setData()
	{
		apk_list = new ArrayList<ApkEntity>();
		for (int i = 0; i < 10; i++)
		{
			ApkEntity entity = new ApkEntity();
			entity.setName("默认数据");
			entity.setDes("这是一个神奇的应用");
			entity.setInfo("50w用户");
			apk_list.add(entity);
		}
	}

	private void setReflashData()
	{
		for (int i = 0; i < 2; i++)
		{
			ApkEntity entity = new ApkEntity();
			entity.setName("刷新数据");
			entity.setDes("这是一个神奇的应用");
			entity.setInfo("50w用户");
			apk_list.add(0, entity);
		}
	}

	@Override
	public void onReflash()
	{
		Handler handler = new Handler();
		handler.postDelayed(new Runnable()
		{

			public void run()
			{
				// 获取最新数据
				setReflashData();
				// 通知界面显示
				showList(apk_list);
				// 通知listview 刷新数据完毕；
				listview.reflashComplete();
			}
		}, 2000);

	}


	private void getLoadData()
	{
		for (int i = 0; i < 2; i++)
		{
			ApkEntity entity = new ApkEntity();
			entity.setName("更多程序");
			entity.setInfo("50w用户");
			entity.setDes("这是一个神奇的应用！");
			apk_list.add(entity);
		}
	}

	@Override
	public void onLoad()
	{
		// TODO Auto-generated method stub
		Handler handler = new Handler();
		handler.postDelayed(new Runnable()
		{

			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				// 获取更多数据
				getLoadData();
				// 更新listview显示；
				showList(apk_list);
				// 通知listview加载完毕
				listview.loadComplete();
			}
		}, 1000);
	}
}
