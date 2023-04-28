package com.example.distantdbusers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(naviglistener);
    }

    public BottomNavigationView.OnNavigationItemSelectedListener naviglistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment unFragment = null;
            switch (item.getItemId()) {
                case R.id.add:
                    unFragment = new AddFragment();
                    break;
//                case R.id.edit:
//                    unFragment = new editFragment();
//                    break;
//                case R.id.list:
//                    unFragment = new ListFragment();
//                    break;
//                case R.id.delete:
//                    unFragment = new DeleteFragment();
//                    break;
            }

            String URL = "http://172.16.21.158:443/"; // or :80
            Bundle bundle = new Bundle();
            bundle.putString("url", URL);
            unFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentplaceholder, unFragment).commit();
            return true;
        }
    };
}