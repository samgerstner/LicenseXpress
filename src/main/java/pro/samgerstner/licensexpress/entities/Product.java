package pro.samgerstner.licensexpress.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product
{
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private String guid;

   @Column(name = "product_name", nullable = false)
   private String productName;

   @Column(name = "product_description")
   private String productDescription;

   @Column(name = "num_key_groups", nullable = false)
   private int numKeyGroups;

   @Column(name = "key_group_length", nullable = false)
   private int keyGroupLength;

   @OneToMany
   private List<ProductKey> productKeys;

   public Product() {}

   public Product (String productName, String productDescription, int numKeyGroups, int keyGroupLength)
   {
      this.productName = productName;
      this.productDescription = productDescription;
      this.numKeyGroups = numKeyGroups;
      this.keyGroupLength = keyGroupLength;
   }

   public String getGuid ()
   {
      return guid;
   }

   public void setGuid (String guid)
   {
      this.guid = guid;
   }

   public String getProductName ()
   {
      return productName;
   }

   public void setProductName (String productName)
   {
      this.productName = productName;
   }

   public String getProductDescription ()
   {
      return productDescription;
   }

   public void setProductDescription (String productDescription)
   {
      this.productDescription = productDescription;
   }

   public int getNumKeyGroups ()
   {
      return numKeyGroups;
   }

   public void setNumKeyGroups (int numKeyGroups)
   {
      this.numKeyGroups = numKeyGroups;
   }

   public int getKeyGroupLength ()
   {
      return keyGroupLength;
   }

   public void setKeyGroupLength (int keyGroupLength)
   {
      this.keyGroupLength = keyGroupLength;
   }

   public List<ProductKey> getProductKeys ()
   {
      return productKeys;
   }

   public void setProductKeys (List<ProductKey> productKeys)
   {
      this.productKeys = productKeys;
   }
}