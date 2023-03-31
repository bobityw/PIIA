package Form;

import java.util.ArrayList;

public class Model {
	private ArrayList<FormGeo> listShape;
	
	public Model() {
		listShape = new ArrayList<FormGeo>();
	}

	public ArrayList<FormGeo> getListShape() {
		return listShape;
	}
	
	public FormGeo getFContaining(double x, double y) {
		FormGeo shape = null;
	    for(FormGeo f : getListShape()){
	        if(f.contained(x, y)) {
	            shape = f;
	        }
	    }
	    return shape;
	}
	
	public FormGeo forme(int i) {
		return listShape.get(i);
	}
	
	public int nbOfShape() {
		return listShape.size();
	}
	
	public void addForm(FormGeo formGeo) {
		listShape.add(formGeo);
	}

}
