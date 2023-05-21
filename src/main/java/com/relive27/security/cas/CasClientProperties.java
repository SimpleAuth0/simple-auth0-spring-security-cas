package com.relive27.security.cas;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * @author: ReLive27
 * @date: 2023/5/18 15:54
 */
@ConfigurationProperties(prefix = "spring.security.cas.client")
public class CasClientProperties implements InitializingBean {

    private String casServerBaseUrl;

    private String casServerLoginUri;

    private String service;

    private boolean authenticateAllArtifacts = false;

    private boolean sendRenew = false;

    private String artifactParameter = "ticket";

    private String serviceParameter = "service";


    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.service, "service must not be null");
        Assert.notNull(this.casServerBaseUrl, "casServerBaseUrl must not be null");
        if (!StringUtils.hasText(this.casServerLoginUri)) {
            this.casServerLoginUri = "/cas/login";
        }
    }
}
