/*
Brian Johnson
August 2023
Spanish Verb Conjugator Imperfect application
*/
import java.util.*;
public class Imperfect extends logic{
    //constructor
    public Imperfect(String[] AR, String[] IR, String[] ER) {
        super(AR,ER,IR);
        insert();
    }

    //creating hashmap
    HashMap<String, String[]> irregulars = new HashMap<>();
    //method for irregular imperfect verbs
    public void insert() {
        irregulars.put("ir", new String[] {"iba", "ibas", "iba", "íbamos", "ibais", "iban"});
        irregulars.put("ver", new String[] {"veía","veías","veía", "veíamos", "veíais", "veían"});
        irregulars.put("ser", new String[] {"era", "eras", "era", "éramos", "erais", "eran"});
}
    //conjugates the verb in the imperfect tense
    public void conjugate(String verb) {
        String[] endings = verbEnding(verb);

        //checks if the verb is either ir, ver, or ser
        if(irregulars.containsKey(verb)) {
            print("",irregulars.get(verb)); //prints the irregular verb using the print method in tense
        } else {
            print(root(verb), endings); //prints the verb using the print method
        }


    }

}


