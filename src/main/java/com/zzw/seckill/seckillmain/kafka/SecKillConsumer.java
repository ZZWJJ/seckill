package com.zzw.seckill.seckillmain.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecKillConsumer {
    @KafkaListener(topics = {"secKill"})
    public  void consumer(ConsumerRecord consumerRecord){
        Optional kafkaMsg=  Optional.ofNullable(consumerRecord.value());
        if (kafkaMsg.isPresent()){
            Object msg=  kafkaMsg.get();
            System.err.println(msg);
        }
    }
}
