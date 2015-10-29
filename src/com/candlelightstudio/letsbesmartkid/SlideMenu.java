package com.candlelightstudio.letsbesmartkid;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SlideMenu extends BaseAdapter {

	private Context ctx;
	private ArrayList<SlideMenuItem> ListMenu;
	
	public SlideMenu(Context c, ArrayList<SlideMenuItem> ListMenu){
		this.ctx = c;
		this.ListMenu = ListMenu;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ListMenu.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return ListMenu.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.list_menu, null);
		}
		
		ImageView icon = (ImageView) convertView.findViewById(R.id.img_IconMenu);
		TextView title = (TextView) convertView.findViewById(R.id.lbl_Menu);
		
		icon.setImageResource(ListMenu.get(position).getIcon());
		title.setText(ListMenu.get(position).getMenu());
		
		return convertView;
	}

}
