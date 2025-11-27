package ldAntDron2k25;
import ldAntDron2k25.ldEntornoHormiga.ldHZangano;

public class ldAntCiberDron extends ldBBA implements ldIIA {

private ldHZangano ldHormiga;
private ldBBA ldBomba;
    
     public ldAntCiberDron(ldHZangano  hormiga) {
        this.ldHormiga = hormiga;   
        this.ldBomba = new ldBBA();
    }
    @Override
    public boolean ldBuscar(String tipoArsenal) {

        return ldBomba.ldVerificarPalabra(tipoArsenal);
    }

public ldHZangano getLdHormiga() {
return ldHormiga;
}
public void setLdHormiga(ldHZangano ldHormiga) {
    this.ldHormiga = ldHormiga;
}
public ldBBA getLdBomba() {
    return ldBomba;
}
public void setLdBomba(ldBBA ldBomba) {
    this.ldBomba = ldBomba;
}
}
