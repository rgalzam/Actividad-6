package com.tecmilenio.activity6.ui.gallery;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tecmilenio.activity6.databinding.FragmentGalleryBinding;

import java.util.Calendar;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private int selectedYear, selectedMonth, selectedDay;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        GalleryViewModel galleryViewModel;
        galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calcular la fecha de hoy
                Calendar today = Calendar.getInstance();
                int currentYear = today.get(Calendar.YEAR);
                int currentMonth = today.get(Calendar.MONTH);
                int currentDay = today.get(Calendar.DAY_OF_MONTH);

                // Crear DatePickerDialog y establecer fecha de hoy como default
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                selectedYear = year;
                                selectedMonth = month;
                                selectedDay = dayOfMonth;

                                Calendar today = Calendar.getInstance();
                                int currentDay = today.get(Calendar.DAY_OF_MONTH);
                                int currentMonth = today.get(Calendar.MONTH);
                                int currentYear = today.get(Calendar.YEAR);

                                int ageYears = currentYear - selectedYear;

                                int ageMonths = currentMonth - selectedMonth;

                                if (ageMonths < 0) {
                                    ageYears--;
                                    ageMonths += 12; // Add 12 to the months to get the correct number
                                }

                                // Adjust the month if the current day is before the selected day in the current month
                                if (currentDay < selectedDay) {
                                    ageMonths--; // Subtract 1 month since the current day hasn't reached the birth day yet
                                    if (ageMonths < 0) {
                                        ageMonths += 12; // Adjust months if it becomes negative
                                        ageYears--; // Also adjust years if necessary
                                    }
                                }
                                
                                Toast.makeText(getContext(), "Age: " + ageYears + " years and " + ageMonths + " months", Toast.LENGTH_SHORT).show();
                            }
                        },
                        currentYear, currentMonth, currentDay);

                // Show the DatePickerDialog
                datePickerDialog.show();;
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}