package meesho.round2.autosuggest.service.impl;

import meesho.round2.autosuggest.configuration.KafkaConfig;

public class KafkaService {

    private KafkaConfig config;

    public KafkaService(KafkaConfig config) {
        this.config = config;
    }

    public void pushToTopic(String data) {
        System.out.println("Pushed to topic");
        //conection details and sending logic
    }
}
