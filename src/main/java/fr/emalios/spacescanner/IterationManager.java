package fr.emalios.spacescanner;

import java.util.ArrayList;
import java.util.List;

public class IterationManager
{

    private final ActionManager actionManager;
    private final FilterManager filterManager;
    private final List<Iteration> iterations;

    public IterationManager(ActionManager actionManager, FilterManager filterManager) {
        this.actionManager = actionManager;
        this.filterManager = filterManager;
        this.iterations = new ArrayList<>();
    }

    public void addIteration(Iteration iteration)
    {
        this.iterations.add(iteration);
    }

    public void run()
    {
        if(allIterationIsEnded())
            return; //End of the game guys.
        loop(this.iterations.get(0), 0);
    }

    public void loop(Iteration iteration, int indexInArray)
    {
        if(indexInArray == this.iterations.size()-1)
            return; //return if it's the last Iteration
        loop(this.iterations.get(indexInArray+1), indexInArray+1);
        Iteration nextIteration = this.iterations.get(indexInArray+1);
        if(nextIteration.isEnded())
        {
            iteration.iterate();
            nextIteration.reset();
        }
        if(iteration.isEnded())
            return;
        if(this.filterManager.passAllTest(getAllCurrentInteger()))
            this.actionManager.execute(getAllCurrentInteger());
        nextIteration.iterate();
        loop(iteration, indexInArray);
    }

    private boolean allIterationIsEnded()
    {
        for (Iteration iteration : this.iterations) {
            if(!iteration.isEnded())
                return false;
        }
        return true;
    }

    private List<Integer> getAllCurrentInteger()
    {
        List<Integer> integers = new ArrayList<>();
        for (Iteration iteration : this.iterations) {
            integers.add(iteration.getCurrent());
        }
        return integers;
    }

}
