/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pogoda;

import java.util.Random;

/**
 *
 * @author jvm
 */
public class Pogoda {
    
    static enum Month {
        Январь, Февраль, Март, Апрель, Май, Июнь, Июль, Август, Сентябрь, Ноябрь, Октябрь, Декабрь
    };
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random rnd = new Random();
        int n = 0;
        int min = 0;
        int max = 0;
        int[][] year = new int[12][];
        for (int i = 0; i < year.length; i++) {
            switch (i) {
                case 0: min = -15; max = 0; n = 31; break; // январь
                case 2: min = -5; max = 3; n = 31; break; // март
                case 4: min = -2; max = 15; n = 31; break; // май
                case 6: min = 3; max = 25; n = 31; break; // июль
                case 7: min = 10; max = 30; n = 31; break; // август
                case 9: min = -5; max = 5; n = 31; break; // октябрь
                case 11:min = -10; max = 10; n = 31; break; // ноябрь
                case 1: min = -20; max = -3; n = 28; break; // февраль
                case 3: min = -5; max = 10; n = 30; break; // апрель
                case 5: min = 10; max = 25; n = 30; break; // июнь
                case 8: min = 0; max = 15; n = 30; break; // сентябрь
                case 10:min = -5; max = 5; n = 30; break; // ноябрь
            }
            year[i]=new int[n];
            for (int j = 0; j < year[i].length; j++) {
                year[i][j]=rnd.nextInt(max - min + 1) + min;
                
            }
            
        }

        System.out.println("Список температур в 2017 году по дням:");
        System.out.print("     День: ");
        for (int i = 0; i < 31; i++) {
            System.out.printf("%4d",i+1);
        }
        System.out.println();
        System.out.print("           ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");

        
        for (int i = 0; i < year.length; i++) {
            for (int j = 0; j < year[i].length; j++) {
                if(j < 1){
                    System.out.printf("%9s: %4d",Month.values()[i],year[i][j]);
                }else{
                    System.out.printf("%4d",year[i][j]);
                }
            }
            System.out.println();
        }
    }
}
