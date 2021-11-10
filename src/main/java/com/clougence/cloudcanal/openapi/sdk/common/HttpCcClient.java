package com.clougence.cloudcanal.openapi.sdk.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.clougence.cloudcanal.openapi.sdk.common.exception.ClientException;
import com.clougence.cloudcanal.openapi.sdk.common.exception.ServerException;
import com.fasterxml.uuid.Generators;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

/**
 * @author bucketli 2021/11/10 11:59:18
 */
@Slf4j
public class HttpCcClient implements CcClient {

    public static final MediaType JSON            = MediaType.get("application/json; charset=utf-8");

    private String                host;

    private String                accessKey;

    private String                secretKey;

    private final String          signatureMethod = "HmacSHA1";

    public HttpCcClient(String host, String accessKey, String secretKey){
        this.host = host;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @Override
    public String doJsonPost(String uri, String content) throws ClientException, ServerException {
        Response response = null;
        try {
            Map<String, String> commonParams = genCommonParams();
            String url = genFullUrl(uri, commonParams);

            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(JSON, content);
            Request request = new Request.Builder().url(url).post(body).build();
            response = client.newCall(request).execute();
            if (response.code() >= 200 && response.code() < 300) {
                return Objects.requireNonNull(response.body()).string();
            } else {
                throw new ServerException(String.valueOf(response.code()), Objects.requireNonNull(response.body()).string());
            }
        } catch (IOException e) {
            String msg = "failed to request to open api endpoint(" + host + "),msg:" + ExceptionUtils.getRootCauseMessage(e);
            log.error(msg, e);
            throw new ClientException(e);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    protected String genFullUrl(String uri, Map<String, String> commonParams) {
        String paramStr = OpenApiSigner.genSortedParamsStr(commonParams);
        return "http://" + host + uri + "?" + paramStr;
    }

    protected Map<String, String> genCommonParams() {
        String nonce = Generators.timeBasedGenerator().generate().toString();
        Map<String, String> commonParams = new HashMap<>();
        commonParams.put("SignatureMethod", signatureMethod);
        commonParams.put("SignatureNonce", nonce);
        commonParams.put("AccessKeyId", accessKey);

        String paramStr = OpenApiSigner.composeStringToSign(commonParams);
        String signature = OpenApiSigner.signString(paramStr, secretKey);

        commonParams.put("Signature", signature);

        return commonParams;
    }
}
