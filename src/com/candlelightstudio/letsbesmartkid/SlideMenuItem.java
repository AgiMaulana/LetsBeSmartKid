package com.candlelightstudio.letsbesmartkid;

public class SlideMenuItem {
	private String menu;
	private int icon;
	
	public SlideMenuItem(){}
	
	public SlideMenuItem(String menu, int icon){
		this.menu = menu;
		this.icon = icon;
	}
	
	public String getMenu(){
		return this.menu;
	}
	
	public int getIcon(){
		return this.icon;
	}
	
	public void setMenu(String menu){
		this.menu = menu;
	}
	
	public void setIcon(int icon){
		this.icon = icon;
	}
}
