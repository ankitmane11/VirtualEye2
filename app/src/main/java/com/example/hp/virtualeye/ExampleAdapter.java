package com.example.hp.virtualeye;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private CardView cardView;
    private ArrayList<example_item> example_items1;
    private onItemClickListener listener;

    public interface onItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(onItemClickListener listener)
    {
        this.listener=listener;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView  char1;
        public TextView name1;

        public ExampleViewHolder(@NonNull View itemView, final onItemClickListener listener) {
            super(itemView);
            char1=itemView.findViewById(R.id.char1);
            name1=itemView.findViewById(R.id.name1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null)
                    {
                        int position=getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }


    public ExampleAdapter(ArrayList<example_item> example_items){
        example_items1=example_items;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        ExampleViewHolder evh=new ExampleViewHolder(v,listener);
        return evh;
    }


    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
        example_item current_example=example_items1.get(i);


        exampleViewHolder.char1.setText(current_example.getA());
        exampleViewHolder.name1.setText(current_example.getText());


    }


    @Override
    public int getItemCount() {
        return example_items1.size();
    }
}

