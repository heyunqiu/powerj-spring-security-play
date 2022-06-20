package com.powerj.oauth2.play.model;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.util.StringUtils;

/**
 * <p>自定义客户端的模型</p>
 *
 * @author : Heyunqiu
 * @date :2022/6/20
 **/
public class PowerJClient {
    private String clientId;
    private String secretId;
    private String redirectUris;
    private String scopes;
    private String grantTypes;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(String redirectUris) {
        this.redirectUris = redirectUris;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public String getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(String grantTypes) {
        this.grantTypes = grantTypes;
    }

    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    public ClientDetails toClientDetails(){
        BaseClientDetails clientDetails = new BaseClientDetails();
        clientDetails.setClientId(this.clientId);
        clientDetails.setClientSecret(this.secretId);
        clientDetails.setAccessTokenValiditySeconds(this.accessTokenValiditySeconds);
        clientDetails.setRefreshTokenValiditySeconds(this.refreshTokenValiditySeconds);
        clientDetails.setAuthorizedGrantTypes(StringUtils.commaDelimitedListToSet(this.grantTypes));
        clientDetails.setScope(StringUtils.commaDelimitedListToSet(this.scopes));
        clientDetails.setRegisteredRedirectUri(StringUtils.commaDelimitedListToSet(this.redirectUris));
        return clientDetails;
    }
}
