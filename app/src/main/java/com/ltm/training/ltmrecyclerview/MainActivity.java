package com.ltm.training.ltmrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String [] tableauString = new String[50];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        // Remplir le tableau
        for( int t = 0; t < 50; t++ ) {
            tableauString[t] = "Texte " + t;
        }

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MonAdapter(tableauString);
        recyclerView.setAdapter(mAdapter);
    }

    public class MonAdapter extends RecyclerView.Adapter<MonAdapter.MonViewHolder> {
        private String[] mDataset;

        public class MonViewHolder extends RecyclerView.ViewHolder {
            public TextView textView;
            public MonViewHolder(TextView v) {
                super(v);
                textView = v;
            }
        }

        public MonAdapter(String[] myDataset) {
            mDataset = myDataset;
        }

        @Override
        public MonAdapter.MonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView v = new TextView(getApplicationContext());
            v.setHeight(120);
            v.setTextSize(30.0f);
            v.setBackgroundColor(Color.CYAN);

            MonViewHolder vh = new MonViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MonViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.textView.setText(mDataset[position]);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.length;
        }
    }
}