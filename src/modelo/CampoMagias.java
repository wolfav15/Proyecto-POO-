package modelo;

import java.util.ArrayList;
import java.util.List;

public class CampoMagias {
    
    private List<CartaMagica> CampoDeMagias;

    public CampoMagias() {
        this.CampoDeMagias = new ArrayList<CartaMagica>();
    }

    public void agregarCarta(CartaMagica e) throws Exception {
		if (CampoDeMagias.size() <= 4) {
			CampoDeMagias.add(e);
		} else {
			throw new Exception("Campo lleno");
		}
	}

	public void removerCarta(CartaMagica e) throws Exception {
		if (CampoDeMagias.size() <= 0) { //como dije, ver bien esta wea
			CampoDeMagias.add(e);
		} else {
			throw new Exception("Campo Vacío");
		}
	}

    public List<CartaMagica> getCartaMagicasEnCampo() {
        return CampoDeMagias;
    }

}