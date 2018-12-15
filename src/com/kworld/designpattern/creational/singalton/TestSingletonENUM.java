package com.kworld.designpattern.creational.singalton;

import org.junit.Assert;
import org.junit.Test;

public class TestSingletonENUM {

	@Test
    public void testEnumSingalton(){
        SingletonENUM x = SingletonENUM.INSTANCE;
        Assert.assertTrue(x.getData() == SingletonENUM.INSTANCE.getData());
        SingletonENUM.INSTANCE.setData(5);
        Assert.assertTrue(x.getData() == SingletonENUM.INSTANCE.getData());
    }

    enum SingletonENUM{
        INSTANCE;

        private Integer data;

        public void setData(Integer data) {
            this.data = data;
        }

        public Integer getData() {
            return data;
        }
    }
}
