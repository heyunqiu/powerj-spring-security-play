package com.powerj.oauth2.play.service;

import com.powerj.oauth2.play.conf.PowerJOauth2Property;
import com.powerj.oauth2.play.model.PowerJClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

/**
 * <p>客户端service</p>
 *
 * @author : Heyunqiu
 * @date :2022/6/20
 **/
@Service
public class PowerJClientService implements ClientDetailsService {
    @Autowired
    private PowerJOauth2Property powerJOauth2Property;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        PowerJClient powerJClient = powerJOauth2Property.getClients().stream()
                .filter(client -> client.getClientId().equals(clientId))
                .findFirst()
                .orElse(null);
        return powerJClient.toClientDetails();
    }
}
