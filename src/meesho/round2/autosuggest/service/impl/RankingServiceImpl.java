package meesho.round2.autosuggest.service.impl;

import meesho.round2.autosuggest.configuration.KafkaConfig;
import meesho.round2.autosuggest.model.WordFreq;
import meesho.round2.autosuggest.repository.AbstractRepository;
import meesho.round2.autosuggest.service.RankingService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankingServiceImpl implements RankingService {

    private TrieService trieService;

    private AbstractRepository repository;

    private int maxWords;

    public RankingServiceImpl(TrieService trieService, AbstractRepository repository, int maxWords) {
        this.trieService = trieService;
        this.repository = repository;
        this.maxWords = maxWords;
    }

    /**
     * consume from Kafka and build trie
     * @param config
     */
    @Override
    public void consume(KafkaConfig config) {

    }

    @Override
    public Map<String, List<String>> rank(List<String> words) {
        //implement trie and extracted top frequent words
        Map<String, List<WordFreq>> map = trieService.getAllWordFrequencies(words);
        sortRanking(map);
        saveTopK(map);
        persist(map);    //save in redis
        return null;
    }

    @Override
    public void saveTopK(Map<String, List<WordFreq>> topWords) {
        Map<String, List<String>> persistMap = new HashMap<>(topWords.size());

        //select top k from sorted list and store in redis
        for (Map.Entry<String, List<WordFreq>> entry : topWords.entrySet()) {
            //persistMap.put(entry.getKey(), entry.getValue().subList(0, maxWords));
            //repository.save();
        }
    }

    @Override
    public void persist(Map<String, List<WordFreq>> allWordsWithFreq) {

    }

    private void sortRanking(Map<String, List<WordFreq>> wordFreqMap) {
        //will sort them in place and return
    }
}
