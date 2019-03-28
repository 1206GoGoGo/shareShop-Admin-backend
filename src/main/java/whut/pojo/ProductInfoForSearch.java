package whut.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

/**
 * 商品信息表
 * @author wangql
 *
 */
public class ProductInfoForSearch implements Serializable{
	@Field
    private Integer productId;//商品ID

	@Field
    private String productName;//商品名称

	@Field
    private String brandName;//品牌

	@Field
	private Integer oneCategoryId;//一级分类ID

	@Field
    private Integer twoCategoryId;//二级分类ID

	@Field
    private Integer threeCategoryId;//三级分类ID

	@Field
    private String mainImage;//主图

	@Field
    private String attributeList;//属性列表

	@Field
    private Byte publishStatus;//上下架状态

	@Field
    private Byte auditStatus;//审核状态

	@Field
    private Byte useCoupon;//是否可以使用优惠券

	@Field
    private Integer discountRate;//折扣比率

	@Field
    private Date productionDate;//生产日期

	@Field
    private String description;//商品描述

	@Field
    private Integer stock;//商品库存

	@Field
    private Date inputTime;//商品录入时间

	@Field
    private Date modifiedTime;//商品修改时间
    
    //private List<ProductSpecs> productSpecs; //商品规格(单品详情)
    
    //--计算出的数据
	@Field
	private int view;//用户浏览记录
	
	@Field
    private Double score;//商品评分
    
	@Field
    private Double price;//商品中某种规格的最低价
    
	@Field
    private int collect;//收藏数
    
	@Field
    private int cart;//加入购物车数
	
	@Field
    private int sales;//出售的数量

	public ProductInfoForSearch(Integer productId, String productName, String brandName, Integer oneCategoryId,
			Integer twoCategoryId, Integer threeCategoryId, String mainImage, String attributeList, Byte publishStatus,
			Byte auditStatus, Byte useCoupon, Integer discountRate, Date productionDate, String description,
			Integer stock, Date inputTime, Date modifiedTime, Double score, Double price, int collect, int cart, int sales) {
		this.productId = productId;
		this.productName = productName;
		this.brandName = brandName;
		this.oneCategoryId = oneCategoryId;
		this.twoCategoryId = twoCategoryId;
		this.threeCategoryId = threeCategoryId;
		this.mainImage = mainImage;
		this.attributeList = attributeList;
		this.publishStatus = publishStatus;
		this.auditStatus = auditStatus;
		this.useCoupon = useCoupon;
		this.discountRate = discountRate;
		this.productionDate = productionDate;
		this.description = description;
		this.stock = stock;
		this.inputTime = inputTime;
		this.modifiedTime = modifiedTime;
		this.score = score;
		this.price = price;
		this.collect = collect;
		this.cart = cart;
	}

	public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public Integer getOneCategoryId() {
        return oneCategoryId;
    }

    public void setOneCategoryId(Integer oneCategoryId) {
        this.oneCategoryId = oneCategoryId;
    }

    public Integer getTwoCategoryId() {
        return twoCategoryId;
    }

    public void setTwoCategoryId(Integer twoCategoryId) {
        this.twoCategoryId = twoCategoryId;
    }

    public Integer getThreeCategoryId() {
        return threeCategoryId;
    }

    public void setThreeCategoryId(Integer threeCategoryId) {
        this.threeCategoryId = threeCategoryId;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage == null ? null : mainImage.trim();
    }

    public String getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(String attributeList) {
        this.attributeList = attributeList == null ? null : attributeList.trim();
    }

    public Byte getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Byte publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Byte getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Byte getUseCoupon() {
        return useCoupon;
    }

    public void setUseCoupon(Byte useCoupon) {
        this.useCoupon = useCoupon;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
    

    public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getCollect() {
		return collect;
	}

	public void setCollect(int collect) {
		this.collect = collect;
	}

	public int getCart() {
		return cart;
	}

	public void setCart(int cart) {
		this.cart = cart;
	}
    
    @Override
    public String toString() {
    	return null;
    }
}