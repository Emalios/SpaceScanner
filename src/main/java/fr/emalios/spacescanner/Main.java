package fr.emalios.spacescanner;

public class Main
{

    public static void main(String[] args)
    {
        SpaceScanner spaceScanner = new SpaceScanner();
        spaceScanner.addIterations(new Iteration(1, 4));
        spaceScanner.addIterations(new Iteration(1, 4));
        spaceScanner.addIterations(new Iteration(1, 4));
        spaceScanner.addIterations(new Iteration(1, 4));
        spaceScanner.addAction(System.out::println);
        /*
        spaceScanner.addFilter(integers -> {
            int current = integers.get(0);
            for (Integer integer : integers) {
                if(integer == current)
                    continue;
                return false;
            }
            return true;
        });

         */
        spaceScanner.run();
    }

}
