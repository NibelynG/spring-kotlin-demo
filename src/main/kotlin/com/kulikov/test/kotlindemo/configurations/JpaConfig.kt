package com.kulikov.test.kotlindemo.configurations

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableJpaRepositories(basePackages = ["com.kulikov.test.kotlindemo.db"])
@EntityScan(basePackages = ["com.kulikov.test.kotlindemo.db"])
@EnableTransactionManagement
class JpaConfig {
}