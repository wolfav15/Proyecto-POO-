package modelo;

public class CartaMagicaCampo extends CartaMagica{
	
private String tipoEfecto; //opciones: "AUMENTAR", "INFLIGIR", "NEGAR"
	
	public CartaMagicaCampo(String nombre, String descripcion, int efectos, String tipoEfecto, Jugador jugador) {
        super(nombre, descripcion, efectos, jugador);
        this.tipoEfecto = tipoEfecto;
    }
	
	
	
	
	private void aumentarAtributos() {   //Incrementa Atributos de las cartas del jugador
		
	}
    private void infligirDaño() {  //para inflijir daño, a los rivales
    }
	
    private void negacion() {} //Otorga Beneficios al jugador

	@Override
	public void activar_efecto() {
		switch(tipoEfecto) {
		 case "AUMENTAR":
			 this.aumentarAtributos();
			 break;
		 case "INFLIGIR":
			 this.infligirDaño();
			 break;
		 case "NEGAR":
			 this.negacion();
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
