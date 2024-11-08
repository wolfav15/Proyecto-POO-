package carta;

public class CartaTrampaNormal extends CartaTrampa{
	
	private String tipoEfecto; //opciones: "CONTRA", "INFLIGIR", "DESTRUCCION"
	
	public CartaTrampaNormal(String nombre, String descripcion, int efectos, String tipoEfecto) {
        super(nombre, descripcion, efectos);
        this.tipoEfecto = tipoEfecto;
    }
	
	
	
	private void contraEfecto() {   //aqui se debe recibir a la carta a la cual se le negara el efecto o le hara contra
		
	}
    private void infligirDaño() {  //para inflijir daño, a los rivales
    }
	
    private void destruccionCarta() {} //Destruir Cartas del Oponenete
	

	@Override
	public void activar_efecto() {
		 switch(tipoEfecto) {
		 case "CONTRA":
			 this.contraEfecto();
			 break;
		 case "INFLIGIR":
			 this.infligirDaño();
			 break;
		 case "DESTRUCCION":
			 this.destruccionCarta();
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
