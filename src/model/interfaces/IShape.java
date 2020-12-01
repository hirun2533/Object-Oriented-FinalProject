package model.interfaces;



import model.Point;
import model.ShapeType;
import view.gui.ShapeSetting;

public interface IShape {
	
	ShapeSetting getShapeSetUp();
	Point BeginPoint();
	Point StopPoint();
	int getX();
	int getY();
	int Width();
	int Height();
	void setBeginPoint(int x, int y);
	void setStopPoint(int x, int y);
	void PaintShape();
	void selectLine();
	
}
