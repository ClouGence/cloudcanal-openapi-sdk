# cloudcanal-openapi-sdk


#### 简介

此项目为 CloudCanal 产品开放 API 客户端 SDK。我们目前并没有将其发布到 MAVEN 中央仓库，所以你可以将其发布到本地仓库并依赖使用它。

整个开放 API 分为 4 个部分
- cluster(集群)
- consolejob(异步任务)
- constant(常量)
- datajob(数据任务)
- datasource(数据源)

#### Example

- 启动 CloudCanal 产品，确定控制台连接串
- 将本仓库检出 , ClusterApiTest.testListCluster 展示了开放 API 基本使用
- 根据 [API 文档](https://doc.clougence.com/docs/en/api_constant_cachevalueformats)，开发代码，调用相应 api 并使用

```
    @Test
    public void testListCluster() {
        try {
            UserProfile profile = new UserProfile("127.0.0.1:8111", "your ak from cloudcanal", "your sk from cloudcanal");
            CcClient client = profile.genClient();
            ListClusterRequest request = new ListClusterRequest();
            String paramStr = request.toJson();
            String result = client.doJsonPost("/cloudcanal/console/api/v1/openapi/cluster/listclusters", paramStr);
            System.out.println(result);
        } catch (Exception e) {
            throw new RuntimeException("api failed.", e);
        }
    }
```

### Contribute

根据 [API 文档](https://doc.clougence.com/docs/en/api_constant_cachevalueformats) 实现如下所描述的内容

- 我们需要实现所有 api 对应的 RequestDO 和 ResponseDO, DO 的类名需要和 api 名字对应
- 我们需要将 json 字符串反序列化为对应 DO 的逻辑
- 我们需要实现 https 客户端通信协议
