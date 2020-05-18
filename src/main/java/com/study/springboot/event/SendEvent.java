package com.study.springboot.event;

import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: zjt
 * @date: 2020-05-17 16:08
 */
@Data
@Builder
public class SendEvent {
    private String msg;
}