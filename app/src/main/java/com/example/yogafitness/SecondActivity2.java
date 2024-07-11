package com.example.yogafitness;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity2 extends AppCompatActivity {

    int[] newArray;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        newArray = new int[]{

                R.id.mountain_climber,
                R.id.basic_crunches,
                R.id.bench_dips,
                R.id.bicycle_crunches,
                R.id.leg_raise,
                R.id.alternative_touch_heel,
                R.id.leg_up_crunches,
                R.id.sit_ups,
                R.id.alternative_v_ups,
                R.id.plank_rotation,
                R.id.plank_with_left_leg,
                R.id.russian_twist,
                R.id.bridge_pose,
                R.id.vertical_leg_crunches,
                R.id.wind_mill,
        };

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_privacy_policy) {
            showPrivacyPolicyDialog();
            return true;
        }

        if (id == R.id.term) {
            showTermsDialog();
            return true;
        }

        if (id == R.id.rate) {

            try{
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
            }
            catch (Exception e){
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
            }

            return true;
        }

        if (id == R.id.share) {

            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String sharebody = "This is a fun app for doing Yoga\n By the way its free Soo...\n Download Now\n" +
                    "https://play.google.com/store/apps/details?id=com.example.yogafitness&hl=en";
            String sharehub = "Yoga Fitness App";
            myIntent.putExtra(Intent.EXTRA_TEXT, sharebody);
            myIntent.putExtra(Intent.EXTRA_SUBJECT, sharehub);
            startActivity(Intent.createChooser(myIntent, "Share via"));


            return true;
        }

        return true;
    }

    private void showPrivacyPolicyDialog() {
        String privacyPolicyText = getString(R.string.privacy_policy_text);
        new AlertDialog.Builder(this)
                .setTitle("Privacy Policy")
                .setMessage(privacyPolicyText)
                .setPositiveButton("Close", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void showTermsDialog() {
        String termsText = getString(R.string.terms_text);
        new AlertDialog.Builder(this)
                .setTitle("Terms and Conditions")
                .setMessage(termsText)
                .setPositiveButton("Close", (dialog, which) -> dialog.dismiss())
                .show();
    }

    public void Imagebuttonclicked(View view) {

        for(int i = 0;i< newArray.length;i++){
            if(view.getId() == newArray[i]){
                int value = i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent = new Intent(SecondActivity2.this,ThirdActivity2.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);

            }
        }

    }
}