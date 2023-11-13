package com.app.daeja.Activity.Domain;

public class History {
    private String startPointTxt;
    private String destinationPointTxt;

    public String getStartPointTxt() {
        return startPointTxt;
    }

    public void setStartPointTxt(String startPointTxt) {
        this.startPointTxt = startPointTxt;
    }

    public String getDestinationPointTxt() {
        return destinationPointTxt;
    }

    public void setDestinationPointTxt(String destinationPointTxt) {
        this.destinationPointTxt = destinationPointTxt;
    }

    public History(String startPointTxt, String destinationPointTxt) {
        this.startPointTxt = startPointTxt;
        this.destinationPointTxt = destinationPointTxt;
    }
}
