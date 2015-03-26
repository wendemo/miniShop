package cn.springmvc.model;

public class GoodsInbound {
	private Integer goodsId;

    private String name;

    private String code;

    private String company;

    private String trademark;

    private Integer type;
    
    private Integer shopId;
    
    private Integer purchasePrice;

    private Integer price;
    
    private Integer period;

    private Integer count;
    
    private Integer operatorId;
    
    private Integer lackThreshold;
    
    private Integer backlogThreshold;

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTrademark() {
		return trademark;
	}

	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Integer purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public Integer getLackThreshold() {
		return lackThreshold;
	}

	public void setLackThreshold(Integer lackThreshold) {
		this.lackThreshold = lackThreshold;
	}

	public Integer getBacklogThreshold() {
		return backlogThreshold;
	}

	public void setBacklogThreshold(Integer backlogThreshold) {
		this.backlogThreshold = backlogThreshold;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}
}
