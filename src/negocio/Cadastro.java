package negocio;

import java.util.Arrays;
import java.util.Objects;

public class Cadastro {
	private String nome;
	private String usuario;
	private char[] senha;
	private String crm;
	public static String nomeMedico;

	public Cadastro() {

	}

	public Cadastro(String nome, String usuario, char[] senha, String crm) {
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public char[] getSenha() {
		return senha;
	}

	public void setSenha(char[] senha) {
		this.senha = senha;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(senha);
		result = prime * result + Objects.hash(crm, nome, usuario);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		return Objects.equals(crm, other.crm) && Objects.equals(nome, other.nome) && Arrays.equals(senha, other.senha)
				&& Objects.equals(usuario, other.usuario);
	}

}
