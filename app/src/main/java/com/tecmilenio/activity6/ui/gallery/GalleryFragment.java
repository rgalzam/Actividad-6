package com.tecmilenio.activity6.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tecmilenio.activity6.databinding.FragmentGalleryBinding;

import java.util.Calendar;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

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
                //String day, month, year;
                long longDate = binding.calendarView2.getDate();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(longDate);

                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH) + 1 ;
                int year = calendar.get(Calendar.YEAR);

                //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                //String formattedDate = dateFormat.format(new Date(longDate));
                //month = String.valueOf(binding.calendarView2.getMonth());
                //year = String.valueOf(binding.calendarView2.getYear());

                Toast.makeText(getContext(), day + "/" + month + "/" + year,Toast.LENGTH_SHORT).show();
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