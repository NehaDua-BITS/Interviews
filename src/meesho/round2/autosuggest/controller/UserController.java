package meesho.round2.autosuggest.controller;

import meesho.round2.autosuggest.service.SuggestionService;
import meesho.round2.autosuggest.service.impl.SuggestionServiceImpl;

import java.util.List;

public class UserController {

    private SuggestionService suggestionService = new SuggestionServiceImpl();


    //search GET call
    public List<String> getSuggestions(String prefix) {
        return suggestionService.getSuggestions(prefix);
    }
}
