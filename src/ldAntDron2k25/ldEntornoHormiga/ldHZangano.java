package ldAntDron2k25.ldEntornoHormiga;

public class ldHZangano implements IHormiga {
public ldHZangano(){
    System.out.println("Hormiga Zangano creada");
}
    
public void ldVive(boolean comio) {
        if (comio) {
            System.out.println("La hormiga Zángano está viva ");
        } else {
            System.out.println("La hormiga Zángano NO puede vivir porque no comió el alimento ");
        }
    }
    @Override
    public boolean ldComer(Alimento Alimento) {
      if (Alimento instanceof Omnivoro) {
            return true;  
        }
        return false;
    }

}
