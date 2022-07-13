package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Voos;

public class DaoVoo {
	
	private Connection connection;
	
	public DaoVoo(Connection connection) {
		this.connection = connection;
	}
	
	public void criarVOO(Voos voo) {
		try {
			String sql = "INSERT INTO voos (NMRVOO, DATA, PRECO, ORIGEM, DESTINO, DURACAOVOO, NUMEROASSENTOS) VALUES (?, ?, ?, ?, ?, ?, ?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pstm.setInt(1, voo.getNmrDoVoo());
				pstm.setDate(2, voo.getData());
				pstm.setFloat(3, voo.getPreco());
				pstm.setString(4, voo.getOrigem());
				pstm.setString(5, voo.getDestino());
				pstm.setDate(6, voo.getDuracaoVoo());
				pstm.setInt(7, voo.getNumeroAssentos());

				pstm.execute();
			} 
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void deletarVoo(int nmrVoo) {
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM voos WHERE NMRVOO = ?")) {
			stm.setInt(1, nmrVoo);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Voos> getVoos() {
		List<Voos> voos = new ArrayList<Voos>();
		try {
			String sql = "SELECT * FROM voos";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						Voos voo = new Voos(rst.getInt(1), rst.getDate(2), rst.getFloat(3), rst.getString(4), rst.getString(5), rst.getDate(6), rst.getInt(7));
						voos.add(voo);
					}
				}
			}
			return voos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizarVoo(int nmrVoo, Date date, float preco, String origem, String destino, Date duracao, int numeroAssentos) {
		try (PreparedStatement stm = connection
				.prepareStatement("UPDATE voos P SET P.DATA = ?, P.PRECO = ?, P.ORIGEM = ?, P.DESTINO = ?, P.DURACAOVOO = ?, P.NUMEROASSENTOS = ? WHERE NMRVOO = ?")) {
			
			stm.setDate(1, (java.sql.Date) date);
			stm.setFloat(2, preco);
			stm.setString(3, origem);
			stm.setString(4, destino);
			stm.setDate(5, (java.sql.Date) duracao);
			stm.setInt(6, numeroAssentos);
			stm.setInt(7, nmrVoo);
			stm.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

