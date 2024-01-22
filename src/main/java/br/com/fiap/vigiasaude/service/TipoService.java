package br.com.fiap.vigiasaude.service;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.vigiasaude.data.TipoDao;
import br.com.fiap.vigiasaude.model.TipoUnidade;

public class TipoService {

	TipoDao dao = new TipoDao();
	
	public TipoUnidade buscarPorId(Long id) {
		try {
			TipoUnidade tipoEncontrado = dao.buscarPorId(id);
			return tipoEncontrado;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TipoUnidade> listarTodos() {
		try {
			List<TipoUnidade> lista = dao.findAll();
			return lista;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
