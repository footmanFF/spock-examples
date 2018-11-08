package com.fm.core

/**
 * @author zhangli on 2017/10/20.
 */
import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification

class DatabaseDrivenSpec extends Specification {

    @Shared
    sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    def setupSpec() {
        sql.execute("CREATE TABLE maxdata (id INT PRIMARY KEY, a INT, b INT, c INT)")
        sql.execute("INSERT INTO maxdata VALUES (1, 3, 7, 7), (2, 5, 4, 5), (3, 9, 9, 9)")
    }

    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        // 将查询结果赋个a, b, c
        [a, b, c] << sql.rows("SELECT a, b, c FROM maxdata")
    }
}