package com.example.yogafitness;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    String buttonValue;
    Button startBtn;
    TextView timerTextView;
    CountDownTimer countDownTimer;
    boolean timerRunning;
    long timeLeftInMillis;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        buttonValue = intent.getStringExtra("value");

        int intValue = Integer.valueOf(buttonValue);

        switch (intValue) {
            case 1:
                setContentView(R.layout.activity_exercise_1);
                break;
            case 2:
                setContentView(R.layout.activity_exercise_2);
                break;
            case 3:
                setContentView(R.layout.activity_exercise_3);
                break;
            case 4:
                setContentView(R.layout.activity_exercise_4);
                break;
            case 5:
                setContentView(R.layout.activity_exercise_5);
                break;
            case 6:
                setContentView(R.layout.activity_exercise_6);
                break;
            case 7:
                setContentView(R.layout.activity_exercise_7);
                break;
            case 8:
                setContentView(R.layout.activity_exercise_8);
                break;
            case 9:
                setContentView(R.layout.activity_exercise_9);
                break;
            case 10:
                setContentView(R.layout.activity_exercise_10);
                break;
            case 11:
                setContentView(R.layout.activity_exercise_11);
                break;
            case 12:
                setContentView(R.layout.activity_exercise_12);
                break;
            case 13:
                setContentView(R.layout.activity_exercise_13);
                break;
            case 14:
                setContentView(R.layout.activity_exercise_14);
                break;
            case 15:
                setContentView(R.layout.activity_exercise_15);
                break;


            default:
                setContentView(R.layout.activity_exercise_1);
                break;
        }

        startBtn = findViewById(R.id.startbutton);
        timerTextView = findViewById(R.id.time);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerRunning) {
                    stopTimer();
                } else {
                    startTimer();
                }
            }
        });
    }

    private void startTimer() {
        String timeString = timerTextView.getText().toString();
        int minutes = Integer.parseInt(timeString.substring(0, 2));
        int seconds = Integer.parseInt(timeString.substring(3, 5));
        timeLeftInMillis = (minutes * 60 + seconds) * 1000;

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                // Logic to handle finishing of the timer
                int newValue = Integer.valueOf(buttonValue) + 1;
                if (newValue <= 7) {
                    startNewActivity(newValue);
                } else {
                    startNewActivity(1);
                }
            }
        }.start();

        timerRunning = true;
        startBtn.setText("Pause");
    }

    private void stopTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        startBtn.setText("START");
    }

    private void updateTimer() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);
        timerTextView.setText(timeLeftFormatted);
    }

    private void startNewActivity(int value) {
        Intent intent = new Intent(ThirdActivity.this, ThirdActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("value", String.valueOf(value));
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
