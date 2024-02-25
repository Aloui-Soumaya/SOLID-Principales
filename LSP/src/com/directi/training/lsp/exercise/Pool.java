package com.directi.training.lsp.exercise;

public class Pool
{
    public void run()
    {
        IDuck donaldDuck = new Duck();
        IDuck electricDuck = new ElectronicDuck();
        quack(donaldDuck, electricDuck);
        swim(donaldDuck, electricDuck);
    }

    private void quack(IDuck... ducks)
    {
        for (IDuck duck : ducks) {
            duck.quack();
        }
    }

    private void swim(IDuck... ducks)
    {
        for (IDuck duck : ducks) {
            if(duck instanceof ElectronicDuck)
                ((ElectronicDuck) duck).turnOn();
            duck.swim();
        }
    }

    public static void main(String[] args)
    {
        Pool pool = new Pool();
        pool.run();
    }
}
