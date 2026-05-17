// Singleton Pattern
class Logger {
  // 1. Hold the single instance
  private static instance: Logger;

  // 2. Make constructor private (no one can do `new Logger()`)
  private constructor() {}

  // 3. Global access point
  public static getInstance(): Logger {
    if (!Logger.instance) {
      Logger.instance = new Logger();
    }
    return Logger.instance;
  }

  // 4. Some method
  public log(message: string) {
    console.log(`[LOG]: ${message}`);
  }
}

// usecase
const logger1 = Logger.getInstance();
const logger2 = Logger.getInstance();

logger1.log("Hello");
logger2.log("World");

// Proof it's same instance
console.log(logger1 === logger2); // true