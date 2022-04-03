package Base;

import java.awt.Graphics2D;

public abstract class CenarioPadrao {

	protected int altura, largura;

        //Contructor com parametros
	public CenarioPadrao(int largura, int altura) {
		this.altura = altura;
		this.largura = largura;
	}

        
        //Metodos abstractos
	public abstract void carregar();

	public abstract void descarregar();

	public abstract void atualizar();

	public abstract void desenhar(Graphics2D g);

}
