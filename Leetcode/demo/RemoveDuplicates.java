public class RemoveDuplicates {

    static void removeDuplicatesInOrder(String inp) {
        StringBuilder sb = new StringBuilder(inp);

        for (int i = 0; i < sb.length(); i++) {
            System.out.println("LENGTHHHHHH::::::: " + sb.length());
            // alphabet
            if (sb.charAt(i) >= 'a') {
                char currentChar = sb.charAt(i);
                System.out.println("CCCC :::" + currentChar);
                boolean isMatchFound = false;
                for (int j = 0; j < sb.length(); j++) {
                    if (currentChar == sb.charAt(j) && !isMatchFound) {
                        System.out.println(
                                "Found the match :: " + i + " " + j + " -- " + sb.charAt(i) + " :: " + sb.charAt(j));
                        isMatchFound = true;
                        continue;
                    }
                    if (currentChar == sb.charAt(j) && isMatchFound) {
                        sb.deleteCharAt(j);
                        if(i==j) i--;
                    }
                }
            } else {
                // number
                char currentChar = sb.charAt(i);
                System.out.println("NNN ::" + currentChar);
                boolean isMatchFound = false;
                for (int j = sb.length() - 1; j >= 0; j--) {
                    if (currentChar == sb.charAt(j) && !isMatchFound) {
                        isMatchFound = true;
                        continue;
                    }
                    if (currentChar == sb.charAt(j) && isMatchFound) {
                        sb.deleteCharAt(j);
                        if(i==j) i--;
                    }
                }
            }
            
            System.out.println(sb);
        }
        System.out.println("String: " + sb);
    }

    public static void main(String[] args) {
        String inp = "a1b2c34c3b2cb3a1d";
        // String inp = "ab13cc1a3";
        removeDuplicatesInOrder(inp);
    }
}
