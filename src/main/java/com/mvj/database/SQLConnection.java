package com.mvj.database;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Zheka on 15.09.2015.
 */

public class SQLConnection {

    private static Connection connection = null;
    private static Session session = null;

    public static void main(String[] args) throws SQLException {
        portForvatdingOverSsh();
    }

    private static void connectToServer(String dataBaseName) throws SQLException {
        portForvatdingOverSsh();
        connectToDataBase(dataBaseName);
    }

    public static void portForvatdingOverSsh() throws SQLException {
        String sshHost = "my-visualjava.rhcloud.com";
        String sshuser = "55edf4792d527192a300014a";
        String SshKeyFilepath = "C:/Users/LyashenkoGS/.ssh/id_rsa";

        int localPort = 8742; // any free port can be used
        String remoteHost = "127.9.81.2";
        int remotePort = 3306;
        String driverName = "com.mysql.jdbc.Driver";

        try {
            java.util.Properties config = new java.util.Properties();
            JSch jsch = new JSch();
            session = jsch.getSession(sshuser, sshHost, 22);
            jsch.addIdentity(SshKeyFilepath);
            config.put("StrictHostKeyChecking", "no");
            config.put("ConnectionAttempts", "3");
            session.setConfig(config);
            session.connect();

            System.out.println("SSH Connected");

            Class.forName(driverName).newInstance();

            int assinged_port = session.setPortForwardingL(localPort, remoteHost, remotePort);

            System.out.println("localhost:" + assinged_port + " -> " + remoteHost + ":" + remotePort);
            System.out.println("Port Forwarded");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void connectToDataBase(String dataBaseName) throws SQLException {
        String dbuserName = "adminiwG1ZaB";
        String dbpassword = "v3ykjhlpBE9q";
        int localPort = 8742; // any free port can be used
        String localSSHUrl = "127.0.0.1";
        try {

            //mysql database connectivity
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName(localSSHUrl);
            dataSource.setPortNumber(localPort);
            dataSource.setUser(dbuserName);
            dataSource.setAllowMultiQueries(true);

            dataSource.setPassword(dbpassword);
            dataSource.setDatabaseName(dataBaseName);

            connection = dataSource.getConnection();

            System.out.print("Connection to server successful!:" + connection + "\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}