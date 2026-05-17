// Payment Factory Implementation
abstract class Payment {
  protected log(message: string) {
    console.log(` ${message}`);
  }

  abstract pay(amount: number): void;
}

class CreditCard extends Payment {
  pay(amount: number): void {
    this.log(`[PAYMENT MADE VIA CREDIT CARD]: ${amount}`);
  }
}

class UPI extends Payment {
  pay(amount: number): void {
    this.log(`[PAYMENT MADE VIA UPI]: ${amount}`);
  }
}

// ✅ Factory added
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

const payment1 = PaymentFactory.create("card");
payment1.pay(100);

const payment2 = PaymentFactory.create("upi");
payment2.pay(200);