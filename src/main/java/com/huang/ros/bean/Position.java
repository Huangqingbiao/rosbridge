package com.huang.ros.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Position {
    @JSONField(name = "x",serialize = true)
    private double x;
    @JSONField(name = "y", serialize = true)
    private double y;
    @JSONField(name = "z", serialize = true)
    private double z;

    public Position(double v, double v1, float z) {
    }
}
