// STEP 1: Create a class where only ONE object should exist

class Logger {
  // This will store the single object
  private static instance: Logger;

  // STEP 2: Make constructor private
  // So no one can do: new Logger()
  private constructor() {}

  // STEP 3: Provide a single way to access the object
  // If object doesn't exist → create it
  // If already exists → return same one
  public static getInstance(): Logger {
    if (!Logger.instance) {
      Logger.instance = new Logger();
    }
    return Logger.instance;
  }

  // STEP 4: Normal method
  public log(message: string) {
    console.log(`[LOG]: ${message}`);
  }
}

// STEP 5: Usage

// You never use "new"
// Always use getInstance()

const logger1 = Logger.getInstance();
const logger2 = Logger.getInstance();

logger1.log("Hello");
logger2.log("World");

// Both are SAME object
console.log(logger1 === logger2); // true
