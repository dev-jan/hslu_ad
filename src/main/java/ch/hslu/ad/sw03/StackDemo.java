package ch.hslu.ad.sw03;

/**
 * This is a simple using example of the @{@link ArrayStack}. Can be run as a standalone app in the IDE or console.
 */
public class StackDemo {
    /**
     * Private constructor to prevent instantiation
     */
    private StackDemo() {
        // class cannot be instantiated
    }

    public static void main(final String[] args) {
        Stack<String> stack = new ArrayStack<>(3);
        stack.push("toll");
        stack.push("sind");
        stack.push("datenstrukturen");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
