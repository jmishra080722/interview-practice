package org.example.stream.june_25.try_with_resource;

public class AutoClosableOrderMain {

    public static void main(String[] args) {
        //Resources that were defined/acquired first will be closed last.
        try (AutoCloseableResourcesFirst af = new AutoCloseableResourcesFirst();
             AutoCloseableResourcesSecond as = new AutoCloseableResourcesSecond()) {

            af.doSomething();
            as.doSomething();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
