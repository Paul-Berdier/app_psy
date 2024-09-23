package com.example.app_psy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private Button btnAddAppointment;
    private RecyclerView recyclerViewAppointments;
    private TextView tvNoAppointments;
    private AppointmentAdapter appointmentAdapter;

    // List of appointments
    private List<String> appointmentsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        calendarView = findViewById(R.id.calendarView);
        btnAddAppointment = findViewById(R.id.btnAddAppointment);
        recyclerViewAppointments = findViewById(R.id.recyclerViewAppointments);
        tvNoAppointments = findViewById(R.id.tvNoAppointments);

        // Set up the RecyclerView
        recyclerViewAppointments.setLayoutManager(new LinearLayoutManager(this));
        appointmentAdapter = new AppointmentAdapter(appointmentsList);
        recyclerViewAppointments.setAdapter(appointmentAdapter);

        // Set a default date for appointments
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                loadAppointmentsForDate(selectedDate);
            }
        });

        // Add an appointment
        btnAddAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Adding an appointment is not implemented yet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadAppointmentsForDate(String date) {
        // Clear the current list and add dummy appointments
        appointmentsList.clear();
        appointmentsList.add("Appointment with Ms. Dupont at 2 PM");
        appointmentsList.add("Appointment with Mr. Martin at 3 PM");

        if (appointmentsList.isEmpty()) {
            tvNoAppointments.setVisibility(View.VISIBLE);
            recyclerViewAppointments.setVisibility(View.GONE);
        } else {
            tvNoAppointments.setVisibility(View.GONE);
            recyclerViewAppointments.setVisibility(View.VISIBLE);
            appointmentAdapter.notifyDataSetChanged();
        }
    }
}
