package calculator2;

import sun.invoke.util.VerifyAccess;

public class ValueStorage {
    private Double result;
    private boolean runAtFirstTime = false;
    char operator;

   public Double getResult () {
       return result;
   }

   public void setResult (Double result) {
       this.result=result;
   }

   public void setRunAtFirstTime(boolean runAtFirstTime) {
       this.runAtFirstTime = runAtFirstTime;
   }

    public boolean getRunAtFirstTime() {
        return runAtFirstTime;
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