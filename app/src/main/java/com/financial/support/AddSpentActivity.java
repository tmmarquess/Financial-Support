package com.financial.support;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.financial.support.databinding.ActivityAddSpentBinding;

import java.util.Calendar;

public class AddSpentActivity extends AppCompatActivity {

    private ActivityAddSpentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddSpentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button chooseDate = binding.chooseDate;

        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddSpentActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                String day = dayOfMonth < 10 ? "0" + dayOfMonth : "" + dayOfMonth;
                                String month = (monthOfYear + 1) < 10 ? "0" + (monthOfYear + 1) : "" + (monthOfYear + 1);
                                chooseDate.setText(day + "/" + month + "/" + year);

                            }
                        },
                        year, month, day);
                datePickerDialog.show();
            }
        });

    }
}