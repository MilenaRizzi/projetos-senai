import { NavigationImages } from "../molecules/NavigationImages";
import { NavigationMenuProduct } from "../molecules/NavigationMenuProduct";
import { NavigationMenuProductDetail } from "../molecules/NavigationMenuProductDetail";
import { ProductDetail } from "../molecules/ProductDetail";
import styles from './ProductInfo.module.css'

export function ProductInfo() {
  return (
    <div>
      <NavigationMenuProduct/>
      <div className={styles.productInfo}>
        <NavigationImages/>
        <img src="src\assets\1.png" alt="" />
        <div className={styles.info}>
          <ProductDetail/>
          <NavigationMenuProductDetail/>
        </div>
      </div>
    </div>
  )
}