/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pogoda;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jvm
 */
public class Pogoda {
    
    static enum Month {
        Январь, Февраль, Март, Апрель, Май, Июнь, Июль, Август, Сентябрь, Октябрь, Ноябрь, Декабрь
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер месяца: ");
        int month = scanner.nextInt();
        System.out.print("Введите число указанного месяца: ");
        int day = scanner.nextInt();
        System.out.println("--------------------------------");
        System.out.println("Вы выбрали");
        System.out.printf("Месяц: %s%nДень: %d%nТемпература в этот день: %d градусов Цельсия%n", Month.values()[month-1],day,year[month-1][day-1]);
        int maxT=0;
        int minT=0;
        String DateMax ="";
        int dayMax = 0;
        String DateMin = "";
        int dayMin = 0;
        for (int i = 0; i < year.length; i++) {
            for (int j = 0; j < year[i].length; j++) {
                if(maxT < year[i][j]){
                    maxT = year[i][j];
                }
                if(minT > year[i][j]){
                    minT = year[i][j];
                }
            }
        }
        for (int i = 0; i < year.length; i++) {
            for (int j = 0; j < year[i].length; j++) {
                if(maxT == year[i][j]){
                    DateMax += j+1+" "+Month.values()[i]+", ";
                }
                if(minT == year[i][j]){
                    DateMin += j+1+" "+Month.values()[i]+", ";
                }    
            }
        }
        System.out.println();
        System.out.println("Самая высокая температура в году: "+maxT+" градусов Цельсия.");
        System.out.printf("Дата: %s%n",DateMax);
        System.out.println();
        System.out.println("Самая низкая температура в году: "+minT+" градусов Цельсия.");
        System.out.printf("Дата: %s%n",DateMin);
        System.out.println();
        

        System.out.println("Средняя температура по месяцам:");
        System.out.println();
        System.out.printf("%8s       %20s%n","Месяц","Средняя темпрература");
        System.out.println("----------------------------------");
//        for (int i = 0; i < 31; i++) {
//            System.out.printf("%4d",i+1);
//        }
//        System.out.println();
//        System.out.print("           ");
//        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        
        double averageTemperatur = 0.0;
        for (int i = 0; i < year.length; i++) {
            for (int j = 0; j < year[i].length; j++) {
                averageTemperatur += year[i][j];
            }
            System.out.printf("%10s  -   %3.1f",Month.values()[i],averageTemperatur/year[i].length);
            System.out.println();
            averageTemperatur=0;
        }
        System.out.println();
    }
}
