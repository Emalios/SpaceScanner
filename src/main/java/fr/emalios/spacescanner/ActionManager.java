package fr.emalios.spacescanner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ActionManager
{

    private List<Consumer<List<Integer>>> actions;

    public ActionManager()
    {
        this.actions = new ArrayList<>();
    }

    public void addAction(Consumer<List<Integer>> action)
    {
        this.actions.add(action);
    }

    public void execute(List<Integer> integers)
    {
        actions.forEach(action -> action.accept(integers));
    }

}
