package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.Point;
import model.ShapeShadingType;
import model.interfaces.IShape;
import view.gui.ShapeSetting;

public class StrategyPaintEllipse implements IShape{

	ShapeSetting shapesetUp;
	int x;
	int y;
	int width;
	int height;
	Point BeginPoint;
	Point StopPoint;
	int minX;
	int minY;

	int widthX;
	int heightY;
	int BeginX;
	int BeginY;
	int StopX;
	int StopY;

	public StrategyPaintEllipse(ShapeSetting shapesetUp)
	{
		this.shapesetUp = shapesetUp;
		this.BeginX = shapesetUp.BeginPoint.getX();
		this.BeginY = shapesetUp.BeginPoint.getY();
		this.StopX = shapesetUp.StopPoint.getX();
		this.StopY = shapesetUp.StopPoint.getY();

		this.widthX = StopX - BeginX;
		this.heightY = StopY - BeginY;
		this.width = widthX;
		this.height = heightY;


		this.BeginPoint = shapesetUp.getBegin();
		this.StopPoint = shapesetUp.getStop();
	}

	@Override
	public void PaintShape()
	{
		BasicStroke bs = new BasicStroke(3);
		ShapeShadingType shadetype = shapesetUp.shadingType;
		Graphics2D graphic = shapesetUp.graphic;



		switch(shadetype) {

		case FILLED_IN:	

			graphic.setColor(shapesetUp.primaryColor.getColor());	
			graphic.fillOval(shapesetUp.BeginPoint.getX(), shapesetUp.BeginPoint.getY(), width, height);
			break;

		case OUTLINE:

			graphic.setColor(shapesetUp.primaryColor.getColor());
			graphic.setStroke(bs);
			graphic.drawOval(shapesetUp.BeginPoint.getX(), shapesetUp.BeginPoint.getY(), width, height);
			break;

		case OUTLINE_AND_FILLED_IN:	

			graphic.setColor(shapesetUp.primaryColor.getColor());
			graphic.fillOval(shapesetUp.BeginPoint.getX(), shapesetUp.BeginPoint.getY(), width, height);
			graphic.setStroke(bs);
			graphic.setColor(shapesetUp.secondColor.getColor());
			graphic.drawOval(shapesetUp.BeginPoint.getX(), shapesetUp.BeginPoint.getY(), width, height);

		default:
			break;
		}

	}

	public int CalX() {
		return this.CalX();
	}

	public int CalY() {
		return this.CalY();
	}

	@Override
	public int getX()
	{
		return this.shapesetUp.BeginPoint.getX();


	}

	@Override
	public int getY()
	{
		return this.shapesetUp.BeginPoint.getY();

	}

	@Override
	public int Width()
	{
		return this.width;


	}

	@Override
	public int Height()
	{
		return this.height;


	}

	@Override
	public Point BeginPoint()
	{
		return BeginPoint;
	}

	@Override
	public Point StopPoint()
	{
		return StopPoint;
	}

	@Override
	public void setBeginPoint(int x, int y)
	{

		BeginPoint.setX(x);
		BeginPoint.setY(y);

	}

	@Override
	public void setStopPoint(int x, int y)
	{

		StopPoint.setX(x);
		StopPoint.setY(y);

	}

	@Override
	public ShapeSetting getShapeSetUp()
	{
		return shapesetUp;
	}

	public void selectLine() {


	}



}
