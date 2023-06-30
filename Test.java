public class Test {
    public static void main(String[] args) {
        //Converting String to int
        // for primity data type
        //java String to int convertion
        String s = "100";
        int i = Integer.parseInt(s);

        System.out.println(s + 100);
        System.out.println(i + 100);

        System.out.println();
        //for object 
        //java String to Integer convertion
        Integer obj = Integer.valueOf(s);

        System.out.println(s + 100);
        System.out.println(obj + 100);
    }
}
