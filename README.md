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

- checkout the source , ClusterApiTest.testListCluster show the basic usage of OPEN API

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

just checkout and follow the [API DOC](https://doc.clougence.com/docs/en/api_constant_cachevalueformats) to implement contents as below

- we need all api RequestDO and ResponseDO implementation, DO's class name need in line with api name
- we need deserialize data from Response to ResponseDO logic
- we need https communication protocol for client
