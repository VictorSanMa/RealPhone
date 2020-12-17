package com.andromedarp.realphone.api.realphone.config;


import com.andromedarp.realphone.api.realphone.service.SSHService;
import com.jcraft.jsch.JSchException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class SSHConfig {

    @Value("${ssh.ip}")
    public String ip;

    @Value("${ssh.port}")
    public int port;

    @Value("${ssh.username}")
    public String username;

    @Value("${ssh.password}")
    public String password;

    @Bean
    public SSHService sshConfig() throws IllegalAccessException, JSchException {
        SSHService sshService = new SSHService();
        sshService.connect(username, password, ip, port);
        return sshService;
    }

}
