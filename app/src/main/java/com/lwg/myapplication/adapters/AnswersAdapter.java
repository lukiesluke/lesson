package com.lwg.myapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lwg.myapplication.R;
import com.lwg.myapplication.models.Item;

import java.util.ArrayList;
import java.util.List;

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {
    private List<Item> list = new ArrayList<>();
    private itemClickedListener listener;

    public AnswersAdapter(itemClickedListener listener) {
        this.listener = listener;
    }

    public void setCountryList(List<Item> listCountryCode) {
        this.list = listCountryCode;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_answers, viewGroup, false);
        return new AnswersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = list.get(position);
        holder.name.setText(item.getOwner().getDisplayName());
        holder.email.setText(item.getOwner().getUserType());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;
        private TextView email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                Item codeEvent = list.get(getAdapterPosition());
                listener.onItemClicked(codeEvent, getAdapterPosition());
            }
        }
    }

    public interface itemClickedListener {
        void onItemClicked(Item item, int selectedViewYPosition);
    }
}
