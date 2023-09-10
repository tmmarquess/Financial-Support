package com.financial.support.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.financial.support.model.Transaction;

import java.util.List;


@Dao
public interface TransactionDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Transaction transaction);

    @Query("DELETE FROM `Transaction`")
    void deleteAll();

    @Query("SELECT * FROM `Transaction` ORDER BY date ASC")
    List<Transaction> getTransactions();
}
