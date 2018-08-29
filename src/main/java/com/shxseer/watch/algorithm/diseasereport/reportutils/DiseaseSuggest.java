package com.shxseer.watch.algorithm.diseasereport.reportutils;

import com.shxseer.watch.common.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiseaseSuggest {
	/**
	 * 19种病症的分级和建议的工具类
	 * @author zhangliang
	 * @since 2017-07-10
	 */
	private static String result = null;//病症的分级
	private static String diseaseType = null;//病症分级的状态
	private static String dietSuggest = null;//饮食建议
	private static String sportSuggest = null;//运动建议
	private static String healthProtectionSuggest = null;//保健建议
	private static String otherSuggest = null;//其他建议
	
	/**
	 * 疲劳病症的分级和建议
	 */
	public static Map<String,Object> tiredSuggest(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> sports = new ArrayList<String>();//运动 
		List<String> diets = new ArrayList<String>();//饮食 
		List<String> healthProtections = new ArrayList<String>();//保健
		if(number==0){
			result = "精神饱满";
			diseaseType = "注意劳逸结合，精力更持久。";
			//饮食建议
			String d1 = "猕猴桃、橙子等具有抗疲劳、增强免疫力的作用";
			String d2 = "香蕉可向大脑提供酪氨酸，经常食用会使人注意力集中，精力充沛";
			String d3 = "鲜草莓汁具有生津开胃、消除疲劳的功效";
			String d4 = "建议每顿吃7-8分饱，同时忌食油腻";
			String d5 = "经常吃一些赤豆、黑豆，能补充铁质，减轻贫血导致的疲惫感";
			String d6 = "常服柏子仁粥具有养心安神的作用";
			String d7 = "南瓜中的维生素B6和铁能将体内的糖原转变成葡萄糖，可防止脑疲劳";
			String d8 = "进行长时间的体力劳动之前，应摄取脂肪较多的食物，可防止热量消耗而出现的疲劳";
			diets.add(d1);
			diets.add(d2);
			diets.add(d3);
			diets.add(d4);
			diets.add(d5);
			diets.add(d6);
			diets.add(d7);
			diets.add(d8);
			//运动建议
			String s1 = "每行车2小时，休息10分钟左右，活动一下关节，放松身体";
			String s2 = "起床后锻炼5分钟，不仅能加倍燃烧卡路里，还能使人精力充沛";
			String s3 = "在工作时，可每隔1小时起来走动一下，伸展四肢，放松大脑";
			String s4 = "工作要劳逸结合，适当的休息既能保持体力，又能提高工作效率";
			sports.add(s1);
			sports.add(s2);
			sports.add(s3);
			sports.add(s4);
		}else if(number>0&&number<=30){
			result = "精神较好";
			diseaseType = "注意劳逸结合，工作更有效。";
			//饮食建议
			String d1 = "每天饮用200-500ml酸奶或牛奶，可缓解疲乏、心情烦躁等症状";
			String d2 = "菜花、卷心菜可以提高脑细胞的活力，保持头脑清醒";
			String d3 = "蘑菇富含维生素D，经常食用可起到缓解疲倦的作用";
			String d4 = "柿子椒、芦笋等适量食用有助于缓解食欲不振，全身倦怠等症状。";
			String d5 = "芦笋中含有的天冬酰胺及其盐类，有助于缓解全身倦怠、食欲不振等症状";
			String d6 = "适量食用蜂蜜可促进人体组织的新陈代谢，增进食欲，恢复体力";
			String d7 = "金针菇含人体必需氨基酸成分较全，多吃金针菇可加速消除疲劳";
			String d8 = "桃子含有较多的钙，有利于消除体液偏酸所引起的疲劳";
			diets.add(d1);
			diets.add(d2);
			diets.add(d3);
			diets.add(d4);
			diets.add(d5);
			diets.add(d6);
			diets.add(d7);
			diets.add(d8);
			//运动建议
			String s1 = "快走是恢复身体活力的最佳方式，建议每天至少快走30分钟";
			String s2 = "跳舞可愉悦身心，健美减肥，增强心肺功能。建议每天30分钟";
			String s3 = "用薄荷油或薄荷棒涂抹太阳穴，可使人感到清凉，舒爽";
			String s4 = "从颈部下方到胸部可划出黄金三角胸腺，用手指轻敲可使人充满精神";
			sports.add(s1);
			sports.add(s2);
			sports.add(s3);
			sports.add(s4);
		}else if(number>30&&number<=60){
			result = "精神一般";
			diseaseType = "小憩一会，保持良好的精神状态。";
			//饮食建议
			String d1 = "米醋可在凉拌菜中使用，能起到恢复体力的作用";
			String d2 = "经常吃一些赤豆、黑豆能补充铁质，减轻贫血导致的疲惫感";
			String d3 = "蜜饯雪梨能滋阴润燥、缓解疲劳。建议每日早晚各一汤匙";
			String d4 = "花生、葡萄干等，能够提供能量，缓解疲劳";
			String d5 = "核桃可缓解神经衰弱、大脑神经紧张等症状";
			String d6 = "建议每周食用2-3次的牡蛎、鳕鱼，可缓解缺铁导致的疲惫";
			String d7 = "薏米红豆汤可以改善湿气重引起的四肢沉重、困倦等症状";
			String d8 = "山药有利于人体对食物的消化吸收，故能抗疲劳、抗衰老";
			String d9 = "五谷杂粮中含有的镁元素、B族维生素和维生素E，有助于消除疲劳";
			String d10 = "西兰花炒胡萝卜可提供丰富的维生素A、C、B族等，可缓解眼疲劳";
			String d11 = "樱桃具有滋养肝肾、抗疲劳等功效，可适量食用";
			diets.add(d1);
			diets.add(d2);
			diets.add(d3);
			diets.add(d4);
			diets.add(d5);
			diets.add(d6);
			diets.add(d7);
			diets.add(d8);
			diets.add(d9);
			diets.add(d10);
			diets.add(d11);
			//运动建议
			String s1 = "伸懒腰能促进人体肌肉收缩和舒张，使人精力充沛";
			String s2 = "人在踮脚时，可促进下肢血液的回流，减轻下肢酸胀感";
			String s3 = "打电话时可站起来舒展筋骨，深呼吸，会使人精力旺盛";
			String s4 = "放声大笑能释放让人感到幸福的激素，有助于缓解疲劳";
			String s5 = "进行斜体连续俯撑，可伸展肩背肌肉，消除疲劳";
			String s6 = "躺在床上，舒展身体，两只手用力抱紧双膝，重复此动作可缓解疲劳";
			String s7 = "选择一颗顺手的石头，反复沿着肩颈线慢慢滑动，能一扫疲惫";
			String s8 = "疲倦时，花10分钟做填字游戏，有助于激发能量";
			String s9 = "在脸上洒点冷水或用冷水洗脸，有助于快速提神醒脑";
			String s10 = "两手手指交叉互相磨擦至手心发热，能消除疲劳，振作精神";
			String s11 = "将左右手背、肘部贴紧抬于胸前，然后将手腕外翻，掌心向外朝身体两侧推，可缓解疲劳";
			sports.add(s1);
			sports.add(s2);
			sports.add(s3);
			sports.add(s4);
			sports.add(s5);
			sports.add(s6);
			sports.add(s7);
			sports.add(s8);
			sports.add(s9);
			sports.add(s10);
			sports.add(s11);
		}else if(number>60&&number<=80){
			result = "比较疲劳";
			diseaseType = "建议休息，改善疲劳。";
			//饮食建议
			String d1 = "柠檬可以补充维生素C，薄荷自然清凉，振作精神，可饮用薄荷青柠檬水";
			String d2 = "碱性食物如葡萄、海带等，能有效消除疲劳";
			String d3 = "常吃芝麻可清除血管垃圾，舒缓疲劳";
			String d4 = "B族维生素是缓解压力、消除疲劳必不可少的营养素，如动物肝脏、玉米等可常吃";
			String d5 = "在热牛奶中放一块薄荷糖，能使人精神振奋";
			String d6 = "花生荸荠奶露具有清肺化痰、消除疲劳的功效";
			String d7 = "摄取适量的牛奶糖、麦芽糖可缓解脑力劳动和精神极度紧张所造成的疲劳";
			String d8 = "菠菜粥具有养血止血、消除疲劳的功效，适用于慢性疲劳综合征";
			String d9 = "经常食用猴头菇可增加免疫力和消除疲劳";
			diets.add(d1);
			diets.add(d2);
			diets.add(d3);
			diets.add(d4);
			diets.add(d5);
			diets.add(d6);
			diets.add(d7);
			diets.add(d8);
			diets.add(d9);
			//运动建议
			String s1 = "在脑力劳动过程中，穿插一定时间的体力活动，可使大脑放松，消除疲劳";
			String s2 = "双目来回转动数次，然后紧闭片刻，再迅速睁开眼睛，可缓解疲劳";
			String s3 = "做弯腰动作，进行深呼吸，使大脑尽快得到氧气和血液补充，消除疲惫感";
			String s4 = "双手十指交叉放于颈项处，以两手手掌拿捏颈项肌肉，有舒筋活血和解除颈肩疲劳的作用";
			sports.add(s1);
			sports.add(s2);
			sports.add(s3);
			sports.add(s4);
			//保健建议
			String hp1 = "洗脚后，搓足底涌泉穴20分钟，有提高机体免疫力，缓解疲劳的功效";
			String hp2 = "红枣枸杞茶：枸杞中具有补肝、益肾、缓解眼疲劳的作用";
			String hp3 = "竹叶青茶：能兴奋中枢神经系统，使人精神振奋";
			String hp4 = "洋参茶：西洋参具有增强免疫力，缓解疲劳的作用";
			String hp5 = "蜂蜜菊花茶：具有提神醒脑、消除疲劳的功效";
			String hp6 = "玫瑰茄茶：具有消除疲倦、调节血压的作用";
			String hp7 = "肌肉酸痛时，可用一块青柠在酸痛部位轻擦，有舒缓肌肉的功效";
			String hp8 = "菊花茶对改善眼睛疲劳、视力模糊有很好的疗效，可适当饮用";
			String hp9 = "柠檬香茅、迷迭香精油等，能净化空气，刺激大脑";
			String hp10 = "利用中午的时间小睡（最好不要超过1小时）一下，会让你下午精力充沛";
			String hp11 = "将葡萄柚的果皮放置房间内，有较强的提神作用";
			healthProtections.add(hp1);
			healthProtections.add(hp2);
			healthProtections.add(hp3);
			healthProtections.add(hp4);
			healthProtections.add(hp5);
			healthProtections.add(hp6);
			healthProtections.add(hp7);
			healthProtections.add(hp8);
			healthProtections.add(hp9);
			healthProtections.add(hp10);
			healthProtections.add(hp11);
		}else if(number>80&&number<=100){
			result = "非常疲惫";
			diseaseType = "立即休息，缓解疲劳。";
			//饮食建议
			String d1 = "陈皮中具有抗氧化、抗疲劳的功效，可常泡水饮用";
			String d2 = "适当吃点蓝莓，能有效增强大脑机能，缓解疲劳";
			String d3 = "酸奶香蕉汁具有润肠通便、消除疲劳的功效，适用于严重疲劳者";
			String d4 = "嚼一些腰果、核桃等干果对恢复体能有奇效";
			String d5 = "常食南瓜子能够放松肌肉，消除疲惫感";
			String d6 = "青柠泡水饮用，可消除疲劳，增强免疫力";
			String d7 = "生姜的辣味能使身体从内部生热，具有解毒、提神的作用";
			String d8 = "感到筋疲力尽时，可在口中嚼上一些花生、杏仁等干果，对恢复体能有奇效";
			diets.add(d1);
			diets.add(d2);
			diets.add(d3);
			diets.add(d4);
			diets.add(d5);
			diets.add(d6);
			diets.add(d7);
			diets.add(d8);
			//保健建议
			String hp1 = "用两手的拇指指腹揉按太阳穴3分钟左右，可快速消除疲劳";
			String hp2 = "绿茶中的抗氧化剂，不仅可预防心脑血管疾病和癌症，还能使人神清气爽";
			String hp3 = "在温水中加入2～3汤匙海盐和3～4滴精油泡脚，可加速末梢血液循环，消除疲劳";
			String hp4 = "神门穴在腕横纹尺端，尺侧腕屈肌腱的桡侧凹陷处。用拇指端按揉2分钟，可消除脑力疲劳";
			String hp5 = "风池穴位于后颈部，轻轻叩压风池穴能起到明目醒脑的功效";
			String hp6 = "合谷穴：右手拇指第一横纹放于左手虎口正中,按摩此穴对于神经性头痛、神经衰弱等有一定的改善作用";
			String hp7 = "足三里穴位于小腿外膝眼下3寸，距胫骨前嵴一横指。用指腹按压穴位1-3分钟可消除腿部、足部疲劳";
			String hp8 = "印堂穴位于两眉头连线中点位置。经常按摩可锻炼大脑的反映速度，改善视力的作用";
			String hp9 = "百会穴位于头顶正中线与两耳尖连线的交点处。揉按3分钟左右，可快速消除疲劳";
			String hp10 = "每天沐浴后搓脚心20-30分钟，能健身壮骨，养心安神，有利于消除疲劳";
			String hp11 = "拇指指腹按于两侧太阳穴，以屈曲的食指外侧面由内到外进行刮法，有镇静明目和消除精神疲劳的作用";
			String hp12 = "以双手手指的指腹与掌心着力，形如双手洗脸，旋转抚摩至面部微热，可通经活络，消除疲劳";
			String hp13 = "疲劳时用手指尖轻拍（敲）头部，可提神醒脑";
			String hp14 = "拳头握紧，放在耳斜后方靠颈部中央的头骨位置，头往后仰，用拳头支撑头部，可缓解疲劳";
			String hp15 = "感觉疲劳的时候，做深呼吸有助于缓解压力";
			String hp16 = "迷迭香、薄荷等香料能够提神醒脑，增强记忆力";
			String hp17 = "把双臂从肘部以下交替放入冷水中，拿出甩干，可使人精神抖擞";
			String hp18 = "嗅清凉油、花露水，可缓解疲劳";
			String hp19 = "柑橘的气味可让人头脑清醒，食用后的果皮可放置房间内，有较强的提神作用";
			String hp20 = "困倦时揉捏中指，能起到提神醒脑的功效";
			String hp21 = "柠檬气味可让人头脑清醒，有较强的提神作用";
			healthProtections.add(hp1);
			healthProtections.add(hp2);
			healthProtections.add(hp3);
			healthProtections.add(hp4);
			healthProtections.add(hp5);
			healthProtections.add(hp6);
			healthProtections.add(hp7);
			healthProtections.add(hp8);
			healthProtections.add(hp9);
			healthProtections.add(hp10);
			healthProtections.add(hp11);
			healthProtections.add(hp12);
			healthProtections.add(hp13);
			healthProtections.add(hp14);
			healthProtections.add(hp15);
			healthProtections.add(hp16);
			healthProtections.add(hp17);
			healthProtections.add(hp18);
			healthProtections.add(hp19);
			healthProtections.add(hp20);
			healthProtections.add(hp21);
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(sports.isEmpty()==false){
			int sr = (int)(Math.random()*sports.size());
			sportSuggest = sports.get(sr);
		}
		if(healthProtections.isEmpty()==false){
			int hpr = (int)(Math.random()*healthProtections.size());
			healthProtectionSuggest = healthProtections.get(hpr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("sportSuggest", sportSuggest);
		maps.put("healthProtectionSuggest", healthProtectionSuggest);
		dietSuggest = null;
		sportSuggest = null;
		healthProtectionSuggest = null;
		diseaseType = null;
		return maps;
	}

	/**
	 * 月经前期的分级和建议2
	 * @param number
	 * @return
	 */
	public static Map<String,Object> judgeMenstruation2(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食 
		List<String> sports = new ArrayList<String>();//运动
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(number>=0&&number<=50){
			result = "安全期";
			diseaseType = "您目前处于安全期。";
		}else if(number>50&&number<=80){
			result = "经前期";
			diseaseType = "您月经即将到来，请您提前做好防护措施。";
			//饮食建议
			String d1 = "在经前期女性缺锌会导致脸上长痘痘，可适当吃一些含锌丰富的牛肉、猪肉等";
			String d2 = "缺锌会使黄体酮分泌不足，导致心情紧张焦虑，如南瓜、大麦等可常吃";
			String d3 = "含维生素B6的食物如菜花、虾等，可减轻女性在经前期出现喜怒无常的症状";
			String d4 = "香蕉、鲑鱼等富含维生素B6，常食可减轻女性在经前期出现喜怒无常的症状";
			String d5 = "维生素B6缺乏可导致雌、孕激素比例失调，可常吃黄豆、芥菜等";
			String d6 = "经前期女性会出现失眠多梦，可常吃富含色氨酸的食物如香菇、豆腐等";
			String d7 = "辛辣生冷食物容易使盆腔血管收缩，导致经血量少，月经前一周应避免食用";
			String d8 = "经前期吃生冷食物，会伤害脾胃、寒气凝滞，引发经血偏少及痛经等症状";
			String d9 = "经前期吃些温补食物，如羊肉、红枣等，可减轻经期出现乏力、疲惫等症状";
			String d10 = "女性月经前一周要注意补铁，以免影响衰老、能量代谢等问题";
			String d11 = "经前期常喝含咖啡因的饮料，会使经期乳房胀痛，易怒与情绪不稳";
			String d12 = "经前期常喝含咖啡因的饮料会消耗体内储存的B族维生素";
			String d13 = "奶油、酵母乳等乳酪类是经痛的祸源，会破坏镁的吸收，经前期避免食用";
			String d14 = "女性经前期常食巧克力会导致情绪失控，造成经前期情绪不稳";
			String d15 = "酒会毒害肝脏消耗体内B族维生素与矿物质，破坏碳水化合物的新陈代谢";
			String d16 = "高钠食物如腌菜、香肠等会使乳房胀痛，造成水肿与乳房胀痛，应避免食用";
			String d17 = "多吃维生素E丰富的食物，可减少引起经前疼痛，如五谷、植物油等";
			String d18 = "月经前及月经期间可以每晚喝一杯热牛奶，可消除烦躁情绪";
			String d19 = "沙丁鱼、草鱼中的ω-3脂肪酸抗抑郁，女性在经前期可适当吃些鱼类";
			String d20 = "面条，粥类等食物可促进吸收，保证体内的营养平衡，避免经期营养不良";
			String d21 = "香蕉中含有的B族维生素和镁具有安神、缓解经前情绪不良的作用";
			String d22 = "经前期食用富含镁的食物，如酸枣、桑葚等，可缓解腹痛，改善经痛";
			String d23 = "女性在月经前一周饮食要以清淡，易消化及营养为主";
			String d24 = "多补充绿叶蔬菜、鱼类等食物，每天保持大便，可以缓解骨盆充血状况";
			String d25 = "咸食会增加盐分和水分，导致孕激素增加，引发水肿、头痛等问题";
			diets.add(d1);
			diets.add(d2);
			diets.add(d3);
			diets.add(d4);
			diets.add(d5);
			diets.add(d6);
			diets.add(d7);
			diets.add(d8);
			diets.add(d9);
			diets.add(d10);
			diets.add(d11);
			diets.add(d12);
			diets.add(d13);
			diets.add(d14);
			diets.add(d15);
			diets.add(d16);
			diets.add(d17);
			diets.add(d18);
			diets.add(d19);
			diets.add(d20);
			diets.add(d21);
			diets.add(d22);
			diets.add(d23);
			diets.add(d24);
			diets.add(d25);
			//运动建议
			String sp1 = "要避免剧烈运动，特别是引起腹压增高的运动，如跳绳、长跑等";
			String sp2 = "经前期适当走路或慢步（20-40分钟）等，可有效调整经期不适的症状";
			String sp3 = "经前期适当慢跑，能活化大脑、提振心情，减少生理期心情郁郁寡欢";
			String sp4 = "经前期可适当做些瑜珈 ，可放松心情，缓解经期疲惫、烦躁等";
			String sp5 = "经前期有氧舞蹈能够纾解浮肿，加速体内新陈代谢";
			sports.add(sp1);
			sports.add(sp2);
			sports.add(sp3);
			sports.add(sp4);
			sports.add(sp5);
		}else if(number>80&&number<=100){
			result = "行经期";
			diseaseType = "您目前处于生理期，忌食生冷。";
			//饮食建议
			String d1 = "生理期喝冰水会让污血无法顺利排出，留在身体里对身体有害";
			String d2 = "生理期间吃巧克力、蛋糕等甜食，可以帮助污血代谢";
			String d3 = "生理期刚来可以适当多吃点麻油猪肝，帮助废血排出";
			String d4 = "桂圆红枣茶、红糖姜水、玫瑰花茶等可以让生理期更舒适";
			String d5 = "生理期饮酒会对肝脏造成严重的伤害，可能引发肝脏机能障碍";
			String d6 = "生理期进食油炸食品，会增加肌肤负担，容易出现粉刺、痤疮、毛囊炎等";
			String d7 = "生理期间不要吃辛辣的东西，易导致肚子疼、痛经等状况的出现";
			String d8 = "生理期间要注意补充营养，可适当食用红糖水、阿胶、红枣莲子羹等";
			String d9 = "过咸的食物，会使体内的盐分和水分贮留增多，生理期易发生头痛、情绪激动等症状";
			String d10 = "浓茶、咖啡等咖啡因含量很高，容易刺激神经和心血管，产生月经疼痛、经期延长和经血过多等不适症状";
			String d11 = "月经来潮初期，女性常会感到腰痛、不思饮食，可多吃一些开胃、易消化的食物，如枣子、面条、薏米粥等";
			String d12 = "月经期应多饮水、多吃蔬菜，这样可以保持大便通畅，减少盆腔充血";
			String d13 = "月经后期要适当多吃有助于补血的食物，如牛肉、动物肝脏、蛋、奶等";
			diets.add(d1);
			diets.add(d2);
			diets.add(d3);
			diets.add(d4);
			diets.add(d5);
			diets.add(d6);
			diets.add(d7);
			diets.add(d8);
			diets.add(d9);
			diets.add(d10);
			diets.add(d11);
			diets.add(d12);
			diets.add(d13);
			//其他建议
			String s1 = "生理期期间尽量不要洗头，洗完头一定要立即吹干";
			String s2 = "生理期期间要注意保暖，少吹冷气，在冷气房里要多穿件衣服";
			String s3 = "生理期要充分休息，过于劳累会导致经期延长或是失血过多";
			String s4 = "生理期情绪不好时，也不要纵容自己乱发脾气，容易扰乱经期";
			String s5 = "生理期子宫口比较张开，容易受到污染，所以洗澡最好采用淋浴";
			String s6 = "生理期间毛孔张开，容易长痘，因此脸部清洁工作要做好";
			String s7 = "经期腰部酸胀是盆腔充血引起的，捶打腰部会导致盆腔更加充血，加剧酸胀感";
			String s8 = "经期捶腰不利于子宫内膜剥落后创面的修复愈合，导致流血增多，经期延长";
			String s9 = "经期受荷尔蒙分泌的影响，不适宜做妇科检查、尿检、血检、心电图等检查项目";
			String s10 = "经期拔牙时出血量增多，拔牙后嘴里也会长时间留有血腥味，影响食欲";
			String s11 = "经期阴部容易产生异味，清洗阴部需要选择专业的阴部清洗液，避免感染";
			String s12 = "月经期应禁止发生性生活，容易将细菌引入子宫腔内，引起子宫内的感染";
			String s13 = "女性从月经来潮前两天开始就应注意不要长时间或高声唱歌，以免声带受损";
			String s14 = "不管冬季还是夏季，月经期间应避免用凉水洗碗，洗衣服，洗脸等";
			String s15 = "月经期间请勿做激烈运动，会造成体内排泄不畅，影响身体健康";
			String s16 = "生理期间卫生巾要勤换（晚上睡觉除外），以免滋生大量细菌，感染生殖系统";
			String s17 = "经期注意腹部和脚部保暖，避免子宫受凉";
			String s18 = "臀围小的紧身裤会使局部微血管受到压力，影响血液循环，造成阴部充血水肿";
			String s19 = "生理期内，身体很容易疲惫，最好每天保证睡足8小时，且要注意防寒保暖";
			otherSuggests.add(s1);
			otherSuggests.add(s2);
			otherSuggests.add(s3);
			otherSuggests.add(s4);
			otherSuggests.add(s5);
			otherSuggests.add(s6);
			otherSuggests.add(s7);
			otherSuggests.add(s8);
			otherSuggests.add(s9);
			otherSuggests.add(s10);
			otherSuggests.add(s11);
			otherSuggests.add(s12);
			otherSuggests.add(s13);
			otherSuggests.add(s14);
			otherSuggests.add(s15);
			otherSuggests.add(s16);
			otherSuggests.add(s17);
			otherSuggests.add(s18);
			otherSuggests.add(s19);
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(sports.isEmpty()==false){
			int dr = (int)(Math.random()*sports.size());
			sportSuggest = sports.get(dr);
		}
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("sportSuggest", sportSuggest);
		maps.put("otherSuggest", otherSuggest);
		dietSuggest = null;
		sportSuggest = null;
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}

	/**
	 * 血糖的分级和建议2
	 * @param VP
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> judgeBloodSugar1(String VP){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食
		List<String> healthProtections = new ArrayList<String>();//保健
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(Constant.BLOODSUGAR_DOWN.equals(VP)){
			diseaseType = "本次血糖偏低，请注意饮食。";
			//饮食建议
			String d1 = "宜吃低糖、高脂、高蛋白饮食，少食多餐";
			String d2 = "有低血糖病史的人应当在活动量增加时，及时少量加餐";
			String d3 = "低血糖症较轻者，可随时吃点饼干，严重者可随身携带一些糖块";
			String d4 = "低血糖患者最好少量多餐，睡前吃少量的零食及点心也会有帮助";
			String d5 = "要交替食物种类，不要经常吃某种食物，使症状更复杂";
			String d6 = "严格限制单糖类摄取量，要尽量少吃精制及加工产品";
			String d7 = "避免糖分高的水果及果汁，如葡萄汁混合50%的水饮用";
			String d8 = "餐前半小时，先服用纤维素，有助于稳定血糖浓度以稳定血糖";
			String d9 = "螺旋藻中富含多糖和生理活性物质，适当食用可稳定血糖浓度";
			String d10 = "饮食应该力求均衡，最少包含50%—60%的碳水化合物";
			String d11 = "低血糖患者应限制单糖类的摄入量，以防导致血糖储存不足";
			String d12 = "少吃一些精制品或加工品，制止食用糖分高的生果和果汁";
			String d13 = "保证摄入充足的营养物质，使体质从纤弱逐渐变得健壮";
			String d14 = "能量摄入不足,没有按时进餐,空腹运动、饮酒等，可导致低血糖";
			String d15 = "一旦出现低血糖，可立即吃“糖”，快速增高血糖水平";
			String d16 = "出现低血糖，可以使用糖水(温开水冲白糖)，或口服葡萄糖片";
			String d17 = "易消化的碳水化合物吸收快，可引起机体血糖降低";
			String d18 = "应多吃蔬菜、鱼类等这些可缓慢吸收的食物，以保持血糖稳定";
			String d19 = "当出现低血糖时，忌用含有脂肪或者蛋白质的食物（如冰激凌）";
			String d20 = "不同食品引起血糖升高快慢不同，可适当选择食用";
			String d21 = "老年人可选择富含蛋白质、铁、叶酸的食物，如猪肝、瘦肉等";
			diets.add(d1);
			diets.add(d2);
			diets.add(d3);
			diets.add(d4);
			diets.add(d5);
			diets.add(d6);
			diets.add(d7);
			diets.add(d8);
			diets.add(d9);
			diets.add(d10);
			diets.add(d11);
			diets.add(d12);
			diets.add(d13);
			diets.add(d14);
			diets.add(d15);
			diets.add(d16);
			diets.add(d17);
			diets.add(d18);
			diets.add(d19);
			diets.add(d20);
			diets.add(d21);
			//其他
			String s1 = "血糖低患者不要减肥，要按时吃饭，否则会出现更多的健康问题";
			String s2 = "尽可能于饭后l-2小时内参加运动，这时不易发生低血糖";
			String s3 = "短效胰岛素注射后1小时左右不宜参加运动";
			String s4 = "注射胰岛素时选活动剧烈的部位，会导致胰岛素吸收加快，易诱发低血糖";
			String s5 = "当糖尿病患者出现肠胃问题,进食后不能及时消化吸收,也会导致低血糖反应";
			otherSuggests.add(s1);
			otherSuggests.add(s2);
			otherSuggests.add(s3);
			otherSuggests.add(s4);
			otherSuggests.add(s5);
		}else if(Constant.BLOODSUGAR_NOMAL.equals(VP)){
			diseaseType = "本次血糖正常。";
		}else if(Constant.BLOODSUGAR_UP.equals(VP)){
			diseaseType = "本次血糖偏高，请注意饮食。";
			Map<String,Object> bloodSugarMaps = addBloodSugarList();
			diets = (List<String>) bloodSugarMaps.get("diets");
			healthProtections = (List<String>) bloodSugarMaps.get("healthProtections");
			otherSuggests = (List<String>) bloodSugarMaps.get("otherSuggests");
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(healthProtections.isEmpty()==false){
			int hr = (int)(Math.random()*healthProtections.size());
			healthProtectionSuggest = healthProtections.get(hr);
		}
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("healthProtectionSuggest", healthProtectionSuggest);
		maps.put("otherSuggest", otherSuggest);
		dietSuggest = null;
		healthProtectionSuggest = null;
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}

	/**
	 * 血脂的分级和建议
	 * @param number
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> judgeHyperlipaemia(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食 
		List<String> healthProtections = new ArrayList<String>();//运动
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(number >= 0 && number <= 30){
			result = "正常";
			diseaseType = "血脂相关风险低。";
		}else if(number > 30 && number <= 80){
			result = "偏高";
			diseaseType = "可能存在高血脂的风险，请注意休息及饮食。";
			Map<String,Object> hyperlipaemiaMaps = addHyperlipaemiaList();
			diets = (List<String>) hyperlipaemiaMaps.get("diets");
			healthProtections = (List<String>) hyperlipaemiaMaps.get("healthProtections");
			otherSuggests = (List<String>) hyperlipaemiaMaps.get("otherSuggests");
		}else if(number > 80 && number <= 100){
			result = "高";
			diseaseType = "血脂的相关风险较高，请及时就医。";
			Map<String,Object> hyperlipaemiaMaps = addHyperlipaemiaList();
			diets = (List<String>) hyperlipaemiaMaps.get("diets");
			healthProtections = (List<String>) hyperlipaemiaMaps.get("healthProtections");
			otherSuggests = (List<String>) hyperlipaemiaMaps.get("otherSuggests");
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(healthProtections.isEmpty()==false){
			int hr = (int)(Math.random()*healthProtections.size());
			healthProtectionSuggest = healthProtections.get(hr);
		}
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("healthProtectionSuggest", healthProtectionSuggest);
		maps.put("otherSuggest", otherSuggest);
		dietSuggest = null;
		healthProtectionSuggest = null;
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}
	
	/**
	 * 冠心病的分级和建议
	 * @param number
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> judgeCoronaryHeartDisease(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食 
		List<String> sports = new ArrayList<String>();//运动
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(number >= 0 && number <= 50){
			result = "正常";
			diseaseType = "冠心病相关风险低。";
		}else if(number > 50 && number <= 80){
			result = "偏高";
			diseaseType = "可能存在冠心病的风险，请注意休息。";
			Map<String,Object> coronaryHeartDiseaseMaps = addCoronaryHeartDiseaseList();
			diets = (List<String>) coronaryHeartDiseaseMaps.get("diets");
			sports = (List<String>) coronaryHeartDiseaseMaps.get("sports");
			otherSuggests = (List<String>) coronaryHeartDiseaseMaps.get("otherSuggests");
		}else if(number > 80 && number <= 100){
			result = "高";
			diseaseType = "冠心病风险高，请结合自身状况及时就医。";
			Map<String,Object> coronaryHeartDiseaseMaps = addCoronaryHeartDiseaseList();
			diets = (List<String>) coronaryHeartDiseaseMaps.get("diets");
			sports = (List<String>) coronaryHeartDiseaseMaps.get("sports");
			otherSuggests = (List<String>) coronaryHeartDiseaseMaps.get("otherSuggests");
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(sports.isEmpty()==false){
			int spr = (int)(Math.random()*sports.size());
			sportSuggest = sports.get(spr);
		}
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("sportSuggest", sportSuggest);
		maps.put("otherSuggest", otherSuggest);
		dietSuggest = null;
		sportSuggest = null;
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}
	
	/**
	 * 动脉硬化的分级和建议
	 * @param number
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> judgeArteriosclerosis(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食 
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(number >= 0 && number <= 36){
			result = "正常";
			diseaseType = "动脉粥样硬化相关风险低。";
		}else if(number > 36 && number <= 70){
			result = "偏高";
			diseaseType = "可能存在动脉粥样硬化的风险，请结合自身状况并及时就医。";
			Map<String,Object> arteriosclerosisMaps = addArteriosclerosisList();
			diets = (List<String>) arteriosclerosisMaps.get("diets");
			otherSuggests = (List<String>) arteriosclerosisMaps.get("otherSuggests");
		}else if(number > 70 && number <= 100){
			result = "高";
			diseaseType = "动脉粥样硬化风险高，请结合自身状况并及时就医。";
			Map<String,Object> arteriosclerosisMaps = addArteriosclerosisList();
			diets = (List<String>) arteriosclerosisMaps.get("diets");
			otherSuggests = (List<String>) arteriosclerosisMaps.get("otherSuggests");
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("otherSuggest", otherSuggest);
		dietSuggest = null;
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}

	/**
	 * 风寒感冒的分级和建议
	 * @param number
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> judgeCold(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食 
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(number >= 0 && number <= 50){
			result = "正常";
			diseaseType = "风寒感冒的相关风险低。";
		}else if(number > 50 && number <= 80){
			result = "风险";
			diseaseType = "可能存在风寒感冒的风险，请注意保暖。";
			Map<String,Object> coldMaps = addColdList();
			diets = (List<String>) coldMaps.get("diets");
			otherSuggests = (List<String>) coldMaps.get("otherSuggests");
		}else if(number > 80 && number <= 100){
			result = "感冒";
			diseaseType = "风寒感冒的相关风险较高，请及时就医。";
			Map<String,Object> coldMaps = addColdList();
			diets = (List<String>) coldMaps.get("diets");
			otherSuggests = (List<String>) coldMaps.get("otherSuggests");
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("otherSuggest", otherSuggest);
		dietSuggest = null;
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}

	/**
	 * 风热感冒的分级和建议
	 * @param number
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> judgeHoltCold(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食 
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(number >= 0 && number <= 40){
			result = "正常";
			diseaseType = "风热感冒的相关风险低。";
		}else if(number > 40 && number <= 70){
			result = "风险";
			diseaseType = "可能存在风热感冒的风险，请注意休息。";
			Map<String,Object> holtColdMaps = addHoltColdList();
			diets = (List<String>) holtColdMaps.get("diets");
			otherSuggests = (List<String>) holtColdMaps.get("otherSuggests");
		}else if(number > 70 && number <= 100){
			result = "感冒";
			diseaseType = "风热感冒的相关风险较高，请及时就医。";
			Map<String,Object> holtColdMaps = addHoltColdList();
			diets = (List<String>) holtColdMaps.get("diets");
			otherSuggests = (List<String>) holtColdMaps.get("otherSuggests");
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("otherSuggest", otherSuggest);
		dietSuggest = null;
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}

	/**
	 * 排卵期的分级和建议（没范围）（没指数）（要改名字）
	 * @param number
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> judgeplq(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(number >= 0 && number <= 36){
			result = "阴性";
			diseaseType = "您本次测量值为"+number+"，目前处于阴性状态";
		}else if(number > 36 && number <= 70){
			result = "弱阳";
			diseaseType = "您本次测量值为"+number+"，目前处于弱阳状态，请注意饮食，我们给出的建议如下：";
			Map<String,Object> plqMaps = addplqList();
			otherSuggests = (List<String>) plqMaps.get("otherSuggests");
		}else if(number > 70 && number <= 100){
			result = "强阳";
			diseaseType = "您本次测量值为"+number+"，目前处于强阳状态，请注意饮食，我们给出的建议如下：";
			
		}
		//随机取集合中的建议给前端返回
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("otherSuggest", otherSuggest);
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}

	/**
	 * 13-其他风险里的血压的返回值
	 * @param ssa 高压
	 * @param sza 低压
	 * @return
	 */
	public static Map<String,Object> getBloodShow(double ssa,double sza){
		Map<String,Object> maps = new HashMap<String,Object>();
		String bl=null;
		String bl1=null;
		if(ssa<=90 && sza<=80){
			bl="血压偏低，请注意饮食";
		}
		if((90<ssa && ssa<130) && (sza>60 && sza<110)){
			bl="血压正常，请继续保持";
		}
		if((130<ssa && ssa<139) && (sza>85 && sza<120)){
			bl="血压偏高，请注意休息。";
		}
		if((140<ssa && ssa<159) && (sza>90 && sza<130)){
			bl="可能存在1级高血压的风险，请及时就医";
		}
		if((160<ssa && ssa<179) && (sza>100 && sza<150)){
			bl="可能存在2级高血压的风险，请及时就医";
		}
		if(180<=ssa  && sza>=100){
			bl="可能存在3级高血压的风险，请并及时就医";
		}
		if(ssa-sza>60){
			bl1="脉压大";
		}
		if(ssa-sza<20){
			bl1="脉压小";
		}
		if(140<=ssa && sza<90){
			bl="单纯收缩期高血压";
		}
		maps.put("bl", bl);
		maps.put("bl1", bl1);
		return maps;
	}
	
	/**
	 * 血糖的偏高和高的文案的工具类
	 * @return
	 */
	public static Map<String,Object> addBloodSugarList(){
		List<String> diets = new ArrayList<String>();//饮食 
		List<String> healthProtections = new ArrayList<String>();//保健
		List<String> otherSuggests = new ArrayList<String>();//其他
		Map<String,Object> maps = new HashMap<String,Object>();
		//饮食建议
		String d1 = "及时补充维生素A，可预防糖尿病并发症的发生和发展，如动物肝脏、鱼肝油等";
		String d2 = "常食富含维生素C的食物如包菜、青椒等，可提高组织对胰岛素的敏感性，起到增强药效的作用";
		String d3 = "维生素B1可促进葡萄糖转化为能量，有助于糖尿病患者降低血糖值，如牛肉、牡蛎等";
		String d4 = "维生素B2帮助糖类分解与代谢，有利于糖值的控制，如鱼、牡蛎等";
		String d5 = "维生素B6对预防和改善糖尿病患者各种并发症均有益，如鸡肉、鲑鱼等";
		String d6 = "糖尿病患者适当摄取维生素E，可减少心血管疾病的产生，如小麦、绿色蔬菜等";
		String d7 = "膳食纤维能延缓食物中葡萄糖得吸收，有助于预防糖尿病，如玉米、绿色蔬菜等";
		String d8 = "及时补充维生素A，可预防糖尿病并发症的发生和发展，如鳗鱼、白萝卜等";
		String d9 = "芦笋、芒果等富含维生素A，对糖尿病并发症的发生和发展有一定预防作用";
		String d10 = "维生素C能有效消除自由基，可预防和改善糖尿病并发症，如番石榴、猕猴桃等";
		String d11 = "橙子、草莓等富含维生素C，对预防和改善糖尿病并发足病、肾病等具有重要作用";
		String d12 = "糙米、豆类等富含维生素B1，可帮助糖尿病患者更好的利用体内的糖类，降低血糖值";
		String d13 = "当体内的维生素B2缺乏时，将影响糖值的控制，可常吃香菇、黑木耳等";
		String d14 = "牛奶、豆类等富含维生素B6的食物，可预防和改善糖尿病患者的各种并发症";
		String d15 = "糖尿病患者适当摄取橄榄油、坚果等富含维生素E的食物，可减少心血管疾病的产生";
		diets.add(d1);
		diets.add(d2);
		diets.add(d3);
		diets.add(d4);
		diets.add(d5);
		diets.add(d6);
		diets.add(d7);
		diets.add(d8);
		diets.add(d9);
		diets.add(d10);
		diets.add(d11);
		diets.add(d12);
		diets.add(d13);
		diets.add(d14);
		diets.add(d15);
		//保健建议
		String hp1 = "期门穴位于胸部，乳头直下，第六肋间隙，前正中线旁开4寸。用拇指指腹按揉期门穴能够改善糖尿病引起的胸肋痛、吞酸等症状";
		String hp2 = "肾俞穴位于腰部，第二腰椎棘突下，旁开1.5寸。用艾条温和灸肾俞穴5-20分钟，可改善肾气不足型糖尿病";
		String hp3 = "少府穴位于手掌面，第四、第五掌骨之间，握拳时当小指尖处。用拇指弹拨少府穴10-15分钟，能改善糖尿病并发神经系统损害";
		String hp4 = "太溪穴位于足内侧，内踝后方，内踝尖与跟腱之间的凹陷处。用拇指指腹用力按揉太溪穴能够改善糖尿病并发症";
		String hp5 = "冲阳穴位于足背部最高处，拇长伸肌腱和趾长伸肌腱之间。用手掌小鱼际敲击冲阳穴，可改善糖尿病导致的下肢血管病变";
		String hp6 = "历兑穴位于足第二趾末节外侧，距趾甲角0.1寸。用手指关节夹按历兑穴，长期按摩，可改善糖尿病引起的咽喉肿痛、癫狂等不适症状";
		String hp7 = "阳池穴位于腕背横纹中，指总伸肌腱的尺侧缘凹陷处。用拇指指尖稍用力掐按阳池穴3-5分钟，每天坚持，可缓解糖尿病并发症所致微血管病变";
		healthProtections.add(hp1);
		healthProtections.add(hp2);
		healthProtections.add(hp3);
		healthProtections.add(hp4);
		healthProtections.add(hp5);
		healthProtections.add(hp6);
		healthProtections.add(hp7);
		//其他建议
		String s1 = "糖尿病患者应综合治疗，包括服药打针、饮食控制、心理平衡、科学运动、科学监测等";
		String s2 = "血糖应控制在一定的范围内，不能过高或者过低";
		String s3 = "糖尿病已有年轻化的趋势，应养成健康的行为和生活方式，重视糖尿病的预防";
		String s4 = "监测糖尿病血糖控制情况的主要指标，包括血糖和糖化血红蛋白";
		String s5 = "多吃降糖药，就可以不控制饮食的想法是错误的，饮食治疗是糖尿病综合治疗的基础";
		String s6 = "当确诊为糖尿病时，虽然没有感觉不舒服，但需要及时接受正规的筛查和治疗";
		String s7 = "血糖控制得好，可以减少糖尿病并发症的发生和发展，血糖过低会出现低血糖血症";
		String s8 = "定期体检有助于糖尿病的及早发现，可采取早期措施和治疗";
		otherSuggests.add(s1);
		otherSuggests.add(s2);
		otherSuggests.add(s3);
		otherSuggests.add(s4);
		otherSuggests.add(s5);
		otherSuggests.add(s6);
		otherSuggests.add(s7);
		otherSuggests.add(s8);
		maps.put("diets", diets);
		maps.put("healthProtections", healthProtections);
		maps.put("otherSuggests", otherSuggests);
		return maps;
	}

	/**
	 * 血脂的偏高和高的文案的工具类
	 * @return
	 */
	public static Map<String,Object> addHyperlipaemiaList(){
		List<String> diets = new ArrayList<String>();//饮食 
		List<String> healthProtections = new ArrayList<String>();//保健
		List<String> otherSuggests = new ArrayList<String>();//其他
		Map<String,Object> maps = new HashMap<String,Object>();
		//饮食建议
		String d1 = "新鲜蔬果、薯类等富含膳食纤维，可吸附胆酸，促进胆盐排泄，降低血液中胆固醇含量";
		String d2 = "富含维生素C的食物如猕猴桃、草莓等能促进胆固醇代谢，降低总胆固醇含量";
		String d3 = "纤维醇能防止脂肪在肝脏积聚，从而有利于降低血脂，如酵母、牛心等可常吃";
		String d4 = "谷类、豆类等食物富含镁，能降低代谢不良引发的脂肪囤积以及代谢症候群的发生";
		String d5 = "坚果中含有的必需脂肪酸能够预防脂肪蓄积，降低患高脂血症的概率，建议每天一小把";
		String d6 = "维生素B2可促进脂肪代谢，降低血脂，富含维生素B2的食物有绿色蔬菜、五谷杂粮等";
		String d7 = "常食虾皮、牛奶等富含钙的食物，能够从多方面达到降低血脂的作用";
		String d8 = "富含膳食纤维的食物如糙米、玉米等，可降低血液中胆固醇含量";
		String d9 = "富含维生素C的食物如土豆、西红柿等，能促进胆固醇代谢，降低总胆固醇";
		String d10 = "维生素C能促进胆固醇代谢，降低总胆固醇，如柑橘、枸杞等可常吃";
		String d11 = "纤维醇能降低人体内胆固醇含量，有助于降低血脂，富含纤维醇的食物有青豆、香瓜等";
		String d12 = "柚子、葡萄干等富含纤维醇的食物能降低人体内胆固醇的含量，有助于降低血脂";
		String d13 = "纤维醇能降低人体内胆固醇的含量，并且有助于降低血脂，如小麦芽胚、花生等";
		String d14 = "镁可以降低代谢不良引发的脂肪囤积以及代谢症候群的发生，如松子、榛子等可常吃";
		String d15 = "富含镁的食物有菠菜、莴苣等，能减轻有害物质对血管的伤害并提高心血管的免疫力";
		String d16 = "必需脂肪酸能够阻止胆固醇的沉积，并预防脂肪积蓄，如植物油、大部分鱼类等";
		String d17 = "富含必需脂肪酸的食物如奶酪、牛奶等，可促进脂肪分解消耗，降低患高脂血症的概率";
		String d18 = "乳制品、坚果类等富含维生素B2的食物，可有效促进脂肪代谢，降低血脂";
		String d19 = "钙可促进激素分泌、减少脂肪堆积，从而降低血脂。如豆类及豆制品等";
		String d20 = "富含钙的食物如雪里蕻、小白菜等，可促进激素分泌、减少脂肪堆积";
		diets.add(d1);
		diets.add(d2);
		diets.add(d3);
		diets.add(d4);
		diets.add(d5);
		diets.add(d6);
		diets.add(d7);
		diets.add(d8);
		diets.add(d9);
		diets.add(d10);
		diets.add(d11);
		diets.add(d12);
		diets.add(d13);
		diets.add(d14);
		diets.add(d15);
		diets.add(d16);
		diets.add(d17);
		diets.add(d18);
		diets.add(d19);
		diets.add(d20);
		//保健建议
		String h1 = "神阙穴位于脐中央。用拇指点按神阙穴，以皮肤有酸胀感为度。高脂血症患者长期按摩可改善四肢冰冷、脱肛等症状";
		String h2 = "大横穴位于腹中部，距脐中4寸。用拇指指腹按揉大横穴。每天坚持，能够促进肠蠕动，排毒通便，减少脂肪生成";
		String h3 = "曲池穴位于肘横纹外侧端，当尺泽与肱骨外上踝连线中点。用拇指弹拨曲池穴，以皮肤有酸胀感为宜。可预防高脂血症、高血压、肩臂肘疼痛";
		String h4 = "足三里穴位于小腿前外侧，当犊鼻穴下3寸，距胫骨前缘一横指（中指）。用拇指指腹推按足三里穴，可改善高脂血症、下肢不遂等";
		String h5 = "解溪穴位于小腿与足背交界处的横纹中央凹陷处，拇指伸肌腱与趾长伸肌腱之间。用拇指指腹推按解溪穴，可改善高脂血症引起的头痛";
		healthProtections.add(h1);
		healthProtections.add(h2);
		healthProtections.add(h3);
		healthProtections.add(h4);
		healthProtections.add(h5);
		//其他建议
		String s1 = "精神压力大者长期处于紧张、焦虑的状态，易诱发高脂血症或其他心脑血管疾病";
		String s2 = "酒精可促使脂肪酸在肝内合成三酰甘油，出现严重的高脂血症";
		String s3 = "长期不运动，易导致多余的脂肪在体内堆积，容易发生高脂血症";
		String s4 = "随着年龄的增长，肝脏自身清除脂肪的能力下降，患高脂血症的概率增加";
		String s5 = "保证充足的睡眠，睡眠不足可间接造成脂肪代谢异常和肥胖";
		String s6 = "长期熬夜及失眠者，极易造成机体代谢紊乱、血脂异常，对心血管造成伤害";
		String s7 = "类固醇和避孕药等药物，长期服用会使患高脂血症的概率增加";
		String s8 = "有暴饮暴食，挑食偏食等不良饮食习惯者，都易导致血脂升高";
		String s9 = "中老年妇女的眼睑上出现淡黄色的小皮疹，往往提示病人血脂水平较高";
		String s10 = "腿肚经常抽筋并感到刺痛，是胆固醇积聚在腿部肌肉中的表现，应及时进行血脂检查";
		String s11 = "高脂血症可以引起脂肪肝，影响肝功能，出现食欲不振等症状";
		String s12 = "肥胖是血脂升高最常见的“信号”，要注意进行血脂检查";
		otherSuggests.add(s1);
		otherSuggests.add(s2);
		otherSuggests.add(s3);
		otherSuggests.add(s4);
		otherSuggests.add(s5);
		otherSuggests.add(s6);
		otherSuggests.add(s7);
		otherSuggests.add(s8);
		otherSuggests.add(s9);
		otherSuggests.add(s10);
		otherSuggests.add(s11);
		otherSuggests.add(s12);
		maps.put("diets", diets);
		maps.put("healthProtections", healthProtections);
		maps.put("otherSuggests", otherSuggests);
		return maps;
	}

	/**
	 * 冠心病的偏高和高的文案的工具类
	 * @return
	 */
	public static Map<String,Object> addCoronaryHeartDiseaseList(){
		List<String> diets = new ArrayList<String>();//饮食 
		List<String> sports = new ArrayList<String>();//运动
		List<String> otherSuggests = new ArrayList<String>();//其他
		Map<String,Object> maps = new HashMap<String,Object>();
		String d1 = "海鱼的脂肪中含有多不饱和脂肪酸，能够促进人体脂质代谢，保护心血管";
		String d2 = "冠心病患者，应控制鸡蛋的摄入，每日半个鸡蛋或每两日一个鸡蛋";
		String d3 = "茶叶中的茶多酚，能有效增强心肌和血管壁的弹性，减轻动脉粥样硬化的程度";
		String d4 = "硒能降低血液粘稠度，增加冠脉血流量，富含硒的食物如牡蛎、鲜贝等可适量食用";
		String d5 = "富含维生素C的食物，如猕猴桃、柑桔等能影响心肌代谢，使血管弹性增加";
		String d6 = "镁能影响血脂代谢和血栓形成，并能防止血小板凝聚。含镁丰富的食品有小米、豆类等";
		String d7 = "含铬丰富的食物，如牛肉、肝脏等，可预防动脉粥样硬化的形成，降低胆固醇";
		String d8 = "硒能预防动脉粥样硬化形成，减少心肌的损伤。富含硒的食物有海虾、巴鱼等";
		String d9 = "多食富含维生素C的食物，如柠檬、紫皮茄子等，能够影响心肌代谢，增加血管韧性";
		String d10 = "含镁丰富的食物如枸杞、桂圆等，可影响血脂代谢和血栓形成，防止血小板凝聚";
		String d11 = "含铬丰富的食物如干酪、红糖等，可预防动脉粥样硬化的形成，降低胆固醇";
		diets.add(d1);
		diets.add(d2);
		diets.add(d3);
		diets.add(d4);
		diets.add(d5);
		diets.add(d6);
		diets.add(d7);
		diets.add(d8);
		diets.add(d9);
		diets.add(d10);
		diets.add(d11);
		String sp1 = "散步、慢跑等有氧运动可使身体吸收氧气，促进冠状动脉及心肌病变的恢复";
		String sp2 = "冠心病患者如进行竞争对抗性强的体育活动，会引起血压升高，诱发心肌梗死";
		String sp3 = "运动前后需有5-10分钟准备、恢复活动，以使四肢血液慢慢回流至大血管和心脏";
		sports.add(sp1);
		sports.add(sp2);
		sports.add(sp3);
		String s1 = "心情舒畅的人血脉不易瘀阻，所以保持心情舒畅，是防治冠心病的第一要义";
		String s2 = "适当控制体重，降低血压、血脂、血糖，是血管恢复活力的重要前提";
		String s3 = "避免长时间疲劳和精神紧张，确保每天有足够的休息和放松时间";
		String s4 = "按时入睡、保证每天的睡眠时间和质量，是养心的一大法宝";
		String s5 = "每晚睡觉前用温水泡脚，有助于扩张血管、改善血液循环，对促进睡眠也有好处";
		String s6 = "寒冷会使血管收缩，导致血脉瘀阻，所以要做好避寒保暖工作";
		String s7 = "每天晚上用热水泡脚后，自我按摩一会足底，是冠心病患者的保健良方";
		String s8 = "经常做拍手操，能改善冠心病、心悸、心律不齐等病症";
		String s9 = "下蹲有利于气血流畅，减轻心脏的负担，减少冠心病和脑卒中的发病率";
		otherSuggests.add(s1);
		otherSuggests.add(s2);
		otherSuggests.add(s3);
		otherSuggests.add(s4);
		otherSuggests.add(s5);
		otherSuggests.add(s6);
		otherSuggests.add(s7);
		otherSuggests.add(s8);
		otherSuggests.add(s9);
		maps.put("diets", diets);
		maps.put("sports", sports);
		maps.put("otherSuggests", otherSuggests);
		return maps;
	}

	/**
	 * 动脉硬化的偏高和高的文案的工具类
	 * @return
	 */
	public static Map<String,Object> addArteriosclerosisList(){
		List<String> diets = new ArrayList<String>();//饮食 
		List<String> otherSuggests = new ArrayList<String>();//其他
		Map<String,Object> maps = new HashMap<String,Object>();
		//饮食建议
		String d1 = "海带、淡菜等海产品含有不饱和脂肪酸，具有阻碍胆固醇在肠道内吸收的作用";
		String d2 = "低盐饮食：钠能促使血压升高，而高血压对动脉粥样硬化及冠心病均可带来不利的影响";
		String d3 = "维生素E具有预防动脉粥样硬化形成的作用,如未精制加工过的植物油、小麦胚芽等";
		String d4 = "适量的补充钙质，保持血钙正常水平，避免血管平滑肌痉挛，可预防动脉血管硬化";
		String d5 = "将肉类切小块熬煮，能使饱和脂肪酸含量减少30%-40%，避免加速血管硬化";
		String d6 = "缺乏维生素C易导致血管粥样硬化及血栓症，富含维生素C的有橙子、猕猴桃等";
		String d7 = "富含膳食纤维的食物如竹笋、芹菜等能够减少胆固醇在体内的生成，防止动脉硬化";
		String d8 = "碘可减少胆固醇和钙盐在体内的沉积，减缓动脉粥样硬化病变的形成，如海带、海蜇等";
		String d9 = "镁对降低血清胆固醇有重要作用，可减缓动脉粥样硬化病变的形成，如花椰菜，菠菜等";
		String d10 = "藻类食物如紫菜、羊栖菜等，在人体内具有阻碍胆固醇吸收的作用，常食可软化血管";
		String d11 = "维生素E可保护血管内皮细胞的完整性，预防动脉粥样硬化形成，如绿色蔬菜、坚果等";
		diets.add(d1);
		diets.add(d2);
		diets.add(d3);
		diets.add(d4);
		diets.add(d5);
		diets.add(d6);
		diets.add(d7);
		diets.add(d8);
		diets.add(d9);
		diets.add(d10);
		diets.add(d11);
		//其他建议
		String s1 = "慢性忧郁或持续的紧张，可刺激交感神经兴奋，易致血压上升，要尽量放松身心";
		String s2 = "定期进行血管健康检查必不可少。建议20岁以上成年人，至少每3-5年查一次空腹血脂；40岁以上人群，建议每年都检查；60岁以上，每半年查一次；心脑血管疾病高危人群，则应每3个月查一次血脂";
		String s3 = "起床太猛，可能造成血压突然升高而引起脑血管破裂";
		String s4 = "清晨血液较黏稠，易形成血栓，起床后应喝一杯温开水";
		String s5 = "解便太用力：晨起时血压高，如果用力排便，腹压增大，血压会更快升高";
		String s6 = "被窝运足法：脚微悬空，左右旋转、前后伸直各10-20下，可防治动脉硬化";
		String s7 = "足麻治法：将足用力伸直，手用力拉足尖，然后站起，足跟抬高，足尖触地，保持数秒钟后复原，每分钟重复作5、10次";
		String s8 = "耳聪明目法：左右手握左右趾关节反复揉捏，重心在2、3趾腹、4、5趾背间上一寸处，重复作10次";
		String s9 = "踩石子法：1米方布一块铺地上，光滑石子平铺6cm高，赤足踏石5、8分钟，明目健身，每日1、2次";
		String s10 = "登楼梯法：每日进行3、4次蹬楼梯阶锻炼，以利足趾五官及感觉功能";
		String s11 = "健脑法：左右手固定左右足趾，对侧手指使手指、足趾互相撞击，可起到健脑、增强记忆、预防老年痴呆等作用";
		String s12 = "用热水，水温以不烫伤皮肤为宜，浸足20分钟，或采用冷热水交替浴足，应热浸一分钟、凉浸半分钟";
		String s13 = "捏转趾法:用手拇食指捏足大趾腹，扭转20下，各趾下同，能醒脑益智";
		String s14 = "按摩足心涌泉穴，用力200下，长期坚持，能消炎止痛、安眠、增食欲、调整血压等";
		otherSuggests.add(s1);
		otherSuggests.add(s2);
		otherSuggests.add(s3);
		otherSuggests.add(s4);
		otherSuggests.add(s5);
		otherSuggests.add(s6);
		otherSuggests.add(s7);
		otherSuggests.add(s8);
		otherSuggests.add(s9);
		otherSuggests.add(s10);
		otherSuggests.add(s11);
		otherSuggests.add(s12);
		otherSuggests.add(s13);
		otherSuggests.add(s14);
		maps.put("diets", diets);
		maps.put("otherSuggests", otherSuggests);
		return maps;
	}

	/**
	 * 风寒感冒的偏高和高的文案的工具类
	 * @return
	 */
	public static Map<String,Object> addColdList(){
		List<String> diets = new ArrayList<String>();//饮食 
		List<String> otherSuggests = new ArrayList<String>();//其他
		Map<String,Object> maps = new HashMap<String,Object>();
		//饮食建议
		String d1 = "可乐煮姜：生姜1片，可乐适量，煮开后服用。可乐煲姜具有一定的散寒、止咳、提神的作用，可以改善感冒、咳嗽等症状";
		String d2 = "姜糖饮：取生姜10克切丝，以沸水冲泡约5分钟，再调入红糖15克即可，具有疏散风寒，和胃健中的作用。每日1次，趁热服后盖被取汗";
		String d3 = "萝卜葱白汤：萝卜1个、葱白6根、生姜15克。用水三碗先将萝卜煮熟，再放葱白、姜，煮剩一碗汤，连渣一次服，适用于风寒咳嗽，痰多泡沫，伴畏寒、身倦酸痛等";
		String d4 = "烤橘子：将橘子在小火上烤至橘皮发黑、有热气从橘子里冒出来，让患者吃温热的橘瓣，最好连同橘皮一起吃，可促进提高抵抗力，适用于风寒感冒咳嗽者";
		String d5 = "葱豉汤：用水500毫升，加入豆豉10克，煮沸2～3分钟，之后加入葱白2根出锅。趁热服用，服后盖被取汗，具有解表散寒的作用";
		String d6 = "葱白粥：大米50克，生姜5片，连须葱白5段，米醋5毫升，加水适量煮粥，趁热饮用，具有散寒、发热的作用，在改善风寒感冒方面能起到一定的效果";
		String d7 = "蒸大蒜水：取大蒜2-3瓣，拍碎，放入碗中，加入半碗水，放入一粒冰糖，把碗加盖放入锅中蒸15分钟即可。一天2-3次，一次小半碗，对改善寒性咳嗽、肾虚咳嗽效果好";
		String d8 = "核桃生姜饮：取核桃仁5克、葱白25克、生姜25克捣烂，与红茶（约15克）一起放入砂锅内，加水煎煮即可。对风寒感冒后发热、恶寒、头痛等症有效";
		String d9 = "蒸花椒冰糖梨：将梨横断切开挖去中间核后，放入20颗花椒，2粒冰糖，再把梨对拼好放入碗中，蒸半小时左右即可，分两次吃完，对改善风寒咳嗽效果非常明显";
		String d10 = "红糖姜枣汤：红糖30克、鲜姜15克、红枣30克。加水三碗煎至过半，顿服，服后微出汗为宜，有驱风散寒，改善伤风咳嗽的作用";
		String d11 = "香菜葱白汤：取香菜15克，葱白15根，生姜9克，分别洗净、切碎，共放锅中加清水适量煎煮10～15分钟，去渣取汁饮服即可。具有发表散寒的作用";
		String d12 = "芥菜姜汤；将鲜芥菜80克洗净后切成小块，鲜姜10克切片，加清水四碗煎至两碗，以食盐调味。每天2次，可改善风寒咳嗽，头痛鼻塞，四肢酸痛等症状";
		String d13 = "香菜汤：先将大米100克洗净，加水煮汤，取大米汤三汤匙与香菜30克，饴糖30克搅拌后蒸10分钟，趁热一次服，可改善伤风感冒引起的咳嗽";
		String d14 = "麻油姜末炒鸡蛋：将一小勺麻油放入炒锅内，油热后放入姜末，随即打入1个鸡蛋炒匀。每晚在临睡前趁热吃一次，对风寒咳嗽、体虚咳嗽有很好的作用";
		String d15 = "香葱饮：将葱须、香菜根、白菜头洗干净之后放入锅中加入清水煎煮，大约二十分钟之后取出渣滓加入红糖，搅拌均匀即可。可缓解风寒感冒";
		String d16 = "生姜萝卜饮：将白萝卜500克、生姜30克去皮后切块，一起放入榨汁机榨汁，再加入蜂蜜30克即可饮用。适合风寒感冒引起的咽喉干痛、咳嗽、声音嘶哑等问题";
		String d17 = "玉米须橘皮：玉米须、橘皮各适量。共加水煎煮，每日2次，对风寒咳嗽、痰多等症状有很好的作用";
		diets.add(d1);
		diets.add(d2);
		diets.add(d3);
		diets.add(d4);
		diets.add(d5);
		diets.add(d6);
		diets.add(d7);
		diets.add(d8);
		diets.add(d9);
		diets.add(d10);
		diets.add(d11);
		diets.add(d12);
		diets.add(d13);
		diets.add(d14);
		diets.add(d15);
		diets.add(d16);
		diets.add(d17);
		//其他建议
		String s1 = "保持室内空气新鲜，注意避风保暖。轻者多休息，重者则卧床休息";
		String s2 = "每日早晚、餐后用淡盐水漱口，以清除口腔病菌";
		String s3 = "每晚用较热的水泡脚15分钟，以水量没过脚面，泡后双脚发红为宜";
		otherSuggests.add(s1);
		otherSuggests.add(s2);
		otherSuggests.add(s3);
		maps.put("diets", diets);
		maps.put("otherSuggests", otherSuggests);
		return maps;
	}

	/**
	 * 风热感冒的偏高和高的文案的工具类
	 * @return
	 */
	public static Map<String,Object> addHoltColdList(){
		List<String> diets = new ArrayList<String>();//饮食 
		List<String> otherSuggests = new ArrayList<String>();//其他
		Map<String,Object> maps = new HashMap<String,Object>();
		//饮食建议
		String d1 = "对于风热感冒咳嗽者，可用生梨一个，洗净连皮切碎，加冰糖炖水服";
		String d2 = "白菊花有疏风、清热、解毒功效，可用白菊花5克，开水冲泡，代茶饮";
		String d3 = "风热感冒后，饮食上不能大鱼大肉、辛辣刺激,尽量吃清淡的食物，不要给肠胃添加负担";
		String d4 = "可补充一些易于消化、高热能的流质半流质食物，如稀粥、豆浆、菜汤、果汁等";
		String d5 = "荔枝、桂圆、大红枣等属于温性水果，风热感冒病人吃了有可能会发烧，因此不要吃";
		String d6 = "鸡汤、羊肉汤、狗肉汤等补品，风热感冒的患者，等身体康复了再吃";
		diets.add(d1);
		diets.add(d2);
		diets.add(d3);
		diets.add(d4);
		diets.add(d5);
		diets.add(d6);
		//其他建议
		String s1 = "早晨起床后，及时打开窗户，呼吸室外新鲜空气，同时保持室内空气流通";
		String s2 = "早上用冷水洗脸，晚上用热水泡脚，长期坚持可促进血液循环提高身体抵抗力";
		String s3 = "每天晨起后，适当慢跑一刻钟，做早操，增强体质，增加机体免疫力";
		String s4 = "每天坚持早晚用淡盐水和茶水漱口，可杀灭口腔中感冒病毒保持口腔清洁卫生";
		String s5 = "根据时令气候和天气预报及时添加衣服，不可硬撑";
		String s6 = "夏季准备一瓶陈醋或白酒，经常打开盖子闻闻，可提神醒脑，有效的预防感冒";
		String s7 = "把陈醋加热，关上门窗，每隔两周熏一次，可有效的杀灭感冒病毒和微生物";
		otherSuggests.add(s1);
		otherSuggests.add(s2);
		otherSuggests.add(s3);
		otherSuggests.add(s4);
		otherSuggests.add(s5);
		otherSuggests.add(s6);
		otherSuggests.add(s7);
		maps.put("diets", diets);
		maps.put("otherSuggests", otherSuggests);
		return maps;
	}

	/**
	 * 排卵期的偏高和高的文案的工具类
	 * @return
	 */
	public static Map<String,Object> addplqList(){
		List<String> otherSuggests = new ArrayList<String>();//其他
		Map<String,Object> maps = new HashMap<String,Object>();
		//其他建议
		String s1 = "在排卵期时要有自己专用的毛巾，不使用他人毛巾，以防受到感染";
		String s2 = "每次排泄后，用流动的水清洗，以免肠道细菌进入阴道，引起炎症";
		String s3 = "每天饮用足够的水，可以减少在尿道滋生的细菌";
		String s4 = "注意在女性排卵期里做好避孕工作，例如使用避孕套、服用避孕药等";
		String s5 = "夫妻可以选择在排卵期同房，这样能够提高受孕机率";
		String s6 = "排卵期少量出血，持续2-3天时，不需要特殊处理。如出血量多，建议就医";
		String s7 = "排卵期出血期间应避免过度劳累，注意休息";
		String s8 = "排卵期腹痛时，可予腹部热敷，同时保持情绪稳定";
		String s9 = "排卵期前后，应禁食辛、辣等刺激性食物，以免排卵期出血";
		String s10 = "排卵期出血期间应尽量避免性生活，容易引起感染";
		String s11 = "排卵期分泌物很多时，洗完澡要在阴部较干之后再穿内裤";
		String s12 = "排卵期最好穿着吸收力强且透气的全棉内裤，避免穿紧身裤袜";
		String s13 = "在公共场所落座时尽量不穿着超短裙，避免让内裤接触座位，发生感染";
		String s14 = "排卵期时，女性尽量不吃冷饮等温度低的食物，比如梨、葡萄、西瓜等";
		String s15 = "排卵期食欲下降时，可以多喝一些淮山药粥，以健脾、补肾气";
		String s16 = "普通沐浴液和香皂大都呈碱性，可破坏弱酸环境，导致妇科疾病，应避免使用";
		String s17 = "睡觉时不穿内裤，能让阴道有透风、干燥的机会，防止感染";
		String s18 = "内裤要与其他衣服分开清洗，并且用温顺的洗衣剂清洗";
		otherSuggests.add(s1);
		otherSuggests.add(s2);
		otherSuggests.add(s3);
		otherSuggests.add(s4);
		otherSuggests.add(s5);
		otherSuggests.add(s6);
		otherSuggests.add(s7);
		otherSuggests.add(s8);
		otherSuggests.add(s9);
		otherSuggests.add(s10);
		otherSuggests.add(s11);
		otherSuggests.add(s12);
		otherSuggests.add(s13);
		otherSuggests.add(s14);
		otherSuggests.add(s15);
		otherSuggests.add(s16);
		otherSuggests.add(s17);
		otherSuggests.add(s18);
		maps.put("otherSuggests", otherSuggests);
		return maps;
	}

	/**
	 * 根据高压和低压计算指数
	 * @param ssa 高压
	 * @param sza 低压
	 * @return
	 */
	public static int calculateNumberByHighAndLow(double ssa,double sza){
		int number = 0;
		if(ssa<=90 && sza<=80){
			number=1*100/6;
		}else if((90<ssa && ssa<130) && (sza>60 && sza<110)){
			number=2*100/6;
		}else if((130<ssa && ssa<139) && (sza>85 && sza<120)){
			number=3*100/6;
		}else if((140<ssa && ssa<159) && (sza>90 && sza<130)){
			number=4*100/6;
		}else if((160<ssa && ssa<179) && (sza>100 && sza<150)){
			number=5*100/6;
		}else if(180<=ssa  && sza>=100){
			number=6*100/6;
		}
		return number;
	}

	/**
	 * 15-血压的分级和建议
	 * @param number 指数
	 * @return
	 */
	public static Map<String,Object> judgeBloodShow(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食
		List<String> sports = new ArrayList<String>();//运动
		if(number >= 0 && number <= 20){
			result="低血压";
			diseaseType = "血压偏低，请注意饮食。";
			String d1 = "合理膳食，少食用降压的食物如芹菜、冬瓜等";
			String d2 = "宜选择适当的高钠饮食，如牛肉干、虾皮等，每日摄入食盐12-15克";
			String d3 = "经常食用莲子、桂圆、大枣等果品，有助于养心益血，升高血压";
			String d4 = "纠正贫血，改善大脑供血，提高血压，宜适当多吃鸡肝、瘦肉等";
			String d5 = "宜选择适当高胆固醇饮食，如蛋黄、畜肉等";
			String d6 = "可经常食用枸杞、山药等，滋补肝肾，健脾养胃";
			String d7 = "建议多吃富含维生素C的水果如猕猴桃、橙子、苹果等";
			String d8 = "注意荤素搭配，少食用降压的食物：苦瓜、番茄等";
			String d9 = "建议适量饮用鲫鱼豆腐汤，板栗乌鸡汤等，有助于提高血压";
			diets.add(d1);
			diets.add(d2);
			diets.add(d3);
			diets.add(d4);
			diets.add(d5);
			diets.add(d6);
			diets.add(d7);
			diets.add(d8);
			diets.add(d9);
			String s1 = "慢跑：可以加速血液循环（建议每次持续15~30分钟）";
			String s2 = "下蹲：手扶桌沿，挺直腰背站立，做下蹲动作（建议每次持续15~30分钟）";
			String s3 = "太极拳：可提高心肺功能（建议每次持续15~30分钟）";
			String s4 = "舞蹈：有提高心肺功能（建议每次持续15~30分钟）";
			String s5 = "骑单车：能强化微血管组织，增强心肺功能（建议每次持续15~30分钟）";
			String s6 = "散步：加速新陈代谢，提高身体素质（建议每次15~30分钟）";
			String s7 = "保健操：可活血通脉。（建议每次持续15~30分钟）";
			sports.add(s1);
			sports.add(s2);
			sports.add(s3);
			sports.add(s4);
			sports.add(s5);
			sports.add(s6);
			sports.add(s7);
		}
		if(number > 20 && number <= 40){
			result="正常血压";
			diseaseType = "血压正常，继续保持";
		}
		if(number > 40 && number <= 60){
			result="正常高值";
			diseaseType = "血压偏高，请注意休息";
			String d1 = "限制钠盐，建议每天食盐摄入量小于6g";
			String d2 = "建议每天钙摄入1000mg，含钙高的食物有低脂牛奶、黑芝麻等";
			String d3 = "提倡吃复合糖类，可用紫米、燕麦来代替米饭、面粉制品";
			String d4 = "富含膳食纤维的水果如香蕉、苹果等，能促使脂肪消耗达到减肥降压的目的";
			String d5 = "榛子、葡萄干等坚果能降低血脂，保护血管，建议每天一小把";
			String d6 = "降压食物有芹菜、胡萝卜等；降脂食物有洋葱、大蒜等";
			String d7 = "增加钾离子摄入量，有利于降低血压，如四季豆、冬瓜等";
			diets.add(d1);
			diets.add(d2);
			diets.add(d3);
			diets.add(d4);
			diets.add(d5);
			diets.add(d6);
			diets.add(d7);
			String s1 = "按摩：按揉涌泉穴100下,可降低血管的外周阻力，使血压下降";
			String s2 = "散步：建议每次60分钟";
			String s3 = "慢跑：能改善颈椎及肩部的不适，增强体质（建议每次持续60分钟）";
			String s4 = "羽毛球：增加心血管功能，促进热量消耗（建议每次持续60分钟）";
			String s5 = "太极拳：建议每次持续60分钟";
			String s6 = "音乐疗法：经常听节奏平稳的音乐可辅助降压（建议每次持续10~15分钟）";
			String s7 = "舞蹈：可使患者心情舒畅，有利于血压下降（建议每次持续60分钟）";
			sports.add(s1);
			sports.add(s2);
			sports.add(s3);
			sports.add(s4);
			sports.add(s5);
			sports.add(s6);
			sports.add(s7);
		}
		if(number > 60 && number <= 70){
			result="一级高血压";
			diseaseType = "可能存在1级高血压的风险，请注意休息并参考以下建议";
			String d1 = "富含维生素C的食物如鲜枣、猕猴桃等，能保护血管，预防出血";
			String d2 = "摄入足量的钾，可辅助降压，含钾丰富的食物有赤豆、蚕豆等";
			String d3 = "提倡吃复合糖类，可用糙米、荞麦等来代替米饭、面粉制品";
			String d4 = "烹饪起锅前再撒盐，盐附着于食物表面，既有咸味，又不过量";
			String d5 = "减少含能量、糖分较高食物的摄入量，如碳酸饮料、油炸食品等";
			String d6 = "降压食物有番茄、木耳等；降脂食物有平菇、蘑菇等";
			String d7 = "富含膳食纤维的食物如芹菜、紫薯等，能减少胆固醇吸收，达到降压降脂的目的";
			diets.add(d1);
			diets.add(d2);
			diets.add(d3);
			diets.add(d4);
			diets.add(d5);
			diets.add(d6);
			diets.add(d7);
			String s1 = "太极拳：研究表明高血压患者打完一套太极拳之后，收缩压可下降10~15mmHg。（建议每次持续60分钟）";
			String s2 = "舞蹈：可使患者心情舒畅，有利于血压下降（建议每次持续60分钟）";
			String s3 = "骑自行车：促进血液循环，增强机体免疫力（建议每次持续60分钟）";
			String s4 = "散步：对于高血压患者建议每次持续60分钟，每分钟60～90步为宜";
			String s5 = "慢跑：有降脂、降压和促进血液循环的功效（建议每次持续60分钟）";
			String s6 = "按摩：按揉涌泉穴100下,可降低血管的外周阻力，使血压下降";
			String s7 = "音乐疗法：经常倾听节奏平稳的音乐可辅助降压（建议每次持续10~15分钟）";
			sports.add(s1);
			sports.add(s2);
			sports.add(s3);
			sports.add(s4);
			sports.add(s5);
			sports.add(s6);
			sports.add(s7);
		}
		if(number > 70 && number <= 90){
			result="二级高血压";
			diseaseType = "可能存在2级高血压的风险，请注意休息并及时就医";
			String d1 = "杏仁、花生等坚果能降低血脂，保护血管，建议每天一小把";
			String d2 = "限制钠盐的摄入量，酱油、味精也含有较高的盐分，应减少用量";
			String d3 = "镁能阻止胆固醇合成，降低血压，如花生、黑芝麻等可常吃";
			String d4 = "降压食物有海带、荸荠等；降脂食物有银耳、西兰花等";
			String d5 = "做菜时用胡椒粉来代替部分盐来调味，减少食盐摄入";
			String d6 = "提倡吃复合糖类，可用绿豆、红豆等来代替米饭、面粉制品";
			String d7 = "逐渐减少盐的摄入，有助于降低血压，切忌突然停止，影响体内水分平衡";
			diets.add(d1);
			diets.add(d2);
			diets.add(d3);
			diets.add(d4);
			diets.add(d5);
			diets.add(d6);
			diets.add(d7);
			String s1 = "同步甩手：自然站立，双手举至头顶，同步向上、下甩手，重复50~100次";
			String s2 = "捶打上臂：双脚弓步站立，双手交替互打左右上臂，重复50~100次";
			String s3 = "空跳绳：双手成握绳姿势，模仿跳绳动作，重复50~100次";
			String s4 = "高抬腿握拳：做高抬腿动作并双手握拳，上下挥动重复50~100次";
			String s5 = "空跳绳：双手成握绳姿势，模仿跳绳动作，重复50~100次";
			String s6 = "左右甩手：向与肩膀45°的方向用力甩手，左右交替进行，重复50~100次";
			String s7 = "捶打上臂：双脚弓步站立，双手交替互打左右上臂，重复50~100次";
			sports.add(s1);
			sports.add(s2);
			sports.add(s3);
			sports.add(s4);
			sports.add(s5);
			sports.add(s6);
			sports.add(s7);
		}
		if(number > 90){
			result="三级高血压";
			diseaseType = "可能存在3级高血压的风险，请注意休息并及时就医";
			String d1 = "妙招减盐:做汤时少用油、盐，尽量用虾皮紫菜来提鲜";
			String d2 = "富含膳食纤维的水果，如柠檬、柑橘等能使脂肪消耗达到减肥降压的目的";
			String d3 = "限制钠盐的摄入，建议每天食盐摄入量小于6g";
			String d4 = "建议每天钙摄入量为1000mg，含钙高的食物有低脂牛奶、黑芝麻等";
			String d5 = "维生素C能保护血管，预防出血，如柑橘、鲜枣等可常吃";
			String d6 = "少食或不食含钠盐较高的加工食品，如咸菜、腐乳等";
			String d7 = "高钾饮食能减轻高血压病情，如椰子、杏、哈密瓜等可常吃";
			diets.add(d1);
			diets.add(d2);
			diets.add(d3);
			diets.add(d4);
			diets.add(d5);
			diets.add(d6);
			diets.add(d7);
			String s1 = "拍打法：每天晨起，全身上下都可拍起来，力度由轻到微痛即可";
			String s2 = "人在受冷空气刺激的情况下，会使血管收缩痉挛，血压升高，应避免";
			String s3 = "晨起先仰卧5-10分钟，再慢慢坐起，可避免心脑血管病的发生";
			String s4 = "拍打法：每天晨起，全身上下都可拍起来，力度由轻到微痛即可";
			String s5 = "人在受冷空气刺激的情况下，会使血管收缩痉挛，血压升高，应避免";
			String s6 = "左右甩手：向与肩膀45°的方向用力甩手，左右交替进行，重复50~100次";
			String s7 = "晨起先仰卧5-10分钟，再慢慢坐起，可避免心脑血管病的发生";
			sports.add(s1);
			sports.add(s2);
			sports.add(s3);
			sports.add(s4);
			sports.add(s5);
			sports.add(s6);
			sports.add(s7);
		}

		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(sports.isEmpty()==false){
			int spr = (int)(Math.random()*sports.size());
			sportSuggest = sports.get(spr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("sportSuggest", sportSuggest);
		dietSuggest = null;
		sportSuggest = null;
		diseaseType = null;
		result = null;
		return maps;
	}


	/**
	 * 4-心肌梗死的分级和建议
	 * @param number
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> judgeHeartAttack(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(number >= 0 && number <= 50){
			result = "正常";
			diseaseType = "目前处于正常状态，请继续保持。";
		}else if(number > 50 && number <= 80){
			result = "偏高";
			diseaseType = "指数偏高，可能存在心肌梗死的风险，请注意休息。";
			Map<String,Object> coronaryHeartDiseaseMaps = addHeartAttackList();
			diets = (List<String>) coronaryHeartDiseaseMaps.get("diets");
			otherSuggests = (List<String>) coronaryHeartDiseaseMaps.get("otherSuggests");
		}else if(number > 80 && number <= 100){
			result = "高";
			diseaseType = "指数高，可能存在心肌梗死的风险，请及时就医。";
			Map<String,Object> coronaryHeartDiseaseMaps = addHeartAttackList();
			diets = (List<String>) coronaryHeartDiseaseMaps.get("diets");
			otherSuggests = (List<String>) coronaryHeartDiseaseMaps.get("otherSuggests");
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("otherSuggest", otherSuggest);
		dietSuggest = null;
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}


	/**
	 * 心肌梗死的偏高和高的文案的工具类
	 * @return
	 */
	public static Map<String,Object> addHeartAttackList(){
		List<String> diets = new ArrayList<String>();//饮食
		List<String> otherSuggests = new ArrayList<String>();//其他
		Map<String,Object> maps = new HashMap<String,Object>();
		String d1 = "维生素E缺乏时，会增加心肌梗死及脑卒中的危险性，如坚果、豆类等可适当补充";
		String d2 = "忌食猪油、油炸食品等高脂肪食物，长期食用冠状动脉易形成血栓，发生心肌梗死";
		String d3 = "忌食辣椒、花椒等辛辣食物，易引起便秘，导致排便时心肌耗氧量增加，加重梗死症状";
		String d4 = "动物内脏、蛋黄等高胆固醇食物，可加重梗死灶缺氧缺血的症状";
		String d5 = "钠摄入过多，可使血压升高，心肌梗死的病人每日食盐量应少于4克";
		String d6 = "心肌梗死病平时要吃半流食和易消化的软食，一日进餐4-5次";
		diets.add(d1);
		diets.add(d2);
		diets.add(d3);
		diets.add(d4);
		diets.add(d5);
		diets.add(d6);
		String o1 = "洗澡时水温控制在25-40℃之间，过高会引起头晕、胸闷等症状，严重者可导致晕厥、心肌梗死等";
		String o2 = "便秘者过于用力排便，会出现血压升高、头晕、心悸等症状，甚至诱发心绞痛、心肌梗死";
		String o3 = "要重视口腔卫生，做到多饮水，勤漱口，每日刷牙2-3次，避免增加血液粘稠度";
		String o4 = "情绪激动会加速血液循环，易诱发心肌梗死，心血管病患者应避免情绪激动";
		String o5 = "在心肌梗死前一两个月，通常都会出现胸闷现象，病发前一两天，人会特别累，感到很闷";
		otherSuggests.add(o1);
		otherSuggests.add(o2);
		otherSuggests.add(o3);
		otherSuggests.add(o4);
		otherSuggests.add(o5);
		maps.put("diets", diets);
		maps.put("otherSuggests", otherSuggests);
		return maps;
	}

	/**
	 * 9-脑梗塞的分级和建议
	 * @param number
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> judgeCerebralInfarction(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(number >= 0 && number <= 50){
			result = "正常";
			diseaseType = "目前处于正常状态，请继续保持。";
		}else if(number > 50 && number <= 80){
			result = "偏高";
			diseaseType = "指数偏高，可能存在脑梗塞的风险，请注意休息。";
			Map<String,Object> coronaryHeartDiseaseMaps = addCerebralInfarctionList();
			diets = (List<String>) coronaryHeartDiseaseMaps.get("diets");
			otherSuggests = (List<String>) coronaryHeartDiseaseMaps.get("otherSuggests");
		}else if(number > 80 && number <= 100){
			result = "高";
			diseaseType = "指数高，可能存在脑梗塞的风险，请及时就医。";
			Map<String,Object> coronaryHeartDiseaseMaps = addCerebralInfarctionList();
			diets = (List<String>) coronaryHeartDiseaseMaps.get("diets");
			otherSuggests = (List<String>) coronaryHeartDiseaseMaps.get("otherSuggests");
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("otherSuggest", otherSuggest);
		dietSuggest = null;
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}

	/**
	 * 脑梗塞的偏高和高的文案的工具类
	 * @return
	 */
	public static Map<String,Object> addCerebralInfarctionList(){
		List<String> diets = new ArrayList<String>();//饮食
		List<String> otherSuggests = new ArrayList<String>();//其他
		Map<String,Object> maps = new HashMap<String,Object>();
		String d1 = "素菜和水果含有大量维生素Ｃ，可防止动脉硬化的发展";
		String d2 = "常用植物油，植物油含不饱和脂肪酸，可降低血清胆固醇";
		String d3 = "少吃动物脂肪如动物内脏、蛋黄等含胆固醇较高，可增加动脉硬化发生的概率";
		String d4 = "减少食盐的摄入，钠离子会进入血管壁，使其增厚，血压增高";
		String d5 = "饮食清淡不过饱，进食量应适当，否则身体过胖可加重心脏负担";
		String d6 = "适当进食海产品如海带、海鱼等，可降低胆固醇，防止动脉硬化";
		String d7 = "蛋白质含动物蛋白和豆类蛋白，以供应身体必需氨基酸，饮牛奶以去脂为佳";
		String d8 = "在炒菜时加一些醋、番茄酱，不仅可以调味，还可加速脂肪的溶解";
		String d9 = "芝麻酱含钙量高，经常食用可补充钙，对防止脑出血有一定好处";
		String d10 = "适量增加蛋白质，可由瘦肉，去皮禽类提供，可降低血液胆固醇";
		String d11 = "每日吃适量的豆制品如豆腐，豆干等，对降低血液胆固醇及血液粘滞有利";
		String d12 = "长期大量的进食三高食物，可以导致血脂增高，影响脑梗塞的治疗";
		String d13 = "辛辣食物如辣椒、芥末等，会直接刺激脑袋的血管，引发脑出血";
		String d14 = "烟中的尼古丁可损害血管内膜，引起小血管收缩，因而容易形成血栓";
		String d15 = "香菇可降低血液中胆固醇，降低血压，对高血压、动脉硬化有良好疗效";
		String d16 = "芹菜可降低血中胆固醇含量，对防治高血压、脑血管意外等，有一定疗效";
		String d17 = "山楂具有活血化瘀降血压、降血脂等作用，是心脑血管病患者的佳品";
		String d18 = "含碘的食物如海带、虾米等，可减少胆固醇在动脉壁沉积，预防动脉硬化";
		String d19 = "为预防便秘， 应多吃一些富含纤维的食物， 如青菜﹑韭菜及水果等";
		String d20 = "脑梗塞的病人有食盐的用量要小，要采用低盐饮食，每日食盐3克";
		String d21 = "要经常饮水，尤其在清晨和夜间，稀释血液，防止血栓的形成";
		diets.add(d1);
		diets.add(d2);
		diets.add(d3);
		diets.add(d4);
		diets.add(d5);
		diets.add(d6);
		diets.add(d7);
		diets.add(d8);
		diets.add(d9);
		diets.add(d10);
		diets.add(d11);
		diets.add(d12);
		diets.add(d13);
		diets.add(d14);
		diets.add(d15);
		diets.add(d16);
		diets.add(d17);
		diets.add(d18);
		diets.add(d19);
		diets.add(d20);
		diets.add(d21);
		String o1 = "脑梗塞不能中断药物治疗，以防止脑梗塞反复及加重病情";
		String o2 = "降压过度是诱发脑梗塞的重要原因，必须正确应用降压药";
		String o3 = "生活不规律、劳累过度或休息不好，易引起血压波动，诱发脑梗塞";
		String o4 = "大量引用烈性酒，对血管有害无益，酗酒是引起脑梗塞的诱因之一";
		String o5 = "暴怒或忧郁可引起血管神经调节失常，是诱发脑梗塞的重要原因";
		String o6 = "寒冷刺激可引起小血管收缩，血液粘稠度增加，易诱发脑梗塞";
		String o7 = "脱水可使血液粘稠度增高，容易引起脑梗塞复发";
		otherSuggests.add(o1);
		otherSuggests.add(o2);
		otherSuggests.add(o3);
		otherSuggests.add(o4);
		otherSuggests.add(o5);
		otherSuggests.add(o6);
		otherSuggests.add(o7);
		maps.put("diets", diets);
		maps.put("otherSuggests", otherSuggests);
		return maps;
	}


	/**
	 * 10-脑出血的分级和建议
	 * @param number
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> judgeCerebralHemorrhage(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(number >= 0 && number <= 50){
			result = "正常";
			diseaseType = "目前处于正常状态，请继续保持。";
		}else if(number > 50 && number <= 80){
			result = "偏高";
			diseaseType = "指数偏高，可能存在脑出血的风险，请注意休息。";
			Map<String,Object> coronaryHeartDiseaseMaps = addCerebralHemorrhageList();
			diets = (List<String>) coronaryHeartDiseaseMaps.get("diets");
			otherSuggests = (List<String>) coronaryHeartDiseaseMaps.get("otherSuggests");
		}else if(number > 80 && number <= 100){
			result = "高";
			diseaseType = "指数高，可能存在脑出血的风险，请及时就医。";
			Map<String,Object> coronaryHeartDiseaseMaps = addCerebralHemorrhageList();
			diets = (List<String>) coronaryHeartDiseaseMaps.get("diets");
			otherSuggests = (List<String>) coronaryHeartDiseaseMaps.get("otherSuggests");
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("otherSuggest", otherSuggest);
		dietSuggest = null;
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}

	/**
	 * 脑出血的偏高和高的文案的工具类
	 * @return
	 */
	public static Map<String,Object> addCerebralHemorrhageList(){
		List<String> diets = new ArrayList<String>();//饮食
		List<String> otherSuggests = new ArrayList<String>();//其他
		Map<String,Object> maps = new HashMap<String,Object>();
		String d1 = "新鲜的蔬菜和水果中富含维生素C和钾、镁等，可降低胆固醇，保护血管";
		String d2 = "含碘的食物如海带、虾米等，可减少胆固醇在动脉壁沉积，防止动脉硬化";
		String d3 = "为预防便秘，应多吃一些富含膳食纤维的食物，如芹菜﹑韭菜等";
		String d4 = "要保证体内有充足的水，使血液稀释，晚睡前﹑晨起时，饮1～2杯温开水";
		String d5 = "饮食中应有适当蛋白质，常吃些瘦肉、鱼类，以供给身体所需要的氨基酸";
		String d6 = "鱼子、肥肉等食物，所含的饱和脂肪酸可使胆固醇明显升高，促进动脉硬化";
		String d7 = "过量的冷饮食品进入胃肠后，会使血管收缩，血压升高，易诱发脑溢血";
		String d8 = "膳食中要控制总的脂肪量，烹调时不用动物油，而用植物油";
		String d9 = "脑出血患者的食物中要控制食盐量，每日6克以下为宜";
		String d10 = "注意少吃些高脂肪的食物，这类食物易导致血脂增高，从而堵塞血管";
		String d11 = "多吃富含膳食纤维的食物（粗粮、蔬菜等），尽量少吃蔗糖、糕点等";
		String d12 = "限制总热量，控制体重在标准或接近标准体重范围";
		String d13 = "牛奶能降低血脂及胆固醇，建议每日饮牛奶及酸牛奶各一杯";
		String d14 = "常食豆类和豆制品，可促进胆固醇的排出，降低心脑血管的发病概率";
		String d15 = "脑出血患者忌用兴奋神经系统的食物，如浓茶、咖啡及刺激性强的调味品";
		String d16 = "猕猴桃、青菜等富含维生素C，可降低胆固醇并增强血管致密性，预防出血";
		String d17 = "日常饮食要少喝鸡汤、肉汤等，对保护心脑血管有益";
		diets.add(d1);
		diets.add(d2);
		diets.add(d3);
		diets.add(d4);
		diets.add(d5);
		diets.add(d6);
		diets.add(d7);
		diets.add(d8);
		diets.add(d9);
		diets.add(d10);
		diets.add(d11);
		diets.add(d12);
		diets.add(d13);
		diets.add(d14);
		diets.add(d15);
		diets.add(d16);
		diets.add(d17);
		String o1 = "定期检查身体健康状况 ,防止出现血压反跳及过度波动";
		String o2 = "患有动脉硬化时 ,应及早治疗并注意饮食 ,以降低血脂 ,保持血管的弹性";
		String o3 = "在日常的生活和工作中 ,应避免情绪过度激动 ,以防止血压突增";
		String o4 = "体力劳动和脑力劳动不要过于劳累，超负荷工作可诱发脑出血";
		String o5 = "要保持大便畅通 ,定时排便。排便时避免过度用力 ,以防血压突然增高";
		String o6 = "根据季节变化做好身体冷暖调节工作 ,以免血管舒缩功能障碍而发生意外";
		String o7 = "体位改变幅度较大时 ,动作必须缓慢 ,以防头部一时供血不足而发生意外";
		String o8 = "选择自己喜爱并力所能及的体育项目 ,锻炼时避免剧烈运动或过度疲劳";
		String o9 = "为防脑溢血的发生，可常用左手转动两个健身球，帮助锻炼右脑半球";
		String o10 = "如出现无诱因的头痛、肢体麻木、一时性失视、交流困难等，应及时就医";
		otherSuggests.add(o1);
		otherSuggests.add(o2);
		otherSuggests.add(o3);
		otherSuggests.add(o4);
		otherSuggests.add(o5);
		otherSuggests.add(o6);
		otherSuggests.add(o7);
		otherSuggests.add(o8);
		otherSuggests.add(o9);
		otherSuggests.add(o10);
		maps.put("diets", diets);
		maps.put("otherSuggests", otherSuggests);
		return maps;
	}


	/**
	 * 15-积食的分级和建议
	 * @param number
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> judgeForthwith(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(number >= 0 && number <= 40){
			result = "正常";
			diseaseType = "目前处于正常状态。";
		}else if(number > 40 && number <= 80){
			result = "可能积食";
			diseaseType = "可能存在积食风险，请注意饮食";
			Map<String,Object> forthwithMaps = addForthwithList();
			diets = (List<String>) forthwithMaps.get("diets");
			otherSuggests = (List<String>) forthwithMaps.get("otherSuggests");
		}else if(number > 80 && number <= 100){
			result = "积食";
			diseaseType = "目前处于积食的状态，请注意饮食并及时就医";
			Map<String,Object> forthwithMaps = addForthwithList();
			diets = (List<String>) forthwithMaps.get("diets");
			otherSuggests = (List<String>) forthwithMaps.get("otherSuggests");
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("otherSuggest", otherSuggest);
		dietSuggest = null;
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}
	/**
	 * 12-喝酒检测的分级和建议
	 * @param number
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> judgeDrinkWater(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(number >= 0 && number <= 50){
			result = "正常";
			diseaseType = "目前处于正常状态，请继续保持。";
		}else if(number > 50 && number <= 90){
			result = "饮酒";
			diseaseType = "目前处于饮酒的状态，建议您适量饮酒。";
			Map<String,Object> drinkWaterMaps = addDrinkWaterList();
			diets = (List<String>) drinkWaterMaps.get("diets");
			otherSuggests = (List<String>) drinkWaterMaps.get("otherSuggests");
		}else if(number > 90 && number <= 100){
			result = "醉酒";
			diseaseType = "目前处于醉酒的状态，请注意休息。";
			Map<String,Object> drinkWaterMaps = addDrinkWaterList();
			diets = (List<String>) drinkWaterMaps.get("diets");
			otherSuggests = (List<String>) drinkWaterMaps.get("otherSuggests");
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("otherSuggest", otherSuggest);
		dietSuggest = null;
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}

	/**
	 * 喝酒检测的偏高和高的文案的工具类
	 * @return
	 */
	public static Map<String,Object> addDrinkWaterList(){
		List<String> diets = new ArrayList<String>();//饮食
		List<String> otherSuggests = new ArrayList<String>();//其他
		Map<String,Object> maps = new HashMap<String,Object>();
		String d1 = "饮酒前先喝一杯牛奶或酸奶，或吃几片面包，勿空腹喝酒，以免刺激胃黏膜";
		String d2 = "喝白酒时，要多喝白开水，以利于酒精尽快随尿排出体外；喝啤酒时，要勤上厕所；喝烈酒时最好加冰块";
		String d3 = "喝酒不宜过快过猛，应当慢慢喝，让身体有时间分解体内的乙醇。酒桌上罚酒数杯或一口闷易醉酒";
		String d4 = "喝酒时多吃绿叶蔬菜，其中的抗氧化剂和维生素可保护肝脏";
		String d5 = "喝酒时不要喝碳酸饮料，如可乐、汽水等，以免加快身体吸收酒精的速度";
		String d6 = "喝酒者可多吃富含B族维生素的食物如燕麦、瘦肉等，能修复酒精造成胃黏膜充血，溃烂";
		String d7 = "萝卜醒酒法：将500克鲜萝卜捣碎取汁，1次饮服，或适量吃些生白萝卜，都有醒酒之效";
		String d8 = "绿豆醒酒法：取50克绿豆，加适量红糖煎服，可醒酒";
		String d9 = "糖水醒酒法：取适量白糖用开水冲服，有解酒、醒脑的作用";
		String d10 = "醋醒酒法：取50克米醋或陈醋，加25克红糖、3片生姜煎汤饮服，可减轻酒精对人体的损害";
		String d11 = "藕醒酒法：将鲜藕捣烂取汁饮服，对消除醉酒症状有一定的作用";
		String d12 = "番薯醒酒法：醉酒后，可将生番薯切细，拌入白糖服食，即可解酒";
		String d13 = "牛奶醒酒法：醉酒者可饮些牛奶，以便使蛋白凝固，保护胃粘膜，缓解对酒精的吸收";
		String d14 = "甘蔗汁醒酒法：醉酒神志尚清醒者可自己嚼食甘蔗，严重者可榨出甘蔗汁灌服，能醒酒";
		String d15 = "皮蛋醒酒法：醉酒时，取1-2只皮蛋，蘸醋服食，可以醒酒";
		String d16 = "白菜醒酒法：将大白菜心切成细丝，加白糖、醋拌匀，当凉菜服食，对消除酒醉有一定的作用";
		String d17 = "生梨醒酒法：吃几个梨或将梨去皮切片，浸入凉开水中10分钟，吃梨饮水，可解酒";
		String d18 = "米汤醒酒法：醉酒者可取浓米汤饮服，米汤中含有多糖类及B族维生素，有解毒醒酒之效";
		String d19 = "杨桃醒酒法：醋渍杨桃1个，加水煎服，可用于醒酒";
		String d20 = "花露水醒酒法：洒数滴花露水在热毛巾上，轻轻擦试醉酒者的胸背、肘和太阳穴等处就可明显减轻其醉意";
		String d21 = "茶叶醒酒法：醉酒后可饮浓茶，茶叶中的单宁酸能解除急性酒精中毒，咖啡碱、茶碱对呼吸抑制及昏睡现象有疗效";
		String d22 = "豆腐解酒：饮酒时宜多以豆腐菜肴作下酒菜。因为豆腐中半脱氨酸是一种主要的氨基酸，它能解乙醇的毒性，食后可促进酒中的乙醇迅速排泄";
		String d23 = "不要开冷风：如果你有喝完酒发热的经历，这是因为酒精的热量不能在体内储存，而是向外散发。如果此时开冷风，就抑制了酒精的散发，不利于解酒";
		String d24 = "喝酒之后唱歌是非常不错的解酒方式，可以通过呼吸散发酒精，有利于解酒";
		String d25 = "喝完酒后不要马上坐车回家，汽车内密闭的空气不利于酒精排出，可稍微沿着马路快走一会，因为运动出汗可以加速酒精代谢";
		diets.add(d1);
		diets.add(d2);
		diets.add(d3);
		diets.add(d4);
		diets.add(d5);
		diets.add(d6);
		diets.add(d7);
		diets.add(d8);
		diets.add(d9);
		diets.add(d10);
		diets.add(d11);
		diets.add(d12);
		diets.add(d13);
		diets.add(d14);
		diets.add(d15);
		diets.add(d16);
		diets.add(d17);
		diets.add(d18);
		diets.add(d19);
		diets.add(d20);
		diets.add(d21);
		diets.add(d22);
		diets.add(d23);
		diets.add(d24);
		diets.add(d25);
		String o1 = "饮酒后驾车，由于酒精的麻醉作用，人的手、脚的触觉较平时降低，往往无法正常控制油门、刹车及方向盘";
		String o2 = "饮酒后，对光、声刺激反应时间延长，本能反射动作的时间也相应延长，感觉器官和运动器官如眼、手、脚之间的配合功能发生障碍，因此，无法正确判断距离、速度";
		String o3 = "饮酒后可使视力暂时受损，视像不稳，辨色能力下降，因此不能发现和正确领会交通信号、标志和标线";
		String o4 = "饮酒后视野减小，视像模糊，眼睛只盯着前方目标，对处于视野边缘的危险隐患难以发现，易发生事故";
		String o5 = "在酒精的刺激下，人有时会过高地估计自己，对周围人的劝告常不予理睬，往往干出一些力不从心的事";
		String o6 = "饮酒后易困倦，表现为行驶不规律，空间视觉差等疲劳驾驶的行为";
		otherSuggests.add(o1);
		otherSuggests.add(o2);
		otherSuggests.add(o3);
		otherSuggests.add(o4);
		otherSuggests.add(o5);
		otherSuggests.add(o6);
		maps.put("diets", diets);
		maps.put("otherSuggests", otherSuggests);
		return maps;
	}
	/**
	 * 13-血管阻滞度的分级和建议
	 * @param number
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> judgeArteriosclerosisDegree(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(number >= 0 && number <= 35){
			result = "正常";
			diseaseType = "目前处于正常状态。";
		}else if(number > 35 && number <= 70){
			result = "Ⅰ度";
			diseaseType = "可能存在血管阻滞的风险，建议您及时就医";
			Map<String,Object> arteriosclerosisDegreeMaps = addArteriosclerosisDegreeList();
			diets = (List<String>) arteriosclerosisDegreeMaps.get("diets");
			otherSuggests = (List<String>) arteriosclerosisDegreeMaps.get("otherSuggests");
		}else if(number > 70){
			result = "Ⅱ度";
			diseaseType = "可能存在血管阻滞的风险，建议您及时就医。";
			Map<String,Object> arteriosclerosisDegreeMaps = addArteriosclerosisDegreeList();
			diets = (List<String>) arteriosclerosisDegreeMaps.get("diets");
			otherSuggests = (List<String>) arteriosclerosisDegreeMaps.get("otherSuggests");
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("otherSuggest", otherSuggest);
		dietSuggest = null;
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}
	/**
	 * 血管阻滞度的偏高和高的文案的工具类
	 * @return
	 */
	public static Map<String,Object> addArteriosclerosisDegreeList(){
		List<String> diets = new ArrayList<String>();//饮食
		List<String> otherSuggests = new ArrayList<String>();//其他
		Map<String,Object> maps = new HashMap<String,Object>();
		String d1 = "每日要吃一定量的豆制品，如豆腐，豆干，对降低血液粘滞有利";
		String d2 = "合理饮食，少吃油腻食物，控制钠盐摄入可减少血管硬化";
		String d3 = "多食高脂肪、刺激性强的食物会堵塞血管，应尽量少食用";
		String d4 = "可多吃一些菌类食物如黑木耳、金针菇等，可清除血管垃圾，减少血管阻滞";
		String d5 = "西红柿中的维生素能帮助人体消除血管垃圾，可减少血管阻滞的发生";
		String d6 = "茶叶中含有的茶多酚还能够缓解血液高凝状态，可适当饮用";
		String d7 = "黑豆富含花青素能够降低胆固朜，促进血液的循环，降低血管阻塞";
		String d8 = "蜂蜜含有丰富的维生素能改善血管的血液循环，降低血管阻塞";
		String d9 = "番薯多吃可减少血浆胆固醇的含量，避免血管阻滞度的发生";
		String d10 = "火麻仁做成茶喝，可降低血液中的中性脂质，清除胆固醇";
		String d11 = "玉米可以减少胆固醇在血管中的沉积，从而软化血管";
		String d12 = "大蒜可消除积存在血管中的脂肪,清除血管垃圾，减少血管堵塞";
		String d13 = "清晨起床后可饮低渗盐水既能稀释血液，又能刺激胃肠蠕动、促进排便";
		String d14 = "柠檬可疏通血管，常喝柠檬水可帮助疏通血管，减缓血管堵塞";
		String d15 = "燕麦中的维生素E可清除血管垃圾，经常食用，可避免血管堵塞";
		String d16 = "含膳食纤维高的食物，有助于疏通血管，如苹果、芹菜等";
		String d17 = "油炸类食物中的反式脂肪酸可导致血栓，堵塞血管，应尽量少食";
		String d18 = "洋葱是唯一含有前列腺A的蔬菜，可稀释血液，降低血液粘稠度";
		String d19 = "生姜含有抗凝血的姜油酮、姜烯酚等物质，经常食用可以让血液流通顺畅";
		String d20 = "海带不仅含碘，还含有胶质，其中胶质成分可结合血液中的有害物质，净化血液";
		String d21 = "鱼肉富含脯氨酸、赖氨酸等，有改善血管弹性、顺应性及促进钠盐排泄的作用";
		String d22 = "多吃含精氨酸的食物，有助调节血管张力、抑制血小板聚集，如芝麻、山药等";
		String d23 = "多吃富含叶酸的食物，缺乏叶酸易促进粥样硬化斑块形成，如菠菜、芦笋等";
		diets.add(d1);
		diets.add(d2);
		diets.add(d3);
		diets.add(d4);
		diets.add(d5);
		diets.add(d6);
		diets.add(d7);
		diets.add(d8);
		diets.add(d9);
		diets.add(d10);
		diets.add(d11);
		diets.add(d12);
		diets.add(d13);
		diets.add(d14);
		diets.add(d15);
		diets.add(d16);
		diets.add(d17);
		diets.add(d18);
		diets.add(d19);
		diets.add(d20);
		diets.add(d21);
		diets.add(d22);
		diets.add(d23);
		String o1 = "适当的健身锻炼可以控制体重，等于经常让血管做体操，可以增强血管弹性，防止老化";
		String o2 = "生活习惯要健康，不要抽烟，喝酒，避免情绪激动及过度劳累";
		String o3 = "血管堵塞，往往是因为高血脂、高血压引起严格控制血压、血糖、血脂等脑血管病危险因素";
		String o4 = "饭前运动半小时，都能起到减肥消脂的作用，提高血管“年轻化”程度";
		otherSuggests.add(o1);
		otherSuggests.add(o2);
		otherSuggests.add(o3);
		otherSuggests.add(o4);
		maps.put("diets", diets);
		maps.put("otherSuggests", otherSuggests);
		return maps;
	}

	/**
	 * 积食的偏高和高的文案的工具类
	 * @return
	 */
	public static Map<String,Object> addForthwithList(){
		List<String> diets = new ArrayList<String>();//饮食
		List<String> otherSuggests = new ArrayList<String>();//其他
		Map<String,Object> maps = new HashMap<String,Object>();
		String d1 = "养成良好的生活习惯，注意饮食及生活规律，不暴饮暴食";
		String d2 = "粗纤维食物可促进肠道蠕动，如玉米、芹菜等可适量常吃";
		String d3 = "水可以加速肠胃蠕动，带动体内循环加快，缓解因积食产生的胃疼胃涨现象";
		String d4 = "将适量的柚子皮切成丝与水同煮，代茶饮服，能消食、开胃、通气";
		String d5 = "积食后可适量吃蔬菜水果，能促进胃肠蠕动，防止便秘，缓解胃部涨疼";
		String d6 = "辛辣食物会刺激肠胃，加重肠胃负担，所以在积食阶段要禁食辛辣的食物";
		String d7 = "在积食期多喝蜂蜜水，不仅可以缓解便秘，还有促进消化的作用";
		String d8 = "零食吃多了会影响食欲，导致积食。所以零食要适当的吃，以正餐为主";
		String d9 = "应尽量少食油腻、煎炸、冷饮类的食物，容易损伤脾胃，导致积食";
		String d10 = "果汁里含有丰富的维生素，常喝能够润滑肠道，帮助消化";
		String d11 = "喝白萝卜煮的汤能够通肠胃，胃食积后饮用可以清出肠道中多余的东西";
		String d12 = "积食期适量喝点酸奶，能调整肠道菌群，促进消化吸收，改善胃肠道功能";
		String d13 = "取冰糖适量，入锅炒化，加入山楂翻炒5-6分钟，饭后吃一点，可缓解积食";
		String d14 = "常吃土豆、红薯可以通便排毒，增强肠道蠕动，对积食有很好的帮助";
		String d15 = "晚饭不宜吃得过晚，避免吃的油腻，以清淡少量为主，可预防积食";
		String d16 = "葱、姜、大蒜等刺激性食物，会影响胃肠消化，积食期应少食用";
		String d17 = "饭后半小时之内不喝水，不吃水果。以防胃酸被稀释，对消化和吸收都不好";
		diets.add(d1);
		diets.add(d2);
		diets.add(d3);
		diets.add(d4);
		diets.add(d5);
		diets.add(d6);
		diets.add(d7);
		diets.add(d8);
		diets.add(d9);
		diets.add(d10);
		diets.add(d11);
		diets.add(d12);
		diets.add(d13);
		diets.add(d14);
		diets.add(d15);
		diets.add(d16);
		diets.add(d17);
		String o1 = "捏脊：积食者面孔朝下平卧，另一人用拇指、食指和中指捏其脊柱两侧，随捏随按，由下而上，再从上而下，捏3-5遍，每晚一次";
		String o2 = "揉中脘：用手掌根旋转按揉中脘穴位（胸中与肚脐连线的二分之一处），每日两次，可缓解积食";
		String o3 = "摩涌泉：足底心即是涌泉穴。以拇指压按涌泉穴，旋转按摩30-50下，每日两次";
		String o4 = "揉摩：在胃部左边用手掌心或掌根顺时针轻摩30下，每天1~2次，摩推后胃脘部会觉得酣畅不少";
		String o5 = "调理心境：坏心境也会影响食欲和减轻胃肠蠕动紊乱，所以心态要乐观开朗些";
		String o6 = "每天饭后休息10分钟左右再去做点适量运动，比如散步、慢跑等，可以加速胃肠蠕动，帮助人体消化";
		String o7 = "养成饭后走动的习惯，可在家里做高抬腿运动，活动腰部和腹部，帮助消化";
		otherSuggests.add(o1);
		otherSuggests.add(o2);
		otherSuggests.add(o3);
		otherSuggests.add(o4);
		otherSuggests.add(o5);
		otherSuggests.add(o6);
		otherSuggests.add(o7);
		maps.put("diets", diets);
		maps.put("otherSuggests", otherSuggests);
		return maps;
	}

	/**
	 * 16-睡眠监测的分级和建议
	 * @param number
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> judgeSleepualityQ(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(number >= 0 && number <= 50){
			result = "睡眠质量好";
			diseaseType = "睡眠质量非常好，继续保持：";
		}else if(number > 50 && number <= 70){
			result = "睡眠质量一般";
			diseaseType = "睡眠质量一般，请注意休息：";
			Map<String,Object> SleepualityQMaps = addSleepualityQList();
			diets = (List<String>) SleepualityQMaps.get("diets");
			otherSuggests = (List<String>) SleepualityQMaps.get("otherSuggests");
		}else if(number > 70 && number <= 100){
			result = "睡眠质量差";
			diseaseType = "睡眠质量差，建议立即休息：";
			Map<String,Object> SleepualityQMaps = addSleepualityQList();
			diets = (List<String>) SleepualityQMaps.get("diets");
			otherSuggests = (List<String>) SleepualityQMaps.get("otherSuggests");
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("otherSuggest", otherSuggest);
		dietSuggest = null;
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}

	/**
	 * 睡眠质量的偏高和高的文案的工具类
	 * @return
	 */
	public static Map<String,Object> addSleepualityQList(){
		List<String> diets = new ArrayList<String>();//饮食
		List<String> otherSuggests = new ArrayList<String>();//其他
		Map<String,Object> maps = new HashMap<String,Object>();
		String d1 = "睡前可以吃点如百合莲子羹、桂圆银耳汤等食物，以清心养心、健脑和胃";
		String d2 = "全麦面包中的维生素B含量丰富，而维生素B能起到促进睡眠的作用";
		String d3 = "小米粥中的成分，能使我们更快进入睡眠模式，提高我们的睡眠质量";
		String d4 = "葡萄中含有能辅助睡眠的物质--褪黑素，对改善失眠有很好的作用";
		String d5 = "用莲子、龙眼、百合配粟米熬粥，有令人入睡的疗效";
		String d6 = "血虚失眠者，可常服藕粉，或用小火煨藕加蜂蜜适量吃";
		String d7 = "取芭蕉根50g，猪瘦肉100g，同煮服用，能催眠入睡";
		String d8 = "莴笋中有一种乳白色浆液，具有安神镇静的作用，可促进睡眠";
		String d9 = "苹果、橘子等水果的芳香味，对神经系统有镇静作用，可适量食用";
		String d10 = "洋葱捣烂装瓶盖好，临睡前放在枕边嗅闻其气，片刻之后便可入睡";
		String d11 = "睡前喝茶、喝咖啡等这些不良生活习惯也会造成睡眠不好和失眠";
		String d12 = "牛奶中的色氨酸和肽类具有缓解疲劳、安眠的作用，每天可适量饮用";
		String d13 = "核桃能改善神经衰弱、健忘、失眠等症状，每天可吃些核桃仁，有利睡眠";
		String d14 = "临睡前将一汤匙食醋倒入一杯温开水中喝下，能够提高睡眠质量";
		String d15 = "燕麦富含松果体素，能促进睡眠，可适量食用牛奶燕麦粥、红枣燕麦粥等";
		String d16 = "火鸡富含人体必需氨基酸—色胺酸，适量食用可促进睡眠";
		String d17 = "菊花茶具有适度的镇静效果，适量食用可放松神经，促进睡眠";
		String d18 = "莲子心加盐少许，水煎，每晚睡前服，有养心安神的作用";
		String d19 = "香蕉除了能平稳血清素和褪黑素，还含有让肌肉松弛的镁元素，有利于睡眠";
		String d20 = "桂圆具有补益心脾、养血安神的作用，失眠健忘、神经衰弱等可适量食用";
		String d21 = "将土豆混合温奶做成土豆泥，能有效提高睡眠质量";
		String d22 = "杏仁既含有色胺酸，又含有适量的肌肉松弛剂――镁，可适量食用";
		String d23 = "亚麻籽富含欧米加-3脂肪酸，喝燕麦粥时适量加入，有助于睡眠";
		String d24 = "全麦面包有助于胰岛素转变成血清素，使色胺酸对大脑产生影响，促进睡眠";
		String d25 = "睡前喝1杯热糖水，使大脑皮层受到抑制，会很快入睡";
		String d26 = "可用鲜百合60-90克与蜂蜜适量拌和，蒸熟，睡前服，有清心安神的作用";
		String d27 = "橙子、梨等水果的糖分，能使大脑皮质抑制而易进入睡眠状态，可适量食用";
		diets.add(d1);
		diets.add(d2);
		diets.add(d3);
		diets.add(d4);
		diets.add(d5);
		diets.add(d6);
		diets.add(d7);
		diets.add(d8);
		diets.add(d9);
		diets.add(d10);
		diets.add(d11);
		diets.add(d12);
		diets.add(d13);
		diets.add(d14);
		diets.add(d15);
		diets.add(d16);
		diets.add(d17);
		diets.add(d18);
		diets.add(d19);
		diets.add(d20);
		diets.add(d21);
		diets.add(d22);
		diets.add(d23);
		diets.add(d24);
		diets.add(d25);
		diets.add(d26);
		diets.add(d27);
		String o1 = "一个良好的环境能够使人心旷神怡，精神振奋，有利于提高睡眠质量";
		String o2 = "较强的噪声长时间作用后，可引起头晕、失眠、血压波动及心律失常等症状";
		String o3 = "合理的采光照明，既能保证视觉机能的需要，又有助于睡眠质量的提高";
		String o4 = "适宜的温度有利于人们的工作、生活，如果室内外的温度过高，就会影响人们的大脑活动，增加机体的耗氧量，影响睡眠";
		String o5 = "空气的湿度太大或过于干燥会使人感到不适，不利于正常的醒睡生活";
		String o6 = "在睡觉前要保持室内安静，光线幽暗，从而有利于睡眠";
		String o7 = "睡前半小时至一小时要放松身心，如静坐、深呼吸、听听舒缓的音乐等有助于睡眠";
		String o8 = "不做过强的活动，不宜看紧张刺激的影视剧，以免兴奋神经，影响睡眠";
		String o9 = "睡姿以“卧如弓”为佳，尤以右侧卧为好，这样不仅有利于肌肉组织松弛，消除疲劳，同时能帮助食物消化以及避免心脏受压";
		String o10 = "养成良好的生活习惯，按时作息。每晚9~11时上床休息，以醒来全身舒服，精力恢复，身心轻松为好";
		String o11 = "睡眠时长因人和睡眠质量而异，但长时间缺少睡眠会对人体造成很大的损害。成人每天睡7～8小时为宜";
		String o12 = "用温水泡脚，促进心肾相交，水火相济，阴阳合抱，以达到最佳睡眠状态";
		String o13 = "失眠不要过分依赖安眠药，要尽量静下心来，心情变好了，才有助于睡眠";
		String o14 = "参加气功、太极拳等强调精神力锻炼的运动，提高神经的调节能力";
		String o15 = "心理压力大导致的睡眠不好，应该先解决心理压力，压力小了睡眠自然就好了";
		String o16 = "快速入睡法：自由站立，全身放松，双手在体前有节律地上下摆动，双腿带动身体进行有节律的抖动，10分钟左右";
		String o17 = "轻松入睡法:躺上床之后，不必马上入睡，可以想一些轻松的事情，告诉自己一定会成功，不用焦急";
		String o18 = "想象自己很舒服地漂在水面上，很快就可以入睡。有了良性的心理暗示后，情绪就会放松，入睡也就容易了";
		String o19 = "睡觉前尽量少思考问题，如果控制不住，要用日记的形式将思考的问题做出解答，这样可以避免思考的问题引发大脑皮层局部兴奋";
		String o20 = "用热水泡脚或洗个热水澡，卧室应尽量幽静、舒适，有助于更快入睡。枕头不宜过高，否则会妨碍呼吸";
		String o21 = "注意睡前精神要放松，不可思绪过多，要力求心无杂念。保持心神宁静，也就能很自然入睡";
		String o22 = "保持乐观、知足长乐的良好心态。对社会竞争、个人得失等有充分的认识，避免因挫折致心理失衡，影响睡眠";
		String o23 = "创造有利于入睡的条件反射机制。如睡前半小时洗热水澡、泡脚等，只要长期坚持，就会建立起“入睡条件反射”";
		String o24 = "白天适度的体育锻炼，有助于晚上的入睡";
		String o25 = "可玩一些放松的活动，也可反复计数等，有时稍一放松，反而能加快入睡";
		String o26 = "限制白天睡眠时间，除老年人白天可适当午睡或打盹片刻外，应避免午睡或打盹，否则会减少晚上的睡意及睡眠时间";
		String o27 = "冬天气候干燥，在卧室里放一个加湿器会对睡眠起到好的作用";
		String o28 = "床头边放上一杯水，万一夜里渴了也不用起来找水喝，免得困意全消";
		String o29 = "床铺的硬度宜适中，过硬的铺会使人因受其刺激而不得不时常翻身，难以安睡，睡后周身酸痛";
		String o30 = "枕高一般以睡者的一肩（约10厘米）为宜，过低易造成颈椎生理骨刺，影响睡眠";
		String o31 = "足部保暖：双脚凉的妇女的睡眠质量比足部舒适暖和的妇女要差，建议双脚凉的可穿着厚袜子睡觉";
		String o32 = "建议关上窗户睡觉。引起人们过敏的物质和影响睡觉的噪音通过开着的窗户进入卧室，从而影响睡眠质量";
		String o33 = "卧室里不能有花卉，因为它们能引起人们的过敏反应，影响睡眠";
		String o34 = "每天坚持锻炼三十分钟，身体疲倦了自然就睡得好";
		String o35 = "睡前到户外散步一会儿，放松一下精神，对顺利入眠有百利而无一害";
		String o36 = "聆听平淡而有节律的音响，如滴水声、音乐催眠音带等，有助睡眠";
		String o37 = "鸣天鼓法。上床后，仰卧闭目，双手掩耳，用指头弹击后脑勺，使之听到呼呼的响声，弹击的次数到自觉微累为止，然后头慢慢靠近睡枕，便会很快入睡";
		otherSuggests.add(o1);
		otherSuggests.add(o2);
		otherSuggests.add(o3);
		otherSuggests.add(o4);
		otherSuggests.add(o5);
		otherSuggests.add(o6);
		otherSuggests.add(o7);
		otherSuggests.add(o8);
		otherSuggests.add(o9);
		otherSuggests.add(o10);
		otherSuggests.add(o11);
		otherSuggests.add(o12);
		otherSuggests.add(o13);
		otherSuggests.add(o14);
		otherSuggests.add(o15);
		otherSuggests.add(o16);
		otherSuggests.add(o17);
		otherSuggests.add(o18);
		otherSuggests.add(o19);
		otherSuggests.add(o20);
		otherSuggests.add(o21);
		otherSuggests.add(o22);
		otherSuggests.add(o23);
		otherSuggests.add(o24);
		otherSuggests.add(o25);
		otherSuggests.add(o26);
		otherSuggests.add(o27);
		otherSuggests.add(o28);
		otherSuggests.add(o29);
		otherSuggests.add(o30);
		otherSuggests.add(o31);
		otherSuggests.add(o32);
		otherSuggests.add(o33);
		otherSuggests.add(o34);
		otherSuggests.add(o35);
		otherSuggests.add(o36);
		otherSuggests.add(o37);
		maps.put("diets", diets);
		maps.put("otherSuggests", otherSuggests);
		return maps;
	}

	/**
	 * 17-运动预警的分级和建议
	 * @param number
	 * @return
	 */
	public static Map<String,Object> judgeSportHertRate(int number){
		Map<String,Object> maps = new HashMap<String,Object>();
		List<String> diets = new ArrayList<String>();//饮食
		List<String> otherSuggests = new ArrayList<String>();//其他
		if(number == 1){
			result = "运动正常";
			diseaseType = "您本次测量值为"+number+"，运动正常。";
		}else if(number == 2){
			result = "运动过于剧烈";
			diseaseType = "您本次测量值为"+number+"，可能存在运动过于剧烈的情况，请立即休息并参考以下建议，如有不适请及时就医：";
			String d1 = "要做到合理营养，平衡饮食。不要让自己过饱或过饿，三餐应定时定量";
			String d2 = "镁有助于保持规律的心跳，对心率过速有好处。含镁丰富的食物有坚果类、豆类等";
			String d3 = "可以在煲汤或煮粥的时候选一些能够减慢心率的食材，比如粳米、金针菜等";
			String d4 = "须少食多餐，不宜进食过饱，尤其晚餐，以免增加心肌负担";
			String d5 = "低热量的食物能够减少心脏的负担，如竹笋、绿豆芽等可适量常吃";
			String d6 = "高脂肪食物可加重心脏负担，使腹部胀气，从而限制心脏的正常收缩和舒张";
			String d7 = "辣椒、芥末等这类食品能导致大便秘结,因排便困难过于用力,可加重心脏负担，使心跳加快";
			String d8 = "蔬菜及水果中富含膳食纤维，可促进肠蠕动，预防便秘，从而减轻心脏负担";
			String d9 = "烟草中的尼古丁对神经系统有刺激作用,会使人血压上升,心跳加快，对心脏产生负担";
			String d10 = "禁用刺激心脏及血管的食物，如烟酒、浓茶、咖啡及辛辣调味品等";
			String d11 = "慎食胀气的食物，如生萝卜洋葱等，以免胃肠胀气，影响心脏活动";
			String d12 = "应供给富含VB、VC及钙、磷的食物，以维持心肌的营养和脂类代谢";
			String d13 = "限制盐及水的摄入。有水肿和心力衰竭者，饮食中不得加盐和酱油";
			String d14 = "应少食多餐，避免过饥过饱，尤其饮食过饱会加重心脏负担，加重原有的心律失常";
			String d15 = "香蕉中含有的镁离子对心血管系统具有保护作用，可每天一个";
			String d16 = "可多食用富含辅酶Q10高的食物，如沙丁鱼、莴苣等，对减缓心率有帮助";
			String d17 = "钙、磷含量较高的食物如海带、黑木耳等，对减缓心率有利，可适量多吃";
			String d18 = "限制高脂肪、高胆固醇食物，如动物内脏、动物油等，以免加重心脏负担";
			String d19 = "限制蛋白质供给，一般按每日每公斤体重1-1.5克供给，出现心衰及血压高时，蛋白质应控制在每日每公斤体重1克以内";
			diets.add(d1);
			diets.add(d2);
			diets.add(d3);
			diets.add(d4);
			diets.add(d5);
			diets.add(d6);
			diets.add(d7);
			diets.add(d8);
			diets.add(d9);
			diets.add(d10);
			diets.add(d11);
			diets.add(d12);
			diets.add(d13);
			diets.add(d14);
			diets.add(d15);
			diets.add(d16);
			diets.add(d17);
			diets.add(d18);
			diets.add(d19);
			String o1 = "注重休息，轻者可做适当活动，严重者需绝对卧床静养，室内光线不宜过强";
			String o2 = "保持环境清静，禁止喧哗、嘈杂，尤其对严重心律失常的病人更应注重";
			String o3 = "避免喜怒忧思等精神刺激，以免加重病情，要善于做患者的思想工作";
			String o4 = "要戒烟戒酒并保持良好的心态，避免紧张、劳累熬夜";
			String o5 = "不要做太剧烈的运动，可以通过散步、慢跑等有氧运动来锻炼心脏，运动频率每周3-5次，每次20-60分钟";
			String o6 = "深吸一口气后屏住气，再用力呼气，应用这种方法，可使过快的心跳减慢";
			String o7 = "用手指刺激咽喉，诱发呕吐，通过兴奋迷走神经，可反射性地引起心跳减慢";
			String o8 = "生理性心率过速受许多因素影响，如体力活动、情绪焦虑等，都可使心率增快，在日常生活中应注意";
			otherSuggests.add(o1);
			otherSuggests.add(o2);
			otherSuggests.add(o3);
			otherSuggests.add(o4);
			otherSuggests.add(o5);
			otherSuggests.add(o6);
			otherSuggests.add(o7);
			otherSuggests.add(o8);
		}else if(number == 3){
			result = "提高运动强度";
			diseaseType = "您本次测量值为"+number+"，建议您适当提高运动强度并请参考以下建议：";
			String d1 = "注意生活规律，保证充足的睡眠，不要吃辛辣刺激性食物，不要喝酒抽烟";
			String d2 = "冷饮可导致胃部负担加重，刺激迷走神经，增加心动过缓的发生风险";
			String d3 = "饮食宜高热量、高维生素而易消化的食物，平时可服用益气养心的食物，如大枣粥、莲子粥等";
			String d4 = "燕麦富含纤维素，并且糖分很低，不但能软化血管，还能增强心脏功能";
			String d5 = "沙丁鱼含有大量的ω-3脂肪酸，以及丰富的钙质与烟酸。这些成分不但能强壮心脏，而且还能够预防心脏病的发生";
			String d6 = "平时要低脂高蛋白饮食，多吃含维生素丰富的蔬菜和水果";
			String d7 = "腌制食品、鱼子等高盐高胆固醇食物，常吃容易诱发各种心血管疾病，不利于心动过缓患者的病情";
			String d8 = "为了增强心脏功能,必需的热量供应要保证,还须注意食物中蛋白质,维生素 B族,C和重要无机盐的供给";
			diets.add(d1);
			diets.add(d2);
			diets.add(d3);
			diets.add(d4);
			diets.add(d5);
			diets.add(d6);
			diets.add(d7);
			diets.add(d8);
		}
		//随机取集合中的建议给前端返回
		if(diets.isEmpty()==false){
			int dr = (int)(Math.random()*diets.size());
			dietSuggest = diets.get(dr);
		}
		if(otherSuggests.isEmpty()==false){
			int sr = (int)(Math.random()*otherSuggests.size());
			otherSuggest = otherSuggests.get(sr);
		}
		maps.put("result", result);
		maps.put("diseaseType", diseaseType);
		maps.put("dietSuggest", dietSuggest);
		maps.put("otherSuggest", otherSuggest);
		dietSuggest = null;
		otherSuggest = null;
		diseaseType = null;
		return maps;
	}

}
