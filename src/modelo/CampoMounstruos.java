package modelo;

import java.util.ArrayList;
import java.util.List;

public class CampoMounstruos {
    private List<Carta> CampoDeMounstruos;

    public CampoMounstruos() {
        this.CampoDeMounstruos = new ArrayList<Carta>(); 
    }

    public void agregarCarta(Carta e) throws Exception {
		if (CampoDeMounstruos.size() <= 4) {
			CampoDeMounstruos.add(e);
		} else {
			throw new Exception("Campo lleno");
		}
	}

	public void removerCarta(Carta e) throws Exception {
		if (CampoDeMounstruos.size() <= 0) { //me confunde esto, ver bien despues, crei que seria un remove
			CampoDeMounstruos.add(e);
		} else {
			throw new Exception("Campo Vacío");
		}
	}

    public List<Carta> getCartasMounstruoEnCampo() {
        return CampoDeMounstruos;
    }

}