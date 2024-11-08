package carta;

public class CartaMagicaCampo extends CartaMagica{
	
private String tipoEfecto; //opciones: "AUMENTAR", "INFLIGIR", "CURAR"
	
	public CartaMagicaCampo(String nombre, String descripcion, int efectos, String tipoEfecto) {
        super(nombre, descripcion, efectos);
        this.tipoEfecto = tipoEfecto;
    }
	
	
	
	
	private void aumentarAtributos() {   //Incrementa Atributos de las cartas del jugador
		
	}
    private void infligirDaño() {  //para inflijir daño, a los rivales
    }
	
    private void proteccionJugador() {} //Otorga Beneficios al jugador

	@Override
	public void activar_efecto() {
		switch(tipoEfecto) {
		 case "AUMENTAR":
			 this.aumentarAtributos();
			 break;
		 case "INFLIGIR":
			 this.infligirDaño();
			 break;
		 case "PROTECCION":
			 this.proteccionJugador();
			 break;
		}	
	}

	@Override
	public void colocar() {
		 this.activo = true;
	     this.estado = "colocado";	
	}

	@Override
	public void destruirse() {
		this.activo = false;
		
	}

}
