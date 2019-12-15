package com.speedment.runtime.typemapper.integer;

import com.speedment.runtime.typemapper.AbstractTypeMapperTest;

import java.util.HashMap;
import java.util.Map;

import static com.speedment.runtime.typemapper.TypeMapper.Category;
import static com.speedment.runtime.typemapper.TypeMapper.Ordering;

final class IntegerToByteMapperTest extends AbstractTypeMapperTest<Integer, Byte, IntegerToByteMapper> {

    IntegerToByteMapperTest() {
        super(
            Integer.class,
            Byte.class,
            Category.COMPARABLE,
            Ordering.RETAIN,
            IntegerToByteMapper::new);
    }

    @Override
    protected Map<Integer, Byte> testVector() {
        Map<Integer, Byte> map = new HashMap<>();
        map.put(100, Byte.valueOf("100"));
        map.put(-128, Byte.MIN_VALUE);
        map.put(0, Byte.valueOf("0"));
        map.put(127, Byte.MAX_VALUE);
        map.put(null, null);
        return map;
    }

}