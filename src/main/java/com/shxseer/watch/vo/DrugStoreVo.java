package com.shxseer.watch.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 根据id查询药品库Vo
 * @author yangsonglin
 * @since 2018年6月12日09:45:40
 */
@ApiModel
public class DrugStoreVo implements Serializable {

	@ApiModelProperty(value="主键id")
	private String id ;
	@ApiModelProperty(value="类别")
	private String categoryId;             // '类别',
	@ApiModelProperty(value="药物名称")
	private String drugName;             // '药物名称',
	@ApiModelProperty(value="规格")
	private String specification;        // '规格',
	@ApiModelProperty(value="用法用量")
	private String usagedosage;          // '用法用量',
	@ApiModelProperty(value="适应症")
	private String adaptation ;          // '适应症',
	@ApiModelProperty(value="药品禁忌")
	private String taboo;                // '药品禁忌',
	@ApiModelProperty(value="半衰期最小时间")
	private Integer halflifeSmall;        // '半衰期最小时间',
	@ApiModelProperty(value="半衰期最大时间")
	private Integer halflifeBig;          // '半衰期最大时间',
	@ApiModelProperty(value="半衰期最内容")
	private String halflifeContent;          // '半衰期最大时间',
	@ApiModelProperty(value="不适症状")
	private String disadaptation;        // '不适症状',

	@ApiModelProperty(value="创建时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;          // '创建时间',
	@ApiModelProperty(value="创建人")
	private String createBy;            // '创建人',

	@ApiModelProperty(value="药品类型")
	private String catogoryName;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getUsagedosage() {
		return usagedosage;
	}

	public void setUsagedosage(String usagedosage) {
		this.usagedosage = usagedosage;
	}

	public String getAdaptation() {
		return adaptation;
	}

	public void setAdaptation(String adaptation) {
		this.adaptation = adaptation;
	}

	public String getTaboo() {
		return taboo;
	}

	public void setTaboo(String taboo) {
		this.taboo = taboo;
	}

	public Integer getHalflifeSmall() {
		return halflifeSmall;
	}

	public void setHalflifeSmall(Integer halflifeSmall) {
		this.halflifeSmall = halflifeSmall;
	}

	public Integer getHalflifeBig() {
		return halflifeBig;
	}

	public void setHalflifeBig(Integer halflifeBig) {
		this.halflifeBig = halflifeBig;
	}
	public String getHalflifeContent() {
		return halflifeContent;
	}

	public void setHalflifeContent(String halflifeContent) {
		this.halflifeContent = halflifeContent;
	}

	public String getDisadaptation() {
		return disadaptation;
	}

	public void setDisadaptation(String disadaptation) {
		this.disadaptation = disadaptation;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCatogoryName() {
		return catogoryName;
	}

	public void setCatogoryName(String catogoryName) {
		this.catogoryName = catogoryName;
	}
}
