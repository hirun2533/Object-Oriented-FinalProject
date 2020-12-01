package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.Point;
import model.ShapeShadingType;
import model.interfaces.IShape;
import view.gui.ShapeSetting;

public class StrategyPaintTriangle implements IShape {

	ShapeSetting shapesetUp;
	int x;
	int y;
	int width;
	int height;
	Point BeginPoint;
	Point StopPoint;
	int[] SetarrayX = new int[3];
	int[] SetarrayY = new int[3];
	int BeginX;
	int BeginY;
	int StopX;
	int StopY;



	public StrategyPaintTriangle(ShapeSetting shapesetUp)
	{		
		this.shapesetUp = shapesetUp;
		this.BeginPoint = shapesetUp.getBegin();
		this.StopPoint = shapesetUp.getStop();

		this.BeginX = shapesetUp.BeginPoint.getX();
		this.BeginY = shapesetUp.BeginPoint.getY();
		this.StopX = shapesetUp.StopPoint.getX();
		this.StopY = shapesetUp.StopPoint.getY();


		this.width = Math.abs(StopX - BeginX);
		this.height = Math.abs(StopY - BeginY);

		this.SetarrayX[0] = BeginX;
		this.SetarrayX[1] = StopX;
		this.SetarrayX[2] = BeginX;

		this.SetarrayY[0] = BeginY;
		this.SetarrayY[1] = StopY;
		this.SetarrayY[2] = StopY;


	}

	@Override
	public void PaintShape()
	{		 
		BasicStroke bs = new BasicStroke(3);
		ShapeShadingType shadetype = shapesetUp.shadingType;
		Graphics2D graphic = shapesetUp.graphic;

		SetarrayX[0] = shapesetUp.BeginPoint.getX();
		SetarrayX[1] = shapesetUp.StopPoint.getX();
		SetarrayX[2] = shapesetUp.BeginPoint.getX();

		SetarrayY[0] = shapesetUp.BeginPoint.getY();
		SetarrayY[1] = shapesetUp.StopPoint.getY();
		SetarrayY[2] = shapesetUp.StopPoint.getY();
		switch(shadetype) {


		case FILLED_IN:

			graphic.setColor(shapesetUp.primaryColor.getColor());
			graphic.fillPolygon(SetarrayX, SetarrayY, 3);

			break;
		case OUTLINE:

			graphic.setColor(shapesetUp.primaryColor.getColor());
			graphic.setStroke(bs);
			graphic.drawPolygon(SetarrayX, SetarrayY, 3);

			break;


		case OUTLINE_AND_FILLED_IN:
			graphic.setColor(shapesetUp.primaryColor.getColor());
			graphic.fillPolygon(SetarrayX, SetarrayY, 3);
			graphic.setStroke(bs);
			graphic.setColor(shapesetUp.secondColor.getColor());
			graphic.drawPolygon(SetarrayX, SetarrayY, 3);

			break;

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

		this.SetarrayX[0] = shapesetUp.BeginPoint.getX();
		this.SetarrayX[1] = shapesetUp.StopPoint.getX();
		this.SetarrayX[2] = shapesetUp.BeginPoint.getX();

		BeginPoint.setX(x);
		BeginPoint.setY(y);

	}

	@Override
	public void setStopPoint(int x, int y)
	{

		this.SetarrayY[0] = shapesetUp.BeginPoint.getY();
		this.SetarrayY[1] = shapesetUp.StopPoint.getY();
		this.SetarrayY[2] = shapesetUp.StopPoint.getY();
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
