package com.zzw.seckill.seckillmain.kafka;

import com.alibaba.fastjson.JSON;
import com.zzw.seckill.seckillmain.entity.PayOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SecKillProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMsg(Long killId){
        PayOrder payOrder = new PayOrder();
        payOrder.setSeckillId(killId);
        kafkaTemplate.send("secKill", JSON.toJSONString(payOrder));

    }
}
