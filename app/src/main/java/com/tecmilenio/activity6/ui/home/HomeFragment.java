package com.tecmilenio.activity6.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tecmilenio.activity6.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        binding.SpinnerMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l){

                String item = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "select item: "+ item, Toast.LENGTH_SHORT).show();

            }
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Miguel");
        arrayList.add("Roberto");
        arrayList.add("David");
        arrayList.add("Diego");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        binding.SpinnerMain.setAdapter(arrayAdapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}