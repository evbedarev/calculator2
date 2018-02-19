package calculator2.calculate;

import calculator2.ValueStorage;

public interface Calculate {
     Double calc (Double numOne, Double numTwo);
     Double calc (Double numOne, ValueStorage valueStorage);
}
