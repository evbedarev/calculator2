package calculator2;

import calculator2.calculate.Calculate;

public class ValueStorage {
    private Double result;
    private boolean runAtFirstTime = true;
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

