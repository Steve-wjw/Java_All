package com.steve.netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: STEVE
 * @Description: 本地文件读数据
 * 使用前面学习后的ByteBuffer(缓冲) 和 FileChannel(通道)， 将 file01.txt 中的数据读
 * 入到程序，并显示在控制台屏幕，假定文件已经存在
 * @since: 2024/1/11
 */
public class NIOFileChannel02 {

    public static void main(String[] args) throws Exception {
        File file = new File("d:\\file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        // 通过fileInputStream获取对应的FileChannel 这个FileChannel真实类型是FileChannelImpl
        FileChannel fileChannel = fileInputStream.getChannel();

        // 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        // 将通道的数据读入到Buffer
        fileChannel.read(byteBuffer);

        // 将byteBuffer的字节数据转成String
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }

}
