package com.parneet.guraya.cookingtime;


public class UnitConverter {
    private static final String KILOGRAM = "Kilogram";
    private static final String GRAM = "Gram";
    private static final String MILLIGRAM = "Milligram";
    private static final String LITRE = "Litre";
    private static final String MILLILITRE = "Millilitre";


    private final double enteredValue;
    private double conversionResult;
    private final String fromUnit;
    private final String toUnit;

    public UnitConverter(String fromUnit, String toUnit, double enteredValue){
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
        this.enteredValue = enteredValue;
    }
    public double convertUnit(){

        switch(fromUnit){
            case KILOGRAM:
                conversionResult = fromKilogram(toUnit,enteredValue);
                break;

            case GRAM:
                conversionResult = fromGram(toUnit,enteredValue);
                break;

            case MILLIGRAM:
                conversionResult = fromMilligram(toUnit,enteredValue);
                break;

            case LITRE:
                conversionResult = fromLitre(toUnit,enteredValue);
                break;

            case  MILLILITRE:
                conversionResult = fromMillilitre(toUnit,enteredValue);

        }
        return conversionResult;
    }
    private double fromKilogram(String toUnit, double enteredValue){
        double result = enteredValue;
        switch (toUnit)
        {

            case KILOGRAM:
            case LITRE:
                return result;

            case GRAM:
            case MILLILITRE:
                result = result * 1000;
                break;

            case MILLIGRAM:
                result = result * 1000000;
                break;
        }
        return result;
    }

    private double fromGram(String toUnit, double enteredValue){
        double result = enteredValue;
        switch (toUnit)
        {

            case GRAM:
                return result;

            case KILOGRAM:
            case LITRE:
                result = result / 1000;
                break;

            case MILLIGRAM:
            case MILLILITRE:
                result = result / 1000000;
                break;

        }
        return result;
    }


    private double fromMilligram(String toUnit, double enteredValue){

        double result = enteredValue;
        switch (toUnit)
        {

            case MILLIGRAM:
                return result;

            case KILOGRAM:
                result = result * 1000000;
                break;

            case GRAM:
                result = result * 1000;
                break;

            case LITRE:
                result = result / 1000000;
                break;

            case MILLILITRE:
                result = result / 1000;
                break;

        }
        return result;
    }


        private double fromLitre(String toUnit, double enteredValue){

        double result = enteredValue;
        switch (toUnit)
        {

            case LITRE:
            case KILOGRAM:
                return result;

            case GRAM:
                result = result * 1000;
                break;

            case MILLIGRAM:
                result = result * 100000;

            case MILLILITRE:
                result = result * 1000;

        }
        return result;
    }


 private double fromMillilitre(String toUnit, double enteredValue){

        double result = enteredValue;
        switch (toUnit)
        {

            case MILLILITRE:
            case GRAM:
                return result;


            case MILLIGRAM:
            case LITRE:
                result = result * 1000;
                break;

            case KILOGRAM:
                result = result / 1000;
                break;
        }
        return result;
    }

}
