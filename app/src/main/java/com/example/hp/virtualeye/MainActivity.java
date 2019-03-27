package com.example.hp.virtualeye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton submit;
    EditText name;
    RecyclerView list;
    ImageButton delete;
    private RecyclerView mrecycler_view;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<example_item> example_items;
    private int pos=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit=findViewById(R.id.submit);
        name=findViewById(R.id.name);
        list=findViewById(R.id.list);
        delete=findViewById(R.id.delete);
        example_items=new ArrayList<>();
        example_items.add(new example_item("W","Wallet"));
        example_items.add(new example_item("B","Bottle"));
        example_items.add(new example_item("C","Charger"));

        mrecycler_view=findViewById(R.id.list);
        mrecycler_view.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        mAdapter=new ExampleAdapter(example_items);

        mrecycler_view.setLayoutManager(layoutManager);
        mrecycler_view.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String a=example_items.get(position).getText();
                Toast.makeText(MainActivity.this,a+" Clicked",Toast.LENGTH_SHORT).show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please enter details",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String i,j;
                    i=name.getText().toString();
                    j=i.substring(0,1);
                    example_items.add(new example_item(j,i));
                    mAdapter.notifyDataSetChanged();
                    name.setText("");

                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please enter details",Toast.LENGTH_SHORT).show();
                }
                else {
                    int i;
                    for (i = 0; i < mAdapter.getItemCount(); i++) {
                        if (example_items.get(i).getText().toLowerCase().equals(name.getText().toString().toLowerCase())) {
                            example_items.remove(i);
                            mAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter correct name", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                }

        });




    }
}
