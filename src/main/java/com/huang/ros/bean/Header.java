package com.huang.ros.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Header {
    @JSONField(name = "frame_id")
    private String frame_id;
}
