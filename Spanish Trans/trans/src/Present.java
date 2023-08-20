/*
Brian Johnson
August 2023
Spanish Verb Conjugator Present application
*/
public class Present extends tenses{

    public Present(String[] AR, String[] IR, String[] ER) {
        super(AR, IR, ER);
        putValues(); //calling the hasmap method
    }
    public void conjugate(String verb) {

}
//make method that handles stem changes
HashMap<String, String> yoForm = new HashMap<>(); //create hashmap for common yo change verbs
HasmMap<String,String[]> irregulars = new HashMap<>(); //create hashmap for common irregular verbs
public void putValues() {
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
    
    irregulars.put();
}

}



