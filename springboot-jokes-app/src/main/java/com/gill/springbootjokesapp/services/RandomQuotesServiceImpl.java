package com.gill.springbootjokesapp.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class RandomQuotesServiceImpl implements RandomQuotesService {

    public final ChuckNorrisQuotes chuckNorrisQuotes;

    public RandomQuotesServiceImpl(ChuckNorrisQuotes chuckNorrisQuotes) {
        this.chuckNorrisQuotes = chuckNorrisQuotes;
    }

    public String getRandomJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
