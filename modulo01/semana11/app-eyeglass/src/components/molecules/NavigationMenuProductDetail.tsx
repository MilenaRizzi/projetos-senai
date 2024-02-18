import { DetailsProduct } from "../atoms/DetailsProduct";
import styles from './ProductDetail.module.css'


export function NavigationMenuProductDetail() {
  return (
    <div className={styles.detailsAndShare}>
      <div>
        <DetailsProduct />
      </div>
      <div className={styles.linksMenuProduct}>
        <a href="">Shipping & Returns + </a>
        <a href="">Share +</a>
      </div>

    </div>
  )
}