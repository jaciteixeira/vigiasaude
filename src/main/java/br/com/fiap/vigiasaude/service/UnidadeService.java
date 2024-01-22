package br.com.fiap.vigiasaude.service;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.vigiasaude.data.UnidadeDao;
import br.com.fiap.vigiasaude.model.Unidade;

public class UnidadeService {
	
	UnidadeDao dao = new UnidadeDao();

	public boolean existeUnidade(Unidade unidade) {
		Unidade unidadeEncontrado;
		try {
			unidadeEncontrado = dao.findByEmail(unidade.getEmail());
			return unidadeEncontrado != null
					&& unidadeEncontrado.getNome().equals(unidade.getNome())
					&& unidadeEncontrado.getCnes().equals(unidade.getCnes())
					&& unidadeEncontrado.getEmail().equals(unidade.getEmail());
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Unidade buscarPorId(Long id) {
		try {
			Unidade unidadeEncontrado = dao.findById(id);
			return unidadeEncontrado;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean validaUnidade(Unidade unidade) {
			try {
				Unidade unidadeEncontrado = dao.findByEmail(unidade.getEmail());
				if (unidadeEncontrado == null ) return false;
				return unidade.getEmail()!= null
						&& unidadeEncontrado.getEmail().equals(unidade.getEmail())
						&& unidadeEncontrado.getSenha().equals(unidade.getSenha());
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return false;
	}

	public boolean cadastrar(Unidade unidade) {
		if (unidade.getNome().isEmpty()
				&& unidade.getEmail().isEmpty()
				&& unidade.getTelefone().isEmpty()
				&& unidade.getCep().isEmpty()) return false;
			try {
				dao.cadastrar(unidade);
				return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Unidade> buscarTodos() {
		try {
			List<Unidade> lista = dao.findAll();
			return lista;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	


}
