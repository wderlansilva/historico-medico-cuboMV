package negocio;

import java.util.Objects;

public class Atendimento {

	private String nomePaciente;
	private String numeroAtendimento;
	private String diagnostico;
	public static int numeroTotalAtendimento = 0;

	public Atendimento() {

	}

	public Atendimento(String nomePaciente, String diagnostico, String numeroAtendimento) {
		this.nomePaciente = nomePaciente;
		this.diagnostico = diagnostico;
		this.numeroAtendimento = numeroAtendimento;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getNumeroAtendimento() {
		return numeroAtendimento;
	}

	public void setNumeroAtendimento(String numeroAtendimento) {
		this.numeroAtendimento = numeroAtendimento;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diagnostico, nomePaciente, numeroAtendimento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atendimento other = (Atendimento) obj;
		return Objects.equals(diagnostico, other.diagnostico) && Objects.equals(nomePaciente, other.nomePaciente)
				&& Objects.equals(numeroAtendimento, other.numeroAtendimento);
	}

}
