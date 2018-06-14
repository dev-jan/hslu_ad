package ch.hslu.ad.mepprepare;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Implement a "getMax" of an integer list via ForkJoin
 */
public class ForkJoinExample {
    public static int getMax(List<Integer> values) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        GetMaxTask getMaxTask = new GetMaxTask(values);
        forkJoinPool.submit(getMaxTask);
        return getMaxTask.get();
    }

    private static class GetMaxTask extends RecursiveTask<Integer> {
        List<Integer> values;
        public GetMaxTask(List<Integer> values) {
            this.values = values;
        }

        @Override
        protected Integer compute() {
            if (values.size() <= 1) {
                if (values.size() == 0) {
                    return -1;
                }
                return values.get(0);
            } else {
                GetMaxTask maxTaskLower = new GetMaxTask(values.subList(0, values.size() / 2));
                maxTaskLower.fork();
                GetMaxTask maxTaskHigher = new GetMaxTask(values.subList(values.size() / 2, values.size()));
                maxTaskHigher.fork();

                return GetMaxTask.getMax(maxTaskLower.join(), maxTaskHigher.join());
            }
        }

        private static Integer getMax(Integer i1, Integer i2) {
            if (i1 > i2) {
                return i1;
            } else {
                return i2;
            }
        }

    }
}
