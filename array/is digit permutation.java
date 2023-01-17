package kuznetsov;

// Дано два числа X и Y без ведущих нулей.
// Необходимо проверить, можно ли получить первое из второго перестановкой цифр?
public class IsDigitPermutation {

    public int[] countDigits(int x) {
        int[] cntArr = new int[10];

        while (x > 0) {
            int lastDigit = x % 10;
            int oldCurrDigitCnt = cntArr[lastDigit];
            cntArr[lastDigit] = oldCurrDigitCnt + 1;
            x = x / 10;
        }

        return cntArr;
    }

    public boolean isDigitPermutation(int x, int y) {
        int[] xCntArr = countDigits(x);
        int[] yCntArr = countDigits(y);

        for (int i = 0; i < xCntArr.length; i++) {
            if (xCntArr != yCntArr) {
                return false;
            }
        }

        return true;
    }
    
}
