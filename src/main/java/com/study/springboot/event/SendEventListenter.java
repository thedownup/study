package com.study.springboot.event;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zjt
 * @date: 2020-05-17 16:09
 */
@Log4j2
@Component
public class SendEventListenter {

    @EventListener
    public void handleSendEvent(SendEvent sendEvent) {
        log.info("监听sendEvent = " + sendEvent);
    }

}