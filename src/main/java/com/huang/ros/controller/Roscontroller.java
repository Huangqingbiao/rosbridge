package com.huang.ros.controller;

import com.alibaba.fastjson.JSON;
import com.huang.ros.bean.*;
import com.huang.ros.util.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;

@RestController
@Slf4j
public class Roscontroller {
    static Socket socket = null;
    static OutputStream out = null;
    private boolean flag = false;
    @Autowired
    Publisher publisher;

    @RequestMapping("/index")
    public String getIndex(){
        return "index";
    }

    @PostMapping("/rosconnect")
    public ResponseMsg rosConnect(){
        System.out.println("连接...");
        try {
            socket = new Socket("192.168.76.128", 9090);
            socket.setSoTimeout(5000);
            if(socket.isConnected()){
                return new ResponseMsg("连接成功");
            }
        } catch (IOException e) {
            return new ResponseMsg("连接失败");
        }
        return new ResponseMsg("连接失败");
    }
    @PostMapping("/rosdisconnect")
    public ResponseMsg rosDisConnect(){
        if(out != null)
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("断开连接...");
                }
            if(socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("断开连接...");
                }
        return new ResponseMsg("已断开");
    }

    @PostMapping("/goalnav")
    public ResponseMsg goalNav() throws InterruptedException {
        HashMap<String, Rosbean> goalPose = new HashMap<String, Rosbean>();
        HashMap<String, Position> hashMap = new HashMap<>();
        Position position1 = new Position(-4.485, -2.767, 0.000);
        Position position2 = new Position(19.561, -12.131, 0.000);
        Position position3 = new Position(9.194, -6.354, 0.000);
        Position position4 = new Position(-9.531, -15.262, 0.000);
        Position position5 = new Position(13.862, -13.986, 0.000);
        hashMap.put("goala", position1);
        hashMap.put("goalb", position2);
        hashMap.put("goalc", position3);
        hashMap.put("goald", position4);
        hashMap.put("goale", position5);
        for (Position position : hashMap.values()) {
            Pose pose = new Pose(position, new Orientation(0, 0, 0, 1));
            Header header = new Header("map");
            Msgbean msgbean = new Msgbean(header, pose);
            goalPose.put("msg", new Rosbean("publish", "/move_base_simple/goal", "geometry_msgs/PoseStamped", msgbean));
            Rosbean msg = goalPose.get("msg");
            String msgjson = JSON.toJSONString(msg);
            System.out.println(msgjson);
            flag = publisher.publisher(socket, out, msgjson);
        }
        return new ResponseMsg("导航中...");
    }

    @PostMapping("/nav")
    public ResponseMsg rosNav(@RequestBody Position position){
        System.out.println(position);
        if(position != null){
            HashMap<String, Rosbean> hashMap = new HashMap<>();
            Header header = new Header("map");
            Pose pose = new Pose(position,new Orientation(0,0,0,1));
            Msgbean msgbean = new Msgbean(header, pose);
            hashMap.put("msg", new Rosbean("publish", "/move_base_simple/goal", "geometry_msgs/PoseStamped", msgbean));
            Rosbean msg = hashMap.get("msg");
            String msgjson = JSON.toJSONString(msg);
            System.out.println(msgjson);
            try {
                out = socket.getOutputStream();
                out.write(msgjson.getBytes());
            } catch (IOException e) {
                return new ResponseMsg("导航失败");
            }
            flag = publisher.publisher(socket,out,msgjson);
            if(flag) {
                return new ResponseMsg("导航中...");
            }
        }
        return new ResponseMsg("导航失败");
    }

    @PostMapping("/goright")
    public ResponseMsg rosGoRight(@RequestBody Msgbean msgbean) {
//        System.out.println(msgbean.toString());
        HashMap<String, Rosbean> hashMap = new HashMap<String, Rosbean>();
        //乌龟例程
//      hashMap.put("ros", new Rosbean("advertise", "/turtle1/cmd_vel", "geometry_msgs/Twist"));
//      hashMap.put("msg", new Rosbean("publish", "/turtle1/cmd_vel", "geometry_msgs/Twist", msgbean));
        hashMap.put("msg", new Rosbean("publish", "/ria_base_controller/cmd_vel", "geometry_msgs/Twist", msgbean));
//        Rosbean ros = hashMap.get("ros");
        Rosbean msg = hashMap.get("msg");
//        String rosjson = JSON.toJSONString(ros);
        String msgjson = JSON.toJSONString(msg);
//        System.out.println(rosjson);
        System.out.println(msgjson);
        flag = publisher.publisher(socket, out, msgjson);
        if (flag) {
            return new ResponseMsg("向右转动了" + msgbean.getAngular().getZ() + "度");
        } else {
            return new ResponseMsg("转动失败");
        }
    }

    @PostMapping("/goleft")
    public ResponseMsg rosGoLeft(@RequestBody Msgbean msgbean) {
        HashMap<String, Rosbean> hashMap = new HashMap<String, Rosbean>();
        hashMap.put("msg", new Rosbean("publish", "/ria_base_controller/cmd_vel", "geometry_msgs/Twist", msgbean));
        Rosbean ros = hashMap.get("ros");
        Rosbean msg = hashMap.get("msg");
        String rosjson = JSON.toJSONString(ros);
        String msgjson = JSON.toJSONString(msg);
        System.out.println(rosjson);
        System.out.println(msgjson);
        flag = publisher.publisher(socket, out, msgjson);
        if (flag) {
            return new ResponseMsg("向左转动了" + msgbean.getAngular().getZ() * (-1) + "度");
        } else {
            return new ResponseMsg("转动失败");
        }
    }

    @PostMapping("/goup")
    public ResponseMsg rosGoUp(@RequestBody Msgbean msgbean) {
        HashMap<String, Rosbean> hashMap = new HashMap<String, Rosbean>();
        hashMap.put("msg", new Rosbean("publish", "/ria_base_controller/cmd_vel", "geometry_msgs/Twist", msgbean));
        Rosbean ros = hashMap.get("ros");
        Rosbean msg = hashMap.get("msg");
        String rosjson = JSON.toJSONString(ros);
        String msgjson = JSON.toJSONString(msg);
        System.out.println(rosjson);
        System.out.println(msgjson);
        flag = publisher.publisher(socket, out, msgjson);
        if (flag) {
            return new ResponseMsg("向前移动了" + msgbean.getLinear().getX());
        } else {
            return new ResponseMsg("移动失败");
        }
    }

    @PostMapping("/godown")
    public ResponseMsg rosGoDown(@RequestBody Msgbean msgbean) {
        System.out.println(msgbean);
        HashMap<String, Rosbean> hashMap = new HashMap<String, Rosbean>();
        hashMap.put("msg", new Rosbean("publish", "/ria_base_controller/cmd_vel", "geometry_msgs/Twist", msgbean));
        Rosbean ros = hashMap.get("ros");
        Rosbean msg = hashMap.get("msg");
        String rosjson = JSON.toJSONString(ros);
        String msgjson = JSON.toJSONString(msg);
        System.out.println(rosjson);
        System.out.println(msgjson);
        flag = publisher.publisher(socket, out, msgjson);
        if (flag) {
            return new ResponseMsg("向后移动了" + msgbean.getLinear().getX() * (-1));
        } else {
            return new ResponseMsg("移动失败");
        }
    }

}
