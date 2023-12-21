package com.steve.demo.thread;

import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author: STEVE
 * @Description: TODO
 * @since: 2023/11/22
 */
public class UseCompletableFuture {

    /**
     * runAsync() 无返回值 supplyAsync() 有返回值
     */
    @Test
    public void test1() {
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> Objects.equals("A", "B"));
        CompletableFuture<Boolean> supplyAsync = CompletableFuture.supplyAsync(() -> Objects.equals("A", "B"));
    }

    /**
     * thenApply()、thenAccept()、thenRun按顺序执行异步任务
     */
    @Test
    public void test2() throws ExecutionException, InterruptedException {
        /* 如果一个异步任务的完成需要依赖前一个异步任务的完成,那么可以使用这三个方法,不需要先调用get()方法获取返回值后再执行. */
        /*thenApply - 能获得前一个任务的返回值，有返回值*/
        CompletableFuture<String> thenApply = CompletableFuture.supplyAsync(() -> "hello").thenApply(i -> i + "world!");
        String res = thenApply.get();
        System.out.println("res = " + res);

        /* thenAccept - 能获得前一个任务的返回值，没有返回值 */
        CompletableFuture<Void> thenAccept = CompletableFuture.supplyAsync(() -> "hello").thenAccept(System.out::println);
        System.out.println("thenAccept = " + thenAccept.get());

        /* thenRun - 不可获得前一个任务的返回值，没有返回值 */
        CompletableFuture<Void> thenRun = CompletableFuture.supplyAsync(() -> "hello").thenRun(() -> {
            System.out.println("thenRun");
        });
        System.out.println("thenRun = " + thenRun.get());
    }

    /**
     * thenCompose、thenCombine()
     */
    @Test
    public void test3() throws ExecutionException, InterruptedException {
        /* thenCompose():可以用于组合多个CompletableFuture,将前一个结果作为下一个计算的参数,他们之间存在先后顺序 */
        CompletableFuture<String> thenCompose = CompletableFuture.supplyAsync(() -> "hello").thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "world!"));
        System.out.println("thenCompose = " + thenCompose.get());

        /* thenCombine():两个任务是并行执行的,最后将结果汇总 */
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> "world");
        CompletableFuture<String> thenCombine = hello.thenCombine(world, (h, w) -> h + w);
        System.out.println("thenCombine = " + thenCombine.get());
    }

    /**
     * allOf、anyOf
     */
    @Test
    public void test4() throws ExecutionException, InterruptedException {
        /* allOf */
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> "world");
        CompletableFuture<String> statement = CompletableFuture.supplyAsync(() -> "I have two cats!");
        /* 等到所有的异步线程都执行完之后，再执行后面的。 */
        CompletableFuture.allOf(hello, world, statement);
        /* anyOf */
        CompletableFuture<String> hello1 = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> world1 = CompletableFuture.supplyAsync(() -> "world");
        CompletableFuture<String> statement1 = CompletableFuture.supplyAsync(() -> "I have two cats！");
        /* objectCompletableFuture:获取到多个线程中第一个执行结束的线程的结果 */
        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.anyOf(hello1, world1, statement1);
        System.out.println("voidCompletableFuture.get() = " + objectCompletableFuture.get());
    }

    /**
     * whenComplete、whenCompleteAsync
     */
    @Test
    public void test5() throws ExecutionException, InterruptedException {
        /* 当CompletableFuture完成计算结果后,我们可能需要对结果进行一些处理 */
        CompletableFuture.supplyAsync(() -> "hello")
                .thenApply(s -> s + "world!")
                .whenComplete((result, e) -> System.out.println(result));
        /**
         * helloworld!
         */
        /* whenComplete其实是有两个值的,一个是结果值,一个是异常信息 */
        CompletableFuture.supplyAsync(() -> {
            int i = 10 / 0;
            return "hello ";
        }).thenApply(s -> s + "world!")
                .whenComplete((result, e) -> {
                    System.out.println(result);
                    System.out.println(e);
                });
        /**
         * null
         * java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
         */
        CompletableFuture<String> exceptionallyCompletable = CompletableFuture.supplyAsync(() -> {
            int i = 10 / 0;
            return "hello ";
        }).exceptionally(e -> {
            System.out.println(e);
            return "你的小主已下线";
        });
        String exceptionally = exceptionallyCompletable.get();
        System.out.println("exceptionally = " + exceptionally);
        /**
         * java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
         * exceptionally = 你的小主已下线
         */
    }

}
