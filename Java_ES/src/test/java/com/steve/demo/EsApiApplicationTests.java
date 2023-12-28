package com.steve.demo;

import cn.hutool.json.JSONUtil;
import com.steve.demo.pojo.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Author: STEVE
 * @Description: 测试类 - SpringBoot整合ES
 * @since: 2023/12/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsApiApplicationTests {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    /**
     * 创建索引
     */
    @Test
    public void testCreateIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("steve_index");
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }

    /**
     * 获取索引
     */
    @Test
    public void testExistsIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("steve_index");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /*
    删除索引
     */
    @Test
    public void testDeleteIndexRequest() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("steve_index");
        AcknowledgedResponse response = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
    }

    /**
     * 添加文档记录
     */
    @Test
    public void testAddDocument() throws IOException {
        //创建对象
        User user = new User("狂神说", 3);
        //创建请求
        IndexRequest request = new IndexRequest("steve_index");
        //规则
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");
        request.source(JSONUtil.toJsonStr(user), XContentType.JSON);
        //发送请求
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        System.out.println(indexResponse.toString());
        RestStatus status = indexResponse.status();
        System.out.println(status == RestStatus.OK || status == RestStatus.CREATED);
    }

    /**
     * 测试某索引下文档id是否存在
     * @throws IOException
     */
    @Test
    public void testIsExists() throws IOException {
        GetRequest getRequest = new GetRequest("steve_index", "1");
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");
        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * 根据id获取记录
     */
    @Test
    public void testGetDocument() throws IOException {
        GetRequest getRequest = new GetRequest("steve_index", "1");
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(getResponse.getSourceAsString());
        System.out.println(getResponse);
    }

    /**
     * 更新文档记录
     */
    @Test
    public void testUpdateDocument() throws IOException {
        UpdateRequest request = new UpdateRequest("steve_index", "5");
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");

        User user = new User("狂神", 18);
        request.doc(JSONUtil.toJsonStr(user), XContentType.JSON);

        UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);

        System.out.println(updateResponse.status() == RestStatus.OK);
    }

    /*
    删除文档记录
     */
    @Test
    public void testDelete() throws IOException {
        DeleteRequest request = new DeleteRequest("steve_index", "1");
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");
        DeleteResponse deleteResponse = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(deleteResponse.status() == RestStatus.OK);
    }

    /**
     * 批量添加数据
     */
    @Test
    public void testBulkRequest() throws IOException {
        BulkRequest request = new BulkRequest();
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("kuangshen1", 3));
        userList.add(new User("kuangshen2", 3));
        userList.add(new User("kuangshen3", 3));
        userList.add(new User("qinjiang1", 3));
        userList.add(new User("qinjiang2", 3));
        userList.add(new User("qinjiang3", 3));

        for(int i = 0; i < userList.size(); i++){
            request.add(new IndexRequest("steve_index").id("" + (i + 2))
                    .source(JSONUtil.toJsonStr(userList.get(i)), XContentType.JSON));
        }
        BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(!bulkResponse.hasFailures());
    }

    // 查询测试
    /**
     * 使用QueryBuilder
     * termQuery("key", obj) 完全匹配
     * termsQuery("key", obj1, obj2..) 一次匹配多个值
     * matchQuery("key", Obj) 单个匹配, field不支持通配符, 前缀具高级特性
     * multiMatchQuery("text", "field1", "field2"..); 匹配多个字段, field有通
     配符忒行
     * matchAllQuery(); 匹配所有文件
     */

    @Test
    public void testSearch() throws IOException {
        SearchRequest searchRequest = new SearchRequest("steve_index");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

//        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("age", 18);
        sourceBuilder.query(termQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        searchRequest.source(sourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSONUtil.toJsonStr(response.getHits ()));
        for (SearchHit documentFields : response.getHits().getHits()) {
            System.out.println(documentFields.getSourceAsMap());
        }
    }

}
