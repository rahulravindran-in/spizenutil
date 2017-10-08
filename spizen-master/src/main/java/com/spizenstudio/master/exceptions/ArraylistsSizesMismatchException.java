package com.spizenstudio.master.exceptions;

/**
 * Created by rahul on 08-10-2017.
 * From company : Spizen
 */

public class ArraylistsSizesMismatchException extends Exception{

    public <T> ArraylistsSizesMismatchException (T trace) {
        System.out.println(trace);
    }


}
