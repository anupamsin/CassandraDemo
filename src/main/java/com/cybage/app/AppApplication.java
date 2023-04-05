package com.cybage.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@SpringBootApplication
public class AppApplication extends AbstractCassandraConfiguration{

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Override
    protected String getKeyspaceName() {
      return "emp";
    }  

}
