package com.example.nutritionfinal1.Listeners;

import com.example.nutritionfinal1.Models.RecipeDetailsResponse;

public interface RecipeDetailsListener {
    void didFetch(RecipeDetailsResponse response, String message);
    void didError(String message);
}
