/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
 * @author User
 */
public class tallerEntregableApp {

    public static void main(String[] args) throws IOException {
        //registroCivil();
        //clienteTemp();
        //departamentoEEUU();
        //consejoJudicatura();
        //clientesRestringidosConsejo();
        //clientesRestringidosDepartamento();
        posiblesRestringuidos();
    }

    public static void registroCivil() throws FileNotFoundException, IOException {
        Random aleatorio = new Random();
        List<String> nombreHombres = new ArrayList<>();
        List<String> nombreMujeres = new ArrayList<>();
        List<String> apellidos = new ArrayList<>();
        GregorianCalendar gc = new GregorianCalendar();

        int aux, provincia, al, posHombre, posMujer, posApellido = 0;

        RandomStringGenerator Cedulagenerator = new RandomStringGenerator.Builder()
                .withinRange('0', '9').build();

        FileReader nH = new FileReader("C://tmp//nombresH.txt");
        BufferedReader b1 = new BufferedReader(nH);
        FileReader nM = new FileReader("C://tmp//nombresM.txt");
        BufferedReader b2 = new BufferedReader(nM);
        FileReader a = new FileReader("C://tmp//apellidos.txt");
        BufferedReader b3 = new BufferedReader(a);

        String cedula = Cedulagenerator.generate(10);

        for (int i = 0; i <= 500; i++) {
            nombreHombres.add(b1.readLine());
            nombreMujeres.add(b2.readLine());
            apellidos.add(b3.readLine());
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= 10000; i++) {
            posHombre = aleatorio.nextInt(500);
            posMujer = aleatorio.nextInt(500);
            posApellido = aleatorio.nextInt(500);
            provincia = aleatorio.nextInt(24);
            
            int year = randBetween(50, 99);
            gc.set(gc.YEAR, year);
            int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
            gc.set(gc.DAY_OF_YEAR, dayOfYear);
            String fecha = gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH);

            al = aleatorio.nextInt(3);
            if (al == 0) {
                aux = 1;
            } else {
                aux = 0;
            }
            sb.append(Cedulagenerator.generate(10));
            sb.append(',');
            sb.append(apellidos.get(posApellido));
            sb.append(',');
            sb.append(apellidos.get(posApellido + 1));
            sb.append(',');
            if (aux == 1) {
                sb.append(nombreHombres.get(posHombre));
                sb.append(',');
                sb.append(nombreHombres.get(posHombre + 1));
                sb.append(',');
            } else {
                sb.append(nombreMujeres.get(posMujer));
                sb.append(',');
                sb.append(nombreMujeres.get(posMujer + 1));
                sb.append(',');
            }
            sb.append(fecha);
            sb.append(',');
            sb.append(provincia);
            sb.append(',');
            if (aux == 1) {
                sb.append('M');
                sb.append(',');
            } else {
                sb.append('F');
                sb.append(',');
            }
            int pro = aleatorio.nextInt(5);

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
        File file = new File("C://tmp//registroCivil.txt");

        try {
            FileUtils.write(file, sb.toString());

        } catch (IOException iOException) {
        }

    }

    public static void clienteTemp() throws FileNotFoundException, IOException {
        //Generar el archivo de CLIENT_TEMP
        List<String> listaRC = new ArrayList<>();
        String genero = "";
        String estadoCivil = "";
        int reemplazoGenero = 0;
        int reemplazoECivil = 0;

        FileReader rC = new FileReader("C://tmp//registroCivil.txt");
        BufferedReader rC1 = new BufferedReader(rC);
        for (int i = 0; i <= 500; i++) { 
            listaRC.add(rC1.readLine());
        }

        StringBuffer clienteTemp = new StringBuffer();
        for (String crearCliente : listaRC) {
            //System.out.println(crearCliente);
            String[] parts = crearCliente.split(",");
            clienteTemp.append(parts[0]);
            clienteTemp.append(',');
            clienteTemp.append(parts[1]);
            clienteTemp.append(',');
            clienteTemp.append(parts[2]);
            clienteTemp.append(',');
            clienteTemp.append(parts[3]);
            clienteTemp.append(',');
            clienteTemp.append(parts[4]);
            clienteTemp.append(',');
            clienteTemp.append(parts[5]);
            clienteTemp.append(',');
            clienteTemp.append(parts[6]);
            clienteTemp.append(',');
            String cual = parts[7];
            if (cual.equals("F")) {
                reemplazoGenero = 1;
            } else {
                reemplazoGenero = 2;
            }
            clienteTemp.append(reemplazoGenero);
            clienteTemp.append(',');
            String cualquiera = parts[8];
            if (cualquiera.equals("SOL")) {
                reemplazoECivil = 1;
            } else if (cualquiera.equals("CAS")) {
                reemplazoECivil = 2;
            } else if (cualquiera.equals("DIV")) {
                reemplazoECivil = 3;
            } else if (cualquiera.equals("VIU")) {
                reemplazoECivil = 4;
            } else {
                reemplazoECivil = 5;
            }
            clienteTemp.append(reemplazoECivil);
            clienteTemp.append('\n');
        }

        File clienteTemporal = new File("C://tmp//clienteTemp.txt");

        try {
            FileUtils.write(clienteTemporal, clienteTemp.toString());

        } catch (IOException iOException) {
        }
    }

