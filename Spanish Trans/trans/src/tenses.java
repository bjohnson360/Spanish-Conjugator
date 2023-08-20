/*
Brian Johnson
August 2023
Spanish Verb Conjugator Tenses application
*/

import java.util.HashMap;

public class tenses {
    String[] endings;
    String[] AR;
    String[] ER;
    String[] IR;
    String[] ERIR;

    //constructor
    public tenses(String[] endings) {
        this.endings = endings;
        addAccent();
    }

    //another constructor for verb endings
    public tenses(String[] AR, String[] ER, String[] IR) {
        this.AR = AR;
        this.ER = ER;
        this.IR = IR;
        addAccent();
    }

    //arrays of a few stem-changing verbs
    static String[] eToIe = {"pensar", "empezar", "comenzar", "preferir", "acertar", "tener", "venir", "cerrar", "mentir", "fregar", "hervir", "confesar", "defender", "negar", "sentir", "querer"};
    static String[] eToI = {"pedir", "decir", "seguir", "servir", "competir", "elegir", "cerregir", "vestir", "freír", "gemir", "repetir"};
    static String[] oToUe = {"dormir", "almorzar", "morir", "probar", "mover", "colgar", "mostrar", "contar", "costar", "recordar", "volver", "resolver", "solver", "jugar"};

    //a hashmap of vowels with their accents
    HashMap<Character, String> accents = new HashMap<Character, String>();
    public void addAccent() {
        accents.put('i',"í");
        accents.put('o',"ó");
        accents.put('a',"á");
        accents.put('e',"é");
        accents.put('u',"ú");
    }
    
    //returns the root of the verb
    public static String root(String verb) {
        return verb.substring(0, verb.length()-2);
    }
    
    //returns what type of verb it is (ar,er,ir)
    public static char end(String verb) {
        return verb.charAt(verb.length()-2);
    }

    public static String ending(String verb) {
        return verb.substring(verb.length()-2);
    }

    //print method
    public static void print(String root, String[] end) {
        for(int i = 0; i< 6; i++) {
            System.out.println(MainClass.toBeReflexive[i] + root + end[i]);
        }
    }

    //change a value at a specific location to a new value
    public static String changeValue(String verb, String newValue, int i) {
        return verb.substring(0,i) + newValue + verb.substring(i+1);
    }

    //return the endings of the verb
    public String[] verbEnding(String verb) {
        if(end(verb) == 'a') {
            return AR;
        } else if(end(verb) == 'e') {
            return ER;
        } else {
            return IR;
        }
    }

    //updates the verb to account for stem changes
    public String stemChange(String verb) {
        if(checkForIreg(verb, eToI) >= 0) {
            for(int i = verb.length()-3; i>=0;i--) {
                if(verb.charAt(i)=='e') {
                    return changeValue(verb,"i",i);
                }
            }
        } else if(checkForIreg(verb, eToIe) >= 0) {
            for(int i = verb.length()-3;i>=0;i--) {
                if(verb.charAtI(i)=='e') {
                    return changeValue(verb,"ie",i);
                }
            }
        } else if(checkForIreg(verb,oToUe) >= 0) {
            for(int i = verb.length()-3; i >= 0; i--) {
                if(verb.charAt(i) == 'o' || (verb.charAt(i) == 'u' && verb.equals("jugar"))) {
                    return changeValue(verb,"ue",i);
                }
            }
        }
        return verb;
    }

    //checks if the verb or any subsections of the verb are keys in a HashMap where the irregular sub-verb beings
    public static int checkForIreg(String verb, HashMap<String, String> map) {
        for(int i=0; i<verb.length();i++) {
            if(map.containsKey(verb.substring(i))) {
                return i;
            }
        }
        return -1;
    }

    //Checks if the verb or any subsections of the verb are in a String array where the irregular sub verb begins
    public static int checkForIreg(String verb, String[] list) {
        for(int i=0; i<verb.length();i++) {
            if(contains(verb.substring(i),list)) {
                return i;
            }
        }
        return -1;
    }
    //Checks if a String array contains a value
    public static boolean contains(String verb, String[] list) {
        for(int i=0; i<list.length;i++) {
            if(list[i].equals(verb)) {
                return true;
            }
        }
        return false;
    }

    //Checks if the verb ends with -car, -zar, or -gar
    public String carZarGar(String verb) {
        if(verb.length() < 3) {
            return verb;
        }
        String last3 = verb.substring(verb.length()-3);
        String root;
        if(last3.equals("car")) {
            root = verb.substring(0,verb.length()-3) + "qu";
        } else if(last3.equals("zar")) {
            root = verb.substring(0,verb.length()-3) + "c";
        } else if(last3.equals("gar")) {
            root = verb.substring(0,verb.length()-3) + "gu";
        } else {
            root = root(verb);
        }
        return root + ending(verb);
    }

    //Adds an accent to the first vowel
    public String endReflexive(String root) {
        if(MainClass.toBeReflexive[0].equals("")) {
            return root;
        }
        for(int i = 1; i<root.length();i++) {
            if("aeiou".contains(root.substring(root.length()-i, root.length()-i+1))) {
                return root.substring(0,root.length()-i)+accents.get(root.charAt(root.length()-i))+root.substring(root.length()-i+1, root.length());
            }
        }
        return root;
    }

}
