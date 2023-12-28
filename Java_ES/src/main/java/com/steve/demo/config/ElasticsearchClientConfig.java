package com.steve.demo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: STEVE
 * @Description: ES配置类
 * @since: 2023/12/27
 */
@Configuration
public class ElasticsearchClientConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        /* 高级客户端内部会创建低级客户端用于基于提供的builder执行请求。低级客户端维护一个连接池，并启动一些线程，因
        此当你用完以后应该关闭高级客户端，并且在内部它将会关闭低级客户端，以释放这些资源。关闭客户端可以使用close()方法：
        client.close();*/
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));
        return client;
    }

}
