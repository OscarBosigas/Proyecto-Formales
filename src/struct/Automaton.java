package struct;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Automaton {
    
    private Stade root;
    private List<Stade> listNodes;
    private List<Stade> listNodes2;
    private ArrayList<String> listCharacters;
    private ArrayList<Funcion> listFuncions;   
    private Stade initialStade;
    private ArrayList<Stade> listAceptablesStades;
    private String wordToValidate;
    
    public Automaton() {
    	listNodes = new ArrayList<>();
    	listNodes2 = new ArrayList<>();
		listCharacters = new ArrayList<>();
		listFuncions = new ArrayList<>();
		listAceptablesStades = new ArrayList<>();
		wordToValidate = "";
	}

    public Stade getRoot() {
        return root;
    }

    public void setRoot(Stade root) {
    	listNodes.add(root);
        this.root = root;
        
        System.out.println(root.getName());
    }
    
    public void transicion(Stade actual, Stade next, String character) {
        
    	if(!comprobateStade(next)) {
    		listNodes.add(next);
    		if (next.isAceptable()) {
				listAceptablesStades.add(next);
			}
    	}
    	if (!comprobateCharacter(character)) {
			listCharacters.add(character);
		}
        Transition transicion = new Transition(next, character);
        listFuncions.add(new Funcion(actual.getName(), next.getName(), character));
        actual.setTransition(transicion);
    }
    
    private boolean comprobateCharacter(String character) {
    	for (int i = 0; i < listCharacters.size(); i++) {
			if (listCharacters.get(i).equals(character)) {
				return true;
			}
		}
    	return false;
    }
    
    private boolean comprobateStade(Stade stade) {
    	for (int i = 0; i < listNodes.size(); i++) {
			if (listNodes.get(i).getName().equals(stade.getName())) {
				return true;
			}
		}
    	return false;
    }
    
    public boolean validateString(String word) throws Exception {
    	wordToValidate = word;    	
    	return validateString(word, root, 0);
    }
    
    private boolean validateString(String word, Stade initialStade,int index) throws Exception{
        Stade actual = initialStade;
        String aux = word;
        if (aux.equals("") && actual.isAceptable()) {
            return true;
        }else if (aux.equals("") && !actual.isAceptable()) {
            return false;
        }
        if (!aux.equals("")) {
           if (getLetter(aux).equals(actual.getTransition().get(index).getCharacter()) && index < actual.getTransition().size()) {
                actual = actual.getTransition().get(index).getNext();
                index = 0;
                aux = convert(aux);
                validateString(aux, actual,index);
                listNodes2.add(0, actual);
            }else{
                index++;
                validateString(aux, actual,index);
            } 
        }       
        return true;
    }
    
    public String convert(String text){
        String result = "";
        for (int i = 1; i < text.length(); i++) {
            result += text.charAt(i);
        }
        return result;
    }
    
    public void printList(){
    	 System.out.print("Q\t{ ");
         for (Stade stade : listNodes) {
             System.out.print(stade.getName() + " , ");
         }
         System.out.print("}\nL\t{ ");
         for (String character : listCharacters) {
             System.out.print(character + " , ");
         }
         System.out.print("}\n F\t{ ");
         for (Funcion f : listFuncions) {
             System.out.print(f.toString() + " , ");
         }
         System.out.print("}\nS0\t{ " + initialStade.getName() + " }\nSA\t{ ");
         for (Stade e : listAceptablesStades) {
             System.out.print(e.getName() + " , ");
         }
         System.out.println("}");
    	Stade node = null;
    	System.out.println("------------------------------");
    	System.out.println("Palabra a verificar = " + wordToValidate);
        for (int i = 0; i < listNodes2.size(); i++) {
            System.out.print(listNodes2.get(i).getName() + " --> ");
            node = listNodes2.get(i);
        }
        if (node.isAceptable()) {
        	System.out.println("La palabra fue Aceptada");
                JOptionPane.showMessageDialog(null, "La palabra fue Aceptada");
		} else {
            System.out.println("La palabra fue rechazada");
                    JOptionPane.showMessageDialog(null, "La palabra fue Rechazada");
		}
    }
    
    public void setInitialStade(Stade stade) {
    	initialStade = stade;
    	stade.setInitial(true);
        System.out.println("qwertyuio-----------------------------------------------"+ stade.getName());
        
    }

    public List<Stade> getListNodes() {
        return listNodes2;
    }
    
    public String getLetter(String text){
        return String.valueOf(text.charAt(0));
    }
    
}
