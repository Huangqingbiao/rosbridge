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
public class Linear {
	@JSONField(name = "x", serialize = true)
	private double x;
	@JSONField(name = "y", serialize = true)
	private double y;
	@JSONField(name = "z", serialize = true)
	private double z;
//	public Linear(double x, double y, double z) {
//		super();
//		this.x = x;
//		this.y = y;
//		this.z = z;
//	}
//
//
//	public double getX() {
//		return x;
//	}
//
//
//	public void setX(double x) {
//		this.x = x;
//	}
//
//
//	public double getY() {
//		return y;
//	}
//
//
//	public void setY(double y) {
//		this.y = y;
//	}
//
//
//	public double getZ() {
//		return z;
//	}
//
//
//	public void setZ(double z) {
//		this.z = z;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Linear [x=" + x + ", y=" + y + ", z=" + z + "]";
//	}
	
}
