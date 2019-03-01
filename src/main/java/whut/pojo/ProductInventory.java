package whut.pojo;

import java.io.Serializable;

/**
 * 商品库存
 * @author wangql
 *
 */
public class ProductInventory implements Serializable{
    private Integer inventoryId; //商品库存ID

    private Integer productId;  //商品ID

    private Integer currentQuantity; //当前商品数量

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(Integer currentQuantity) {
        this.currentQuantity = currentQuantity;
    }
}