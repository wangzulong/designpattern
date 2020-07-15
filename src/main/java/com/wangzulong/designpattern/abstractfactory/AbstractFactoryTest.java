package com.wangzulong.designpattern.abstractfactory;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/12 16:31
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        IDatabaseUtils databaseUtils = new OracleDatabaseUtils();
        IConnection coonection = databaseUtils.getConnect();
        coonection.connect();
        ICommand command = databaseUtils.getCommand();
        command.command();
    }
}

// 变化， mysql， oracle. ...
//       connection,  command,

interface IConnection {
    void connect();
}

interface ICommand{
    void command();
}

interface IDatabaseUtils {
    IConnection getConnect();
    ICommand getCommand();
}

class MysqlConnection implements IConnection {

    @Override
    public void connect() {
        System.out.println("mysql链接");
    }
}

class MysqlCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("mysql命令");
    }
}

class MysqlDatabaseUtils implements IDatabaseUtils {

    @Override
    public IConnection getConnect() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return  new MysqlCommand();
    }
}

class OracleConnection implements IConnection {

    @Override
    public void connect() {
        System.out.println("oracle链接");
    }
}

class OracleCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("oracle命令");
    }
}

class OracleDatabaseUtils implements IDatabaseUtils {

    @Override
    public IConnection getConnect() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return  new OracleCommand();
    }
}