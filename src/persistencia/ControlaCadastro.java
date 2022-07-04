package persistencia;

import java.util.ArrayList;
import java.util.List;

import negocio.Cadastro;

public class ControlaCadastro {
	
	
	public static List<Cadastro> cadastro = new ArrayList<Cadastro>();
	
	public void cadastraUsuario(Cadastro c) {
		cadastro.add(c);
	}
}
