package com.sajjad.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sajjad.bottomnavigationview.ContactsPackage.ContactsFragment;
import com.sajjad.bottomnavigationview.ContactsPackage.FavouritesFragment;
import com.sajjad.bottomnavigationview.ContactsPackage.MissedCallsFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar mainToolbar;
    FragmentManager fragmentManager;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mainToolbar=findViewById(R.id.mainToolbar);
        setSupportActionBar(mainToolbar);
        //
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        fragmentManager=getSupportFragmentManager();
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationListener);
        //
        fragmentManager.beginTransaction().replace(R.id.fragmentsContainer,new ContactsFragment()).commit();
    }


    BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.contactsItem:
                    selectedFragment=new ContactsFragment();
                    break;
                case R.id.favouritesItem:
                    selectedFragment=new FavouritesFragment();
                    break;
                case R.id.missedCallsItem:
                    selectedFragment=new MissedCallsFragment();
                    break;
            }

            fragmentManager.beginTransaction().replace(R.id.fragmentsContainer,selectedFragment).commit();

            return true;
        }
    };

}
