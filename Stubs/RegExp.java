public class RegExp
{
    public static void main(String [] args)
    {
        String test = "@!(EU@!()EU@!#EIOEJQE#)(FASK./'::'QWDQ";
        System.out.println(test);
        test = test.toLowerCase();
        test = test.replaceAll("[^A-Za-z0-9 ]", "");
        System.out.println(test);
    }
}
