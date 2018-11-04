package com.fm.core

import spock.lang.Specification

/**
 * @author footmanff on 2018/11/4.
 */
class MapTest extends Specification{

    def "map test"() {
        expect:
        map.size() == size

        where:
        map                || size
        [1: 2, 2: 1, 3: 1] || 3
    }
    
}
