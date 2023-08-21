/*
Brian Johnson
August 2023
Spanish Verb Conjugator Main application
*/
import java.util.*;
public class MainClass {
    static String original;

    //arrays of verb endings,,,,,,might add other tenses in the future such as the subjunctive, conditional, future, etc.
    static String[] ARpresent = {"o", "as", "a", "amos", "áis", "an"};
    static String[] ARpast = {"é","aste","ó","amos","asteis","aron"};
    static String[] ARimperfect = {"aba","abas","aba", "ábamos","abais","aban"};

    static String[] IRpresent = {"o", "es","e","imos","ís","en"};
    static String[] ERpresent = {"o","es","e","emos","éis","en"};

    static String[] ERIRimperfect = {"ía","ías","ía","íamos","íais","ían"};
    static String[] ERIRpast = {"í", "iste","ió","imos","isteis","ieron"};

    static boolean reflexive;
    static String[] pronouns = {"yo","tú","ud./él/ella","nosotros","vosotros","uds./ellos/ellas"};
    static String[] rpronouns = {"me ","te ", "se ", "nos ","os ","se "};
    static String[] isReflexive = {"","","","","",""};
        public static void main(String[] args) {
            String verb;
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your verb >>");
            verb = scan.nextLine();
            verb = verb.toLowerCase(); //converts string to all lowercase

            //checks if the verb is reflexive
            if(verb.substring(verb.length()-2).equals("se")) {
                reflexive = true;
                isReflexive = rpronouns;
                verb = logic.root(verb);
            } else {
                reflexive = false;
            }
            original = verb;
            if(logic.verbVowel(verb) == 'í') {
                verb=logic.root(verb) + "ir";
            }

            // System.out.println("Present Tense:");
            // Present Present = new Present(ARpresent, IRpresent,ERpresent);
            // Present.conjugate(verb);
            // System.out.println();

            // System.out.println("Preterite Tense:");
            // Past Past = new Past(ARpast, ERIRpast);
            // Past.conjugate(verb);
            // System.out.println("");

            System.out.println("Imperfect Tense:");
            Imperfect Imperfect = new Imperfect(ARimperfect, ERIRimperfect, ERIRimperfect);
            Imperfect.conjugate(verb);
            System.out.println();
        
    } 
}
