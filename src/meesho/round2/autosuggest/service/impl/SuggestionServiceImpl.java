package meesho.round2.autosuggest.service.impl;

import meesho.round2.autosuggest.repository.AbstractRepository;
import meesho.round2.autosuggest.repository.RedisRepository;
import meesho.round2.autosuggest.service.SuggestionService;
import meesho.round2.autosuggest.service.impl.KafkaService;

import java.util.List;

public class SuggestionServiceImpl implements SuggestionService {

    private AbstractRepository repository;

    private KafkaService kafkaService;

    public SuggestionServiceImpl() {
        repository = new RedisRepository();
    }

    @Override
    public List<String> getSuggestions(String prefix) {
        List<String> topWords = repository.get(prefix);
        kafkaService.pushToTopic(prefix);
        return topWords;
    }

}
