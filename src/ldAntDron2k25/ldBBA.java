package ldAntDron2k25;

public class ldBBA {
    public ldBBA(){

    }

    public boolean ldVerificarPalabra(String palabra){
        if (palabra.matches("a+")) {
            return true;
        }
        if (palabra.matches("abcdt+")) {
            return true;
        }
        return false;
    }
    }

