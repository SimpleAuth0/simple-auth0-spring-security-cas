package com.relive27.security.cas;

import org.springframework.util.Assert;

/**
 * @author: ReLive27
 * @date: 2023/5/25 19:59
 */
public class InMemoryCasClientRegistrationRepository implements CasClientRegistrationRepository {

    private final CasClientRegistration clientRegistration;

    public InMemoryCasClientRegistrationRepository(CasClientRegistration clientRegistration) {
        Assert.notNull(clientRegistration, "clientRegistration cannot be null");
        this.clientRegistration = clientRegistration;
    }

    @Override
    public CasClientRegistration loadCasClientRegistration() {
        return this.clientRegistration;
    }
}
