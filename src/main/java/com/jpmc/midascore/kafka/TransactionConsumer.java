package com.jpmc.midascore.kafka;


import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.service.TransactionService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionConsumer {

    private final TransactionService transactionService;

    public TransactionConsumer(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Transaction transaction){
        System.out.println("Received transaction: " + transaction);
        transactionService.processTransaction(transaction);
    }
}
