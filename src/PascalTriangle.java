public class PascalTriangle {

    public static void main(String[] args) {
        constructPascalTriangle(10);
    }

    private static void constructPascalTriangle(int maxRow) {
        int row, value;

        for (int i = 0; i < maxRow; i++) { //rows
            row = i + 1;
            value = 1;
            for (int x = 0; x < maxRow - i; x++) {
                System.out.print(" "); //pre spaces
            }
            for (int c = 0; c <= i; c++) { //columns
                if (c > 0) {
                    value = value * (row - c) / c;
                }
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
