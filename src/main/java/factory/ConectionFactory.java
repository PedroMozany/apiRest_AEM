package factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import exception.ConexaoException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConectionFactory {
    public DataSource dataSource;

    public ConectionFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/redteam?useTimezone=true&serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("root");
        comboPooledDataSource.setMaxPoolSize(15);
        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperarConexao()  throws SQLException, ClassNotFoundException, ConexaoException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return this.dataSource.getConnection();
        }catch (SQLException e) {
            throw new ConexaoException("Erro ao fechar a conexão" + e);
        }

    }
}
