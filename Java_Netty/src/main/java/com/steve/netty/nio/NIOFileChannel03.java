package com.steve.netty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: STEVE
 * @Description: 使用一个Buffer完成文件读取
 * 使用 FileChannel(通道) 和 方法 read , write，完成文件的拷贝
 * 拷贝一个文本文件 1.txt , 放在项目下即可
 * @since: 2024/1/11
 */
public class NIOFileChannel03 {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("d:\\1.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\2.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while(true) { // 循环读取
            byteBuffer.clear(); // 清空buffer

            int read = fileChannel01.read(byteBuffer);
            System.out.println("read=" + read);
            if(read == -1) {
                // 表示读完
                break;
            }

            // 将buffer中的数据写入到 fileChannel02 -- 2.txt
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
        }

        // 关闭相关的流
        fileInputStream.close();
        fileOutputStream.close();
    }

}
