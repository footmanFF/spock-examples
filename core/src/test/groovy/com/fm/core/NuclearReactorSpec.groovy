package com.fm.core

/**
 * 运行不了
 * 只是展示where的高级用途
 * 代码来自：https://samrayleung.github.io/blog/2017/04/11/spock-%E4%B8%80%E4%B8%AA%E4%BC%98%E9%9B%85%E7%9A%84groovy-java%E6%B5%8B%E8%AF%95%E6%A1%86%E6%9E%B6/#org4e786d2
 *
 * @author zhangli on 2017/10/20.
 */
class NuclearReactorSpec extends spock.lang.Specification {

    def "Complete test of all nuclear scenarios"() {

        given: "a nuclear reactor and sensor data"
        NuclearReactorMonitor nuclearReactorMonitor = new NuclearReactorMonitor()

        when: "we examine the sensor data"
        nuclearReactorMonitor.feedFireSensorData(fireSensors)
        nuclearReactorMonitor.feedRadiationSensorData(radiation)
        nuclearReactorMonitor.feedPressureInBar(pressure)
        NuclearReactorStatus status = nuclearReactorMonitor.getCurrentStatus()

        then: "we act according to safety requirements"
        status.alarmActive == alarm
        status.shutDownNeeded == shutDown
        status.evacuationMinutes == evacuation

        /**
         * 每一列都是上面用到的一些参数，简直方便!!!
         */
        where: "possible nuclear incidents are:"
        pressure | fireSensors | radiation             || alarm | shutDown | evacuation
        150      | 0           | []                    || false | false    | -1
        150      | 1           | []                    || true  | false    | -1
        150      | 3           | []                    || true  | true     | -1
        150      | 0           | [110.4f, 0.3f, 0.0f]  || true  | true     | 1
        150      | 0           | [45.3f, 10.3f, 47.7f] || false | false    | -1
        155      | 0           | [0.0f, 0.0f, 0.0f]    || true  | false    | -1
        170      | 0           | [0.0f, 0.0f, 0.0f]    || true  | true     | 3
        180      | 0           | [110.4f, 0.3f, 0.0f]  || true  | true     | 1
        500      | 0           | [110.4f, 300f, 0.0f]  || true  | true     | 1
        30       | 0           | [110.4f, 1000f, 0.0f] || true  | true     | 1
        155      | 4           | [0.0f, 0.0f, 0.0f]    || true  | true     | -1
        170      | 1           | [45.3f, 10.3f, 47.7f] || true  | true     | 3
    }

}