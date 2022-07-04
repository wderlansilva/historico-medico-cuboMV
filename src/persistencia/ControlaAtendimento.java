package persistencia;

import java.util.ArrayList;
import java.util.List;

import negocio.Atendimento;

public class ControlaAtendimento {

	public static List<Atendimento> listaDeAtendimentos = new ArrayList<Atendimento>();

	public void cadastrarAtendimento(Atendimento atendimento) {
		listaDeAtendimentos.add(atendimento);
	}

	public void removeAtendimento(Atendimento atendimento) {
		listaDeAtendimentos.remove(atendimento);
	}

	public List<Atendimento> verificaLista() {
		return listaDeAtendimentos;
	}


}
