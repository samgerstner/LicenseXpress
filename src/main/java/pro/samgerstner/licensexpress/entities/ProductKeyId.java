package pro.samgerstner.licensexpress.entities;

import java.io.Serializable;
import java.util.Objects;

public class ProductKeyId implements Serializable
{
   private String productKey;
   private Product product;

   public ProductKeyId (String productKey, Product product)
   {
      this.productKey = productKey;
      this.product = product;
   }

   @Override
   public boolean equals(Object obj)
   {
      if(obj == this) {return true; }
      if(!(obj instanceof ProductKeyId)) { return false; }

      ProductKeyId other = (ProductKeyId)obj;
      return (this.productKey.equals(productKey)) && (this.product.getGuid().equals(product.getGuid()));
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(this.productKey, this.product.getGuid());
   }
}