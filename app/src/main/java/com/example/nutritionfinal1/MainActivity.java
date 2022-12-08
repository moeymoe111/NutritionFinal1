package com.example.nutritionfinal1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutritionfinal1.Adapters.RandomRecipeAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ProgressDialog dialog;
    RequestManager manager;
    RecyclerView recyclerView;
    SearchView searchView;
    RandomRecipeAdapter randomRecipeAdapter;
    List<String> tags = new ArrayList<>();
    Button mex, ind, ital, japan, euro, carib;
    String query;

    //Create the launch page of the app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the view to the main activity layout XML
        setContentView(R.layout.recipes_start_screen);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading...");

       findButtons();

        //Create a search bar with the created searchView layout that reads user input
        searchView = findViewById(R.id.searchView_start);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                //Call getRandomRecipes method with given tags to show user search results
                startActivity(new Intent(MainActivity.this, ShowRecipesActivity.class)
                        .putExtra("query", query));
                return true;
            }

            @Override
            //Do nothing when user changes search text
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        mex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query = "mexican";
                openShowRecipes();
            }
        });
        ind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query = "indian";
                openShowRecipes();
            }
        });
        ital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query = "italian";
                openShowRecipes();
            }
        });
        japan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query = "japanese";
                openShowRecipes();
            }
        });
        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query = "european";
                openShowRecipes();
            }
        });
        carib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query = "caribbean";
                openShowRecipes();
            }
        });


        dialog.show();
    }

    private void findButtons() {
        mex = (Button) findViewById(R.id.mexicanButton);
        ind = (Button) findViewById(R.id.indianButton);
        ital = (Button) findViewById(R.id.italianButton);
        japan = (Button) findViewById(R.id.japaneseButton);
        euro = (Button) findViewById(R.id.europeanButton);
        carib = (Button) findViewById(R.id.caribbeanButton);

    }


    public void openShowRecipes(){
        startActivity(new Intent(MainActivity.this, ShowRecipesActivity.class)
                .putExtra("query", query));
    }
}
