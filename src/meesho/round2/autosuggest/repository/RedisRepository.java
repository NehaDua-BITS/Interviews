package meesho.round2.autosuggest.repository;

import java.util.List;

public class RedisRepository extends AbstractRepository {

    @Override
    public List<String> get(String prefix) {
        System.out.println("Fetching top K words for prefix : " + prefix);
        return get(prefix);
    }


}
