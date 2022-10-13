public class SymbolTester{

    public static void main(String[] args){
        test();
    }


    public static void test(){
        SymbolBalance s = new SymbolBalance();
        s.setFile("//home//codio//workspace//TestFiles//Test7.java");
        System.out.println(s.checkFile());
    }

}
