package com.huang.ros.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Nav {
    @JSONField(name = "header", ordinal = 1)
    private Header header;
    @JSONField(name = "pose", ordinal = 2)
    private Pose pose;
}
