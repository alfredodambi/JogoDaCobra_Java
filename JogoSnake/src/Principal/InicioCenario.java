package Principal;

import java.awt.Graphics2D;

import Base.CenarioPadrao;
import Base.Menu;
import Base.Util;

public class InicioCenario extends CenarioPadrao {

    
	public InicioCenario(int largura, int altura) {
		super(largura, altura);
	}

	private Menu menuJogo;

	private Menu menuVelInicial;

        //Editando o menu do jogo
	@Override
	public void carregar() {

            //Niveis do jogo
		menuJogo = new Menu("Fase");
		
		String[] opcoes = new String[Nivel.niveis.length + 1];
		
		for (int i = 0; i < opcoes.length; i++) {
			opcoes[i] = "Nivel " + i;
		}
		
		opcoes[opcoes.length - 1] = "Cobra Gigante";

		menuJogo.addOpcoes(opcoes);

                //velocidade da cobra
		menuVelInicial = new Menu("Veloidade");
		menuVelInicial.addOpcoes("Normal", "Rápido", "Lento");

                //Centralizando o menu
		Util.centraliza(menuJogo, largura, altura);
		Util.centraliza(menuVelInicial, largura, altura);

		menuVelInicial.setPy(menuJogo.getPy() + menuJogo.getAltura());

		menuJogo.setAtivo(true);
		menuJogo.setSelecionado(true);
		menuVelInicial.setAtivo(true);
	}

	@Override//Carregando as opções do menu
	public void descarregar() {
		Jogo.nivel = menuJogo.getOpcaoId();

                //Velocidade da cobra 0 para normal, 1 para rápido e 2 para lento 
		switch (menuVelInicial.getOpcaoId()) {
		case 0:
			Jogo.velocidade = 6;
			break;
		case 1:
			Jogo.velocidade = 10;
			break;
		case 2:
			Jogo.velocidade = 4;
		}

	}

	@Override//Actualizando a movimentação da tecla pressionada
	public void atualizar() {
		if (Jogo.controleTecla[Jogo.Tecla.CIMA.ordinal()] || Jogo.controleTecla[Jogo.Tecla.BAIXO.ordinal()]) {
			if (menuJogo.isSelecionado()) {
				menuJogo.setSelecionado(false);
				menuVelInicial.setSelecionado(true);

			} else {
				menuJogo.setSelecionado(true);
				menuVelInicial.setSelecionado(false);
			}

		} else if (Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()] || Jogo.controleTecla[Jogo.Tecla.DIREITA.ordinal()]) {
			menuJogo.setTrocaOpcao(Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()]);
			menuVelInicial.setTrocaOpcao(Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()]);

		}

		Jogo.liberaTeclas();

	}

	@Override//Desenho do menu do jogo
	public void desenhar(Graphics2D g) {
		menuJogo.desenha(g);
		menuVelInicial.desenha(g);
	}

}
