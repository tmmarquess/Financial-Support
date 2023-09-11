package com.financial.support.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.financial.support.model.Transaction;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> total;

    private final MutableLiveData<List<Transaction>> transactionList;


    public HomeViewModel() {
        total = new MutableLiveData<>();
        total.setValue("R$xx,xx");

        transactionList = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return total;
    }
}