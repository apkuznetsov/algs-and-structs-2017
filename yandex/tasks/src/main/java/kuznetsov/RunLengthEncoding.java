package kuznetsov;

public class RunLengthEncoding {
    public String runLengthEncoding(String str) {

        StringBuilder sb = new StringBuilder();

        char currSymb;
        char lastSymb = str.charAt(0);
        int lastStartIndex = 0;

        for (int i = 1; i < str.length(); i++) {
            currSymb = str.charAt(i);
            if (currSymb != lastSymb) {
                int lastLength = i - lastStartIndex;
                sb.append(lastSymb).append(lastLength);

                lastSymb = currSymb;
                lastStartIndex = i;
            }
        }

        return sb.toString();
    }
}
