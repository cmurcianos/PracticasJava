package Logica;

public class Rocluminis extends MystiMonstersGeneral implements IElectrico{
	
	public Rocluminis() {
		
	}

	@Override
	public void atacarImpactrueno() {
		System.out.print("Hola soy Rocluminis y este es mi ataque de Impactrueno'\n'");		
	}

	@Override
	public void atacarPuniotrueno() {
		System.out.print("Hola soy Rocluminis y este es mi ataque de Puniotrueno'\n'");		
	}

	@Override
	protected void atacarPlacaje() {
		System.out.print("Hola soy Rocluminis y este es mi ataque de Placaje'\n'");		
	}

	@Override
	protected void atacarAraniazo() {
		System.out.print("Hola soy Rocluminis y este es mi ataque de Araniazo'\n'");		
	}

	@Override
	protected void atacarMordisco() {
		System.out.print("Hola soy Rocluminis y este es mi ataque de Mordisco'\n'");		
	}

}
