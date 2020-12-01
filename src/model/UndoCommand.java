package model;

import model.interfaces.RunCommand;

public class UndoCommand implements RunCommand {

	@Override
	public void run()
	{
		CommandHistory.undo();
		System.out.println("UNDO");
	}

}
