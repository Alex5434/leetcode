package demo;
public class RemoveDuplicates {

    static void removeDuplicatesInOrder(String inp) {
        String s = "";
        StringBuilder sb = new StringBuilder(inp);
        for (int i = 0; i < inp.length(); i++) {
            System.out.println();
            // alphabet
            if (inp.charAt(i) >= 'a') {
                char currentChar = inp.charAt(i);
                boolean isOk = true;
                int j;
                for (j = 0; j < inp.length(); j++) {
                    if (i == j) {
                        break;
                    }
                    if (currentChar == inp.charAt(j)) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    // System.out.println("the jj to delete" + j);
                    // sb.deleteCharAt(j);
                    s+= 
                } 
            } else { 
                // number
                char currentNum = inp.charAt(i);
                // System.out.println("NNN ::" + currentNum);
                boolean isOk = true;
                int j;
                for (j = inp.length() - 1; j >= 0; j--) {
                    if (i == j) {
                        break;
                    }
                    if (currentNum == inp.charAt(j)) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    System.out.println("the jj to delete NNN" + j);
                    sb.deleteCharAt(j);
                }
            }
        }
        System.out.println("String: " + sb);
    }

    public static void main(String[] args) {
        String inp = "a1b2c34c3b2cb3a1d";
        // String inp = "ab13cc1a3";
        removeDuplicatesInOrder(inp);
    }
}
