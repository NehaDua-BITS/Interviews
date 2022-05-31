package meesho.round2.autosuggest.repository;

import meesho.round2.autosuggest.exception.PrefixNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractRepository {

     protected Map<String, List<String>> storeMap;

     public AbstractRepository() {
          this.storeMap = new HashMap<>();
     }

     //fetching top k
     public List<String> get(String data) {
          List<String> list = storeMap.get(data);
          if (list == null || list.size() == 0) {
               throw new PrefixNotFoundException("Prefix not found in Redis");
          }
          return list;
     }

     //storing top k
     public void save(Map<String, List<String>> map) {
          storeMap.clear();
          storeMap.putAll(map);
     }
}
