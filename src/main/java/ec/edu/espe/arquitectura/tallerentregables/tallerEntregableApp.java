/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.tallerentregables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.text.RandomStringGenerator;

/**
 *
 * @author Alejandro Torres
 */
public class tallerEntregableApp {

    public static void main(String[] args) throws IOException, IOException, IOException {
        String cadena, cadenaHombre, cadenaMujer = null;
        List<String> nombreHombres = new ArrayList<String>();
        List<String> nombreMujeres = new ArrayList<String>();        
        List<String> apellidos = new ArrayList<String>();
        int aux = 0;

        RandomStringGenerator Cedulagenerator = new RandomStringGenerator.Builder()
                .withinRange('0', '9').build();

        RandomStringGenerator Diagenerator = new RandomStringGenerator.Builder()
                .withinRange('0', '9').build();

        RandomStringGenerator Mesgenerator = new RandomStringGenerator.Builder()
                .withinRange('0', '9').build();

        RandomStringGenerator Aniogenerator = new RandomStringGenerator.Builder()
                .withinRange('1', '9').build();

        RandomStringGenerator Provinciagenerator = new RandomStringGenerator.Builder()
                .withinRange('0', '9').build();

        FileReader nH = new FileReader("C://tmp//nombresH.txt");
        BufferedReader b1 = new BufferedReader(nH);
        FileReader nM = new FileReader("C://tmp//nombresM.txt");
        BufferedReader b2 = new BufferedReader(nM);
        FileReader a = new FileReader("C://tmp//apellidos.txt");
        BufferedReader b3 = new BufferedReader(a);
        
        String cedula = Cedulagenerator.generate(10);
        String provincia = Provinciagenerator.generate(2);
        
        for(int i=0; i<= nombreHombres.size(); i++){
            nombreHombres.add(b1.readLine());
            //System.out.println(nombreHombres);
        }
        for(int i=0; i<= nombreMujeres.size(); i++){
            nombreMujeres.add(b2.readLine());
            //System.out.println(nombreMujeres);
        }
        for(int i=0; i<= apellidos.size(); i++){
            apellidos.add(b3.readLine());
            System.out.println(apellidos);
        }
        
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 10; i++) {
            while ((cadena = b3.readLine()) != null) {
                //cadenaHombre = b1.readLine();
                cadenaMujer = b2.readLine();
                sb.append(Cedulagenerator.generate(10));
                sb.append(',');
                sb.append(cadena);
                sb.append(',');
                if(aux!=1)
                {
                    //sb.append(cadenaHombre);
                    sb.append(nombreHombres);
                    sb.append(',');
                } else{
                    sb.append(cadenaMujer);                                        
                    sb.append(',');
                }
                sb.append(Diagenerator.generate(2));
                sb.append('/');
                sb.append(Mesgenerator.generate(2));
                sb.append('/');
                sb.append(Aniogenerator.generate(2));
                sb.append(',');
                sb.append(provincia);
                sb.append(',');
                Random aleatorio = new Random();
                Random estado = new Random();
                
                int al = aleatorio.nextInt(3);
                if (al == 0) {
                    sb.append('M');
                    aux=1;
                } else {
                    sb.append('F');
                }
                sb.append(',');

                int pro = estado.nextInt(5);
                if (pro == 0) {
                    sb.append("SOL");
                } else if (pro == 1) {
                    sb.append("CAS");
                } else if (pro == 2) {
                    sb.append("DIV");
                } else if (pro == 3) {
                    sb.append("VIU");
                } else {
                    sb.append("ULI");
                }
                sb.append('\n');
            }
        }
        File file = new File("C://tmp//registroCivil.txt");

        try {
            FileUtils.write(file, sb.toString());

        } catch (IOException iOException) {
        }
        long stop = System.currentTimeMillis();
    }
}

/*Scanner in, ni = null;

        String cadena;
         String cadena2;
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('A', 'Z').build();
        RandomStringGenerator ApeGenerator = new RandomStringGenerator.Builder()
                .withinRange('A', 'Z').build();
        RandomStringGenerator Cedulagenerator = new RandomStringGenerator.Builder()
                .withinRange('0', '9').build();

        RandomStringGenerator Numgenerator = new RandomStringGenerator.Builder()
                .withinRange('0', '9').build();

        FileReader f1 = new FileReader("C://tmp//nombresH.txt");
        BufferedReader b1 = new BufferedReader(f1);
        FileReader f2 = new FileReader("C://tmp//nombresH.txt");
        BufferedReader b2 = new BufferedReader(f1);
        StringBuffer sb = new StringBuffer();
        while ((cadena = b1.readLine()) != null) {
            System.out.println(cadena);
            cadena2 = b2.readLine();
            String line = generator.generate(4, 10);
            String cedula = Cedulagenerator.generate(10);
            long start = System.currentTimeMillis();
            sb.append(cadena);
            sb.append(',');
            sb.append(cadena2);
            sb.append(',');
            sb.append(Cedulagenerator.generate(10));
            sb.append(',');
            sb.append(generator.generate(4, 10));
            sb.append(',');
            sb.append(ApeGenerator.generate(4, 10));
            sb.append(',');
            sb.append("09" + Numgenerator.generate(7));

            sb.append(',');
            Random aleatorio = new Random(System.currentTimeMillis());
// Producir nuevo int aleatorio entre 0 y 99
            int al = aleatorio.nextInt(3);
            if (al == 0) {
                sb.append('M');
            } else {
                sb.append('F');
            }
            sb.append('\n');

        }
        File file = new File("C://tmp//departamentoEstadosunidos.txt");

        try {
            FileUtils.write(file, sb.toString());

        } catch (IOException iOException) {
        }
        long stop = System.currentTimeMillis();
        //     System.out.pr
*/