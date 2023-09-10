package com.financial.support.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.financial.support.model.Transaction;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    private final MutableLiveData<List<Transaction>> transactionList;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

        transactionList = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}