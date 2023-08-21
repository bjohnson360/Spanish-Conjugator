/*
Brian Johnson
August 2023
Spanish Verb Conjugator Present application
*/
public class Present extends logic {

    public Present(String[] AR, String[] IR, String[] ER) {
        super(AR, IR, ER);
        insert(); //calling the hasmap method
    }
    //conjugates the verb in the present tense (including irregulars)
    public void conjugate(String verb) {
        String[] endings = verbEnding(verb);
        

        //checks if verb is in the irregular hashmap
        if(irregulars.containsKey(verb)) {
            print("",irregulars.get(verb));
        } else if(checkIrregulars(verb, yoForm) >=0) { //checks for irregular yo form verbs
            
        //checks if the verb ends with "cer"
        } else if() {

        //checks if the verb ends with "uar"
        } else if() {
        
        //checks if the verb ends with "iar"
        } else if() {

        //checks if the verb ends with "uir"
        } else if() {

        } else {
            
        }

}

HashMap<String, String> yoForm = new HashMap<>(); //create hashmap for common yo change verbs
HasmMap<String,String[]> irregulars = new HashMap<>(); //create hashmap for common irregular verbs
public void insert() {
    yoForm.put("salir","salgo");
    yoForm.put("tener", "tengo");
    yoForm.put("hacer","hago");
    yoForm.put("poner","pongo");
    yoForm.put("caer", "caigo");
    yoForm.put("traer","traigo");
    yoForm.put("venir","vengo");
    yoForm.put("dar", "doy");
    yoForm.put("gir", "jo");
    yoForm.put("oir", "oigo");
    yoForm.put("valer", "valgo");
    yoForm.put("saber", "sé");
    yoForm.put("caber","caigo");

    irregulars.put("","");
}
    //print method for stem changing verbs
    public void print(String root, String stemChange, String[] end) {
        
    }

    //print method for irregular verbs and irregular yo verbs
    public void print2(String beginning, String verb, string withChange, String[] end) {

    }
}



