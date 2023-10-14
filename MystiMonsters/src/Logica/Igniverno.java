package Logica;

public class Igniverno extends MystiMonstersGeneral implements IFuego{

	
	public Igniverno() {
		
	}
	
	@Override
	public void atacarPunioFuego() {
		System.out.print("Hola soy Igniverno y este es mi ataque de PunioFuego'\n'");		
	}

	@Override
	public void atacarLanzallamas() {
		System.out.print("Hola soy Igniverno y este es mi ataque de Lanzallamas'\n'");		
	}

	@Override
	public void atacarAscuas() {
		System.out.print("Hola soy Igniverno y este es mi ataque de Ascuas'\n'");		
	}

	@Override
	protected void atacarPlacaje() {
		System.out.print("Hola soy Igniverno y este es mi ataque de Placaje'\n'");		
	}

	@Override
	protected void atacarAraniazo() {
		System.out.print("Hola soy Igniverno y este es mi ataque de Araniazo'\n'");		
	}

	@Override
	protected void atacarMordisco() {
		System.out.print("Hola soy Igniverno y este es mi ataque de Mordisco'\n'");		
	}

}
