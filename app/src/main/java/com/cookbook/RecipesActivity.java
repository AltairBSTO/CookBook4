package com.cookbook;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecipesActivity extends AppCompatActivity {

    private RecyclerView rvRecipes;
    private TextView tvNoRecipes;
    private Button btnAgregarReceta;
    private RecipesAdapter adapter;
    private List<Recetas> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        rvRecipes = findViewById(R.id.rvRecipes);
        tvNoRecipes = findViewById(R.id.tvNoRecipes);
        btnAgregarReceta = findViewById(R.id.btnAgregarReceta);

        rvRecipes.setLayoutManager(new LinearLayoutManager(this));


        recipeList = new ArrayList<>();
        adapter = new RecipesAdapter(recipeList);
        rvRecipes.setAdapter(adapter);


        toggleNoRecipesMessage();


        btnAgregarReceta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RecipesActivity.this, agregarRecetas.class);
                startActivity(intent);
            }
        });
    }

    private void toggleNoRecipesMessage() {
        if (recipeList.isEmpty()) {
            tvNoRecipes.setVisibility(View.VISIBLE);
        } else {
            tvNoRecipes.setVisibility(View.GONE);
        }
    }
}