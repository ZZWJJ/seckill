package com.zzw.seckill.seckillmain;

import com.zzw.seckill.seckillmain.config.KafkaTopicConfig;
import com.zzw.seckill.seckillmain.kafka.SecKillProducer;
import com.zzw.seckill.seckillmain.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SeckillMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillMainApplication.class, args);
    }

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SecKillProducer producer;

    @PostConstruct
    public void init(){
        producer.sendMsg(5555L);

        redisUtil.set("key","apple");
        System.out.println("the value is :" + redisUtil.get("key"));
    }

}
