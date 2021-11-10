# cloudcanal-openapi-sdk

### Description

The open api client sdk project for cloudcanal. By now , we have not yet publish it to MAVEN centre repository,you can install it in local MAVEN repository and use it.

API include 5 parts
- cluster
- consolejob
- constant
- datajob
- datasource

### Example

- start CloudCanal , confirm the console addr
- checkout the source , ClusterApiTest.testListCluster show the basic usage of OPEN API
- according [API DOC](https://doc.clougence.com/docs/en/api_constant_cachevalueformats), write code to use it

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

### How To Contribute

just checkout and follow the [API DOC](https://doc.clougence.com/docs/en/api_constant_cachevalueformats) to implement contents as below

- we need all api RequestDO and ResponseDO implementation, DO's class name need in line with api name
- we need deserialize data from Response to ResponseDO logic
- we need https communication protocol for client
