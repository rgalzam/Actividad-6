package com.tecmilenio.activity6.ui.list;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tecmilenio.activity6.R;
import com.tecmilenio.activity6.databinding.FragmentListBinding;

import java.util.List;
public class ListFragment extends Fragment {

    public static ListFragment newInstance() {return new ListFragment(); }

    private FragmentListBinding binding;

    String memberList[] = {"Miguel","David","Roberto","Diego"};
    int memberImages[] = {R.drawable.miguel, R.drawable.david, R.drawable.roberto, R.drawable.diego};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ListViewModel listViewModel = new ViewModelProvider(this).get(ListViewModel.class);

        binding = FragmentListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textList;
        listViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        CustomBasedAdapter customAdapter = new CustomBasedAdapter(getContext(),memberList,memberImages);

        binding.listView.setAdapter(customAdapter);

        binding.listView.setOnItemClickListener((parent, view, position, id) -> {

            String clickedMember = memberList[position];
            Toast.makeText(getContext(),"Selected Item: "+clickedMember,Toast.LENGTH_SHORT).show();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}