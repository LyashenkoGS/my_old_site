package com.rhcloud.my_visualjava.web.test.my_visualjava.web.todo;


public class JdbcProductionConfiguration {

    /*
    * Configure JDBC
    * */

    public static final String URL = "jdbc:mysql://127.9.81.2:3306/test?useUnicode=yes&characterEncoding=UTF-8";
    public static final String USERNAME = "adminiwG1ZaB";
    public static final String PASSWORD = "v3ykjhlpBE9q";

    /*
    * Queary JDBC
    * */

    public static final String INSERT_NEW = "insert into todo (todo, name,isdone) values (?,?,?)";
    public static final String DEL = "delete from todo where id=?";

}
