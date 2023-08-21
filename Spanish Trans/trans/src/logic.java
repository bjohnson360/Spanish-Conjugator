/*
Brian Johnson
August 2023
Spanish Verb Conjugator logic application
*/

import java.util.HashMap;

public class logic {
    String[] endings, AR, ER, IR, ERIR;
    
    //constructor
    public logic(String[] endings) {
        this.endings = endings;
        insertAccent();
    }

    //another constructor for verb endings
    public logic(String[] AR, String[] ER, String[] IR) {
        this.AR = AR;
        this.ER = ER;
        this.IR = IR;
        insertAccent();
    }

    //array of common e -> ie stem-changing verbs
    static String[] eIe = {"acertar","encender","advertir","entender","cerrar","fregar","comenzar","hervir","confesar","mentir","consentir","negar","convertir","pensar","defender","perder","empezar","preferir","querer","sentir","venir","tener"};

    //array of common e -> i stem-chaning verbs
    static String[] eI = {"bendecir","impedir","colegir","maldecir","competir","medir","conseguir","pedir","corregir","perseguir","decir","reír","despedir","repetir","elegir","seguir","freír","servir","gemir","sonreír","vestir",""};

    //array of common o -> ue stem-chaning verbs
    static String[] oUe = {"almorzar","morir","aprobar","mostrar","colgar","mover","contar","probar","costar","recordar","devolver","resolver","volver","solver","rogar","dormir","sonar","econtrar","soñar","envolver","tostar","morder","volar","jugar",};

    //a hashmap of vowels with their accents
    HashMap<Character, String> accents = new HashMap<Character, String>();
    public void insertAccent() {
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
    
    //returns either an a, e, or i
    public static char verbVowel(String verb) {
        return verb.charAt(verb.length()-2);
    }

    //returns the verb ending of either ar, er, or ir
    public static String ending(String verb) {
        return verb.substring(verb.length()-2);

    }


    //print method
    public static void print(String root, String[] end) {
        for(int i = 0; i< 6; i++) {
            System.out.println(MainClass.isReflexive[i] + root + end[i]);
        }
    }

    //changes a letter to a new letter for the stem-changing verbs
    public static String newLetter(String verb, String newValue, int i) {
        return verb.substring(0,i) + newValue + verb.substring(i+1);
    }

    //return the endings of the verb
    public String[] verbEnding(String verb) {
        if(verbVowel(verb) == 'e') {
            return ER;
        } else if(verbVowel(verb) == 'i') {
            return IR;
        } else {
            return AR;
        }
    }
    
    //updates the verb to account for stem changes
    public String stemChangeVerbs(String verb) {
        if(checkIrregulars(verb, eI) >= 0) {
            for(int i = verb.length()-3; i>=0;i--) {
                if(verb.charAt(i)=='e') {
                    return newLetter(verb,"i",i);
                }
            }
        } else if(checkIrregulars(verb, oUe) >= 0) {
            for(int i = verb.length()-3; i >= 0; i--) {
                if(verb.charAt(i) == 'o' || (verb.charAt(i) == 'u' && verb.equals("jugar"))) {
                    return newLetter(verb,"ue",i);
                }
            }
        } 
        else if(checkIrregulars(verb, eIe) >= 0) {
            for(int i = verb.length()-3;i>=0;i--) {
                if(verb.charAtI(i)=='e') {
                    return newLetter(verb,"ie",i);
                }
            }
        } 
        return verb;
    }

    //checks if the verb are keys in the hashmap where irregulars belong
    public static int checkIrregulars(String verb, HashMap<String, String> map) {
        for(int i=0; i<verb.length();i++) {
            if(map.containsKey(verb.substring(i))) {
                return i;
            }
        }
        return -1;
    }

    
    //checks if the verb is in either the eI,eIe, or oUe arrays
    public static int checkIrregulars(String verb, String[] stemChangeList) {
        for(int i=0; i<verb.length();i++) {
            if(contains(verb.substring(i),stemChangeList)) {
                return i;
            }
        }
        return -1;
    }
    //checks if one of the eI,eIe, or oUe arrays contains a letter of the verb
    public static boolean contains(String verb, String[] stemChangeList) {
        for(int i=0; i<stemChangeList.length;i++) {
            if(stemChangeList[i].equals(verb)) {
                return true;
            }
        }
        return false;
    }

    //checks for verbs ending with -car,-zar,-gar
    public String zarGarCar(String verb) {
        String endZGC = verb.substring(verb.length()-3);
        String root;
        //test case
        if(verb.length() < 3) {
            return verb;
        }
        
        if(endZGC.equals("car")) {
            root = verb.substring(0,verb.length()-3) + "qu";
        } else if(endZGC.equals("zar")) {
            root = verb.substring(0,verb.length()-3) + "c";
        } else if(endZGC.equals("gar")) {
            root = verb.substring(0,verb.length()-3) + "gu";
        } else {
            root = root(verb);
        }
        return root + ending(verb);
    }

    //adds an accent to the first vowel of a verb
    public String accentReflexive(String root) {
        if(MainClass.isReflexive[0].equals("")) {
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
