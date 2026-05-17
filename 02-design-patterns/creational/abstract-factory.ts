// Abstract factory
interface Chair {
    chair(name: string): void;
}

interface Sofa {
  sofa(name: string): void;
}

interface Table {
  table(name: string): void;
}

class VictorianChair implements Chair {
    chair(name: string) {
        console.log(`this is Victorian ${name} chair`);
    }
}
class VictorianSofa implements Sofa {
  sofa(name: string) {
    console.log(`this is Victorian ${name} sofa`);
  }
}
class VictorianTable implements Table {
  table(name: string) {
    console.log(`this is Victorian ${name} table`);
  }
}

class ModernChair implements Chair {
    chair(name: string) {
        console.log(`this is Modern ${name} chair`);
    }
}
class ModernSofa implements Sofa {
  sofa(name: string) {
    console.log(`this is Modern ${name} sofa`);
  }
}
class ModernTable implements Table {
  table(name: string) {
    console.log(`this is Modern ${name} table`);
  }
}

abstract class FurnitureFactory {
    abstract addChair(): Chair;
    abstract addSofa(): Sofa;
    abstract addTable(): Table;
}

class VictorianFurnitureFactory extends FurnitureFactory {
    addChair(): Chair {
        return new VictorianChair();
    }
    addSofa(): Sofa {
        return new VictorianSofa();
    }
    addTable(): Table {
        return new VictorianTable();
    }
}

class ModernFurnitureFactory extends FurnitureFactory {
    addChair(): Chair {
        return new ModernChair();
    }
    addSofa(): Sofa {
        return new ModernSofa();
    }
    addTable(): Table {
        return new ModernTable();
    }
}

const factory = new VictorianFurnitureFactory();
const chair = factory.addChair();
chair.chair("Ashish");