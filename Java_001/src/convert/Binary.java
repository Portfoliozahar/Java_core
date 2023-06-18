package convert;
public class Binary {
    public String ToBinary(int decimal) {
        StringBuilder binary = new StringBuilder();

        if (decimal == 0) {
            binary.append("0");
        }

        while (decimal > 0) {
            binary.insert(0, decimal % 2);
            decimal /= 2;
        }

        return binary.toString();
    }
}
