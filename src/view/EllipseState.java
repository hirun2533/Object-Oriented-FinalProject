package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.Point;
import model.interfaces.IShape;
import view.gui.ShapeSetting;

public class EllipseState implements IShape  {


	IShape shape;
	int x;
	int y;
	int width;
	int height;
	int BeginX;
	int BeginY;
	int StopX;
	int StopY;
	Point BeginPoint;
	Point StopPoint;

	public EllipseState(IShape shape)

	{	

		this.shape = shape;
		this.BeginX = shape.BeginPoint().getX();
		this.BeginY = shape.BeginPoint().getY();
		this.StopX = shape.StopPoint().getX();
		this.StopY = shape.StopPoint().getY();	

		this.width = Math.abs(StopX - BeginX);
		this.height = Math.abs(StopY - BeginY);

		this.BeginPoint = shape.getShapeSetUp().getBegin();
		this.StopPoint = shape.getShapeSetUp().getStop();


	}



	public int getX()
	{
		return this.shape.getShapeSetUp().BeginPoint.getX();
	}


	public int getY()
	{
		return this.shape.getShapeSetUp().BeginPoint.getY();
	}


	public int Width()
	{
		return this.width;
	}


	public int Height()
	{
		return this.height;
	}


	public Point BeginPoint()
	{
		return BeginPoint;
	}


	public Point StopPoint()
	{
		return StopPoint;
	}


	public void setBeginPoint(int x, int y)
	{

		BeginPoint.setX(x);
		BeginPoint.setY(y);

	}


	public void setStopPoint(int x, int y)
	{

		StopPoint.setX(x);
		StopPoint.setY(y);


	}


	public ShapeSetting getShapeSetUp()
	{
		return getShapeSetUp();
	}


	public void selectLine() {


		x = Math.min(shape.getShapeSetUp().BeginPoint.getX(), shape.getShapeSetUp().StopPoint.getX());
		y = Math.min(shape.getShapeSetUp().BeginPoint.getY() , shape.getShapeSetUp().StopPoint.getY());
		width = Math.abs(shape.getShapeSetUp().StopPoint.getX() - shape.getShapeSetUp().BeginPoint.getX());
		height = Math.abs(shape.getShapeSetUp().StopPoint.getY() - shape.getShapeSetUp().BeginPoint.getY());

		height = shape.Height() + 10;
		width  = shape.Width() + 10;

		int shapeX = shape.getShapeSetUp().BeginPoint.getX() - 5;
		int shapeY =shape.getShapeSetUp().BeginPoint.getY() - 5;

		Graphics2D graphic = shape.getShapeSetUp().graphic;
		final float arraydash[] = {9.0f};
		final BasicStroke dashline;
		dashline = new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER, 10.0f, arraydash, 0);
		graphic.setStroke(dashline);
		graphic.setColor(Color.RED);
		graphic.drawOval(shapeX, shapeY, width, height);

	}

	public void PaintShape() {


	}
}
