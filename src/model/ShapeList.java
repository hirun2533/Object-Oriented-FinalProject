package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import model.interfaces.IShape;
import view.gui.ShapeSetting;
import view.EllipseState;
import view.RectangleState;
import view.TriangleState;

public class ShapeList {

	Graphics2D graphic;
	ArrayList<IShape> Select = new ArrayList<IShape>();
	ArrayList<IShape> List = new ArrayList<IShape>();
	ArrayList<IShape> Duplicate = new ArrayList<IShape>();
	ShapeSetting shapesetUp; 


	public void PaintNewShape()
	{
		graphic.setColor(Color.WHITE);
		graphic.fillRect(0, 0, 500000, 500000);


		for (IShape shape: List)
		{
			shape.PaintShape();
		}

		for (IShape shape: Select)


		{     		

			ShapeType shapeType = shape.getShapeSetUp().shapeType;

			RectangleState rs;
			EllipseState es;
			TriangleState ts;

			switch(shapeType) {
			case RECTANGLE:
				rs = new RectangleState(shape);
				rs.selectLine();
				break;
			case ELLIPSE:
				es = new EllipseState(shape);
				es.selectLine();
				break;
			case TRIANGLE:
				ts = new TriangleState(shape);
				ts.selectLine();
				break;
			default:
				break;

			}


		}

	}	



	public void DupClipBoard(IShape shape) {
		Duplicate.add(shape);

	}
	public ArrayList<IShape> getDupClipBoard() {

		return Duplicate;
	}
	public void removeDupClipBoard() {
		Duplicate.removeAll(Select);
	}

	public void clearDupClipBoard() {
		Duplicate.clear();
	}


	public ArrayList<IShape> getListShape() {
		return List;
	}
	public void ShapeAdd(IShape shape) {
		this.List.add(shape);
		this.graphic = shape.getShapeSetUp().graphic;

	}
	public void ShapeRemove(IShape shape) {
		this.List.remove(shape);
	}




	public ArrayList<IShape> getSelectShape() {
		return Select;
	}

	public void ShapeSelectAdd(IShape shape) {
		this.Select.add(shape);
	}
	public void ShapeSelectRemove(IShape shape) {
		this.Select.remove(shape);
	}

	public void ShapeSelectClear() {
		Select.clear();
	}







}
