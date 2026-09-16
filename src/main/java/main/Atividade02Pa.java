
package main;

import dao.Conexao;
import view.JframeCadastro;

public class Atividade02Pa {

    public static void main(String[] args) {
            Conexao.inicializarBanco();
            
            JframeCadastro tela = new JframeCadastro();
            
            tela.setVisible(true);
    }
}
