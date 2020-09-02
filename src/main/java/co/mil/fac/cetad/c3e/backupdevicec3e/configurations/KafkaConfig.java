/**
 * COPYRIGHT NOTICE
 * <p>
 * All Technical Data and software is Copyright (c), 2020 by
 * COLOMBIAN AIR FORCE.
 * <p>
 * COPYRIGHT NOTICE
 */
package co.mil.fac.cetad.c3e.backupdevicec3e.configurations;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ing. Manuel Fernando Garizao; 
 * Email: manuel.garizao@fac.mil.co manuelfp@gmail.com
 * @date: 2/09/20, 4:26 PM
 **/

@Configuration
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
        Map<String, Object> propConfig = new HashMap<>();
        propConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, " 10.10.10.2:9092");
        propConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "1424543");
        return new DefaultKafkaConsumerFactory<>(propConfig);
    }

    @Bean("kafkaListenerToString")
    public ConcurrentKafkaListenerContainerFactory<String, String> stringInputKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, byte[]> consumerFactory2(){
        Map<String, Object> propConfig = new HashMap<>();
        propConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, " 10.10.10.2:9092");
        propConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);
        propConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "1424543");
        return new DefaultKafkaConsumerFactory<>(propConfig);
    }

    @Bean("kafkaListenerToByteArrays")
    public ConcurrentKafkaListenerContainerFactory<String, byte[]> byteArraysInputKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, byte[]> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory2());
        return factory;
    }
}
