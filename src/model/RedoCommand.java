package model;

import model.interfaces.RunCommand;

public class RedoCommand implements RunCommand {

	@Override
	public void run()
	{
		CommandHistory.redo();
		System.out.println("REDO");
	}

}
