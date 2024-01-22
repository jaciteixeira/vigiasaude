package br.com.fiap.vigiasaude.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.vigiasaude.model.Unidade;
import br.com.fiap.vigiasaude.model.Medico;

public class MedicoDao {

	UnidadeDao unidadeDao = new UnidadeDao();
	
	private Medico populaMedico(ResultSet rs) throws SQLException, ClassNotFoundException {
		Unidade unidade = unidadeDao.findById(rs.getLong("id_unidade"));
        return new Medico(
				rs.getLong("id_medico"),
				rs.getString("nom_medico"),
				rs.getString("des_especialidade"),
				rs.getString("num_crm"),
				rs.getString("des_telefone"),
				rs.getString("des_email"),
				rs.getString("des_senha"),
				unidade);
    }
	
	public void cadastrar(Medico medico) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "INSERT INTO T_VGS_MEDICO("
				+ "nom_medico,"
				+ "des_especialidade, "
				+ "num_crm,"
				+ "des_telefone, "
				+ "id_unidade,"
				+ "des_email, "
				+ "des_senha) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, medico.getNome());
		ps.setString(2, medico.getEspecialidade());
		ps.setString(3, medico.getCrm());
		ps.setString(4, medico.getTelefone());
		ps.setLong(5, medico.getUnidade().getId());
		ps.setString(6, medico.getEmail());
		ps.setString(7, medico.getSenha());
		ps.executeUpdate();
        connection.close();
	}

	public Medico buscarPorEmail(String email) throws ClassNotFoundException, SQLException {
		try(Connection connection = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM T_VGS_MEDICO WHERE des_email = ?";
			try(PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setString(1, email);
				try(ResultSet rs = ps.executeQuery()){
					return rs.next() ? populaMedico(rs) : null;
				}
			}
		}
	}

	public Medico buscaPorId(Long id) throws ClassNotFoundException, SQLException {
		try(Connection connection = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM T_VGS_MEDICO WHERE id_medico = ?";
			try(PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setLong(1, id);
				try(ResultSet rs = ps.executeQuery()){
					return rs.next() ? populaMedico(rs) : null;
				}
			}
		}
	}
}
