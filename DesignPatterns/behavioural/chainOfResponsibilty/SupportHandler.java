package DesignPatterns.behavioural.chainOfResponsibilty;

public abstract class SupportHandler {
    private SupportHandler nextHandler;

    public SupportHandler setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public void handle(Request request) {
        if (canHandle(request)) {
            process(request);
            return;
        }

        if (nextHandler != null) {
            nextHandler.handle(request);
            return;
        }

        System.out.println("No handler found for " + request);
    }

    protected abstract boolean canHandle(Request request);

    protected abstract void process(Request request);
}
