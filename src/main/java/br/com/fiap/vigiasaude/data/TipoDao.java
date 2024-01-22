package br.com.fiap.vigiasaude.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.vigiasaude.model.TipoUnidade;

public class TipoDao {
	
	private TipoUnidade polularUnidade(ResultSet rs) throws SQLException {
		return new TipoUnidade(
				rs.getLong("id_tipo"), 
				rs.getString("des_tipo_unidade"));
	}

	public TipoUnidade buscarPorId(Long id) throws ClassNotFoundException, SQLException {
		try(Connection connection = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM T_VGS_TIPO_UNIDADE WHERE id_tipo = ?";
			try(PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setLong(1, id);
				try(ResultSet rs = ps.executeQuery()){
					return rs.next() ? polularUnidade(rs) : null;
				}
			}
		}
	}

	public List<TipoUnidade> findAll() throws ClassNotFoundException, SQLException {
		List<TipoUnidade> tiposUnidade = new ArrayList<>();
	    try (Connection connection = ConnectionFactory.getConnection()) {
	        String sql = "SELECT * FROM T_VGS_TIPO_UNIDADE";
	        try (PreparedStatement ps = connection.prepareStatement(sql)) {
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    tiposUnidade.add(polularUnidade(rs));
	                }
	            }
	        }
	    }
	    return tiposUnidade;
	}

}
