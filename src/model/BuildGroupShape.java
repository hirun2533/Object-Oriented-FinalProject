package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import model.interfaces.IShape;
import model.interfaces.IUndoRedo;
import model.interfaces.RunCommand;
import view.EllipseState;
import view.RectangleState;
import view.TriangleState;
import view.gui.ShapeSetting;


public class BuildGroupShape implements RunCommand,IUndoRedo {

	Point BeginPoint;
	Point StopPoint;
	ShapeSetting shapesetUp;
	int x; 
	int y; 
	int width; 
	int height;
	int BeginX;
	int BeginY;
	int StopX;
	int StopY;
	ArrayList<IShape> Select = new ArrayList<IShape>();


	public BuildGroupShape(ShapeSetting shapesetUp)
	{
		this.shapesetUp = shapesetUp;
		this.BeginX = shapesetUp.BeginPoint.getX();
		this.BeginY = shapesetUp.BeginPoint.getY();
		this.StopX = shapesetUp.StopPoint.getX();
		this.StopY = shapesetUp.StopPoint.getY(); 
		this.x = Math.min(BeginX, StopX);
		this.y = Math.min(BeginY, StopY); 
		this.width = Math.abs(StopX - BeginX);
		this.height = Math.abs(StopY - BeginY);

	}

	@Override
	public void run()
	{		

		for (IShape Selectshape : shapesetUp.shapeList.getListShape())

		{ 	

			x = Math.min(shapesetUp.BeginPoint.getX(), shapesetUp.StopPoint.getX());
			y = Math.min(shapesetUp.BeginPoint.getY() , shapesetUp.StopPoint.getY());
			width = Math.abs(shapesetUp.StopPoint.getX() - shapesetUp.BeginPoint.getX());
			height = Math.abs(shapesetUp.StopPoint.getY() - shapesetUp.BeginPoint.getY());


			int getX = Selectshape.getX();
			int getY = Selectshape.getY();
			int getHigh = Selectshape.Height();
			int getWidth = Selectshape.Width();



			if (x < getWidth  + 
					getX && 
					x + width > getX && 
					y < getHigh  + 
					getY && 
					y + height > getY)

			{

				shapesetUp.shapeList.ShapeSelectAdd(Selectshape);
				Select.add(Selectshape);	
			}

		}
		shapesetUp.shapeList.PaintNewShape();
		CommandHistory.add(this);

	}

	@Override
	public void undo() {
		for (int i = 0; i < Select.size(); i++) {
			IShape Selectshape = Select.get(i);
			shapesetUp.shapeList.ShapeSelectClear();
			shapesetUp.shapeList.PaintNewShape();
		} 		


	}

	@Override
	public void redo() {
		for (IShape Selectshape : Select)
		{
			shapesetUp.shapeList.ShapeSelectAdd(Selectshape);
			shapesetUp.shapeList.PaintNewShape();
		} 
	}

}