    public static void departamentoEEUU() throws FileNotFoundException, IOException {
        Scanner in, ni = null;
        GregorianCalendar gc = new GregorianCalendar();
        Random aleatorio = new Random();
        String cadena;
        String cadena2;
        String cadena3;
        List<String> nombreHombres = new ArrayList<>();
        List<String> nombreMujeres = new ArrayList<>();
        List<String> apellidos = new ArrayList<>();
        RandomStringGenerator codigoPais = new RandomStringGenerator.Builder()
                .withinRange('A', 'Z').build();
        FileReader nombreH = new FileReader("C://tmp//nombresH.txt");
        BufferedReader b1 = new BufferedReader(nombreH);
        FileReader nombreM = new FileReader("C://tmp//nombresM.txt");
        BufferedReader b2 = new BufferedReader(nombreM);
        FileReader apellido = new FileReader("C://tmp//apellidos.txt");
        BufferedReader b3 = new BufferedReader(apellido);
        for (int i = 0; i <= 500; i++) {
            nombreHombres.add(b1.readLine());
        }
        for (int i = 0; i <= 500; i++) {
            nombreMujeres.add(b2.readLine());

        }
        for (int i = 0; i <= 500; i++) {
            apellidos.add(b3.readLine());

        }
        StringBuffer sb = new StringBuffer();
        String codigo = "USA";
        for (int i = 0; i <= 500; i++) {

            //   String codigoPa = codigoPais.generate(6);
            int year = randBetween(1950, 2000);
            gc.set(gc.YEAR, year);
            int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
            gc.set(gc.DAY_OF_YEAR, dayOfYear);
            String fecha = gc.get(gc.DAY_OF_MONTH) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.YEAR);
            int pro = aleatorio.nextInt(500);
            sb.append(nombreHombres.get(pro));
            sb.append(',');
            sb.append(apellidos.get(pro));
            sb.append(',');
            sb.append(nombreHombres.get(pro) + " " + apellidos.get(pro));
            sb.append(',');
            sb.append(codigo);
            sb.append(',');
            sb.append(fecha);
            sb.append('\n');

        }

        File file = new File("C://tmp//departamentoEstadosunidos.txt");

        try {
            FileUtils.write(file, sb.toString());

        } catch (IOException iOException) {
        }
        long stop = System.currentTimeMillis();

    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static void consejoJudicatura() throws FileNotFoundException, IOException {
        Scanner in, ni = null;
        GregorianCalendar gc = new GregorianCalendar();
        Random aleatorio = new Random();
        String cadena;
        String cadena2;
        String cadena3;
        List<String> nombreHombres = new ArrayList<>();
        List<String> nombreMujeres = new ArrayList<>();
        List<String> apellidos = new ArrayList<>();
        RandomStringGenerator cedulaGenerator = new RandomStringGenerator.Builder()
                .withinRange('0', '9').build();
        FileReader nombreH = new FileReader("C://tmp//nombresH.txt");
        BufferedReader b1 = new BufferedReader(nombreH);
        FileReader nombreM = new FileReader("C://tmp//nombresM.txt");
        BufferedReader b2 = new BufferedReader(nombreM);
        FileReader apellido = new FileReader("C://tmp//apellidos.txt");
        BufferedReader b3 = new BufferedReader(apellido);
        RandomStringGenerator codigoPais = new RandomStringGenerator.Builder()
                .withinRange('A', 'Z').build();
        for (int i = 0; i <= 500; i++) {
            nombreHombres.add(b1.readLine());
        }
        for (int i = 0; i <= 500; i++) {
            nombreMujeres.add(b2.readLine());

        }
        for (int i = 0; i <= 500; i++) {
            apellidos.add(b3.readLine());

        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= 200; i++) {
            int year = randBetween(1950, 2000);
            gc.set(gc.YEAR, year);
            int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
            gc.set(gc.DAY_OF_YEAR, dayOfYear);
            String fecha = gc.get(gc.DAY_OF_MONTH) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.YEAR);
            sb.append(cedulaGenerator.generate(10));
            sb.append(',');
            int pro = aleatorio.nextInt(500);
            String nom = nombreHombres.get(pro) + " " + nombreHombres.get(pro + 1);
            sb.append(nom);
            sb.append(',');
            String apell = apellidos.get(pro) + " " + apellidos.get(pro + 1);
            sb.append(apell);

            sb.append(',');
            sb.append(fecha);
            sb.append('\n');

        }

