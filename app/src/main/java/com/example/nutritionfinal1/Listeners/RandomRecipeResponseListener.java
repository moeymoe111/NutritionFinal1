package com.example.nutritionfinal1.Listeners;

import com.example.nutritionfinal1.Models.RandomRecipeAPIResponse;

public interface RandomRecipeResponseListener {
    void didFetch(RandomRecipeAPIResponse response, String message);
    void didError(String message);
}
