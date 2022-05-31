package meesho.round2.autosuggest.service;

import java.util.List;

public interface SuggestionService {

    List<String> getSuggestions(String prefix);

}
