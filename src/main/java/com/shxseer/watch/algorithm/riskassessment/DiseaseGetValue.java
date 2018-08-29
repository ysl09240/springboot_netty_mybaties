package com.shxseer.watch.algorithm.riskassessment;

import com.shxseer.watch.algorithm.riskassessment.diseaseinterface.DiseaseUtilsA;
import com.shxseer.watch.algorithm.riskassessment.diseaseinterface.DiseaseUtilsB;
import com.shxseer.watch.algorithm.riskassessment.diseaseinterface.DiseaseUtilsC;
import com.shxseer.watch.algorithm.riskassessment.diseaseutilshertrate.LocationWave;
import com.shxseer.watch.algorithm.riskassessment.diseaseutilshertrate.PinBianWave;
import com.shxseer.watch.algorithm.wavetools.WaveFormModel;

import java.util.ArrayList;
import java.util.List;

public class DiseaseGetValue {
    WaveFormModel wfmone;//本次脉搏波的特征值
    WaveFormModel wfmtwo;//这是上一次脉搏波的特征值

    public DiseaseGetValue(WaveFormModel wfmone, WaveFormModel wfmtwo) {
        this.wfmone = wfmone;
        this.wfmtwo = wfmtwo;
    }
    //返回去病症结果的结论
    public List<String> getDiseaseTimeChangge() {
        List<String> list = new ArrayList<String>();
        //病症产生1
        DiseaseUtilsA dua = new DiseaseUtilsA(wfmone,wfmtwo);
        if (dua.A1After()) {
            list.add("各种原因导致的心动过缓");
        } else if (dua.A1Bfore()) {
            list.add("各种原因导致的心动过速");
        } else if (dua.A1Drifting()) {
            list.add("心率不齐");
        } else if (dua.A1Length()) {
            list.add("动脉硬化、高血压等疾病");
        } else if (dua.A1Miss()) {
            list.add("各种贫血");
        } else if (dua.A1Shorten()) {
            list.add("多见于高热、贫血、低血压等疾病");
        } else if (dua.A2Length()) {
            list.add("肺淤血、肺气肿、矽肺、高血压、高血脂");
        } else if (dua.A2Shorten()) {
            list.add("胸内压降低、贫血");
        } else if (dua.A2Miss()) {
            list.add("贫血");
        } else if (dua.A3Drifting()) {
            list.add("心律不齐");
        } else if (dua.A3Length()) {
            list.add("高血糖、高血脂");
        } else if (dua.A3Shorten()) {
            list.add("各种原因导致的外周阻力减小");
        }
        //病症产生2
        DiseaseUtilsB dub = new DiseaseUtilsB(wfmone,wfmtwo);
        if (dub.B1Length()) {
            list.add("右心衰竭引起的肝淤血");
        } else if (dub.B1Shorten()) {
            list.add("贫血");
        } else if (dub.B2Length()) {
            list.add("胃肠淤带");
        } else if (dub.B2Shorten()) {
            list.add("胃肠粘膜猥琐");
        } else if (dub.B3Length()) {
            list.add("下肢静脉曲张");
        } else if (dub.B3Miss()) {
            list.add("下肢萎缩、下肢营养不良");
        } else if (dub.B3Shorten()) {
            list.add("髋关节病变");
        }
        //病症产生3
        DiseaseUtilsC duc = new DiseaseUtilsC(wfmone,wfmtwo);
        if (duc.C1After()) {
            list.add("血管外围阻力减小");
        } else if (duc.C1Before()) {
            list.add("血液粘滞度增大");
        } else if (duc.C1Length()) {
            list.add("动脉硬化、高血压、高血脂");
        } else if (duc.C1Shorten()) {
            list.add("休克、肺心病、房颤");
        } else if (duc.C2FastSpeed()) {
            list.add("重症肌无力、贫血");
        } else if (duc.C2Miss()) {
            list.add("甲状腺危象、阵发性心动过速");
        } else if (duc.C2Shorten()) {
            list.add("发热性疾病");
        } else if (duc.C2SlowSpeed()) {
            list.add("动脉硬化、高血压、高血脂");
        }
        //频变脉应
        PinBianWave pbw = new PinBianWave(wfmone.getHertrate());
        if (pbw.SlowDisease()) {
            list.add("三度房室传导阻滞");
        } else if (pbw.LateCardiac()) {
            list.add("窦性心动过缓或房室传导阻滞、颅内压增高、甲状腺机能低下、阻塞性黄疸、心肌留");
        } else if (pbw.SecondDisease()) {
            list.add("窦性心动过缓或房室传导阻滞、颅内压增高、甲状腺机能低下、阻塞性黄疸、心肌留");
        } else if (pbw.numberDisease()) {
            list.add("窦性心动过速、新功能不全、发热、感染、贫血、甲状腺机能亢进");
        } else if (pbw.MoreDisese()) {
            list.add("窦性心动过速、新功能不全、发热、感染、贫血、甲状腺机能亢进");
        } else if (pbw.jiDisease()) {
            list.add("心房牵颤、风湿性心脏瓣膜（如二尖瓣狭窄）、甲状腺危象、缩窄性心包炎等");
        } else if (pbw.Chaobo()) {
            list.add("阵发性室上性心动过速");
        }

        //位变脉应
        LocationWave lv=new LocationWave(wfmone,wfmtwo);
        if(lv.centerDisease()){
            list.add("身体素虚，久病初愈或慢性消耗性疾病");
        }else if(lv.lowDisease()){
            list.add("缺血性心脏病，主动脉瓣狭窄、甲状腺机能低下症等，亦可见于身体肥胖者");
        }else if(lv.SlowDisease()){
            list.add("各种休克、癫痫及心力衰竭等");
        }else if(lv.upDisease()){
            list.add("感冒及热症");
        }

        if(list.size() == 0){
            list.add("请保持");
        }

        return list;
    }
}
