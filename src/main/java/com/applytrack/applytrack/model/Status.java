package com.applytrack.applytrack.model;

public enum Status {
    APPLIED, INTERVIEW, OFFER, REJECTED;

    public boolean canTransitionTo(Status next){
        if (this == APPLIED) {
            return next == INTERVIEW || next == REJECTED;
        }
        else if(this == INTERVIEW){
            
            return next == OFFER || next == REJECTED;
        }
        else{
            return false;
        }
    }
}
