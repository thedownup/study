package com.study.nio.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description:
 * @author: zjt
 * @date: 2020-04-03 22:43
 */
public class NiotTest {


    public static void main(String[] args) {
        try {
            testWrite();
            testRead();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void testWrite() throws IOException {
        FileOutputStream fos = new FileOutputStream("testNIO.txt");
        FileChannel channel = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        for (int i = 0; i < 10; i++) {
            byteBuffer.put((byte) i);
            System.out.println("write : " + (byte) i);
        }
        byteBuffer.flip();
        channel.write(byteBuffer);

        fos.close();

    }

    private static void testRead() throws IOException {
        FileInputStream fis = new FileInputStream("testNIO.txt");
        FileChannel fileChannel = fis.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            int n = fileChannel.read(byteBuffer);
            System.out.println("read..." + n);
            if (n == -1) {
                break;
            }

        }
        byteBuffer.flip();

        while (byteBuffer.hasRemaining()) {
            System.out.println("read : " + byteBuffer.get());
        }

        fis.close();
    }


}