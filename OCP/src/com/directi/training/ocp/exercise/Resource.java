package com.directi.training.ocp.exercise;

public abstract class Resource {
    public abstract int findFree();
    public abstract void markBusy(int resourceId);
    public abstract void markFree(int resourceId);
}
