package com.steve.netty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @Author: STEVE
 * @Description: 拷贝文件transferFrom 方法
 * 使用 FileChannel(通道) 和 方法 transferFrom ，完成文件的拷贝
 * 拷贝一张图片
 * @since: 2024/1/12
 */
public class NIOFileChannel04 {

    public static void main(String[] args) throws Exception {
        // 创建相关流
        FileInputStream fileInputStream = new FileInputStream("d:\\a.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\a2.jpg");

        // 获取各个流对应的filechannel
        FileChannel sourceCh = fileInputStream.getChannel();
        FileChannel destCh = fileOutputStream.getChannel();

        // 使用transferFrom完成拷贝
        destCh.transferFrom(sourceCh, 0, sourceCh.size());

        // 关闭相关通道和流
        sourceCh.close();
        destCh.close();
        fileInputStream.close();
        fileOutputStream.close();
    }

}
