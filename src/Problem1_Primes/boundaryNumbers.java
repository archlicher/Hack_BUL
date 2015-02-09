package Problem1_Primes;

public class boundaryNumbers {

    private int startNumber;
    private int endNumber;

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        try {
            if(startNumber<1) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException ae){
            System.out.println("Bottom limit cannot be number smaller than 1");
            System.exit(0);
        }
        this.startNumber = startNumber;
    }

    public int getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(int endNumber) {
        try {
            if(endNumber<1) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException ae){
            System.out.println("top limit cannot be number smaller than 1");
            System.exit(0);
        }
        this.endNumber = endNumber;
    }

    public boolean areBoundariesCorrect(){
        int start = this.getStartNumber();
        int end= this.getEndNumber();
        try {
            if (start > end) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException ae) {
            System.out.println("Wrong range of numbers. Please set the bottom limit be smaller than the top limit.");
            return false;
        }
        return true;
    }
}