        File file = new File("C://tmp//consejoJudicatura.txt");

        try {
            FileUtils.write(file, sb.toString());

        } catch (IOException iOException) {
        }
        long stop = System.currentTimeMillis();
        //     System.out.println("final time:" + (stop - start));

    }

    public static void clientesRestringidosConsejo() throws FileNotFoundException, IOException {
        List<String> bancoEEUU = new ArrayList<>();
        FileReader ArchivoBancoEEUU = new FileReader("C://tmp//consejoJudicatura.txt");
        BufferedReader banco = new BufferedReader(ArchivoBancoEEUU);

        for (int i = 0; i < 200; i++) { //hasta 200

            bancoEEUU.add(banco.readLine());

        }
        StringBuffer sb = new StringBuffer();
        String codigo = "ECU";
        for (String g : bancoEEUU) {
            String[] partes = g.split(",");
            sb.append(codigo);
            sb.append(',');
            sb.append(partes[0]);
            sb.append(',');
            sb.append(partes[1]);
            sb.append(',');
            sb.append(partes[2]);
            sb.append(',');
            sb.append(partes[1] + " " + partes[2]);
            sb.append(',');
            sb.append(partes[3]);
            sb.append('\n');

        }
        File file = new File("C://tmp//subirSistemaConsejoJudicatura.txt");

        try {
            FileUtils.write(file, sb.toString());

        } catch (IOException iOException) {
        }

    }

    public static void clientesRestringidosDepartamento() throws FileNotFoundException, IOException {
        List<String> bancoEEUU = new ArrayList<>();
        FileReader ArchivoBancoEEUU = new FileReader("C://tmp//departamentoEstadosunidos.txt");
        RandomStringGenerator cedulaGenerator = new RandomStringGenerator.Builder()
                .withinRange('0', '9').build();
        BufferedReader banco = new BufferedReader(ArchivoBancoEEUU);
        for (int i = 0; i <= 500; i++) {

            bancoEEUU.add(banco.readLine());

        }
        StringBuffer sb = new StringBuffer();
        // String codigo = "USA";
        for (String g : bancoEEUU) {
            String[] partes = g.split(",");
            //  sb.append(codigo);
            sb.append(partes[3]);
            sb.append(',');
            sb.append(cedulaGenerator.generate(10));
            sb.append(',');

            sb.append(partes[0]);
            sb.append(',');
            sb.append(partes[1]);
            sb.append(',');
            sb.append(partes[2]);
            sb.append(',');
            sb.append(partes[4]);
            sb.append('\n');

        }
        File file = new File("C://tmp//subirSistemaDepartamentoEEUU.txt");

        try {
            FileUtils.write(file, sb.toString());

        } catch (IOException iOException) {
        }
    }

    public static void posiblesRestringuidos() throws FileNotFoundException, IOException {
        List<String> registroCivil = new ArrayList<>();
        List<String> restrinccionEEUU = new ArrayList<>();
        List<String> restrinccionECU = new ArrayList<>();
        FileReader archivoRC = new FileReader("C://tmp//registroCivil.txt");
        FileReader archivoRestringuidoEEUU = new FileReader("C://tmp//subirSistemaDepartamentoEEUU.txt");
        FileReader archivoRestringuidoECU = new FileReader("C://tmp//subirSistemaConsejoJudicatura.txt");
        BufferedReader registroC = new BufferedReader(archivoRC);
        BufferedReader EEUU = new BufferedReader(archivoRestringuidoEEUU);
        BufferedReader ECU = new BufferedReader(archivoRestringuidoECU);
        String cedulaRC = "";
        String cedulaECU = "";
        String cedulaEEUU = "";
        String nombres = "";
        String apellidos = "";
        String nombresApellidos = "";
        String primerNombre = "";
        String segundoNombre = "";
        String primerApellido = "";
        String segundoApellido = "";
        String tipoCoincide = "";

        for (int i = 0; i < 1; i++) { //10000
            registroCivil.add(registroC.readLine()); //Archivo de Registro Civil
        }
        for (int i = 0; i < 1; i++) { //500
            restrinccionEEUU.add(EEUU.readLine()); //Archivo EEUU
        }
        for (int i = 0; i < 1; i++) { //200
            restrinccionECU.add(ECU.readLine()); //Archivo ECU
        }

        //Almacenar la cédula de registro Civil
        StringBuffer sb = new StringBuffer();
        for (String rC : registroCivil) {
            String[] partes = rC.split(",");
            cedulaRC = partes[0];
            primerApellido = partes[1];
            segundoApellido = partes[2];
            primerNombre = partes[3];
            segundoNombre = partes[4];
            for (String eC : restrinccionECU) {
                String[] partesEC = eC.split(",");
                cedulaECU = partesEC[0];
                nombres = partesEC[2];
                apellidos = partesEC[3];
                nombresApellidos = partesEC[4];
                //System.out.println(nombresApellidos);
                if (cedulaRC.equals(cedulaECU)) {
                    //System.out.println("Entra al if");
                    tipoCoincide = "Cedula";
                    sb.append(cedulaRC);
                    sb.append(',');
                    sb.append(tipoCoincide);
                } else if ((primerNombre + " " + segundoNombre + " " + primerApellido + " " + segundoApellido).equals(nombresApellidos)) {
                    tipoCoincide = "Nombres y Apellidos";
                    sb.append(cedulaRC);
                    sb.append(',');
                    sb.append(tipoCoincide);
                } else {
                    System.out.println("No coincide ninguno");
                }
                sb.append('\n');
            }
            for (String eU : restrinccionEEUU) {
                String primerNombreEU = "";
                String segundoNombreEU = "";
                String primerApellidoEU = "";
                String segundoApellidoEU = "";
                String[] partesEU = eU.split(",");
                cedulaEEUU = partesEU[1];
                primerNombreEU = partesEU[4];
                segundoNombreEU = partesEU[5];
                primerApellidoEU = partesEU[2];
                segundoApellidoEU = partesEU[3];
                System.out.println(primerNombre + " " + primerApellido);
                System.out.println("Nombres estados Unidos: "+primerNombreEU+" "+primerApellidoEU);
                if (cedulaRC.equals(cedulaEEUU)) {
                    System.out.println("Entra al if");
                    tipoCoincide = "Cedula";
                    sb.append(cedulaRC);
                    sb.append(',');
                    sb.append(tipoCoincide);
                } else if ((primerNombre + " " + primerApellido).equals(primerNombreEU+" "+primerApellidoEU)) {
                    //System.out.println("Entro al else");
                    tipoCoincide = "Primer Nombre y Primer Apellido";
                    sb.append(cedulaRC);
                    sb.append(',');
                    sb.append(tipoCoincide);
                } else if ((primerNombre + " " + segundoNombre + " " + primerApellido + " " + segundoApellido).equals(primerNombreEU+" "+segundoNombreEU+" "+primerApellidoEU+" "+segundoApellidoEU)) {
                    //System.out.println("Entro al else");
                    tipoCoincide = "Nombres y Apellidos";
                    sb.append(cedulaRC);
                    sb.append(',');
                    sb.append(tipoCoincide);
                } else {
                    System.out.println("No coincide ninguno");
                }
                sb.append('\n');
            }
        }
        System.out.println(primerNombre + " " + segundoNombre + " " + primerApellido + " " + segundoApellido);
        File file = new File("C://tmp//archivoCoincidencias.txt");

        try {
            FileUtils.write(file, sb.toString());

        } catch (IOException iOException) {
        }
    }
}
