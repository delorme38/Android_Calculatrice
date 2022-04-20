package com.delorme.democonstraintlayout;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Calculate {

    static String eval(String strng) {
        String[] oparator = {"+","-","*","/"};
        List<String> op1 = new ArrayList<>();
        String[] x = strng.split("");

        int sayac=0;
        for (String i : x) {
            sayac ++;
            for (String c : oparator) {
                if (i.equals(c)) {

                    try {
                        double j = Double.parseDouble(strng.substring(0, sayac - 1));
                        op1.add(strng.substring(0, sayac - 1));
                        op1.add(c);
                        strng = strng.substring(sayac);
                        sayac = 0;
                    }catch (Exception e)
                    {
                        continue;
                    }
                }

            }
        }
        op1.add(strng);

        ListIterator<String> it = op1.listIterator();
        List<List> newlist = new ArrayList<>() ;

        while (it.hasNext()) {

            List<String> p= new ArrayList<>();
            p.add(String.valueOf(it.nextIndex()));
            p.add(it.next());
            newlist.add(p);

        }

        int sayac2=0;
        String oparatorvalue = "*";
        calculate(sayac2,newlist,oparatorvalue);
        String oparatorvalue2 = "/";
        calculate(sayac2,newlist,oparatorvalue2);
        String oparatorvalue3 = "+";
        calculate(sayac2,newlist,oparatorvalue3);
        String oparatorvalue4 = "-";
        calculate(sayac2,newlist,oparatorvalue4);
        return newlist.get(0).get(1).toString();
    }



        // Cette methode calcul seulement des Integer
        private static void calculateX(int sayac2, List<List> newlist, String oparatorvalue) {
            while (sayac2<4){
                try{
                    for (List j : newlist) {
                        if (j.get(1) == oparatorvalue) {
                            Integer opindex = newlist.indexOf(j);
                            Object sayi1 = newlist.get(opindex - 1).get(1);
                            Object sayi2 = newlist.get(opindex + 1).get(1);
                            int sonuc=0;
                            if (oparatorvalue.equals("*")){

                                sonuc = Integer.parseInt(sayi1.toString()) * Integer.parseInt(sayi2.toString());
                            }
                            if (oparatorvalue.equals("/")){

                                sonuc = Integer.parseInt(sayi1.toString()) / Integer.parseInt(sayi2.toString());
                            }
                            if (oparatorvalue.equals("+")){

                                sonuc = Integer.parseInt(sayi1.toString()) + Integer.parseInt(sayi2.toString());
                            }
                            if (oparatorvalue.equals("-")){

                                sonuc = Integer.parseInt(sayi1.toString()) - Integer.parseInt(sayi2.toString());
                            }
                            newlist.remove(opindex - 1);
                            newlist.remove(opindex - 1);
                            newlist.remove(opindex - 1);
                            List<String> sonuclist = new ArrayList<>();
                            sonuclist.add(String.valueOf(opindex - 1));
                            sonuclist.add(String.valueOf(sonuc));
                            newlist.add(opindex - 1, sonuclist);
                        }}}
                catch (Exception e){
                    continue;
                }
                sayac2++;}
        }

        // Cette methode calcul aussi un Double
     private static void calculate(int sayac2, List<List> newlist, String oparatorvalue) {
        while (sayac2<4){
            try{
                for (List j : newlist) {
                    if (j.get(1) == oparatorvalue) {
                        Integer opindex = newlist.indexOf(j);
                        Object sayi1 = newlist.get(opindex - 1).get(1);
                        Object sayi2 = newlist.get(opindex + 1).get(1);
                        double sonuc=0;
                        if (oparatorvalue.equals("*")){

                            sonuc = Double.parseDouble(sayi1.toString()) * Double.parseDouble(sayi2.toString());
                        }
                        if (oparatorvalue.equals("/")){

                            sonuc = Double.parseDouble(sayi1.toString()) / Double.parseDouble(sayi2.toString());
                        }
                        if (oparatorvalue.equals("+")){

                            sonuc = Double.parseDouble(sayi1.toString()) + Double.parseDouble(sayi2.toString());
                        }
                        if (oparatorvalue.equals("-")){

                            sonuc = Double.parseDouble(sayi1.toString()) - Double.parseDouble(sayi2.toString());
                        }
                        newlist.remove(opindex - 1);
                        newlist.remove(opindex - 1);
                        newlist.remove(opindex - 1);
                        List<String> sonuclist = new ArrayList<>();
                        sonuclist.add(String.valueOf(opindex - 1));
                        sonuclist.add(String.valueOf(sonuc));
                        newlist.add(opindex - 1, sonuclist);
                    }}}
            catch (Exception e){
                continue;
            }
            sayac2++;}
    }

    }

