package fr.emalios.spacescanner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterManager
{

    private List<Predicate<List<Integer>>> filters;

    public FilterManager()
    {
        this.filters = new ArrayList<>();
    }

    public void addFilter(Predicate<List<Integer>> filter)
    {
        this.filters.add(filter);
    }

    public boolean passAllTest(List<Integer> integers)
    {
        for (Predicate<List<Integer>> filter : this.filters) {
            if (!filter.test(integers))
                return false;
        }
        return true;
    }

}
