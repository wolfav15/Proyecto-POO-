package Campo;
import java.util.ArrayList;
import java.util.List;

import Carta.Carta;
public abstract class Campo {
    private List<Carta> campo;

    public Campo (){
        this.campo = new ArrayList<Carta> ();
    }
    public void agregarCarta (Carta e) throws Exception {
        if (campo.size() <= 4){
            campo.add(e);
        }
        else {
            throw new Exception("Campo lleno");
        }
    }
    public void removerCarta (Carta e) throws Exception {
        if (campo.size() <= 0){
            campo.add(e);
        }
        else {
            throw new Exception("Campo Vacío");
        }
    }
    
}
