package com.financial.support.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.financial.support.AddSpentActivity;
import com.financial.support.SpentAdapter;
import com.financial.support.databinding.FragmentHomeBinding;
import com.financial.support.enums.TransactionType;
import com.financial.support.model.Transaction;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class HomeFragment extends Fragment {

    public static final int NEW_TRANSACTION_ACTIVITY_REQUEST_CODE = 1;

    private FragmentHomeBinding binding;
    private List<Transaction> itensList;

    private SpentAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        itensList = new LinkedList<>();
        itensList.add(new Transaction(50.5, "batata", "teste", new Date(), TransactionType.Outcome));

        RecyclerView recyclerView = binding.SpentList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new SpentAdapter(itensList);
        recyclerView.setAdapter(adapter);

        final FloatingActionButton addButton = binding.AddButton;

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent addScreen = new Intent(getContext(), AddSpentActivity.class);
                startActivityForResult(addScreen, NEW_TRANSACTION_ACTIVITY_REQUEST_CODE);
            }
        });

        return root;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_TRANSACTION_ACTIVITY_REQUEST_CODE && resultCode == -1) {
            Transaction transaction = (Transaction) data.getSerializableExtra("newTransaction");
            System.out.println(transaction);
            itensList.add(new Transaction(transaction.getValue(), transaction.getDescription(), transaction.getCategory(), transaction.getDate(), transaction.getType()));
            adapter.notifyItemInserted(itensList.size() - 1);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}