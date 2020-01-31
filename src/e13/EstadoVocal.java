package e13;

public  class EstadoVocal extends EstadoTexto{

    public static boolean validarVocal (char letra){
        if ( letra == 'a' || letra=='e'|| letra== 'o' || letra== 'u' || letra== 'i'
                || letra == 'A' || letra=='E'|| letra== 'O' || letra== 'U' ||letra== 'I')
            return true;
        else return false;
    }

    public char convertir (char letra){

        return Character.toUpperCase(letra);

    }

}
