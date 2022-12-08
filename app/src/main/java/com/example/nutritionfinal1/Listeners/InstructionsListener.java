package com.example.nutritionfinal1.Listeners;

import com.example.nutritionfinal1.Listeners.Models.InstructionsResponse;

import java.util.List;

public interface InstructionsListener {
    void didFetch(List<InstructionsResponse> response, String message);
    void didError(String message);
}
