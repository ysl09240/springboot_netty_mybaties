package com.shxseer.watch.model;

/**
 * 新特征值五实体类2018-07-17
 * @author zhangliang
 * @since 2018-07-17 14:38
 */
public class EigenValueFive {
    /**
     * 主键id
     */
    private String id;
    /**
     * 特征值OneId
     */
    private String eigenValueOneId;
    /**
     * b3的中下密度
     */
    private String bthrCenterDwon;
    /**
     * b3的深上密度
     */
    private String bthrDeepUp;
    /**
     * b3的深下密度
     */
    private String bthrDeepDwon;
    /**
     * c1的浅上密度
     */
    private String coneShallowUp;
    /**
     * c1的浅下密度
     */
    private String coneShallowDwon;
    /**
     * c1的中上密度
     */
    private String coneCenterUp;
    /**
     * c1的中下密度
     */
    private String coneCenterDwon;
    /**
     * c1的深上密度
     */
    private String coneDeepUp;
    /**
     * c1的深下密度
     */
    private String coneDeepDwon;
    /**
     * c2的浅上密度
     */
    private String ctwoShallowUp;
    /**
     * c2的浅下密度
     */
    private String ctwoShallowDwon;
    /**
     * c2的中上密度
     */
    private String ctwoCenterUp;
    /**
     * c2的中下密度
     */
    private String ctwoCenterDwon;
    /**
     * c2的深上密度
     */
    private String ctwoDeepUp;
    /**
     * c2的深下密度
     */
    private String ctwoDeepDwon;
    /**
     * 平均动脉压
     */
    private double averagePress;
    /**
     * A3点的速度
     */
    private String athreeSpeed;
    /**
     * b3点的速度
     */
    private String bthreeSpeed;
    /**
     * b2点的速度
     */
    private String bsconeSpeed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEigenValueOneId() {
        return eigenValueOneId;
    }

    public void setEigenValueOneId(String eigenValueOneId) {
        this.eigenValueOneId = eigenValueOneId;
    }

    public String getBthrCenterDwon() {
        return bthrCenterDwon;
    }

    public void setBthrCenterDwon(String bthrCenterDwon) {
        this.bthrCenterDwon = bthrCenterDwon;
    }

    public String getBthrDeepUp() {
        return bthrDeepUp;
    }

    public void setBthrDeepUp(String bthrDeepUp) {
        this.bthrDeepUp = bthrDeepUp;
    }

    public String getBthrDeepDwon() {
        return bthrDeepDwon;
    }

    public void setBthrDeepDwon(String bthrDeepDwon) {
        this.bthrDeepDwon = bthrDeepDwon;
    }

    public String getConeShallowUp() {
        return coneShallowUp;
    }

    public void setConeShallowUp(String coneShallowUp) {
        this.coneShallowUp = coneShallowUp;
    }

    public String getConeShallowDwon() {
        return coneShallowDwon;
    }

    public void setConeShallowDwon(String coneShallowDwon) {
        this.coneShallowDwon = coneShallowDwon;
    }

    public String getConeCenterUp() {
        return coneCenterUp;
    }

    public void setConeCenterUp(String coneCenterUp) {
        this.coneCenterUp = coneCenterUp;
    }

    public String getConeCenterDwon() {
        return coneCenterDwon;
    }

    public void setConeCenterDwon(String coneCenterDwon) {
        this.coneCenterDwon = coneCenterDwon;
    }

    public String getConeDeepUp() {
        return coneDeepUp;
    }

    public void setConeDeepUp(String coneDeepUp) {
        this.coneDeepUp = coneDeepUp;
    }

    public String getConeDeepDwon() {
        return coneDeepDwon;
    }

    public void setConeDeepDwon(String coneDeepDwon) {
        this.coneDeepDwon = coneDeepDwon;
    }

    public String getCtwoShallowUp() {
        return ctwoShallowUp;
    }

    public void setCtwoShallowUp(String ctwoShallowUp) {
        this.ctwoShallowUp = ctwoShallowUp;
    }

    public String getCtwoShallowDwon() {
        return ctwoShallowDwon;
    }

    public void setCtwoShallowDwon(String ctwoShallowDwon) {
        this.ctwoShallowDwon = ctwoShallowDwon;
    }

    public String getCtwoCenterUp() {
        return ctwoCenterUp;
    }

    public void setCtwoCenterUp(String ctwoCenterUp) {
        this.ctwoCenterUp = ctwoCenterUp;
    }

    public String getCtwoCenterDwon() {
        return ctwoCenterDwon;
    }

    public void setCtwoCenterDwon(String ctwoCenterDwon) {
        this.ctwoCenterDwon = ctwoCenterDwon;
    }

    public String getCtwoDeepUp() {
        return ctwoDeepUp;
    }

    public void setCtwoDeepUp(String ctwoDeepUp) {
        this.ctwoDeepUp = ctwoDeepUp;
    }

    public String getCtwoDeepDwon() {
        return ctwoDeepDwon;
    }

    public void setCtwoDeepDwon(String ctwoDeepDwon) {
        this.ctwoDeepDwon = ctwoDeepDwon;
    }

    public double getAveragePress() {
        return averagePress;
    }

    public void setAveragePress(double averagePress) {
        this.averagePress = averagePress;
    }

    public String getAthreeSpeed() {
        return athreeSpeed;
    }

    public void setAthreeSpeed(String athreeSpeed) {
        this.athreeSpeed = athreeSpeed;
    }

    public String getBthreeSpeed() {
        return bthreeSpeed;
    }

    public void setBthreeSpeed(String bthreeSpeed) {
        this.bthreeSpeed = bthreeSpeed;
    }

    public String getBsconeSpeed() {
        return bsconeSpeed;
    }

    public void setBsconeSpeed(String bsconeSpeed) {
        this.bsconeSpeed = bsconeSpeed;
    }

    @Override
    public String toString() {
        return "EigenValueFive{" +
                "id='" + id + '\'' +
                ", eigenValueOneId='" + eigenValueOneId + '\'' +
                ", bthrCenterDwon=" + bthrCenterDwon +
                ", bthrDeepUp=" + bthrDeepUp +
                ", bthrDeepDwon=" + bthrDeepDwon +
                ", coneShallowUp=" + coneShallowUp +
                ", coneShallowDwon=" + coneShallowDwon +
                ", coneCenterUp=" + coneCenterUp +
                ", coneCenterDwon=" + coneCenterDwon +
                ", coneDeepUp=" + coneDeepUp +
                ", coneDeepDwon=" + coneDeepDwon +
                ", ctwoShallowUp=" + ctwoShallowUp +
                ", ctwoShallowDwon=" + ctwoShallowDwon +
                ", ctwoCenterUp=" + ctwoCenterUp +
                ", ctwoCenterDwon=" + ctwoCenterDwon +
                ", ctwoDeepUp=" + ctwoDeepUp +
                ", ctwoDeepDwon=" + ctwoDeepDwon +
                ", averagePress=" + averagePress +
                ", athreeSpeed=" + athreeSpeed +
                ", bthreeSpeed=" + bthreeSpeed +
                ", bsconeSpeed=" + bsconeSpeed +
                '}';
    }
}
