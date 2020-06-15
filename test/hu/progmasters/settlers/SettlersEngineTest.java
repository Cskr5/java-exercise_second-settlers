/*
 * Copyright © Progmasters (QTC Kft.), 2016-2018.
 * All rights reserved. No part or the whole of this Teaching Material (TM) may be reproduced, copied, distributed, 
 * publicly performed, disseminated to the public, adapted or transmitted in any form or by any means, including 
 * photocopying, recording, or other electronic or mechanical methods, without the prior written permission of QTC Kft. 
 * This TM may only be used for the purposes of teaching exclusively by QTC Kft. and studying exclusively by QTC Kft.’s 
 * students and for no other purposes by any parties other than QTC Kft.
 * This TM shall be kept confidential and shall not be made public or made available or disclosed to any unauthorized person.
 * Any dispute or claim arising out of the breach of these provisions shall be governed by and construed in accordance with the laws of Hungary.
 */

package hu.progmasters.settlers;

import hu.progmasters.settlers.buildings.Archery;
import hu.progmasters.settlers.buildings.Barrack;
import hu.progmasters.settlers.buildings.Building;
import hu.progmasters.settlers.units.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SettlersEngineTest {

    @BeforeEach
    public void init() {

    }

    @Test
    public void test_archery_produceUnit() {

        Archery archery = new Archery();

        archery.turnOnProduction();

        archery.produceUnit();
        archery.produceUnit();
        archery.produceUnit();

        Assertions.assertEquals(3,archery.getArchers().size());
    }

    @Test
    public void test_barrack_turnsToProdcue() {

        Barrack barrack = new Barrack();

        barrack.turnOnProduction();

        barrack.produceUnit();
        barrack.produceUnit();
        barrack.produceUnit();
        barrack.produceUnit();
        barrack.produceUnit();

        Assertions.assertEquals(5,barrack.getSwordsmen().size());
    }

    @Test
    public void test_archery_produceResource() {


    }

    @Test
    public void test_barrack_produceResource() {


    }

}
