package com.tal.employeemanager.config.heroku;

/**
 * From Guide: https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java#using-the-database_url-in-spring-with-java-configuration
 */
// @Configuration
// public class HerokuPostgreSQLConfiguration {
//
//     @Bean public BasicDataSource dataSource() throws URISyntaxException {
//         URI dbUri = new URI(System.getenv("DATABASE_URL"));
//
//         String username = dbUri.getUserInfo().split(":")[0];
//         String password = dbUri.getUserInfo().split(":")[1];
//         String dbUrl =
//                 "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() +
//                         dbUri.getPath();
//
//         BasicDataSource basicDataSource = new BasicDataSource();
//         basicDataSource.setUrl(dbUrl);
//         basicDataSource.setUsername(username);
//         basicDataSource.setPassword(password);
//
//         return basicDataSource;
//     }
//
// }

