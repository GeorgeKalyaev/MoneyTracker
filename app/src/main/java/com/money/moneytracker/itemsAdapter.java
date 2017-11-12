package com.money.moneytracker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 04.11.2017.
 */

public class itemsAdapter extends RecyclerView.Adapter<itemsAdapter.itemViewHolder>    {

    private List<item> items = new ArrayList<>();

    public itemsAdapter(){
        items.add(new item ("Молоко", 35 ));
        items.add(new item ("Зубная щётка", 1500 ));
        items.add(new item ("Сковородка с антипригарным покрытием", 55 ));
        items.add(new item ("Молоко", 35 ));
        items.add(new item ("Зубная щётка", 1500 ));
        items.add(new item ("Сковородка с антипригарным покрытием", 55 ));
        items.add(new item ("Молоко", 35 ));
        items.add(new item ("Зубная щётка", 1500 ));
        items.add(new item ("Сковородка с антипригарным покрытием", 55 ));
        items.add(new item ("Молоко", 35 ));
        items.add(new item ("Зубная щётка", 1500 ));
        items.add(new item ("Сковородка с антипригарным покрытием", 55 ));
        items.add(new item ("Молоко", 35 ));
        items.add(new item ("Зубная щётка", 1500 ));
        items.add(new item ("Сковородка с антипригарным покрытием", 55 ));
        items.add(new item ("Молоко", 35 ));
        items.add(new item ("Зубная щётка", 1500 ));
        items.add(new item ("Сковородка с антипригарным покрытием", 55 ));
        items.add(new item ("Молоко", 35 ));
        items.add(new item ("Зубная щётка", 1500 ));
        items.add(new item ("Сковородка с антипригарным покрытием", 55 ));
        items.add(new item ("Молоко", 35 ));
        items.add(new item ("Зубная щётка", 1500 ));
        items.add(new item ("Сковородка с антипригарным покрытием", 55 ));
        items.add(new item ("Молоко", 35 ));
        items.add(new item ("Зубная щётка", 1500 ));
        items.add(new item ("Сковородка с антипригарным покрытием", 55 ));

    }

    @Override
    public itemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(itemViewHolder holder, int position) {
        item item = items.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    static class itemViewHolder extends RecyclerView.ViewHolder {


        private TextView name;
        private TextView price;


        itemViewHolder(View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
        }

        void bind(item item){
            name.setText(item.getName());
            price.setText(String.valueOf(item.getPrice()+ " ք"));
        }

    }

}
