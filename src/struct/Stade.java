package struct;

import java.util.ArrayList;
import java.util.List;

public class Stade {
    
    private String name;
    private List<Transition> listTransition;
    private boolean isInitial;
    private boolean isAceptable;

    public Stade(String name) {
    	listTransition = new ArrayList<>();
    	this.name = name;
    	this.isAceptable = false;
    	this.isInitial = false;
    }
    public Stade(String name, boolean isFinal) {
        listTransition = new ArrayList<Transition>();
        this.name = name;
        this.isAceptable = isFinal;
        this.isInitial = false;
    }

    public Stade(){}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transition> getTransition() {
        return listTransition;
    }
    
    public void setTransition(Transition transition) {
        this.listTransition.add(transition);
    }

    public boolean isInitial() {
        return isInitial;
    }

    public void setInitial(boolean isInitial) {
        this.isInitial = isInitial;
    }

    public boolean isAceptable() {
        return isAceptable;
    }

    public void setAceptable(boolean isAceptable) {
        this.isAceptable = isAceptable;
    }

    @Override
    public String toString() {
    	if (isAceptable) {
    		return "Estado = \t  name:    \t" + name + "\t    tipo:  \t Aceptable";
		}
    	if (isInitial) {
    		return "Estado = \t  name:    \t" + name + "\t    tipo:  \t Inicial";
		}
    	return "Estado = \t  name:    \t" + name + "\t    tipo:  \t Transicion";
    }
}
