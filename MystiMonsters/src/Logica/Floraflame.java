package Logica;

public class Floraflame extends MystiMonstersGeneral implements IPlanta {
	
	public Floraflame() {
		
	}

	@Override
	public void atacarDrenaje() {
		System.out.print("Hola soy Floraflame y este es mi ataque de Drenaje'\n'");
	}

	@Override
	public void atacarParalizar() {
		System.out.print("Hola soy Floraflame y este es mi ataque de Paralizar'\n'");		
	}

	@Override
	protected void atacarPlacaje() {
		System.out.print("Hola soy Floraflame y este es mi ataque de Pacaje'\n'");		
	}

	@Override
	protected void atacarAraniazo() {
		System.out.print("Hola soy Floraflame y este es mi ataque de Araniazo'\n'");		
	}

	@Override
	protected void atacarMordisco() {
		System.out.print("Hola soy Floraflame y este es mi ataque de Mordisco'\n'");		
	}
	
	  
	
}