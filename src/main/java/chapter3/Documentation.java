package chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class Documentation {

    // Semaphore. Счетчик, который контролирует доступ к общему ресурсу.
    // Базовая реализация многопоточности, представленная во многих языках
    // CountDownLatch. Нужен для ожидания завершения пачки потоков.
    // CyclicBarrier. Синхронизация нескольких потоков в одной точке.
    // Phaser. Для выполнения нескольких многопочных задач, разделенных на фазы.
    // Exchanger. Представляет механизм обмена данными между несколькими потоками.
    // CompletableFuture. Механизм, когда один или несколько потоков ждут асинхронного выполнения задачи.

    // Методы CompletableFuture TODO прочитать javadoc. В книге не очень хорошо освещено
    // complete() - выполнить задачу
    // cancel() - отменить выполнение
    // completeAsync(Supplier<T> supplier) - выполнить функционально в отдельном потоке для Supplier'a
    // completeExceptionally(Throwable ex) - кинуть ошибку при ошибке выполнения

    // supplyAsync()
    // runAsync()
    // allOf()
    // thenAcceptAsync()
    // thenApplyAsync()
    // anyOf()
    // runAfterBothAsync(CompletionStage stage, Runnable r)
    // runAfterEitherAsync(CompletionStage stage, Runnable r)
    // thenAcceptBothAsync
    // thenCombineAsync
    // thenComposeAsync
    // thenRunAsync
    // get()
    // join()
    // getNow()


}
