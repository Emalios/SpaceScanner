package fr.emalios.spacescanner;

public class Iteration
{

    private final int from;
    private final int to;
    private int current;
    private boolean isEnded;

    public Iteration(int from, int to)
    {
        this.isEnded = false;
        this.from = from;
        this.to = to;
        reset();
    }

    public void iterate()
    {
        if(this.current < this.to) {
            this.current++;
            return;
        }
        this.isEnded = true;
    }

    public int getCurrent() {
        return this.current;
    }

    public boolean isEnded() {
        return isEnded;
    }

    public void reset() {
        this.isEnded = false;
        this.current = this.from;
    }
}
