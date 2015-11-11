package com.rhcloud.my_visualjava.dao.todo;

/**
 * Created by Zheka on 17.09.2015.
 */
public class JdbcLocalhostConfiguration {

    /*
    * Configure JDBC
    * */

    public static final String URL = "jdbc:mysql://localhost:3306/test?useUnicode=yes&characterEncoding=UTF-8";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    /*
    * Queary JDBCs
    * */

    public static final String INSERT_NEW = "insert into todo (todo, name,isdone) values (?,?,?)";
    public static final String DEL = "delete from todo where id=?";

}
