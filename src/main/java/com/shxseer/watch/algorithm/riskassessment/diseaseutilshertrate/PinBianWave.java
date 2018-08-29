package com.shxseer.watch.algorithm.riskassessment.diseaseutilshertrate;

/**
 * @authorseerhuitao 率变脉应
 * @create2018/5/26
 */
public class PinBianWave implements FrequencyDisease{
    int code;
    public PinBianWave(int code){
        this.code=code;
    }
    @Override
    public boolean SlowDisease() {
        if(code<40){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean LateCardiac() {
        if(code<=50 &&code >41){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean SecondDisease() {
        if (code <= 60 && code >= 51) {
            return true;
        } else {
            return false;
        }

    }
    @Override
    public boolean numberDisease () {
        if (code <= 100 && code >= 91) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean MoreDisese () {
        if (code >= 101 && code < 120) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean jiDisease () {
        if (code > 120) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean Chaobo () {
        if (code == 120 || code == 60) {
            return true;
        } else {
            return false;
        }
    }

}
