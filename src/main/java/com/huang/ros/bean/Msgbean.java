package com.huang.ros.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Msgbean {
	@JSONField(name = "linear")
	private Linear linear;
	@JSONField(name = "angular")
	private Angular angular;
	@JSONField(name = "header", ordinal = 1)
	private Header header;
	@JSONField(name = "pose", ordinal = 2)
	private Pose pose;
	@JSONField(name = "orientation", ordinal = 3)
	private Orientation orientation;
	public Msgbean(Header header, Pose pose){
		this.header = header;
		this.pose = pose;
	}


}
