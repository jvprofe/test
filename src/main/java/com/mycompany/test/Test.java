/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.cli2.CommandLine;
//import org.apache.commons.cli2.CommandLineParser;
//import org.apache.commons.cli2.DefaultParser;
//import org.apache.commons.cli2.HelpFormatter;
import org.apache.commons.cli2.Option;
//import org.apache.commons.cli2.OptionBuilder;
//import org.apache.commons.cli2.OptionGroup;
//import org.apache.commons.cli2.Options;
//import org.apache.commons.cli2.ParseException;


/**
 *
 * @author jv
 */
public class Test {

    public static void main(String[] args) {
        
        
        ///////////////////////////////////// 1. FASE DE DEFINICIÓN
        
        // create Options object
        Options options = new Options();

        // add t option
        options.addOption("t", "time", true, "display current time");
        options.addOption("h", "help", false, "display help");
        //Option oZ = Option.builder("z").hasArgs().required().build();
        //options.addOption(oZ);
        OptionGroup group =  new OptionGroup();  
        group.addOption(new Option("err",     "Salida estándar de errores"));  
        group.addOption(new Option("console", "Salida estándar"));  
        options.addOptionGroup(group);          
        
        ///////////////////////////////////// 2. FASE DE PARSEO
        
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            
        ///////////////////////////////////// 3. FASE DE INTERROGACIÓN
            
            // Fecha actual
            LocalDateTime now = LocalDateTime.now();  
            // Formato sin hora
            DateTimeFormatter dtf = DateTimeFormatter.
                    ofPattern("dd/MM/yyyy");  
            
            // Si opción -h
            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("time", options);
            } else {
                // Si opción -t
                if (cmd.hasOption("t")) {
                    // Entonces formato CON hora
                    String targ = cmd.getOptionValue("t");
                    System.out.print("Hora de " + targ + ": ");
                    dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
    //                System.out.println("Con -t");
                } //else System.out.println("Sin -t");
                //else {
                    // print the date
                //}
                System.out.println(dtf.format(now));              
            }            
            
        } catch (ParseException ex) {
            //Logger.getLogger(Exccli.class.getName()).log(Level.SEVERE, null, ex);
            //System.err.print(ex);
            //ex.printStackTrace(System.err);
            System.err.println(ex.getLocalizedMessage());
            
        }
    }
}
