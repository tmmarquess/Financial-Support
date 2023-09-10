package com.financial.support.repository;

import android.app.Application;

import com.financial.support.AppDatabase;
import com.financial.support.dao.TransactionDAO;
import com.financial.support.model.Transaction;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public class TransactionRepository {

    private TransactionDAO transactionDAO;

    public TransactionRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        this.transactionDAO = db.transactionDAO();
    }

    public Future<List<Transaction>> getAllTransactions(){
        AtomicReference<List<Transaction>> transactions = null;
        return AppDatabase.databaseWriteExecutor.submit(new Callable<List<Transaction>>() {
            @Override
            public List<Transaction> call() {return transactionDAO.getTransactions();}
        });
    }

    public void addTransaction(Transaction t){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            transactionDAO.insert(t);
            System.out.println("==========ADDED=========");
        });
    }
}
