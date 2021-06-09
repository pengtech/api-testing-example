package com.pnxtest.apiExample.configuration;

import com.pnxtest.core.api.Configuration;
import com.pnxtest.core.assertions.PnxAssert;
import com.pnxtest.core.environment.PnxContext;
import com.pnxtest.http.HttpConfig;
import com.pnxtest.http.api.IHttpConfig;


@Configuration
public class HttpGatewayConfig implements IHttpConfig {
    @Override
    public HttpConfig accept() {
        CustomHttpGateway customHttpGateway = new CustomHttpGateway();

        return HttpConfig.builder()
                .header("clientId", "PnxTest") //添加一个header
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlwIjoiMTAuOS45LjkwIiwiZXhwIjoxNjIzNjUyODcxLCJ1c2VySWQiOiJhYWQzZGU4MjcwIiwiaWF0IjoxNjIzMjIwODcxLCJkZXZpY2VJbmZvIjoiTW96aWxsYS81LjAgKE1hY2ludG9zaDsgSW50ZWwgTWFjIE9TIFggMTBfMTVfNSkgQXBwbGVXZWJLaXQvNTM3LjM2IChLSFRNTCwgbGlrZSBHZWNrbykgQ2hyb21lLzkxLjAuNDQ3Mi43NyBTYWZhcmkvNTM3LjM2In0.2bEcMiqPt2IKc_MbaiZCPUGvsqfEbb88wdyrY_cT1g0") //添加token认证
                .connectionTimeout(5000) //设置连接超时时间5s
                .socketTimeout(5000) //设置读取内容超时时间
                .verifySsl(PnxContext.getBoolean("https.required", true))
                .gateway(customHttpGateway) //设置统一网关
                .build();
    }

}
