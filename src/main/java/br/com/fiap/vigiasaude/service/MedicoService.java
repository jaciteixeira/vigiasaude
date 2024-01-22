package br.com.fiap.vigiasaude.service;

import java.sql.SQLException;

import br.com.fiap.vigiasaude.data.MedicoDao;
import br.com.fiap.vigiasaude.model.Medico;

public class MedicoService {
	
	MedicoDao dao = new MedicoDao();

	public boolean existeMedico(Medico medico) {
		Medico medicoEncontrado = buscarMedico(medico);
		return medicoEncontrado != null
				&& medicoEncontrado.getEmail().equals(medico.getEmail());
	}

	public boolean cadastrarMedico(Medico medico) {
		if (medico.getNome().isEmpty()
				&& medico.getEspecialidade().isEmpty()
				&& medico.getCrm().isEmpty()
				&& medico.getEmail().isEmpty()
				&& medico.getTelefone().isEmpty()) return false;
			try {
				dao.cadastrar(medico);
				return true;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public boolean validaMedico(Medico medico) {
		Medico medicoEncontrado = buscarMedico(medico);
		return medicoEncontrado != null
				&& medicoEncontrado.getEmail().equals(medico.getEmail())
				&& medicoEncontrado.getSenha().equals(medico.getSenha());
		
	}
	
	public Medico buscarMedico(Medico medico) {
		try {
			Medico medicoEncontrado = dao.buscarPorEmail(medico.getEmail());
			return medicoEncontrado;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public Medico buscarPorId(Long id) {
		try {
			Medico medico = dao.buscaPorId(id);
			return medico;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
