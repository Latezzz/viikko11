package com.main.viikko11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private ListGrocery listGrocery;

    private RecyclerView recyclerView;

    private RecyclerView.Adapter adapter;


    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listGrocery = ListGrocery.getInstance();
        recyclerView = findViewById(R.id.rvGroceries);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GroceryViewAdapter(getApplicationContext(), listGrocery.getGroceries());
        recyclerView.setAdapter(adapter);
    }


    public void switchToAddGrocery(View view) {
        Intent intent = new Intent(this, AddGroceryActivity.class);
        startActivity(intent);
    }

}