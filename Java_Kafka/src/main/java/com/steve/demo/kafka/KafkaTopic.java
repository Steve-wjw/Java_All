package com.steve.demo.kafka;

import cn.hutool.core.collection.CollUtil;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DeleteTopicsResult;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @Author: STEVE
 * @Description: 主题管理
 * @since: 2023/12/18
 */
@RestController
@RequestMapping("/kafka/topic")
public class KafkaTopic {

    @Autowired
    private KafkaAdmin kafkaAdmin;

    @RequestMapping("/list")
    public Set listTopic() throws Exception {
        // 1. 获取Kafka集群配置消息
        Map<String, Object> configs = kafkaAdmin.getConfigurationProperties();
        // 2. 创建客户端AdminClient
        AdminClient adminClient = KafkaAdminClient.create(configs);
        // 3. 获取Kafka集群中Topic清单
        Set<String> topicSet = adminClient.listTopics().names().get();
        return topicSet;
    }

    @RequestMapping("/add/{topic}")
    public void addTopic(@PathVariable("topic") String topicName) throws Exception {
        // 1. 获取Kafka集群配置消息
        Map<String, Object> configs = kafkaAdmin.getConfigurationProperties();
        // 2. 创建客户端AdminClient
        AdminClient adminClient = KafkaAdminClient.create(configs);
        // 3. 获取Kafka集群中Topic清单
        Set<String> topicSet = adminClient.listTopics().names().get();
        // 4. 在kafka集群中创建Topic
        if (!topicSet.contains(topicName)) {
            NewTopic newTopic = new NewTopic(topicName, 1, (short) 1);
            Collection<NewTopic> newTopics = CollUtil.newArrayList(newTopic);
            adminClient.createTopics(newTopics);
        }
    }

    @RequestMapping("/delete/{topic}")
    public void deleteTopic(@PathVariable("topic") String topicName) throws Exception {
        // 1. 获取Kafka集群配置消息
        Map<String, Object> configs = kafkaAdmin.getConfigurationProperties();
        // 2. 创建客户端AdminClient
        AdminClient adminClient = KafkaAdminClient.create(configs);
        // 3. 获取Kafka集群中Topic清单
        Set<String> topicSet = adminClient.listTopics().names().get();
        // 4. 在kafka集群中创建Topic
        if (topicSet.contains(topicName)) {
            Collection<String> topics = CollUtil.newArrayList(topicName);
            DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(topics);
            deleteTopicsResult.all().get();
        }
    }

}
