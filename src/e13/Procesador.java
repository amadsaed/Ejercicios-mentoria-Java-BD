package e13;

import java.io.*;
import java.util.Scanner;
import java.io.FileWriter;

public class Procesador {


    public static void main(String[] args) throws IOException {

        EstadoTexto estadoVocal = new EstadoVocal();
        EstadoTexto estadoCons = new EstadoConsonante();


        System.out.println("enter the link of the text :");

        Scanner in = new Scanner(System.in);

        String t = in.nextLine();

        File file = new File(t);

        BufferedReader bf = new BufferedReader(new FileReader(file));

        String txt = "";

        String buffer = "";

        while ((buffer=bf.readLine())!= null){
            txt= txt + buffer ;
        }

        System.out.println("Your text is : " + " " + txt);

        String textoNuevo = "";

        for (int i = 0 ; i <txt.length(); i++){

           char symbol =  txt.charAt(i);
           char letraNueva;


           if(EstadoVocal.validarVocal(symbol)){

               letraNueva= estadoVocal.convertir(symbol) ;

           }
           else {
                   letraNueva = estadoCons.convertir(symbol) ;

           }

           textoNuevo = textoNuevo.concat(String.valueOf(letraNueva));

        }

        System.out.println("Your new text is :");

        System.out.println(textoNuevo);

        System.out.println("The text has been created and downloaded in the desktop.");

        try {
            FileWriter writer = new FileWriter("C:/Users/Ahmad Saed/Desktop/MyNewText.txt");

            writer.write(textoNuevo);

            writer.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

}
