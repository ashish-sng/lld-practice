// STEP 1: Define what objects we need
// These are just rules (no implementation)

interface Chair {
  sitOn(): void;
}

interface Sofa {
  lieOn(): void;
}

interface Table {
  use(): void;
}


// STEP 2: Create real objects (Victorian family)
// All these belong to SAME style → Victorian

class VictorianChair implements Chair {
  sitOn() {
    console.log("Sitting on Victorian Chair");
  }
}

class VictorianSofa implements Sofa {
  lieOn() {
    console.log("Lying on Victorian Sofa");
  }
}

class VictorianTable implements Table {
  use() {
    console.log("Using Victorian Table");
  }
}


// STEP 3: Create another family (Modern)
// Again, all belong to SAME style → Modern

class ModernChair implements Chair {
  sitOn() {
    console.log("Sitting on Modern Chair");
  }
}

class ModernSofa implements Sofa {
  lieOn() {
    console.log("Lying on Modern Sofa");
  }
}

class ModernTable implements Table {
  use() {
    console.log("Using Modern Table");
  }
}


// STEP 4: Create abstract factory (main idea)
// This says:
// "Any factory must give me ALL 3 things (chair, sofa, table)"

abstract class FurnitureFactory {
  abstract createChair(): Chair;
  abstract createSofa(): Sofa;
  abstract createTable(): Table;
}


// STEP 5: Concrete factory for Victorian
// It returns ONLY Victorian objects

class VictorianFurnitureFactory extends FurnitureFactory {
  createChair(): Chair {
    return new VictorianChair();
  }

  createSofa(): Sofa {
    return new VictorianSofa();
  }

  createTable(): Table {
    return new VictorianTable();
  }
}


// STEP 6: Concrete factory for Modern
// It returns ONLY Modern objects

class ModernFurnitureFactory extends FurnitureFactory {
  createChair(): Chair {
    return new ModernChair();
  }

  createSofa(): Sofa {
    return new ModernSofa();
  }

  createTable(): Table {
    return new ModernTable();
  }
}


// STEP 7: Usage (this is where magic happens)

function setupRoom(factory: FurnitureFactory) {
  // We don’t care if it's Victorian or Modern
  // Factory decides everything

  const chair = factory.createChair();
  const sofa = factory.createSofa();
  const table = factory.createTable();

  chair.sitOn();
  sofa.lieOn();
  table.use();
}


// Change just ONE line → whole theme changes

const factory = new VictorianFurnitureFactory();
// const factory = new ModernFurnitureFactory();

setupRoom(factory);