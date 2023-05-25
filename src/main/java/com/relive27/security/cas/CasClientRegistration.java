package com.relive27.security.cas;

import lombok.Getter;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * @author: ReLive27
 * @date: 2023/5/25 19:57
 */
@Getter
public class CasClientRegistration {
    private String casServerBaseUrl;

    private String casServerLoginUri;

    private ServiceProperties serviceProperties;


    public static Builder withCasServerBaseUrl(String casServerBaseUrl) {
        Assert.hasText(casServerBaseUrl, "casServerBaseUrl cannot be empty");
        return new Builder(casServerBaseUrl);
    }

    public static final class Builder implements Serializable {
        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

        private String casServerBaseUrl;

        private String casServerLoginUri;

        private String service;

        private boolean authenticateAllArtifacts;

        private boolean sendRenew;

        private String artifactParameter;

        private String serviceParameter;

        private Builder(String casServerBaseUrl) {
            this.casServerBaseUrl = casServerBaseUrl;
        }

        public Builder casServerBaseUrl(String casServerBaseUrl) {
            this.casServerBaseUrl = casServerBaseUrl;
            return this;
        }

        public Builder casServerLoginUri(String casServerLoginUri) {
            this.casServerLoginUri = casServerLoginUri;
            return this;
        }

        public Builder service(String service) {
            this.service = service;
            return this;
        }

        public Builder authenticateAllArtifacts(boolean authenticateAllArtifacts) {
            this.authenticateAllArtifacts = authenticateAllArtifacts;
            return this;
        }

        public Builder sendRenew(boolean sendRenew) {
            this.sendRenew = sendRenew;
            return this;
        }

        public Builder artifactParameter(String artifactParameter) {
            this.artifactParameter = artifactParameter;
            return this;
        }

        public Builder serviceParameter(String serviceParameter) {
            this.serviceParameter = serviceParameter;
            return this;
        }

        public CasClientRegistration build() {
            Assert.hasText(this.casServerBaseUrl, "casServerBaseUrl cannot be empty");
            CasClientRegistration casClientRegistration = new CasClientRegistration();
            casClientRegistration.casServerBaseUrl = this.casServerBaseUrl;
            casClientRegistration.casServerLoginUri = this.casServerLoginUri;
            casClientRegistration.serviceProperties = createServiceProperties();
            return casClientRegistration;
        }

        private ServiceProperties createServiceProperties() {
            ServiceProperties serviceProperties = new ServiceProperties();
            serviceProperties.setService(this.service);
            serviceProperties.setServiceParameter(this.serviceParameter);
            serviceProperties.setArtifactParameter(this.artifactParameter);
            serviceProperties.setSendRenew(this.sendRenew);
            serviceProperties.setAuthenticateAllArtifacts(this.authenticateAllArtifacts);

            return serviceProperties;

        }
    }
}
