package com.powerj.oauth2.play.conf;

import com.powerj.oauth2.play.model.PowerJClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>自定义oauth2配置</p>
 *
 * @author : Heyunqiu
 * @date :2022/6/20
 **/
@Component
@ConfigurationProperties(
        prefix = "powerj.oauth2"
)
public class PowerJOauth2Property {
    private List<PowerJClient> clients;

    public List<PowerJClient> getClients() {
        return clients;
    }

    public void setClients(List<PowerJClient> clients) {
        this.clients = clients;
    }
}
