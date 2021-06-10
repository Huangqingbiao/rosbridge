package com.huang.ros.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Getter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Raddrbean {
    private String host = "192.168.110.129";
    private int port = 9090;
}
