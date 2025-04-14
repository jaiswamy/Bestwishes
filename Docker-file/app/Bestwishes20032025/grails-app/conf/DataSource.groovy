dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
    username = "wishes"
    password = "WisHes@HitpL2025"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
    singleSession = true
    flush.mode = 'manual'
}

environments {
    development {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/db_bestwish?useUnicode=yes&characterEncoding=UTF-8&useSSL=false"
            username = "root"
            password = "mysql123"
        }
    }
    test {
        dataSource {
            pooled = true
            driverClassName = "com.mysql.jdbc.Driver"
            dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/db_fintrack?useUnicode=yes&characterEncoding=UTF-8&useSSL=false"
            username = "root"
            password = "mysql123"
            properties {
                jmxEnabled = true
                initialSize = 5
                maxActive = 50
                minIdle = 5
                maxIdle = 25
                maxWait = 10000
                validationQuery = "SELECT 1"
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = false
                jdbcInterceptors = "ConnectionState"
                defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
            }
        }
    }
    production {
        dataSource {
            pooled = true
            dbCreate = "update"
            url = "jdbc:mysql://db:3306/db_wishes?useUnicode=yes&characterEncoding=UTF-8&useSSL=false"
            username = "wishes"
            password = "WisHes@HitpL2025"
            properties {
                jmxEnabled = true
                initialSize = 5
                maxActive = 50
                minIdle = 5
                maxIdle = 25
                maxWait = 10000
                validationQuery = "SELECT 1"
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = false
                jdbcInterceptors = "ConnectionState"
                defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
            }
        }
    }
}
