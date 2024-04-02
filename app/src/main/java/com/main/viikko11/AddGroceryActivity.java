package com.main.viikko11;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddGroceryActivity extends AppCompatActivity {

    private EditText name;

    private EditText note;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_grocery);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.editGroceryName);
        note = findViewById(R.id.editGroceryNote);


    }

    public void addGrocery(View view) {
        String groceryName = name.getText().toString();
        String groceryNote = note.getText().toString();

        ListGrocery.getInstance().addGrocery(new Grocery(groceryName, groceryNote));
    }
}