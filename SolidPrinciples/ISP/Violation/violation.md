Why is this bad?

The interface says:

void work();
void eat();
void sleep();

But a robot only needs:

void work();

The robot is being forced to implement:

eat()
sleep()

which makes no sense.

Client Code
Worker worker = new RobotWorker();

worker.eat();

Runtime:

UnsupportedOperationException
Why is this an ISP Violation?

The robot depends on methods it doesn't need.

The interface is too large.

This often leads to:

throw new UnsupportedOperationException();

which is a huge ISP smell.