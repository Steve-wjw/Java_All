package com.steve.demo.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: STEVE
 * @Description: 网站爬虫
 * @since: 2023/11/22
 */
public class UseCountDownLatch {

    private static class Cravler implements Runnable {

        private final String url;
        private final CountDownLatch latch;

        public Cravler(String url, CountDownLatch latch) {
            this.url = url;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                URL urlObject = new URL(this.url);
                BufferedReader in = new BufferedReader(new InputStreamReader(urlObject.openStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                    content.append("\n");
                }
                in.close();
                System.out.println("爬取 " + url + " 成功，内容大小：" + content.length() + " 字符");
            } catch (Exception e) {
                System.err.println("爬取 " + url + " 失败, 原因: " + e.getMessage());
            } finally {
                latch.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> urls = new ArrayList<>();
        urls.add("https://github.com/");
        urls.add("https://stackoverflow.com/");
        urls.add("https://www.zhihu.com/");
        urls.add("https://www.reddit.com/");
        urls.add("https://www.linkedin.com/");
        CountDownLatch latch = new CountDownLatch(urls.size());
        System.out.println("开始爬虫任务...");
        for (String url : urls) {
            new Thread(new Cravler(url, latch)).start();
        }
        latch.await();
        System.out.println("所有爬虫任务都已完成！");
    }

}
