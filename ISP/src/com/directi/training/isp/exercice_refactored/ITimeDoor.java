package com.directi.training.isp.exercice_refactored;

public interface ITimeDoor extends Door
{
    void lock();

    void unlock();

    void open();

    void close();

    void timeOutCallback();
}
