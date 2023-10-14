package Logica;

public class Hidroscuro extends MystiMonstersGeneral implements IAgua{

	public Hidroscuro() {
		
	}
	
	
	@Override
	public void atacarHidrobomba() {
		System.out.print("Hola soy Hidroscuro y este es mi ataque de Hidrobomba'\n'");		
	}

	@Override
	public void atacarBurbuja() {
		System.out.print("Hola soy Hidroscuro y este es mi ataque de Burbuja'\n'");		
	}

	@Override
	public void atacarPistolaAgua() {
		System.out.print("Hola soy Hidroscuro y este es mi ataque de PistolaAgua'\n'");		
	}

	@Override
	protected void atacarPlacaje() {
		System.out.print("Hola soy Hidroscuro y este es mi ataque de Placaje'\n'");		
	}

	@Override
	protected void atacarAraniazo() {
		System.out.print("Hola soy Hidroscuro y este es mi ataque de Araniazo'\n'");		
	}

	@Override
	protected void atacarMordisco() {
		System.out.print("Hola soy Hidroscuro y este es mi ataque de Mordisco'\n'");		
	}
	
	

}
