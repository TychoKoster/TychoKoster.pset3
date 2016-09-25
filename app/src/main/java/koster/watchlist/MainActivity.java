package koster.watchlist;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static koster.watchlist.R.id.time;

public class MainActivity extends AppCompatActivity {
    private BottomBar bottomBar;
    private Toolbar toolbar;
    EditText MovieTitle;
    public TextView responseView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        responseView = (TextView) findViewById(R.id.responseView);
        MovieTitle = (EditText) findViewById(R.id.emailText);
        bottomBar = BottomBar.attach(this, savedInstanceState);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottomBar.setItemsFromMenu(R.menu.bottombar_menu, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottomBarItemOne) {
                    android.app.FragmentManager fragmentmanager = getFragmentManager();
                    android.app.FragmentTransaction transaction = fragmentmanager.beginTransaction();
                    HomeFragment homeFragment = new HomeFragment();
                    transaction.replace(android.R.id.content, homeFragment);
                    transaction.commit();
                } else if (menuItemId == R.id.bottomBarItemTwo) {
                    android.app.FragmentManager fragmentmanager = getFragmentManager();
                    android.app.FragmentTransaction transaction = fragmentmanager.beginTransaction();
                    FavoriteFragment favoriteFragment = new FavoriteFragment();
                    transaction.replace(android.R.id.content, favoriteFragment);
                    transaction.commit();
                } else if (menuItemId == R.id.bottomBarItemThree) {
                    android.app.FragmentManager fragmentmanager = getFragmentManager();
                    android.app.FragmentTransaction transaction = fragmentmanager.beginTransaction();
                    SearchFragment searchFragment = new SearchFragment();
                    transaction.replace(android.R.id.content, searchFragment);
                    transaction.commit();
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottomBarItemOne) {
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        bottomBar.onSaveInstanceState(outState);
    }
}
