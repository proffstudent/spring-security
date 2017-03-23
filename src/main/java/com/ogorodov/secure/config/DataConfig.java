package com.ogorodov.secure.config;

import org.apache.log4j.Logger;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.ogorodov.repository")
public class DataConfig {

    private static final String PROP_DATABASE_DRIVER = "org.postgresql.Driver";
    private static final String PROP_DATABASE_URL = "jdbc:postgresql://localhost:5432/publications";
    private static final String PROP_DATABASE_USERNAME = "postgres";
    private static final String PROP_DATABASE_PASSWORD = "hH1508985";

    private static final String PROP_HIBERNATE_DIALECT = "org.hibernate.dialect.PostgreSQL9Dialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "true";
    private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.ogorodov.entity";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "create";
    private static final String PROP_HIBERNATE_FORMAT_SQL = "true";


    private static Logger logger = Logger.getLogger(DataConfig.class);

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(getDataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        entityManagerFactoryBean.setPackagesToScan(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(PROP_HIBERNATE_DIALECT, PROP_HIBERNATE_DIALECT);
        properties.put(PROP_HIBERNATE_SHOW_SQL, PROP_HIBERNATE_SHOW_SQL);
        //properties.put(PROP_HIBERNATE_HBM2DDL_AUTO, PROP_HIBERNATE_HBM2DDL_AUTO);

        return properties;
    }
    /**
     * configure jdbc datasource
     *
     * @return DataSource
     */
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(PROP_DATABASE_URL, PROP_DATABASE_USERNAME, PROP_DATABASE_PASSWORD);
        dataSource.setDriverClassName(PROP_DATABASE_DRIVER);
        return dataSource;
    }

}
