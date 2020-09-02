/**
 * COPYRIGHT NOTICE
 * <p>
 * All Technical Data and software is Copyright (c), 2020 by
 * COLOMBIAN AIR FORCE.
 * <p>
 * COPYRIGHT NOTICE
 */
package co.mil.fac.cetad.c3e.backupdevicec3e.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: Ing. Manuel Fernando Garizao; 
 * Email: manuel.garizao@fac.mil.co manuelfp@gmail.com
 * @date: 2/09/20, 4:08 PM
 **/
@Component
@Slf4j
public class OperationKafkaListener {

    @KafkaListener(topics = "operations", containerFactory = "kafkaListenerToString")
    public void listenerOperationToString(String message) {
        log.info("Message from operations topics: {}", message);
    }

    @KafkaListener(topics = "sps", containerFactory = "kafkaListenerToByteArrays")
    public void listenerOperationToByteArrays(byte[] message) {
        log.info("Message from operations topics: {}", new String(message));
    }
}
