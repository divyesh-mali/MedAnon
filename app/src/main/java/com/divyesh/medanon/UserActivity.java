package com.divyesh.medanon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

// changing MainActivity to UserActivity
public class UserActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    private DrawerLayout drawerLayout;
    private FirebaseAuth firebaseAuth;

    private static final int NAV_HOME = R.id.nav_home;
    private static final int NAV_SETTINGS = R.id.nav_settings;
    private static final int NAV_ABOUT = R.id.nav_about;
    private static final int NAV_LOGOUT = R.id.nav_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        firebaseAuth = FirebaseAuth.getInstance();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation drawer item clicks
        int itemId = item.getItemId();

        if (itemId == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        } else if (itemId == R.id.nav_settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
        } else if (itemId == R.id.nav_about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InfoFragment()).commit();
        } else if (itemId == R.id.nav_logout) {
            firebaseAuth.signOut();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }


//        switch (item.getItemId()) {
//            case R.id.nav_home:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
//                break;
//
//            case R.id.nav_settings:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
//                break;
//
//            case R.id.nav_about:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InfoFragment()).commit();
//                break;
//
//            case R.id.nav_logout:
//                firebaseAuth.signOut();
//                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(intent);
//                finish();
//                break;
//        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            item -> {
                Fragment selectedFragment = null;

                if (item.getItemId() == R.id.home) {
                    selectedFragment = new HomeFragment();
                } else if (item.getItemId() == R.id.forum) {
                    selectedFragment = new ForumFragment();
                } else if (item.getItemId() == R.id.create) {
                    selectedFragment = new CreateFragment();
                } else if (item.getItemId() == R.id.chat) {
                    selectedFragment = new ChatFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();

                return true;
            };




    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}






/* Main Logout code */
//package com.divyesh.medanon;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//
//public class UserActivity extends AppCompatActivity {
//
//    Button btnLogOut;
//    TextView txtUser;
//    FirebaseAuth firebaseAuth;
//    FirebaseUser user;
//    private FirebaseAuth.AuthStateListener authStateListener;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user);
//        firebaseAuth = FirebaseAuth.getInstance();
//        btnLogOut = (Button) findViewById(R.id.btnLogOut);
//        txtUser = (TextView) findViewById(R.id.txtUser);
//        user = firebaseAuth.getCurrentUser();
//
//        if (user == null ) {
//            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//            startActivity(intent);
//            finish();
//        }
//        else {
//            txtUser.setText(user.getEmail());
//        }
//
//        btnLogOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                FirebaseAuth.getInstance().signOut();
//                //Intent I = new Intent(UserActivity.this, LoginActivity.class);
//                //startActivity(I);
//                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(intent);
//                finish();
//
//            }
//        });
//
//    }
//}












//package com.divyesh.medanon;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class UserActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user);
//    }
//}