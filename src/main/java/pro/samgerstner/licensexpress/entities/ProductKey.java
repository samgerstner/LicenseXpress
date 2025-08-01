package pro.samgerstner.licensexpress.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "product_keys")
@IdClass(ProductKeyId.class)
public class ProductKey
{
   @Id
   @Column(name = "product_key")
   private String productKey;

   @Id
   @ManyToOne
   private Product product;

   @Column(name = "key_expires")
   private boolean keyExpires;

   @Column(name = "expiry_date")
   private String expiryDate;

   @ManyToOne
   private ApplicationUser user;

   public ProductKey() {}

   public ProductKey (String productKey, Product product, boolean keyExpires, String expiryDate, ApplicationUser user)
   {
      this.productKey = productKey;
      this.product = product;
      this.keyExpires = keyExpires;
      this.expiryDate = expiryDate;
      this.user = user;
   }

   public String getProductKey ()
   {
      return productKey;
   }

   public void setProductKey (String productKey)
   {
      this.productKey = productKey;
   }

   public Product getProduct ()
   {
      return product;
   }

   public void setProduct (Product product)
   {
      this.product = product;
   }

   public boolean isKeyExpires ()
   {
      return keyExpires;
   }

   public void setKeyExpires (boolean keyExpires)
   {
      this.keyExpires = keyExpires;
   }

   public String getExpiryDate ()
   {
      return expiryDate;
   }

   public void setExpiryDate (String expiryDate)
   {
      this.expiryDate = expiryDate;
   }

   public ApplicationUser getUser ()
   {
      return user;
   }

   public void setUser (ApplicationUser user)
   {
      this.user = user;
   }
}