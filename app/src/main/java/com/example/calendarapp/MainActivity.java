package com.example.calendarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView calendarView = findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                openNote(year, month, dayOfMonth);
            }
        });
    }

    public void openNote(int year, int month, int dayOfMonth){
        Intent intent = new Intent(this, NoteActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("dayOfMonth", String.valueOf(dayOfMonth));
        bundle.putString("month", String.valueOf(month + 1));
        bundle.putString("year", String.valueOf(year));

        intent.putExtras(bundle);
        startActivity(intent);
    }


}