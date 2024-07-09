public class BRGC {

    private String[] namesOriginal = {"Axel", "Boxo", "Crunchy", "Doofus", "Enzo"};
    private String[] namesExtended = {"Fitz", "Giggles", "Enzo", "Doofus", "Crunchy", "Boxo", "Axel"};
    private String[] names;
    
    public String[] binaryReflectedGrayCode(int n) {
        String[] list = new String[(int)Math.pow(2, n)];

        if(n == 1){
            list = new String[]{"0", "1"};
        } else {
            String[] list1 = binaryReflectedGrayCode(n-1);

            String[] list2 = new String[list1.length];
            int j = 0;
            for(int i = list1.length - 1; i >= 0; i--){
                list2[j] = list1[i];
                j++;
            }

            for(int i = 0; i < list1.length; i++){
                list1[i] = "0" + list1[i];
            }

            for(int i = 0; i < list2.length; i++){
                list2[i] = "1" + list2[i];
            }

            for(int i = 0; i < list1.length; i++) {
                list[i] = list1[i];
            }
            for(int i = 0; i < list2.length; i++){
                list[list1.length + i] = list2[i];
            }
        }
        return list;
    }

    public String klutzomaniacSequence(String old, String newStr) {
        String toPrint = "";
        for(int i = 0; i < old.length(); i++) {
            if(old.charAt(i) != newStr.charAt(i)){
                if (newStr.charAt(i) == '0') {
                    toPrint = names[i] + " leaves";
                } else {
                    toPrint = names[i] + " joins";
                }
            }
        }
        return toPrint;
    }

    public String klutzRidingSequence(String str) {
        String toPrint = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1'){
                toPrint += names[i] + " & ";
            }
        }

        if(toPrint.length() > 0){
            return toPrint.substring(0, toPrint.length() - 3);
        }
        return toPrint;
    }

    public void printBRGCandManiacStuff(int userNum) {
        int n = ((userNum == 1) ? 5 : 7);
        names = ((userNum == 1) ? namesOriginal : namesExtended);
        String list[] = binaryReflectedGrayCode(n);

        for (int i = 0; i < list.length; i++) {
            if(i == 0) {
                System.out.format("%-5s %-10s %-40s %-20s\n", i, list[i], "Spotlight", "EMPTY TRICYCLE");
            } else {
                System.out.format("%-5s %-10s %-40s %-20s\n", i, list[i], klutzRidingSequence(list[i]), klutzomaniacSequence(list[i - 1], list[i]));
            }
        }
    }
}