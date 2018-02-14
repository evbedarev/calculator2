package calculator2;

import sun.invoke.util.VerifyAccess;

public class ValueStorage {
    private Double result;
    char operator;

   public Double getResult () {
       return result;
   }

   public void setResult (Double result) {
       this.result=result;
   }
}

class Plus implements Calculate{

    public Double calc (Double numOne, Double numTwo) {
        return numOne + numTwo;
    }

}

class Multi implements Calculate{
    public Double calc (Double numOne, Double numTwo) {
        return numOne * numTwo;
    }
}

class Dev implements Calculate{
    public Double calc (Double numOne, Double numTwo) {
        return numOne / numTwo;
    }
}

class Substr implements Calculate{
    public Double calc (Double numOne, Double numTwo) {
        return numOne / numTwo;
    }
}