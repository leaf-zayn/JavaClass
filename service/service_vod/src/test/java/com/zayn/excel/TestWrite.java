package com.zayn.excel;

import com.alibaba.excel.EasyExcel;

import javax.rmi.CORBA.Stub;
import java.util.ArrayList;
import java.util.List;

public class TestWrite {
    public static void main(String[] args) {
        //设置文件名称和路径
        String fileName = "/Users/zayn/java/zayn.xlsx";
        //调用方法
        EasyExcel.write(fileName, User.class)
                .sheet("写操作")
                .doWrite(data());
    }

    //循环设置要添加的数据，最终添加到List集合中去
    private static List<User> data() {
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User data = new User();
            data.setId(i);
            data.setName("zayn" + i);
            list.add(data);
        }
        return list;
    }
}
