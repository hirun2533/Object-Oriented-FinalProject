package model;


import model.interfaces.IShape;
import view.StrategyPaintEllipse;
import view.StrategyPaintRectangle;
import view.StrategyPaintTriangle;
import view.gui.ShapeSetting;

 // from lecture 3 factory method example

public class ShapePaintFactory {

	public IShape PaintShape(ShapeSetting shapeSetup) {
	    ShapeType shapeType = shapeSetup.getShapeType();
	    IShape shape = null;
	 

	    switch(shapeType) {
	    case RECTANGLE:
	    	shape = new StrategyPaintRectangle(shapeSetup);
	    	break;
	    case ELLIPSE:
	    	shape = new StrategyPaintEllipse(shapeSetup);
	    	break;
	    case TRIANGLE:
	    	shape = new StrategyPaintTriangle(shapeSetup);
	    	break;
	    default:
			break;
		}	
	    
		return shape;
	 }
	


}

