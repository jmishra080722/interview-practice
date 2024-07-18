package org.example.stream.june_25.try_with_resource;

public class AutoCloseableResourcesFirst implements AutoCloseable{

    public AutoCloseableResourcesFirst() {
        System.out.println("Constructor -&gt; AutoCloseableResources_First");
    }

    public void doSomething() {
        System.out.println("Something -&gt; AutoCloseableResources_First");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closed AutoCloseableResources_First");
    }
}
