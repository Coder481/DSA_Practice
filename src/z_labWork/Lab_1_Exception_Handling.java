package z_labWork;

public class Lab_1_Exception_Handling {

    public static void main(String[] args) {

        program1();

        program2A();

        program2B();

        program2C();

        program2D();
    }

    private static void program1() {
        int a = 50;

        try{
            System.out.println(a / 0);
            System.out.println("Rest Of the code");
        }catch (ArithmeticException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void program2A() {
        int a = 50/0;
        try{
            System.out.println(50/10);
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }finally {
            System.out.println("Finally Block");
        }
    }

    private static void program2B() {
        System.out.println(100/10);

        try{
            System.out.println(50/10);
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }finally {
            System.out.println("Finally Block");
        }
    }

    private static void program2C() {
        try{
            System.out.println(50/0);
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }finally {
            System.out.println("Finally Block");
        }
    }

    private static void program2D() {
        System.out.println(50 / 0);
        try {
            System.out.println(50 / 10);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            System.out.println("Finally Block");
        }
    }

}
