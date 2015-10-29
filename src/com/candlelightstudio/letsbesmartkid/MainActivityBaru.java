package com.candlelightstudio.letsbesmartkid;

import java.util.ArrayList;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivityBaru extends FragmentActivity{
	
	private DrawerLayout drawerMenu;
	private ListView menuList;
	private ActionBarDrawerToggle toggleMenu;
	
	private CharSequence titleMenu;
	private CharSequence title;
	
	private String[] menuTitles;
	private TypedArray menuIcons;
	
	private ArrayList<SlideMenuItem> menuItems;
	private SlideMenu menuAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_baru);
       
        title = titleMenu = getTitle();
        menuTitles = getResources().getStringArray(R.array.menu);
        menuIcons = getResources().obtainTypedArray(R.array.menu_icons);
        
        drawerMenu = (DrawerLayout) findViewById(R.id.drawer_layout);
        menuList = (ListView) findViewById(R.id.list_slidermenu);
        
        menuItems = new ArrayList<SlideMenuItem>();
 
        menuItems.add(new SlideMenuItem(menuTitles[0], menuIcons.getResourceId(0, -1)));
        menuItems.add(new SlideMenuItem(menuTitles[1], menuIcons.getResourceId(1, -1)));
        menuItems.add(new SlideMenuItem(menuTitles[2], menuIcons.getResourceId(2, -1)));
        //menuItems.add(new SlideMenuItem(menuTitles[3], menuIcons.getResourceId(3, -1)));
        
        menuIcons.recycle();
        menuList.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				menuHandler(position);
			}
		});
        
        menuAdapter = new SlideMenu(getApplicationContext(), menuItems);
        menuList.setAdapter(menuAdapter);
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
 
        toggleMenu = new ActionBarDrawerToggle(this, drawerMenu,
                R.drawable.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }
 
            public void onDrawerOpened(View drawerView) {
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();;
            }
        };
        drawerMenu.setDrawerListener(toggleMenu);
        if (savedInstanceState == null) {
			// on first time display view for first nav item
			menuHandler(0);
		}
	}
	
	
	private void menuHandler(int position){
		Fragment fragment = null;
		switch(position){
		case 0:
			fragment = new FragmentMain();
			break;
		case 1:
			fragment = new FragmentPencapaian();
			break;
//		case 2:
//			Toast.makeText(getApplicationContext(), "Tentang", Toast.LENGTH_LONG).show();
//			break;
		case 2:
			fragment = new FragmentAbout();
			break;
		default:
			break;
		}
		
		if (fragment != null) {
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, fragment).commit();

			// update selected item and title, then close the drawer
			menuList.setItemChecked(position, true);
			menuList.setSelection(position);
			if(position==0)
				setTitle(getResources().getString(R.string.app_name));
			else
				setTitle(menuTitles[position]);
			drawerMenu.closeDrawer(menuList);
		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
	}
	
	@Override
    public void setTitle(CharSequence title) {
        titleMenu = title;
        getActionBar().setTitle(titleMenu);
    }
	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        toggleMenu.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggleMenu.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (toggleMenu.onOptionsItemSelected(item)) {
          return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }
}
