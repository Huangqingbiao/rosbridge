package com.huang.ros.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orientation {
    @JSONField(name = "x", serialize = true, ordinal = 1)
    private int x;
    @JSONField(name = "y", serialize = true, ordinal = 2)
    private int y;
    @JSONField(name = "z", serialize = true, ordinal = 3)
    private int z;
    @JSONField(name = "w", serialize = true, ordinal = 4)
    private int w;
}
