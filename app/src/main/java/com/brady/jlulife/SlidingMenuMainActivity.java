package com.brady.jlulife;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.brady.jlulife.Fragments.CourseListFragment;
import com.brady.jlulife.Fragments.MenuFragment;
import com.brady.jlulife.Fragments.UIMSAuthFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class SlidingMenuMainActivity extends AppCompatActivity {
    private Context mContext;
    private SlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_container,new CourseListFragment());
        transaction.commit();
        initSlidingMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_upgrade) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.main_container,new UIMSAuthFragment());
            transaction.commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void initSlidingMenu(){
        menu = new SlidingMenu(mContext);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidth(200);
        menu.setBehindOffset(500);
        menu.setFadeDegree(0.5f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.menu_container);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.menu_container,new MenuFragment());
        transaction.commit();
    }
    public SlidingMenu getMenu(){
        return menu;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

    }
}