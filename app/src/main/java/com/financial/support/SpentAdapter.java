package com.financial.support;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.financial.support.enums.TransactionType;
import com.financial.support.model.Transaction;
import com.financial.support.databinding.SpentItemBinding;

import java.text.SimpleDateFormat;
import java.util.List;

public class SpentAdapter extends RecyclerView.Adapter<SpentVH> {

    List<Transaction> spents;

    public SpentAdapter(List<Transaction> spents) {
        this.spents = spents;
    }

    @NonNull
    @Override
    public SpentVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.spent_item, parent, false);
        return new SpentVH(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull SpentVH holder, int position) {
        holder.spentDescription.setText(spents.get(position).getDescription().toString());
        holder.spentDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(spents.get(position).getDate()));

        if(spents.get(position).getType() == TransactionType.Outcome){
            holder.spentValue.setText("R$"+ spents.get(position).getValue() * -1);
            holder.spentValue.setTextColor(Color.parseColor("#C23D3D"));
        }else{
            holder.spentValue.setText("R$"+ spents.get(position).getValue());
            holder.spentValue.setTextColor(Color.parseColor("#2FAD34"));
        }

    }

    @Override
    public int getItemCount() {
        return spents.size();
    }
}

class SpentVH extends RecyclerView.ViewHolder{

    TextView spentDescription;
    TextView spentValue;

    TextView spentDate;

    private SpentAdapter adapter;

    private SpentItemBinding binding;


    public SpentVH(@NonNull View itemView) {
        super(itemView);

        spentDescription = itemView.findViewById(R.id.descText);
        spentValue = itemView.findViewById(R.id.price);
        spentDate = itemView.findViewById(R.id.dateText);
    }

    public SpentVH linkAdapter(SpentAdapter adapter){
        this.adapter = adapter;
        return this;
    }
}