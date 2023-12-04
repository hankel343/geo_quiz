package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ProfessorClassView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_class_view);

        // Get the TableLayout from the layout
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Hardcoded student data
        String[][] students = {
                {"John", "Doe", "12345"},
                {"Jane", "Doe", "23456"},
                {"Jim", "Brown", "34567"},
                {"Jill", "Smith", "45678"},
                {"Jack", "Johnson", "56789"}
        };

        // Add each student to the table
        for (String[] student : students) {
            TableRow row = new TableRow(this);

            TextView firstName = new TextView(this);
            firstName.setText(student[0]);
            row.addView(firstName);

            TextView lastName = new TextView(this);
            lastName.setText(student[1]);
            row.addView(lastName);

            TextView studentId = new TextView(this);
            studentId.setText(student[2]);
            row.addView(studentId);

            tableLayout.addView(row);
        }
    }
}
