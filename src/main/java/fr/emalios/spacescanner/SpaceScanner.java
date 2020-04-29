package fr.emalios.spacescanner;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SpaceScanner
{

    private final ActionManager actionManager;
    private final FilterManager filterManager;
    private final IterationManager iterationManager;

    public SpaceScanner()
    {
        this.filterManager = new FilterManager();
        this.actionManager = new ActionManager();
        this.iterationManager = new IterationManager(actionManager, filterManager);
    }

    public void addIterations(Iteration iteration)
    {
        this.iterationManager.addIteration(iteration);
    }

    public void addAction(Consumer<List<Integer>> action)
    {
        this.actionManager.addAction(action);
    }

    public void addFilter(Predicate<List<Integer>> filter)
    {
        this.filterManager.addFilter(filter);
    }

    public void run()
    {
        this.iterationManager.run();
    }

}
