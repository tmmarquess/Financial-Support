package com.financial.support.ui.Finance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.financial.support.databinding.FragmentFinanceBinding;
import com.financial.support.databinding.FragmentNotificationsBinding;

public class FinanceFragment extends Fragment {

    private FragmentFinanceBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        com.financial.support.ui.Finance.FinanceViewModel financeViewModel =
                new ViewModelProvider(this).get(com.financial.support.ui.Finance.FinanceViewModel.class);

        binding = FragmentFinanceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}