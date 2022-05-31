package meesho.round2.autosuggest.service;

import meesho.round2.autosuggest.configuration.KafkaConfig;
import meesho.round2.autosuggest.model.WordFreq;

import java.util.List;
import java.util.Map;

public interface RankingService {

    //fetch data from kafka
    void consume(KafkaConfig config);

    //rank words in last 1 hour
    Map<String, List<String>> rank(List<String> words);

    //save in Redis
    void saveTopK(Map<String, List<WordFreq>> topWords);

    //persist computed ranking in DB
    void persist(Map<String, List<WordFreq>> allWordsWithFreq);
}
