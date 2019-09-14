package com.javarush.task.task32.task3205;

import java.io.Reader;
import java.lang.reflect.Proxy;

/*
Создание прокси-объекта
*/
public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);



        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {

         SomeInterfaceWithMethods someImp = new SomeInterfaceWithMethodsImpl();

//         SomeInterfaceWithMethodsImpl imp2 =
//                 (SomeInterfaceWithMethodsImpl) Proxy.newProxyInstance(new CustomInvocationHandler(someImp));

         //         ClassLoader classLoader = someImp.getClass().getClassLoader();
//         Class<?>[] interfaces = someImp.getClass().getInterfaces();
//         CustomInvocationHandler invocationHandler = new CustomInvocationHandler(someImp);
//
//         SomeInterfaceWithMethods someImp2 = (SomeInterfaceWithMethodsImpl) Proxy.newProxyIns
//
//        SomeInterfaceWithMethodsImpl impl =
//                (SomeInterfaceWithMethodsImpl)Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);


        return someImp;
    }

}