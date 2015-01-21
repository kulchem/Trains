package trenci;

/*
 Provides a general interface to process input commands. Each implementation
 should use the {@link Commuter} class to carry on their particular action

*/

public interface Command {
	//void execute(Commuter commuter);

	void execute(CommuterImpl commuter);
}
