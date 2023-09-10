package com.financial.support;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.financial.support.databinding.ActivityAddSpentBinding;
import com.financial.support.databinding.SpentItemBinding;
import com.financial.support.enums.TransactionType;
import com.financial.support.model.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddSpentActivity extends AppCompatActivity {

    private ActivityAddSpentBinding binding;

    private SpentItemBinding itemBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddSpentBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        Button chooseDate = binding.chooseDate;
        Button save = binding.saveButton;

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

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                double value = binding.transactionValue.getText().toString().isEmpty() ? 0:Double.valueOf(binding.transactionValue.getText().toString());
                String description = binding.description.getText().toString();
                String category = binding.category.getText().toString();
                Date save_date;
                try {
                    save_date = format.parse(binding.chooseDate.getText().toString());
                } catch (ParseException e) {
                    save_date = null;
                }
                TransactionType type = binding.type.getSelectedItem().toString().equals("Income") ? TransactionType.Income : TransactionType.Outcome;

                if(value == 0 || description.isEmpty()){
                    finish();
                }
                Transaction newTransaction = new Transaction(value, description, category, save_date, type);

                replyIntent.putExtra("newTransaction", newTransaction);
                setResult(RESULT_OK, replyIntent);

                finish();
            }
        });

    }
}