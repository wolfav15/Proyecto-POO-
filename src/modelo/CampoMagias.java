package modelo;

import java.util.ArrayList;
import java.util.List;

public class CampoMagias {
    
    private List<Carta> CampoDeMagias;

    public CampoMagias() {
        this.CampoDeMagias = new ArrayList<Carta>();
    }

    public void agregarCarta(Carta e) throws Exception {
		if (CampoDeMagias.size() <= 4) {
			CampoDeMagias.add(e);
		} else {
			throw new Exception("Campo lleno");
		}
	}

	public void removerCarta(Carta e) throws Exception {
		if (CampoDeMagias.size() <= 0) { //como dije, ver bien esta wea
			CampoDeMagias.add(e);
		} else {
			throw new Exception("Campo Vacío");
		}
	}

    public List<Carta> getCartasMagicasEnCampo() {
        return CampoDeMagias;
    }

}