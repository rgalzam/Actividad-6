package com.tecmilenio.activity6.ui.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListViewModel extends ViewModel {

        private final MutableLiveData<String> mText;

        public ListViewModel(){

            mText = new MutableLiveData<>();
            mText.setValue("List View");
        }

        public LiveData<String> getText() {return mText;}
    }