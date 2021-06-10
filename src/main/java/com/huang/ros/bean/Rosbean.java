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
public class Rosbean {
	@JSONField(name = "op", ordinal = 1)
	private String op;
	@JSONField(name = "id", ordinal = 2)
	private String id;
	@JSONField(name = "topic", ordinal = 3)
	private String topic;
	@JSONField(name = "type", ordinal = 4)
	private String type;
	@JSONField(name = "msg", ordinal = 5)
	private Msgbean msg;
	public Rosbean(String op, String topic, String type) {
		super();
		this.op = op;
		this.topic = topic;
		this.type = type;
	}
	public Rosbean(String op, String topic, String type, Msgbean msg) {
		super();
		this.op = op;
		this.topic = topic;
		this.type = type;
		this.msg = msg;
	}
//	public String getOp() {
//		return op;
//	}
//	public void setOp(String op) {
//		this.op = op;
//	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getTopic() {
//		return topic;
//	}
//	public void setTopic(String topic) {
//		this.topic = topic;
//	}
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
//	public Msgbean getMsg() {
//		return msg;
//	}
//	public void setMsg(Msgbean msg) {
//		this.msg = msg;
//	}
//	@Override
//	public String toString() {
//		return "Rosbean [op=" + op + ", id=" + id + ", topic=" + topic + ", type=" + type + ", msg=" + msg + "]";
//	}
//
//
}
