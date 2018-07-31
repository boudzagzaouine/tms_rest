package com.bagile.tms.entities;

public class TmsDoorType {
    private long tmsDoorTypeId;
    private boolean tmsDoorTypeSide;
    private boolean tmsDoorTypeBack;

    public long getTmsDoorTypeId() {
        return tmsDoorTypeId;
    }

    public void setTmsDoorTypeId(long tmsDoorTypeId) {
        this.tmsDoorTypeId = tmsDoorTypeId;
    }

    public boolean isTmsDoorTypeSide() {
        return tmsDoorTypeSide;
    }

    public void setTmsDoorTypeSide(boolean tmsDoorTypeSide) {
        this.tmsDoorTypeSide = tmsDoorTypeSide;
    }

    public boolean isTmsDoorTypeBack() {
        return tmsDoorTypeBack;
    }

    public void setTmsDoorTypeBack(boolean tmsDoorTypeBack) {
        this.tmsDoorTypeBack = tmsDoorTypeBack;
    }
}
