package factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import exception.ConexaoException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConectionFactory {
    public DataSource dataSource;

    public ConectionFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:postgres://xuzotaszqmdsgo:15ec21679fd40d5d0af51e9825eb9e885578e5bccc865f627e01f89ffa1ae90f@ec2-34-192-210-139.compute-1.amazonaws.com:5432/d6v1aen4h4hkqe");
        comboPooledDataSource.setUser("xuzotaszqmdsgo");
        comboPooledDataSource.setPassword("15ec21679fd40d5d0af51e9825eb9e885578e5bccc865f627e01f89ffa1ae90f");
        comboPooledDataSource.setMaxPoolSize(15);
        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperarConexao() throws SQLException, ClassNotFoundException, ConexaoException {
        try {
            Class.forName("org.postgresql.Driver");
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new ConexaoException("Erro ao fechar a conexão" + e);
        }

    }
}
