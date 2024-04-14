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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.divyesh.medanon.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

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

//        // Populate the doctor list
//        List<Doctor> doctors = generateSampleDoctors();
//        populateDoctorList(doctors);
//
//        // Populate the psychiatrist list
//        List<Psychiatrist> psychiatrists = generateSamplePsychiatrists();
//        populatePsychiatristList(psychiatrists);
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
        } else if(itemId == R.id.nav_feedback) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FeedbackFragment()).commit();
        }
        else if (itemId == R.id.nav_logout) {
            firebaseAuth.signOut();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }

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

    // Sample data for doctors
    private List<Doctor> generateSampleDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Dr. John Doe", "Psychiatry", "10 years", R.drawable.doctor1));
        doctors.add(new Doctor("Dr. Jane Smith", "Pediatrics", "8 years", R.drawable.doctor2));
        // Add more sample doctors as needed
        return doctors;
    }

    // Sample data for psychiatrists
    private List<Psychiatrist> generateSamplePsychiatrists() {
        List<Psychiatrist> psychiatrists = new ArrayList<>();
        psychiatrists.add(new Psychiatrist("Dr. Sarah Johnson", "Psychiatry", "12 years", R.drawable.psychiatrist1));
        psychiatrists.add(new Psychiatrist("Dr. Michael Brown", "Clinical Psychology", "15 years", R.drawable.psychiatrist2));
        // Add more sample psychiatrists as needed
        return psychiatrists;
    }


    //ActivityMainBinding binding; //     <<<<<-------------------------------------------




    // Method to populate the doctor list
//    private void populateDoctorList(List<Doctor> doctors) {
//        LinearLayout doctorsContainer = findViewById(R.id.doctors_container);
//        LayoutInflater inflater = LayoutInflater.from(this);
//        for (Doctor doctor : doctors) {
//            View doctorCardView = inflater.inflate(R.layout.item_doctor_card, doctorsContainer, false);
//            // Bind data to the doctor card view (name, expertise, experience, image)
//            // Set click listener for doctor card view
//            doctorsContainer.addView(doctorCardView);
//        }
//    }

    // Method to populate the psychiatrist list
//    private void populatePsychiatristList(List<Psychiatrist> psychiatrists) {
//        LinearLayout psychiatristsContainer = findViewById(R.id.psychiatrists_containers);
//        LayoutInflater inflater = LayoutInflater.from(this);
//        for (Psychiatrist psychiatrist : psychiatrists) {
//            View psychiatristCardView = inflater.inflate(R.layout.item_doctor_card, psychiatristsContainer, false);
//            // Bind data to the psychiatrist card view (name, expertise, experience, image)
//            // Set click listener for psychiatrist card view
//            psychiatristsContainer.addView(psychiatristCardView);
//        }
//    }


}








/*
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

*/
















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