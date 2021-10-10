/**
 * @author neria doron 315351445
 * Block Method
 */
public class Counter {
    private int num;
    /**
     * @param number a number
     */
    void increase(int number) {
        this.num = this.num + number;
    }
    /**
     * @param number a number
     */
    void decrease(int number) {
        this.num = this.num - number;
    }
    /**
     * @return  number a number
     */
    int getValue() {
    return this.num;
    }
}