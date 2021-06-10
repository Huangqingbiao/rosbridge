package com.huang.ros.bean;

import com.alibaba.fastjson.annotation.JSONField;
import javafx.geometry.Pos;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pose {
    @JSONField(name = "position", ordinal = 1)
    private Position position;
    @JSONField(name = "orientation", ordinal = 2)
    private Orientation orientation;
}
