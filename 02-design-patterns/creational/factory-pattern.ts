// STEP 1: Base class (common behavior)
// All payment types will follow this

abstract class Payment {
  // shared logic (optional)
  protected log(message: string) {
    console.log(message);
  }

  // each payment must implement this
  abstract pay(amount: number): void;
}

// STEP 2: Concrete classes (real implementations)
// These are actual payment methods

class CreditCard extends Payment {
  pay(amount: number): void {
    this.log(`[CREDIT CARD]: Paid ${amount}`);
  }
}

class UPI extends Payment {
  pay(amount: number): void {
    this.log(`[UPI]: Paid ${amount}`);
  }
}

// STEP 3: Factory (main idea)
// This decides WHICH object to create
// So you don’t use "new" everywhere

class PaymentFactory {
  static create(type: string): Payment {
    switch (type) {
      case "card":
        return new CreditCard();
      case "upi":
        return new UPI();
      default:
        throw new Error("Invalid payment type");
    }
  }
}

// STEP 4: Usage

// You just ask factory → "give me payment"
// You don’t care which class is used inside

const payment1 = PaymentFactory.create("card");
payment1.pay(100);

const payment2 = PaymentFactory.create("upi");
payment2.pay(200);
