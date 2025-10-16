package com.jpmc.midascore.kafka;


import com.jpmc.midascore.foundation.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionConsumer {

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Transaction transaction){
        System.out.println("Received transaction: " + transaction);
    }
}
